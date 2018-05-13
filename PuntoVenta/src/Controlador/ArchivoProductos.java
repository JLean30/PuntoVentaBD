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
import Modelo.Producto;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ArchivoProductos {

     private ObjectInputStream archivoEntrada;
    private ObjectOutputStream archivoSalida;
    private ArrayList<Producto> productos;
    
       private boolean cargarArchivo(){
        
        boolean cargado= false;
        try{
            
            this.archivoEntrada = new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\tarea03\\PuntoVenta\\Datos\\archivoProductos.dat"));
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
            this.archivoSalida = new ObjectOutputStream(new FileOutputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\tarea03\\PuntoVenta\\Datos\\archivoProductos.dat"));
            System.out.println("Archivo creado");
        }
        catch(Exception ex){
            System.out.println("Error al crear el archivo"+ ex.getLocalizedMessage());
            
        }
        
        
    }
         
         public void leerAchivo(){
        
        try{
            while(true){
                Producto productos= (Producto) this.archivoEntrada.readObject();
                
                this.productos.add(productos);
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
            for(Producto item: this.productos){
                
                this.archivoSalida.writeObject(item);
                
            }
        }
        catch(Exception ex){
            
            System.out.println("Error escribiendo en el archivo"+ ex.getMessage());
        }
    }
          
           public ArrayList<Producto> getProductos(){
    
    return this.productos;
}
     public void setProductos(ArrayList<Producto> pProductos){
        this.productos= pProductos;
    }
     
      public ArchivoProductos(){
         
          this.productos = new ArrayList<Producto>();
        //se intenta cargar elarchivo
        
        if(this.cargarArchivo()){
            this.leerAchivo();
            // en caso de que no se pudo cargar el archivo, lo crea
        }else{
            this.crearArchivo();
            
        }
     }
}
