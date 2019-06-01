/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.Conexion;
import modelo.ConexionBD;
import vista.FRM_ParametrosConexion;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Zuniga
 */
public class Controlador_FRM_ParametrosConexion implements ActionListener {
    
    private FRM_ParametrosConexion FRMParametros;
    
    private Conexion parametros;
    

    
    public ArchivoConexion archivoC;
    
    ///

    public Controlador_FRM_ParametrosConexion(FRM_ParametrosConexion frm) {
        
        parametros = new Conexion();
        

        
        FRMParametros = frm;
        
        archivoC = new ArchivoConexion();
        
      
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("Guardar")){
            
   
            parametros = this.FRMParametros.obtenerInformacion();
            
            this.archivoC.agregar(parametros);
            
            this.FRMParametros.mostrarMensaje("Informacion almacenada correctamente");
            
        }
        
    }
    
    
    
}
