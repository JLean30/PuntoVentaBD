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
public class Proveedores implements Serializable{

    private String cedulaJuridica, nombreComercial, contacto, direccion, moneda, diasCredito;
    private String montoCredito ;
    
    
    public Proveedores (String proveCJuridica, String proveNComercial, String proveContacto, String proveDireccion, String proveMCredito, String proveDCredito, String proveMoneda){
        this.setCedulaJuridica(proveCJuridica);
        this.setNombreComercial(proveNComercial);
        this.setContacto(proveContacto);
        this.setDireccion(proveDireccion);
        this.setMontoCredito(proveMCredito);
        this.setDiasCredito(proveDCredito);
        this.setMoneda(proveMoneda);
       
    }

    public String getCedulaJuridica() {
        return this.cedulaJuridica;
    }

    public void setCedulaJuridica(String valor) {
        this.cedulaJuridica = valor;
    }

    public String getNombreComercial() {
        return this.nombreComercial;
    }

    public void setNombreComercial(String valor) {
        this.nombreComercial = valor;
    }

    public String getContacto() {
        return this.contacto;
    }

    public void setContacto(String valor) {
        this.contacto = valor;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String valor) {
        this.direccion = valor;
    }

    public String getMontoCredito() {
        return this.montoCredito;
    }

    public void setMontoCredito(String valor) {
        this.montoCredito = valor;
    }

    public String getDiasCredito() {
        return this.diasCredito;
    }

    public void setDiasCredito(String valor) {
        this.diasCredito = valor;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String valor) {
        this.moneda = valor;
    }
    
    
    
    
    
}
