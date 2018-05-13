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
public class Clientes implements Serializable{

    
    private String nombre, apellido1, apellido2, direccion, email, cedula;
    private String telefono;
    
    
    public Clientes(String cNombre, String cApe1, String cApe2, String cDirec, String cEmail, String cCedula, String cTel){
       this.setNombre(cNombre);
       this.setApellido1(cApe1);
       this.setApellido2(cApe2);
       this.setDireccion(cDirec);
       this.setEmail(cEmail);
       this.setCedula(cCedula);
       this.setTelefono(cTel);
        
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String valor) {
        this.nombre = valor;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String valor) {
        this.apellido1 = valor;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String valor) {
        this.apellido2 = valor;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String valor) {
        this.direccion = valor;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String valor) {
        this.email = valor;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String valor) {
        this.cedula = valor;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String valor) {
        this.telefono = valor;
    }
    
    
}
