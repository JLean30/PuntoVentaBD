/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.ConexionBD;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Producto;
import vista.FRM_Productos;


/**
 *
 * @author Melber
 */
public class Controlador_FRM_productos implements ActionListener {

    private FRM_Productos frmProductos;

     //se  declara la conexion
    private  ConexionBD conexion;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getActionCommand().equals("Limpiar")){
           this.frmProductos.estadoInicial();
        }
        
        if(e.getActionCommand().equals("Buscar")){
           this.buscarProducto();
        }
        if(e.getActionCommand().equals("Registrar")){
             modelo.Producto producto = null;
             producto = this.frmProductos.obtenerProductoFrm();
                //this.metodosProductos.agregar(producto);
                this.conexion.registrarProducto(producto);
                this.frmProductos.mostrarMensaje("Producto Registrado");
                this.frmProductos.estadoInicial();
                String[] datos = new String [7];
                datos[0] = producto.getCodigo();
                datos[1] = producto.getDescripcion();
                datos[2] = String.valueOf(producto.getPrecioCompra());
                datos[3] = String.valueOf(producto.getPorDescuento());
                datos[4] =String.valueOf(producto.getPorImpuesto()) ;
                datos[5] = producto.getFechaRegistro();     
                datos[6] = String.valueOf(producto.precioVenta());
       
                this.frmProductos.agregarProductoTabla(datos);
            
            
        }
        if(e.getActionCommand().equals("Modificar")){
            Producto producto=null;
            producto=this.frmProductos.obtenerProductoFrm();
            this.conexion.modificarProducto(producto);
            //this.metodosProductos.modificar(producto);
            this.frmProductos.estadoInicial();
             String[] datos = new String [7];
                datos[0] = producto.getCodigo();
                datos[1] = producto.getDescripcion();
                datos[2] = String.valueOf(producto.getPrecioCompra());
                datos[3] = String.valueOf(producto.getPorDescuento());
                datos[4] =String.valueOf(producto.getPorImpuesto()) ;
                datos[5] = producto.getFechaRegistro();     
                datos[6] = String.valueOf(producto.precioVenta());
            this.frmProductos.modificarProductoTabla(datos);
            this.frmProductos.mostrarMensaje("Producto modificado de forma correcta");
                    
                   
        }
        if(e.getActionCommand().equals("Eliminar")){
            //this.metodosProductos.eliminar(this.frmProductos.txtCodigo.getText());
            this.conexion.eliminarProducto(this.frmProductos.txtCodigo.getText());
            this.frmProductos.eliminarProductoTabla(this.frmProductos.getCodigo());
            this.frmProductos.estadoInicial();
            this.frmProductos.mostrarMensaje("Producto eliminado de forma correcta");
        }
    }
    public void buscarProducto(){
         modelo.Producto temporal = null;
            if(this.conexion.buscarProducto(this.frmProductos.getCodigo())){
                temporal = this.conexion.getProductoTemporal();
            }
            //temporal= this.metodosProductos.buscar(this.frmProductos.getCodigo());
           if( temporal !=null){
                
                this.frmProductos.jP_Botones1.habilitarModificarEliminar();
                this.frmProductos.habilitarAgregar();
                this.frmProductos.txtDescripcion.setText(temporal.getDescripcion());
                this.frmProductos.txtPrecioCompra.setText(String.valueOf(temporal.getPrecioCompra()));
                this.frmProductos.txtPorDescuento.setText(String.valueOf(temporal.getPorDescuento()));
                this.frmProductos.txtPorImpuesto.setText(String.valueOf(temporal.getPorImpuesto()));
                this.frmProductos.txtFechaRegistro.setText(temporal.getFechaRegistro());
                this.frmProductos.txtPrecioVenta.setText(String.valueOf(temporal.precioVenta()));
                
            }
            else{
                this.frmProductos.jP_Botones1.habilitarAgregar(); 
                this.frmProductos.habilitarAgregar();
                
                
              }
    }
    /*
    public void consolidarInformacion(){
        this.archivoJSON.setArray(this.metodosProductos.getArray());
        this.archivoJSON.escribirDatos();
    }*/
    public void actualizarTabla(ArrayList<Producto> array){
        for(Producto item:array){
            if(item!=null){
                String[] datos = new String [7];
                datos[0] = item.getCodigo();
                datos[1] = item.getDescripcion();
                datos[2] = String.valueOf(item.getPrecioCompra());
                datos[3] = String.valueOf(item.getPorDescuento());
                datos[4] =String.valueOf(item.getPorImpuesto()) ;
                datos[5] = item.getFechaRegistro();     
                datos[6] = String.valueOf(item.precioVenta());
                this.frmProductos.agregarProductoTabla(datos);
                
            }
        }
        
        
    }
    public Controlador_FRM_productos(FRM_Productos frm,ConexionBD conex){
        this.frmProductos=frm;
        this.conexion = conex;
    }
    
    
}
