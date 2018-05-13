/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Usuario;
import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MetodosUsuarios {

    public ArrayList<Usuario> usuarios;
    
    public MetodosUsuarios(ArrayList<Usuario> pUsuarios){
        
        this.usuarios = pUsuarios;
        
    this.agregar(new Usuario ("admin", "admin","Administrador de sistema", "Administrador"));
    }
    
    public void agregar(Usuario pUsuario){
        this.usuarios.add(pUsuario);
    }
    
    public void modificar(Usuario pUsuario){
        for(Usuario item:this.usuarios){
            
            if(item.getUsuario().equals(pUsuario.getUsuario())){
                item.setContrasena(pUsuario.getContrasena());
                item.setNombreCompleto(pUsuario.getNombreCompleto());
                item.setTipo(pUsuario.getTipo());
                break;
            }
        }
    }
    
    public void eliminar(String pUsuario){
        for(Usuario item:usuarios){
            if(item.getUsuario().equals(pUsuario)){
                this.usuarios.remove(item);
                break;
            }
            
        }
    }
    
    public boolean buscar(Usuario pUsuario){
        boolean encontrado= false;
        
        for(Usuario item:usuarios){
            
            if(item.getUsuario().equals(pUsuario.getUsuario())
            && item.getContrasena().equals(pUsuario.getContrasena())){
            encontrado = true;
            break;
            }
        }
        
            return encontrado;
    }

    public Usuario buscarPerfil(Usuario pUsuario){
    
        Usuario temporal = null;
        
        for(Usuario item: this.usuarios){
        if(item.getUsuario().equals(pUsuario.getUsuario())){
        temporal = item;
        break;
          }
       }
    return temporal;
    }
}
