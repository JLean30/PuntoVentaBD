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
import Modelo.Clientes;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ArchivoClientes {

    private ObjectInputStream archivoEntrada;
    private ObjectOutputStream archivoSalida;
    private ArrayList<Clientes> clientes;
    
     private boolean cargarArchivo(){
        
        boolean cargado= false;
        try{
            
            this.archivoEntrada = new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\tarea03\\PuntoVenta\\Datos\\archivoClientes.dat"));
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
            this.archivoSalida = new ObjectOutputStream(new FileOutputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\tarea03\\PuntoVenta\\Datos\\archivoClientes.dat"));
            System.out.println("Archivo creado");
        }
        catch(Exception ex){
            System.out.println("Error al crear el archivo"+ ex.getLocalizedMessage());
            
        }
    }
     
     public void leerAchivo(){
        
        try{
            while(true){
                Clientes clientes= (Clientes) this.archivoEntrada.readObject();
                
                this.clientes.add(clientes);
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
            for(Clientes item: this.clientes){
                
                this.archivoSalida.writeObject(item);
                
            }
        }
        catch(Exception ex){
            
            System.out.println("Error escribiendo en el archivo"+ ex.getMessage());
        }
    }
     
     public ArrayList<Clientes> getClientes(){
    
    return this.clientes;
}
     public void setClientes(ArrayList<Clientes> pClientes){
        this.clientes= pClientes;
    }
     
     public ArchivoClientes(){
         
          this.clientes = new ArrayList<Clientes>();
        //se intenta cargar elarchivo
        
        if(this.cargarArchivo()){
            this.leerAchivo();
            // en caso de que no se pudo cargar el archivo, lo crea
        }else{
            this.crearArchivo();
            
        }
     }
}
