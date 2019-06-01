/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vista.FRM_Usuarios;
import modelo.Usuario;
import javax.swing.JOptionPane;
import modelo.ConexionBD;

/**
 *
 * @author JeanC
 */
public class Controlador_Frm_Usuarios implements ActionListener {

    private FRM_Usuarios frmUsuarios;


    private ConexionBD conexion;

    public Controlador_Frm_Usuarios (FRM_Usuarios pFrmUsuarios,ConexionBD conex) {
        this.frmUsuarios = pFrmUsuarios;
        this.conexion=conex;
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Buscar")) {
            Usuario temporal = null;
            
            if(this.conexion.buscarUsuario(this.frmUsuarios.getUsuario())){
                temporal=this.conexion.getUsrTemp();
            }
            
            
            if(temporal != null) {
                //se muestran los datos de la interfaz
                this.frmUsuarios.cargarDatosUsuario(temporal);
                
                //se habilitan los controles para modificar datos
                this.frmUsuarios.habilitarParaModificar();
                
            } else {
                
                //se habilitan los controles para agregar datos y registrar un usuario
                this.frmUsuarios.habilitarParaAgregar();
            }
        }
        
        if(e.getActionCommand().equals("Registrar")) {
            
            if(this.frmUsuarios.confirmarContrasena()) {
                
                Usuario usuario = this.frmUsuarios.obtenerUsuario();
                this.conexion.registrarUsuario(usuario);
                
                String[] datos = new String[4];
                datos[0] = usuario.getUsuario();
                datos[1] = usuario.getContrasena();
                datos[2] = usuario.getNombreCompleto();
                datos[3] = usuario.getTipo();
                this.frmUsuarios.agregarUsuarioTabla(datos);
                this.frmUsuarios.mostrarMensaje("Nuevo usuario registrado!");
                this.frmUsuarios.estadoInicial();
                
            } else {
                
                this.frmUsuarios.mostrarMensaje("Confirmación de contraseña incorrecta!");
            
            }
            
        }
        
        if(e.getActionCommand().equals("Modificar")) {
            if(this.frmUsuarios.confirmarContrasena()) {
                Usuario usuario = this.frmUsuarios.obtenerUsuario();
                this.conexion.modificarUsuario(usuario);

                
                String[] datos = new String[4];
                datos[0] = usuario.getUsuario();
                datos[1] = usuario.getContrasena();
                datos[2] = usuario.getNombreCompleto();
                datos[3] = usuario.getTipo();
                
                this.frmUsuarios.modificarUsuarioTabla(datos);
                this.frmUsuarios.mostrarMensaje("Usuario modificado correctamente!");
                this.frmUsuarios.estadoInicial();
            }
            
        }
        
        if(e.getActionCommand().equals("Eliminar")) {
            
            this.conexion.eliminarUsuario(this.frmUsuarios.getUsuario());
            
            this.frmUsuarios.eliminarUsuarioTabla(this.frmUsuarios.getUsuario());
            
            this.frmUsuarios.mostrarMensaje("Usuario eliminado correctamente!");
            
            this.frmUsuarios.estadoInicial();
            
        }
        
        if(e.getActionCommand().equals("Limpiar")) {
            
            this.frmUsuarios.estadoInicial();
            
        }
    }
    public void inicioTabla(ArrayList<Usuario> usrs){
        for(Usuario item:usrs){
            if(item!=null){
                String[] datos = new String[4];
                datos[0] = item.getUsuario();
                datos[1] = item.getContrasena();
                datos[2] = item.getNombreCompleto();
                datos[3] = item.getTipo();
                this.frmUsuarios.agregarUsuarioTabla(datos);
                
            }
        }
    }
  
}
