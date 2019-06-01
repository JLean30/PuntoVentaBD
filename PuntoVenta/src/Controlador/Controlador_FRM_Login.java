/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import  vista.FRM_Principal;
import  vista.FRM_Login;
import  modelo.Usuario;
/**
 *
 * @author Estudiante
 */
public class Controlador_FRM_Login implements ActionListener,KeyListener {
//variables de interfaz
    private FRM_Login  frmLogin;
    private FRM_Principal frmPrincipal;
    private Usuario usuarioDefault;
    private ConexionBD conexion;
    
    //Constructor de controlador
    
    public Controlador_FRM_Login(FRM_Login pFrmLogin,FRM_Principal pFrmPrincipal,ConexionBD conex){
        
       //se asigna la  referencia para las variables formularios
        this.frmLogin = pFrmLogin;
        this.frmPrincipal = pFrmPrincipal;
        this.conexion=conex;
    
        
       //Se crea el usuario por default
       this.usuarioDefault=new Usuario("admin","admin","","");
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //Accion de ingresar e iniciar session
        if(ae.getActionCommand().equals("Ingresar")){
            
           this.metodoLogin();
            
            
           
        }
        
        //accion de cerrar  la App
        if(ae.getActionCommand().equals("Cerrar")){
            //Cerrar  Sesion
            this.frmPrincipal.CerrarSesion();
        }
        
        
    }
    public void metodoLogin(){
           //Ingresar sesion
    
            Usuario usuarioLogueo=new Usuario(this.frmLogin.obtenerIntentoLogeo());
            if(usuarioLogueo.getUsuario().equals("")){
                this.frmLogin.mostrarMensaje("Ingrese el usuario");
            }else if(usuarioLogueo.getContrasena().equals("")){
                this.frmLogin.mostrarMensaje("Ingrese la contraseña");
            }else {
            if(this.logueoBD(usuarioLogueo)|| this.usuarioDefault(usuarioLogueo)){
                Controlador_FRM_Principal.usuarioLogueo=usuarioLogueo.getUsuario();
                this.frmLogin.mostrarMensaje("Bienvenido");
                this.frmLogin.setVisible(false);
                this.frmPrincipal.setVisible(true);
            }else{
                this.frmLogin.mostrarMensaje("Usuario o contraseña son incorrectos");
                this.frmLogin.estadoInicial();
            }
            }
            
    
    }
    
    public boolean logueoBD(Usuario usr){
        this.conexion.buscarUsuario(usr.getUsuario());
        if(this.conexion.getUsrTemp()!=null){
        Usuario usrVerificacion=this.conexion.getUsrTemp();
        if(usr.getContrasena().equals(usrVerificacion.getContrasena())){
            return true;
        }
        }
        
        return false;
    }
    
    public boolean usuarioDefault(Usuario usr){
        boolean usrdefault=false;
        if(usr.getUsuario().equals(usuarioDefault.getUsuario()) && 
                    usr.getContrasena().equals(usuarioDefault.getContrasena())){
                        usrdefault = true;
                       
            }
        return usrdefault;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
       
        

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
         this.metodoLogin();
         
     } 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
}
