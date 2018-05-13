/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Proveedores;
import Vista.Frm_Proveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Proveedores;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controlador_FRM_proveedores implements ActionListener{
    
    private Frm_Proveedores frmProveedores;
    private MetodosProveedores metodosProve;
    private ArchivoProveedores archivo;
    
    public Controlador_FRM_proveedores(Frm_Proveedores frm){
              
         this.frmProveedores = frm;
         this.archivo = new ArchivoProveedores();
         this.metodosProve= new MetodosProveedores(this.archivo.getProveedores());
         
          }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        
          if(ae.getActionCommand().equals("Limpiar")){
            
             this.frmProveedores.estadoInicial();
        }
          if(ae.getActionCommand().equals("Proveedores")){
           
         this.frmProveedores.estadoInicial();
           this.frmProveedores.setVisible(true);
           
       }
            if(ae.getActionCommand().equals("Buscar")){
            Proveedores temporal = null;
            temporal = this.metodosProve.buscar(this.frmProveedores.getCedulaJuridica());
            //si existe puede modificarlo o eliminarlo//
            if(temporal != null){
                
                 this.frmProveedores.setCedulaJuridica(temporal.getCedulaJuridica());
                this.frmProveedores.setNombreComercial(temporal.getNombreComercial());
                this.frmProveedores.setContacto(temporal.getContacto());
               this.frmProveedores.setDireccionExac(temporal.getDireccion());
                this.frmProveedores.setMontoCredito(String.valueOf(temporal.getMontoCredito()) );
                this.frmProveedores.setDiasCredito(temporal.getDiasCredito());
                this.frmProveedores.setMoneda(temporal.getMoneda());
                
                
                
               this.frmProveedores.hailitarModificarEliminar();
            
           } else{//si no existe puede agragarlo//
                this.frmProveedores.mostrarMensaje("Proveedor sin registrar \n Ingrese uno nuevo  ");
                this.frmProveedores.habilitarAgregar();
                
               
            }
        } 

 
              if(ae.getActionCommand().equals("Registrar")){
        Proveedores provee=  null;
        provee = this.metodosProve.obtenerInformacion(this.frmProveedores);
        
        this.metodosProve.agregar(provee);
        
        String [] datos = new String [7];
             datos [0] = provee.getCedulaJuridica();
             datos [1] = provee.getMontoCredito();
             datos [2] = provee.getNombreComercial();
             datos [3] = provee.getContacto();
             datos[4] = provee.getDireccion();
             datos[5] = provee.getDiasCredito();
             datos[6] = provee.getMoneda();

        this.frmProveedores.agregarProvedorTabla(datos);
        this.frmProveedores.mostrarMensaje("Proveedor registrado");
        this.frmProveedores.estadoInicial();
        
        }
        
                if(ae.getActionCommand().equals("Modificar")){
            Proveedores provee = null;
            provee = this.metodosProve.obtenerInformacion(this.frmProveedores);
            
            this.metodosProve.modificar(provee);
            
             String [] datos = new String [7];
             datos [0] = provee.getCedulaJuridica();
             datos [1] = provee.getMontoCredito();
             datos [2] = provee.getNombreComercial();
             datos [3] = provee.getContacto();
             datos[4] = provee.getDireccion();
             datos[5] = provee.getDiasCredito();
             datos[6] = provee.getMoneda();
            
            this.frmProveedores.modificarProveedoresTabla(datos);
            this.frmProveedores.mostrarMensaje("Cliente modificado");
            this.frmProveedores.estadoInicial();

            
        }
                 if(ae.getActionCommand().equals("Eliminar")){
            
            this.metodosProve.eliminar(this.frmProveedores.getCedulaJuridica());
           this.frmProveedores.eliminarProveedoresTabla(this.frmProveedores.getCedulaJuridica());
            this.frmProveedores.estadoInicial();
            this.frmProveedores.mostrarMensaje("Proveedor eliminado");
        }
                 
    }

    public void consolidarInformacion(){
        
        this.archivo.setProveedores(this.metodosProve.proveedores);
        this.archivo.crearArchivo();
        this.archivo.escribirInformacion();
    }
    
}
