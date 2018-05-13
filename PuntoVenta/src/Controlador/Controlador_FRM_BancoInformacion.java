/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import  java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FRM_BancoInformacion;

import javax.swing.JFileChooser;
import  java.io.File;



public class Controlador_FRM_BancoInformacion implements ActionListener {
//variable  de tipo interfaz
    private  FRM_BancoInformacion  frmBancoInformacion;
    
    //variable de  tipo  archivo
    private  File  archivo;
    
    //variable para el controlador  principal
    private Controlador_FRM_Principal  controladorPrincipal;
    
    //constructor de clase
    public Controlador_FRM_BancoInformacion(FRM_BancoInformacion  frm, 
            Controlador_FRM_Principal pControladorPrincipal){
        this.frmBancoInformacion  = frm;
        
        this.controladorPrincipal = pControladorPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //controlamos el evento seleccionar direccion
        if(ae.getActionCommand().equals("SeleccionarDireccion")){
            //se intancia el  File chooser
            JFileChooser  ruta = new JFileChooser();
            
            //se indica el modo de seleccion
            ruta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            //se visualiza el dialogo de busqueda
            ruta.showOpenDialog(null);
            
            //se toma el direcctorio seleccionado
            this.archivo  = ruta.getSelectedFile();
            
            //se contruye la  ruta del  nuevo  banco de informacion
            this.archivo =  new File(this.archivo.getAbsolutePath()+ "\\" +
                    this.frmBancoInformacion.getJT_NombreBancoNuevo().getText());
            
            //se muestra  la  nueva direccion del  banco de informacion
            this.frmBancoInformacion.getJT_DireccionNuevoBanco().setText(this.archivo.getAbsolutePath());
            
            
            
        }
        
        
        if(ae.getActionCommand().equals("Crear")){
            
            //se crea el  direcctorio
                this.archivo.mkdir();
                this.frmBancoInformacion.mostrarMensaje("Banco creado de forma correcta");
                this.frmBancoInformacion.estadoInicial();
        }
        
        
        if(ae.getActionCommand().equals("SeleccionarBanco")){
            JFileChooser  ruta =  new JFileChooser();
            ruta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            ruta.showOpenDialog(null);
            
            this.archivo  =  ruta.getSelectedFile();
            
            this.frmBancoInformacion.getDireccionBancoTrabajar().setText(this.archivo.getAbsolutePath()+"\\");
            
        }
        
        
        if(ae.getActionCommand().equals("Aplicar")){
            this.frmBancoInformacion.mostrarMensaje("Se cargarán todos los archivos correspondientes al nuevo "+
                    "banco de información. Debe iniciar sessión nuevamente");
            
            this.controladorPrincipal.direccionBancoActual = this.archivo.getAbsolutePath()+"\\";
            
            this.controladorPrincipal.recargarArchivo();
            
            this.controladorPrincipal.frmPrincipal.setVisible(false);
            this.frmBancoInformacion.setVisible(false);
            this.controladorPrincipal.frmLogin.estadoInicial();
            this.controladorPrincipal.frmLogin.setVisible(true);
            
        }
        
        
    }
    
}
