/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import Vista.Frm_Principal;
import Vista.Frm_Login;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controlador_FRM_Login implements ActionListener, KeyListener {

    private Frm_Login frmLogin;
    private Frm_Principal frmPrincipal;
    private MetodosUsuarios metodosUsuarios;
    private ArchivoUsuarios archivo;
    
    public Controlador_FRM_Login(Frm_Login pFrmLogin, Frm_Principal pFrmPrincipal){
        this.frmLogin= pFrmLogin;
        this.frmPrincipal= pFrmPrincipal;
       this.archivo = new ArchivoUsuarios();
        this.metodosUsuarios = new MetodosUsuarios(this.archivo.getUsuarios());
        
      //  this.metodosUsuarios.agregar(new Usuario ("admin", "admin","Administrador de sistema", "Administrador"));
    }
    
    // metodo para recivir la informacion de usuarios
    
    public void asignaMetodosUsuarios(MetodosUsuarios pMetodos){
        
        this.metodosUsuarios = pMetodos;
        
        
    }
      
    
    public void intentoLogueo(){
        
                    
            if(this.metodosUsuarios.buscar(this.frmLogin.obtenerIntentoLogeo())){
                
           
           this.frmLogin.mostrarMensaje("Bienvenido");
           
           this.frmLogin.setVisible(false);
            
            this.frmPrincipal.setVisible(true);
            
            
            
            }else{
                
                this.frmLogin.mostrarMensaje("Usuario o contraseña incorrectos");
                this.frmLogin.estadoInicial();
            }
    }
            
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("Ingresar")){

            this.intentoLogueo();
            
            
        }
        if(ae.getActionCommand().equals("Cerrar")){
            this.frmPrincipal.CerrarSesion();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
if(ke.getKeyCode()==ke.VK_ENTER){
    this.intentoLogueo();
}
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
