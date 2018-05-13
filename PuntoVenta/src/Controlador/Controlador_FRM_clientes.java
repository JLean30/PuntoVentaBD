/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Clientes;
import Vista.Frm_Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controlador_FRM_clientes implements ActionListener{

   private Frm_Clientes frmClientes;
   
   public MetodosClientes metodosClientes;
   
   private ArchivoClientes archivo;
   
    public Controlador_FRM_clientes(Frm_Clientes frm){
              
         this.frmClientes = frm;
         
         this.archivo = new ArchivoClientes();
         
         this.metodosClientes= new MetodosClientes(this.archivo.getClientes());
         
          }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("Limpiar")){
            
             this.frmClientes.estadoInicial();
        }
       if(ae.getActionCommand().equals("Clientes")){
           
         this.frmClientes.estadoInicial();
           this.frmClientes.setVisible(true);
           
       }
       
        if(ae.getActionCommand().equals("Buscar")){
            Clientes temporal = null;
            temporal = this.metodosClientes.buscar(this.frmClientes.getCedula());
            //si existe puede modificarlo o eliminarlo//
            if(temporal != null){
                
                 this.frmClientes.setCedula(temporal.getCedula());
                this.frmClientes.setNombre(temporal.getNombre());
                this.frmClientes.setApellido1(temporal.getApellido1());
               this.frmClientes.setApellido2(temporal.getApellido2());
                this.frmClientes.setTelefono(String.valueOf(temporal.getTelefono()) );
                this.frmClientes.setDireccion(temporal.getDireccion());
                this.frmClientes.setEmail(temporal.getEmail());
                
                
                
               this.frmClientes.hailitarModificarEliminar();
            
           } else{//si no existe puede agragarlo//
                this.frmClientes.mostrarMensaje("Cliente sin registrar \n Ingrese uno nuevo  ");
                this.frmClientes.habilitarAgregar();
                
               
            }
        } 
        
    
        
        if(ae.getActionCommand().equals("Registrar")){
        Clientes clientes=  null;
        clientes = this.metodosClientes.obtenerInformacion(this.frmClientes);
        
        this.metodosClientes.agregar(clientes);
        
        String [] datos = new String [7];
        
            datos [0] = clientes.getCedula();
             datos [1] = clientes.getNombre();
             datos [2] = clientes.getApellido1();
             datos [3] = clientes.getApellido2();
             datos[4] = clientes.getTelefono();
             datos[5] = clientes.getDireccion();
             datos[6] = clientes.getEmail();
       
        this.frmClientes.agregarClienteTabla(datos);
        this.frmClientes.mostrarMensaje("Cliente registrado");
        this.frmClientes.estadoInicial();
        
        }
        
         if(ae.getActionCommand().equals("Modificar")){
            Clientes nuevoClientes =null;
            nuevoClientes = this.metodosClientes.obtenerInformacion(this.frmClientes);
            
            this.metodosClientes.modificar(nuevoClientes);
            
              String [] datos = new String [7];
        
            datos [0] = nuevoClientes.getCedula();
             datos [1] = nuevoClientes.getNombre();
             datos [2] = nuevoClientes.getApellido1();
             datos [3] = nuevoClientes.getApellido2();
             datos[4] = nuevoClientes.getTelefono();
             datos[5] = nuevoClientes.getDireccion();
             datos[6] = nuevoClientes.getEmail();
            
             this.frmClientes.modificarClienteTabla(datos);
            this.frmClientes.estadoInicial();
            this.frmClientes.mostrarMensaje("Cliente modificado");
            
        }
         
          if(ae.getActionCommand().equals("Eliminar")){
            
            this.metodosClientes.eliminar(this.frmClientes.getCedula());
            this.frmClientes.eliminarClienteTabla(this.frmClientes.getCedula());
            this.frmClientes.estadoInicial();
            this.frmClientes.mostrarMensaje("Cliente eliminado");
        }
          
          
   }
    
    

      public void consolidarInformacion(){
        
        this.archivo.setClientes(this.metodosClientes.clientes);
        this.archivo.crearArchivo();
        this.archivo.escribirInformacion();
    }
}
