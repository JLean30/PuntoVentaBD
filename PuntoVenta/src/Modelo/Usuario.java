/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author Estudiante
 */
public class Usuario {
    private  String usuario,contrasena,nombreCompleto,tipo;
    
    
    //propiedades
    public  void  setUsuario(String pValor){
        this.usuario = pValor;
    }
    
    public  String  getUsuario(){
        return  this.usuario;
    }
    public  void  setContrasena(String pValor){
        this.contrasena  =  pValor;
    }
    public  String getContrasena(){
        return  this.contrasena;
    }
    public  void  setNombreCompleto(String pValor){
        this.nombreCompleto = pValor;
    }
    public  String  getNombreCompleto(){
        return  this.nombreCompleto;
    }
    public  void  setTipo(String pValor){
        this.tipo=  pValor;
    }
    public  String  getTipo(){
        return  this.tipo;
    }
    //Contructo del usuario

    public Usuario() {
        this.usuario = "";
        this.contrasena = "";
        this.nombreCompleto = "";
        this.tipo = "";
    }
    
    public  Usuario(String pUsuario,String pContrasena,
            String pNombCompl,String pTipo){
        
        this.setUsuario(pUsuario);
        this.setContrasena(pContrasena);
        this.setNombreCompleto(pNombCompl);
        this.setTipo(pTipo);
    }
    public Usuario(Usuario usr){
        this.setUsuario(usr.getUsuario());
        this.setContrasena(usr.getContrasena());
        this.setNombreCompleto(usr.getNombreCompleto());
        this.setTipo(usr.getTipo());
    }
    
}
