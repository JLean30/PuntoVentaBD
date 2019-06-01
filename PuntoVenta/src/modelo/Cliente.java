/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;




 // @author JeanC
 
public class Cliente{
    
    String cedula,nombre,primerApellido,segundoApellido,telefono,direccion,email;
    
    public void setCedula(String valor){
        this.cedula = valor;
    }
    
    public void setNombre(String valor){
        this.nombre = valor;
    }
    
    public void setPrimerApellido(String valor){
        this.primerApellido = valor;
    }
    
    public void setSegundoApellido(String valor){
        this.segundoApellido = valor;
    }
    
    public void setTelefono(String valor){
        this.telefono = valor;
    }
    
    public void setDireccion(String valor){
        this.direccion = valor;
    }
    
    public void setEmail(String valor){
        this.email = valor;
    }
    
    public String getCedulaCliente(){
        return this.cedula;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getPrimerApellido(){
        return this.primerApellido;
    }
    
    public String getSegundoApellido(){
        return this.segundoApellido;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
    
    public String getEmail(){
        return this.email;
    }

    public Cliente() {
        this.cedula = "";
        this.nombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.telefono = "";
        this.direccion = "";
        this.email = "";
    }

    public Cliente(String pCedula, String pNombre, String pPrimerApellido, String pSegundoApellido, String pTelefono, String pDdireccion, String pEmail){
        this.setCedula(pCedula);
        this.setNombre(pNombre);
        this.setPrimerApellido(pPrimerApellido);
        this.setSegundoApellido(pSegundoApellido);
        this.setTelefono(pTelefono);
        this.setDireccion(pDdireccion);
        this.setEmail(pEmail);
    }
    
    
    
}

