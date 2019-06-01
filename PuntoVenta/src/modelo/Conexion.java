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
public class Conexion {
    
    private String usuario;
    private String contrasenna;
    private String servidor;
    private String baseDeDatos;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }
    
    
    
    public Conexion(){
        this.contrasenna="";
        this.servidor="";
        this.usuario="";
        this.baseDeDatos="";
    }
    
}
