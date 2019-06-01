/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Melber
 */
    public class Producto {
    //Atributos
    private String codigo,descripcion,fechaRegistro;

    private double precioCompra,porDescuento,porImpuesto;
    
    public void setCodigo(String valor){
        this.codigo= valor;
    }
    public String getCodigo(){
        return  this.codigo;
    }
    public void setDescripcion(String valor){
        this.descripcion = valor;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public void setFechaRegistro(String valor){
        this.fechaRegistro = valor;
    }
    public String getFechaRegistro(){
        return this.fechaRegistro;
    }
    public void setPrecioCompra(double valor){
        this.precioCompra = valor;
    }
    public double getPrecioCompra(){
        return this.precioCompra;
    }
    
    public void setPorDescuento(double valor){
        this.porDescuento =valor;
    }
    public double getPorDescuento(){
        return this.porDescuento;
    }
    public void setPorImpuesto(double valor){
        this.porImpuesto = valor;
    }
    public double getPorImpuesto(){
        return this.porImpuesto;
    }
    
public double precioVenta(){
    double montoDescuento =0;
    double montoImpuesto = 0;
    double precioFinal=0;
    montoDescuento = this.getPrecioCompra()* (this.getPorDescuento()/100);
    montoImpuesto = (this.getPrecioCompra()-montoDescuento)*(this.getPorImpuesto()/100);
    precioFinal = (this.getPrecioCompra()-montoDescuento)+ montoImpuesto;
    return  precioFinal;
}

//constructor de la clase
public Producto(String pCod,String pDescrip,double pPrecioComp,
        double pPorDesc,double pPorImp,String pfechaReg){
   this.setCodigo(pCod);
   this.setDescripcion(pDescrip);
   this.setPrecioCompra(pPrecioComp);
   this.setPorDescuento(pPorDesc);
   this.setPorImpuesto(pPorImp);
   this.setFechaRegistro(pfechaReg);
}
    public Producto() {
        this.codigo = "";
        this.descripcion = "";
        this.fechaRegistro = "";
        this.precioCompra = 0.0;
        this.porDescuento = 0.0;
        this.porImpuesto = 0.0;
    }

    
    
    
}
