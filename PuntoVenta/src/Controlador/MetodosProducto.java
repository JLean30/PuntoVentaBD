/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Modelo.Producto;
import java.util.ArrayList;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MetodosProducto {

    public ArrayList<Producto> productos;
    
    public MetodosProducto(ArrayList<Producto> pProductos){
        
        this.productos = pProductos;
    }
    
    public void agregar(Producto pProducto){
        
        this.productos.add(pProducto);
    }
    
    public void modificar (Producto pProducto){
        
        //foreach para recorrer listas de objetos//
        
        for(Producto pItem: this.productos){
            if(pItem.getCodigo().equals(pProducto.getCodigo())){
                
                pItem.setDescripcion(pProducto.getDescripcion());
                pItem.setFecha(pProducto.getFecha());
                pItem.setPrecioCompra(pProducto.getPrecioCompra());
                pItem.setDescuento(pProducto.getDescuento());
                pItem.setImpuesto(pProducto.getImpuesto());
                
            }
        }
    }
    
    public void eliminar(String codigo){
        for(Producto pItem:this.productos){
            
            if(pItem.getCodigo().equals(codigo)){
                
                this.productos.remove(pItem);
                break;
                
            }
        }
    }
    
    public Producto buscar (String codigo){
        Producto temporal = null;
        for(Producto pItem:this.productos){
            if(pItem.getCodigo().equals(codigo)){
                temporal= pItem;
            }
        }
        return temporal;
    }
    
    public Producto obtenerInformacion (Vista.Frm_Productos frm){
        Producto temporal = null;
        
        temporal = new Producto(frm.getCodigo(), 
                frm.getDescripcion(),
                frm.getFechaRegistro(),
                frm.getPrecioCompra() ,
                frm.getPorDescuento(),
                frm.getPorImpuesto());
        
        return temporal;
        
    }
}
