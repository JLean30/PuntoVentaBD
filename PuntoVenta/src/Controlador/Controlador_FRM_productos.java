/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Frm_Productos;
import Modelo.Producto;
import Modelo.ConexionBD;



public class Controlador_FRM_productos implements ActionListener{

    /***Declaracion de la interfaz a usar**/
    private Frm_Productos frmProductos;
    //metodos de interfaz//
    
    public MetodosProducto metodosProductos;
    private ArchivoProductos archivo;
    
    //se  declara la conexion
    private  ConexionBD conexion;
    
    
    public Controlador_FRM_productos(Frm_Productos frm) {
        this.frmProductos = frm;
        this.archivo = new ArchivoProductos();
        this.metodosProductos = new MetodosProducto(this.archivo.getProductos());
        
        this.conexion = new ConexionBD();
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Limpiar")){
            //El estado de la interfaz es inicial
            this.frmProductos.estadoInicial();
        }
        
        if(ae.getActionCommand().equals("Productos")){
            this.frmProductos.estadoInicial();
            this.frmProductos.setVisible(true);
        }
        
        
        
        if(ae.getActionCommand().equals("Buscar")){
            Producto temporal = null;
            temporal = this.metodosProductos.buscar(this.frmProductos.getCodigo());
            
            if(this.conexion.buscarProducto(this.frmProductos.getCodigo())){
                temporal = this.conexion.getProductoTemporal();
            }
            
            //si existe puede modificarlo o eliminarlo//
            if(temporal != null){
                
                this.frmProductos.setCodigo(temporal.getCodigo());
                this.frmProductos.setDescripcion(temporal.getDescripcion());
                this.frmProductos.setPrecioCompra(String.valueOf(temporal.getPrecioCompra()));
                this.frmProductos.setDescuento(String.valueOf(temporal.getDescuento()) );
                this.frmProductos.setImpuesto(String.valueOf(temporal.getImpuesto()));
                this.frmProductos.setFechaRegistro(temporal.getFecha());
                this.frmProductos.setPrecioVenta(String.valueOf(temporal.precioVenta()));
                
                
                this.frmProductos.hailitarModificarEliminar();
            
           } else{//si no existe puede agragarlo//
                this.frmProductos.mostrarMensaje("Producto sin registrar \n Ingrese uno nuevo  ");
                this.frmProductos.habilitarAgregar();
                
               
            }
        }
        
        if(ae.getActionCommand().equals("Registrar")){
        Producto producto=  null;
        producto = this.metodosProductos.obtenerInformacion(this.frmProductos);
        
       // this.metodosProductos.agregar(producto);
       this.conexion.registrarProducto(producto);
       

                    String[] datos = new String [7];
         datos[0] = producto.getCodigo();
        datos[1] = producto.getDescripcion();
        datos[2] = String.valueOf(producto.getPrecioCompra());
        datos[3] = String.valueOf(producto.getDescuento());
        datos[4] =String.valueOf(producto.getImpuesto()) ;
        
        datos[5] = producto.getFecha();     
        datos[6] = String.valueOf(producto.precioVenta());
       
     this.frmProductos.agregarProductoTabla(datos);

        this.frmProductos.mostrarMensaje("Producto registrado");
        this.frmProductos.estadoInicial();
        
        }
        
        if(ae.getActionCommand().equals("Modificar")){
            Producto producto =null;
            producto = this.metodosProductos.obtenerInformacion(this.frmProductos);
            
            //this.metodosProductos.modificar(producto);
            this.conexion.modificarProducto(producto);
            
             String[] datos = new String [7];
         datos[0] = producto.getCodigo();
        datos[1] = producto.getDescripcion();
        datos[2] = String.valueOf(producto.getPrecioCompra());
        datos[3] = String.valueOf(producto.getDescuento());
        datos[4] =String.valueOf(producto.getImpuesto()) ;
        
        datos[5] = producto.getFecha();     
        datos[6] = String.valueOf(producto.precioVenta());
            this.frmProductos.modificarProductoTabla(datos);
            this.frmProductos.estadoInicial();
            this.frmProductos.mostrarMensaje("Producto modificado");
            
        }
        
        if(ae.getActionCommand().equals("Eliminar")){
            
            //this.metodosProductos.eliminar(this.frmProductos.getCodigo());
            this.conexion.eliminarProducto(this.frmProductos.getCodigo());
            this.frmProductos.eliminarProductoTabla(this.frmProductos.getCodigo());
            this.frmProductos.estadoInicial();
            this.frmProductos.mostrarMensaje("Producto eliminado");
        }
        
    }

    
public void consolidarInformacion(){
        
//        this.archivo.setProductos(this.metodosProductos.productos);
//        this.archivo.crearArchivo();
//        this.archivo.escribirInformacion();
    }
    
    

}
