/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import modelo.Cliente;
import modelo.ConexionBD;
import modelo.Factura;
import vista.FRM_Facturacion;
import modelo.Producto;
import vista.FRM_ControlVentas;
/**
 *
 * @author JeanC
 */
public class Controlador_FRM_Facturacion implements ActionListener {
    private FRM_Facturacion frmFacturacion;
    private ConexionBD conexion;
    private FRM_ControlVentas frmCV;
    
    public Controlador_FRM_Facturacion(FRM_Facturacion frmFacturacion,
            ConexionBD conex, FRM_ControlVentas frmCV){
        
        this.frmFacturacion=frmFacturacion;
        this.conexion=conex;
        this.frmCV=frmCV;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("BuscarCliente")){
           
                if(this.conexion.buscarCliente(this.frmFacturacion.getCedula())){
                    this.frmFacturacion.mostrarNombreCliente(this.conexion.getClienteTemp().getNombre());
                }else{
                this.frmFacturacion.mostrarMensaje("No existe el cliente");
                }
        }
        if(e.getActionCommand().equals("BuscarProductos")){
            
            Producto temp=null;
            if(this.conexion.buscarProducto(this.frmFacturacion.getCodigoProducto())){
                this.frmFacturacion.mostrarNombreProducto(this.conexion.getProductoTemporal().getDescripcion());
                this.frmFacturacion.estadoBotonesBuscar();
            }else{
                this.frmFacturacion.mostrarMensaje("no existe el producto");
            }
            
        }
        if(e.getActionCommand().equals("AgregarProducto")){
            Producto temporal=null;
            if(this.conexion.buscarProducto(this.frmFacturacion.getCodigoProducto())){
            temporal=this.conexion.getProductoTemporal();
            }
            if(temporal!=null){
                String[] datos=new String[5];
                datos[0]=temporal.getCodigo();
                datos[1]=temporal.getDescripcion();
                datos[2]=String.valueOf(temporal.getPrecioCompra());
                datos[3]=""+ this.frmFacturacion.getCantidadProducto();
                datos[4]=""+(Double.parseDouble(datos[3]))*temporal.getPrecioCompra();
                this.frmFacturacion.agregarProductoTabla(datos);
                this.frmFacturacion.total();
                this.frmFacturacion.estadoBotonesAgregar();
            }else{
                this.frmFacturacion.mostrarMensaje("No Existe el producto");
            }
        }
        if(e.getActionCommand().equals("EliminarProducto")){
            this.frmFacturacion.eliminarProductoTabla(this.frmFacturacion.getCodigoProducto());
            this.frmFacturacion.total();
        }
        if(e.getActionCommand().equals("Pagar")){
            Factura fact=this.frmFacturacion.obtenerFactura();
            if(fact!=null){
            this.conexion.registrarFactura(fact);
            this.registrarNuevaFacturaTabla(fact);
            this.frmFacturacion.countFact=this.conexion.obtenerNumeroFactura();
            this.frmFacturacion.setJtxNumero(this.frmFacturacion.countFact);
            this.frmFacturacion.mostrarMensaje("Su pago de "+this.frmFacturacion.getJtxTotal()+" Colones ha sido exitoso por medio de pago en "+this.frmFacturacion.getEleccionPago());
            this.frmFacturacion.estadoInicial();
            this.frmFacturacion.estadoBotonesInicio();
            this.frmFacturacion.eliminarRegistroTabla();
            }
        }
    }
    
    public void registrarNuevaFacturaTabla(Factura fact){
        String[] datos = new String [7];
                datos[0] = fact.getCodFactura();
                datos[1] = fact.getCodCliente();
                datos[2] = fact.getDetalle();
                datos[3] = fact.getFecha();
                datos[4] =fact.getMonto();
        this.frmCV.agregarDatosTablaFacturas(datos);
           
    }
    
}
