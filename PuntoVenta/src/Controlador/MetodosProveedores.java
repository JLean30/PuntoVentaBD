/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Proveedores;
import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MetodosProveedores {

    public ArrayList<Proveedores> proveedores;
    
    public MetodosProveedores(ArrayList<Proveedores> pProveedores){
        
        this.proveedores = pProveedores;
    }
    
    public void agregar (Proveedores pProveedores){
        this.proveedores.add(pProveedores);
        
    }
     public void modificar (Proveedores pProveedores){
        
        for(Proveedores cItem: this.proveedores){
            if(cItem.getCedulaJuridica().equals(pProveedores.getCedulaJuridica())){
                cItem.setNombreComercial(pProveedores.getNombreComercial());
                cItem.setContacto(pProveedores.getContacto());
                cItem.setDireccion(pProveedores.getDireccion());
                cItem.setMontoCredito(pProveedores.getMontoCredito());
                cItem.setDiasCredito(pProveedores.getDiasCredito());
                cItem.setMoneda(pProveedores.getMoneda());
                
            }
        }
    }
     
     
       public void eliminar(String cedulaJuridica){
        
        for(Proveedores proveItem:this.proveedores){
            if(proveItem.getCedulaJuridica().equals(cedulaJuridica)){
                this.proveedores.remove(proveItem);
                break;
            }
        }
    }
       public Proveedores buscar(String cedulaJuridica){
        Proveedores temporal = null;
        for(Proveedores proveItem: this.proveedores){
            
            if(proveItem.getCedulaJuridica().equals(cedulaJuridica)){
                
                temporal = proveItem;
            }
           
        }
        return temporal;
    }
       
       public Proveedores obtenerInformacion (Vista.Frm_Proveedores frm){
          Proveedores temporal= null;
          
          temporal = new Proveedores (frm.getCedulaJuridica(), frm.getNombreComercial(), frm.getContacto(), frm.getDireccionExac(), frm.getMontoCredito(), frm.getDiasCredito(), frm.getMoneda());
            return temporal;
       }
       
     
       
}
