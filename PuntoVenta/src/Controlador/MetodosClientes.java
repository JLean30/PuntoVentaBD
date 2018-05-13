/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Clientes;
import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MetodosClientes {

    public ArrayList<Clientes> clientes;
    
    public MetodosClientes(ArrayList<Clientes> pClientes){
        
        this.clientes = pClientes;
    }
    
    public void agregar (Clientes cClientes){
        
        this.clientes.add(cClientes);
        
    }
    
    public void modificar (Clientes cClientes){
        
        for(Clientes cItem: this.clientes){
            if(cItem.getCedula().equals(cClientes.getCedula())){
                cItem.setNombre(cClientes.getNombre());
                cItem.setApellido1(cClientes.getApellido1());
                cItem.setApellido2(cClientes.getApellido2());
                cItem.setDireccion(cClientes.getDireccion());
                cItem.setTelefono(cClientes.getTelefono());
                cItem.setEmail(cClientes.getEmail());
                
            }
        }
    }
    
    public void eliminar(String cedula){
        
        for(Clientes cItem:this.clientes){
            if(cItem.getCedula().equals(cedula)){
                this.clientes.remove(cItem);
                break;
            }
        }
    }
    
    public Clientes buscar(String cedula){
        Clientes temporal = null;
        for(Clientes cItem: this.clientes){
            
            if(cItem.getCedula().equals(cedula)){
                
                temporal = cItem;
            }
        }
        return temporal;
    }
    
   public Clientes obtenerInformacion (Vista.Frm_Clientes frm){
        
       Clientes temporal = null;
       temporal = new Clientes (frm.getNombre(), frm.getApellido1(), frm.getApellido2(), frm.getDireccion(), frm.getEmail(), frm.getCedula(), frm.getTelefono());
     return temporal;
 
    }
}
