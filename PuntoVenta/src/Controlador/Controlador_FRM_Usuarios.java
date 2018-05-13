/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Frm_Usuarios;
import Controlador.MetodosUsuarios;
import Modelo.Usuario;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controlador_FRM_Usuarios implements ActionListener{

private Frm_Usuarios frmUsuarios;
public MetodosUsuarios metodosUsuarios;


//variable para controlar el  archivo de  usuario
public ArchivoUsuarios archivo;

public Controlador_FRM_Usuarios(Frm_Usuarios pfrmUsuarios){

this.frmUsuarios= pfrmUsuarios;
this.archivo = new ArchivoUsuarios();
this.metodosUsuarios = new MetodosUsuarios(this.archivo.getUsuarios());
}
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("Buscar")){
        
            Usuario temporal = null;
            temporal= this.metodosUsuarios.buscarPerfil(this.frmUsuarios.obtenerUsuario());
            
            if(temporal != null){
        // se muestran los datos en la interfaz 
        this.frmUsuarios.cargarDatosUsuario(temporal);
        //se habilitan los controles para modificar datos
        this.frmUsuarios.habilitarModificar();
        }else{
            // se habilitan los controles para la entrada de datos
            // y se registra el perfil de usuario
            this.frmUsuarios.habilitarAgregar();
            }
        }
        
         if(ae.getActionCommand().equals("Registrar")){
        
             if(this.frmUsuarios.confirmarContrasena()){
             
             Usuario usuario= this.frmUsuarios.obtenerUsuario();
             
             this.metodosUsuarios.agregar(usuario);
             
             String [] datos = new String [4];
             datos [0] = usuario.getUsuario();
             datos [1] = usuario.getContrasena();
             datos [2] = usuario.getNombreCompleto();
             datos [3] = usuario.getTipo();
             
             this.frmUsuarios.agregarUsuarioTabla(datos);
             
             this.frmUsuarios.mostrarMensaje("Perfil de usuario registrado");
             
             this.frmUsuarios.estadoInicial();
             }else{
             
             this.frmUsuarios.mostrarMensaje("Confirmacion incorrecta");
             }
             
        }
         
          if(ae.getActionCommand().equals("Modificar")){
        
              
              if(this.frmUsuarios.confirmarContrasena()){
              Usuario usuario = this.frmUsuarios.obtenerUsuario();
              
              this.metodosUsuarios.modificar(usuario);
              
              String [] datos = new String [4];
              datos[0] = usuario.getUsuario();
              datos[1] = usuario.getContrasena();
              datos [2] = usuario.getNombreCompleto();
              datos[3] = usuario.getTipo();
              
              this.frmUsuarios.modificarUsuarioTabla(datos);
              this.frmUsuarios.mostrarMensaje("Perfil modificado");
              this.frmUsuarios.estadoInicial();
              
              }else{
              
              this.frmUsuarios.mostrarMensaje("Conformacion incorrecta");
              }
        }
          
           if(ae.getActionCommand().equals("Eliminar")){
        
               this.metodosUsuarios.eliminar(this.frmUsuarios.getUsuario());
               
               this.frmUsuarios.eliminarUsuarioTabla(this.frmUsuarios.getUsuario());
               
               this.frmUsuarios.mostrarMensaje("Perfil eliminado");
               
               this.frmUsuarios.estadoInicial();
        }
           
           if(ae.getActionCommand().equals("Limpiar")){
           this.frmUsuarios.estadoInicial();
           }
           
    }
public void consolidarInformacion(){
        
        this.archivo.setUsuarios(this.metodosUsuarios.usuarios);
        this.archivo.crearArchivo();
        this.archivo.escribirInformacion();
    }


}
