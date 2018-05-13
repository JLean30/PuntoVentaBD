/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import java.io.EOFException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import Modelo.Usuario;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ArchivoUsuarios {

     private ObjectInputStream archivoEntrada;
     
    private ObjectOutputStream archivoSalida;
    
    private ArrayList<Usuario> usuarios;
    
   private boolean cargarArchivo(){
        
        boolean cargado= false;
        try{
            
            this.archivoEntrada = new ObjectInputStream(new FileInputStream(Controlador_FRM_Principal.direccionBancoActual +"archivoUsuarios.dat"));
            System.out.println("Archivo cargado de forma correcta");
            cargado= true;
        }
        catch(Exception ex){
            System.out.println("Error al cargar el archivo"+ ex.getMessage());
            
        }
        
        return cargado;
    }
       
         public void crearArchivo(){
        
        try{
            this.archivoSalida = new ObjectOutputStream(new FileOutputStream( 
                    Controlador_FRM_Principal.direccionBancoActual+ "archivoUsuarios.dat"));
            System.out.println("Archivo creado");
        }
        catch(Exception ex){
            System.out.println("Error al crear el archivo"+ ex.getLocalizedMessage());
            
        }
    }
         
    public void leerAchivo(){
        
        try{
            while(true){
                Usuario usuario= (Usuario) this.archivoEntrada.readObject();
                
               this.usuarios.add(usuario);
            }
        }
        catch(EOFException ex){
            System.out.println("Fin del archivo");
        }
        catch(Exception ex){
             System.out.println("Error leyendo el archivo"+ ex.getMessage());
        }
    }
          
         public void escribirInformacion(){
        
        try{
            for(Usuario item: this.usuarios){
                
                this.archivoSalida.writeObject(item);
                
            }
        }
        catch(Exception ex){
            
            System.out.println("Error escribiendo en el archivo"+ ex.getMessage());
        }
    }
         
         
          
    public ArrayList<Usuario> getUsuarios(){
    
    return this.usuarios;
}
     public void setUsuarios(ArrayList<Usuario> pUsuarios){
        this.usuarios= pUsuarios;
    }
     
      public ArchivoUsuarios(){
         
          this.usuarios = new ArrayList<Usuario>();
        //se intenta cargar elarchivo
        
        if(this.cargarArchivo()){
            this.leerAchivo();
            // en caso de que no se pudo cargar el archivo, lo crea
        }else{
            this.crearArchivo();
            
        }
     }
}
