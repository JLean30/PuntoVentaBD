/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Conexion;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

/**
 *
 * @author JeanC
 */
public class ArchivoConexion {
    
    private ArrayList<Conexion> listaConexion;
    
    public ArchivoConexion() {
        
        this.listaConexion = new ArrayList<>();
        
        if(verificarArchivo()){
            this.extraerDatos();
        }
        
        
    }
    
    public boolean verificarArchivo(){
        File file = new File("registroConexion.json");
        
        //Se confirma si existe el archivo 
        if(file.exists()){
            
           return true;
            
        }
        return false;
    }
    
    public void extraerDatos(){
        //Parseador Json 
        
        JSONParser parse = new JSONParser();
        
        try{
        
        // Se crea un objeto para guardar la informacion que se lee del archivo
            Object obj = parse.parse(new FileReader("registroConexion.json"));
            
            //se almacena en un objeto json 
            JSONObject jsonObject = (JSONObject) obj;
            
            //se extrae la lista del json 
            JSONArray conexionArray = (JSONArray) jsonObject.get("lista");
            
            //se recorre la lista de carros json 
            for(Object item:conexionArray){
                
                Conexion conexion = new Conexion();
                
                //se extrae el objeto json del array 
                JSONObject objectConexionJSON = (JSONObject) item;
                
                conexion.setServidor(objectConexionJSON.get("servidor").toString());
                conexion.setContrasenna(objectConexionJSON.get("contrasenna").toString());
                conexion.setBaseDeDatos(objectConexionJSON.get("baseDeDatos").toString());
                conexion.setUsuario(objectConexionJSON.get("usuario").toString());
                
                this.listaConexion.add(conexion);
                                              
                
            }
            
        }
            
        catch(FileNotFoundException ex){
            
        }
        catch(IOException ex){
            
        }
        catch(ParseException ex){
            
        }
        
    }
    
    public void escribirDatos(){
        //se crea la raiz del Json y la lista;
        JSONObject conexion = new JSONObject();
        
        JSONArray lista = new JSONArray();
        
        //se valida que la lista exista 
       
            for(Conexion item:this.listaConexion){
                
                JSONObject conexionJSON = new JSONObject();
                conexionJSON.put("servidor", item.getServidor());
                conexionJSON.put("contrasenna", item.getContrasenna());
                conexionJSON.put("baseDeDatos", item.getBaseDeDatos());
                conexionJSON.put("usuario", item.getUsuario());
                
                lista.add(conexionJSON);
          
            }
                    
                    
            conexion.put("lista", lista);
            
            try{
                FileWriter file= new FileWriter("registroConexion.json");
                file.write(conexion.toString());
                file.flush();//cierra el archivo y libera la memoria
            }
            catch(IOException ex){
                
            }

    }
    
    public ArrayList<Conexion> getLista(){
        return this.listaConexion;
    }
    
    public void setArray(ArrayList <Conexion> array){
        this.listaConexion=array;
    }
    
    public void agregar(Conexion pConexion){
        this.listaConexion.clear();
        this.listaConexion.add(pConexion);
        this.escribirDatos();
    }
    
    
    
    
    
}
