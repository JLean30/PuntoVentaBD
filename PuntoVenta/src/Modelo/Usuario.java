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
public class Usuario implements Serializable{
    
    private String usuario;
    private String contrasena;
    private String nombreCompleto;
    private String tipo;
    
    public void setUsuario(String pValor){
        this.usuario=  pValor;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
     public void setContrasena(String pValor){
        this.contrasena=  pValor;
    }
    
    public String getContrasena(){
        return this.contrasena;
    }
    
     public void setNombreCompleto(String pValor){
        this.nombreCompleto=  pValor;
    }
    
    public String getNombreCompleto(){
        return this.nombreCompleto;
    }
    
     public void setTipo(String pValor){
        this.tipo=  pValor;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public Usuario(String pUsuario, String pContrasena, String pNombreCompl, String pTipo){
        
        this.setUsuario(pUsuario);
        this.setContrasena(pContrasena);
        this.setNombreCompleto(pNombreCompl);
        this.setTipo(pTipo);
        
    }
}
