/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Vista.Frm_Facturacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Frm_Facturacion;

import Controlador.MetodosClientes;
import Controlador.MetodosProducto;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controlador_FRM_facturacion implements ActionListener{

     private Frm_Facturacion frmFacturacion;
     
     private MetodosProducto metodosProducto;
     private MetodosClientes metodosClientes;
    
     
     public Controlador_FRM_facturacion(Frm_Facturacion pfrmFacturacion, MetodosProducto pMetodosProducto, MetodosClientes pMetodosClientes){
         
         this.frmFacturacion = pfrmFacturacion;
         
         this.metodosProducto = pMetodosProducto;
         this.metodosClientes = pMetodosClientes;
         
     }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
       if(ae.getActionCommand().equals("BuscarClientes")){
           
           if(this.metodosClientes.buscar(this.frmFacturacion.getCedula()) != null){
               this.frmFacturacion.mostrarNombreCliente(this.metodosClientes.buscar(this.frmFacturacion.getCedula()).getNombre());
           }else{
               
               this.frmFacturacion.mostrarMensaje("No existe el cliente");
           }
           
       }
        
        if(ae.getActionCommand().equals("BuscarProductos")){
           
           Modelo.Producto temporal = null;
           
         temporal = this.metodosProducto.buscar(this.frmFacturacion.getCodigoProducto());
               
           if(temporal != null){
               
               this.frmFacturacion.mostrarNombreProducto(temporal.getDescripcion());
           }else{
               
               this.frmFacturacion.mostrarMensaje("Producto no existe");
           }
       }
    }

    
    
    
}
