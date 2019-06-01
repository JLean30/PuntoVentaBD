/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import modelo.ConexionBD;
import modelo.Factura;
import vista.FRM_ControlVentas;

/**
 *
 * @author JeanC
 */
public class Controlador_FRM_ControlVentas implements ItemListener, ActionListener{
    
    private FRM_ControlVentas frmVentas;
    private ConexionBD conexion;
    public Controlador_FRM_ControlVentas(FRM_ControlVentas frm,ConexionBD conex){
        this.frmVentas=frm;
        this.conexion=conex;
    }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Buscar")){
             this.frmVentas.eliminarRegistroTablaConsulta();
          
           if(this.frmVentas.getCb_TipoBusqueda().getSelectedIndex()==1){
                
                this.actualizarTablaConsultas(this.conexion.tablaConsultaFacturasCliente(this.frmVentas.getCedulaCliente()));
                this.frmVentas.totalC();
                this.frmVentas.estadoInicial();
        }
            if(this.frmVentas.getCb_TipoBusqueda().getSelectedIndex()==2){
                
                this.actualizarTablaConsultas(this.conexion.tablaConsultaNumeroFacturas(this.frmVentas.getNumeroFactura()));
                this.frmVentas.totalC();
                this.frmVentas.estadoInicial();
                
            }
            if(this.frmVentas.getCb_TipoBusqueda().getSelectedIndex()==3){
               
                this.actualizarTablaConsultas(this.conexion.tablaConsultaFechaFacturas(this.frmVentas.getFecha()));
                this.frmVentas.totalC();
                this.frmVentas.estadoInicial();
                
            }
            
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
            int caso =this.frmVentas.getCb_TipoBusqueda().getSelectedIndex();
            if(caso==1)
              this.frmVentas.estadoCliente();
          
               
            if(caso==2)
               this.frmVentas.estadoFactura();

                  
            if(caso==3)
               this.frmVentas.estadoFecha();

        
        
       
    }
    
    public void actualizarTablaFacturas(ArrayList<Factura> array){
        for(Factura item:array){
            if(item!=null){
                String[] datos = new String [7];
                datos[0] = item.getCodFactura();
                datos[1] = item.getCodCliente();
                datos[2] = item.getDetalle();
                datos[3] = item.getFecha();
                datos[4] = item.getMonto();
                this.frmVentas.agregarDatosTablaFacturas(datos);
                
            }
        }
    }
    
    public void actualizarTablaConsultas(ArrayList<Factura> array){
        for(Factura item:array){
            if(item!=null){
                String[] datos = new String [7];
                datos[0] = item.getCodFactura();
                datos[1] = item.getCodCliente();
                datos[2] = item.getDetalle();
                datos[3] = item.getFecha();
                datos[4] = item.getMonto();
                this.frmVentas.agregarDatosTablaConsulta(datos);
                
            }
        }
    }

  
    
    
    
        
        
    
    
}
