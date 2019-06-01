/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JeanC
 */
public class Factura {
    String codFactura,codCliente,detalle,fecha,Monto;

    public Factura(String codFactura, String codCliente, String detalle, String fecha, String Monto) {
        this.codFactura = codFactura;
        this.codCliente = codCliente;
        this.detalle = detalle;
        this.fecha = fecha;
        this.Monto = Monto;
    }

    public String getCodFactura() {
        return this.codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    public String getCodCliente() {
        return this.codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getDetalle() {
        return this.detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMonto() {
        return this.Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }
    
    
    
}
