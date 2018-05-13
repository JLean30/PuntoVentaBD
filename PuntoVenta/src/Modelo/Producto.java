/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import java.io.Serializable;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Producto implements Serializable{
    //***Atributos de objeto***//
    private String codigo;
    private String descripcion;
    private double precioCompra;
    private double descuento;
    private double impuesto;
    private String fecha;

    
    public Producto(String pCod,String pDescrip,String pFechaReg,double pPrecioComp, double pDesc, double pImp){
        
        this.setCodigo(pCod);
        this.setDescripcion(pDescrip);
        this.setFecha(pFechaReg);
        this.setPrecioCompra(pPrecioComp);
        this.setDescuento(pDesc);
        this.setImpuesto(pImp);
    }
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String valor) {
        this.codigo = valor;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String valor) {
        this.descripcion = valor;
    }

    public double getPrecioCompra() {
        return this.precioCompra;
    }

    public void setPrecioCompra(double valor) {
        this.precioCompra = valor;
    }

    public double getDescuento() {
        return this.descuento;
    }

    public void setDescuento(double valor) {
        this.descuento = valor;
    }

    public double getImpuesto() {
        return this.impuesto;
    }

    public void setImpuesto(double valor) {
        this.impuesto = valor;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String valor) {
        this.fecha = valor;
    }
    
public double precioVenta(){
    
    double montoDescuento =0;
    double montoImpuesto = 0;
    double precioFinal = 0;
    
    montoDescuento = this.getPrecioCompra()*(this.getDescuento()/100);
    montoImpuesto = (this.getPrecioCompra()-montoDescuento)*(this.getImpuesto()/100);
    precioFinal= (this.getPrecioCompra()-montoDescuento)+montoImpuesto;
    
    return precioFinal;
}
    
    
}
