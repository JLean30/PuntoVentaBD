/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Vista.Frm_Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Frm_Productos;
import Vista.Frm_Proveedores;
import Vista.Frm_Login;
import Vista.Frm_Principal;
import Vista.Frm_Usuarios;
import Vista.Frm_Facturacion;
import Vista.FRM_BancoInformacion;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controlador_FRM_Principal implements ActionListener{
    
private Frm_Productos frmProductos;
private Frm_Clientes frmClientes;
private Frm_Proveedores frmProveedores;

public Frm_Login frmLogin;
public Frm_Principal frmPrincipal;

private Frm_Usuarios frmUsuarios;
private Frm_Facturacion frmFacturacion;

//variable interfaz  banco de informacion
private  FRM_BancoInformacion  frmBancoInformacion;

//variable estatica para almacenar  la direccion del  archivo  usuario
public static String  direccionBancoActual="";


    public Controlador_FRM_Principal(Frm_Principal pFrmPrincipal) {
        
        this.frmProductos = new Frm_Productos();
        this.frmUsuarios = new Frm_Usuarios();
        this.frmClientes = new Frm_Clientes();
        this.frmProveedores = new Frm_Proveedores();
        
        //se crea  una instancia de  banco de informacion
        this.frmBancoInformacion = new FRM_BancoInformacion(this);
        
        
        this.frmFacturacion = new Frm_Facturacion(this.frmClientes.controlador.metodosClientes, this.frmProductos.controlador.metodosProductos);
        this.frmPrincipal= pFrmPrincipal;
         this.frmLogin = new Frm_Login(this.frmPrincipal);
         
         
         this.frmLogin.controlador.asignaMetodosUsuarios(this.frmUsuarios.controlador.metodosUsuarios);
         
        this.frmLogin.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getActionCommand().equals("Salir")){
            
            System.exit(0);
        }
        
        if(ae.getActionCommand().equals("Productos")){
            
            this.frmProductos.setVisible(true);
        }
        
        if(ae.getActionCommand().equals("Clientes")){
            
            this.frmClientes.setVisible(true);
        }
        
        if(ae.getActionCommand().equals("Proveedores")){
            
            this.frmProveedores.setVisible(true);
        }
        
          if(ae.getActionCommand().equals("Facturacion")){
            
            this.frmFacturacion.setVisible(true);
        }
        
        if(ae.getActionCommand().equals("Cerrar Sesion")){
            // se oculta el principal
            this.frmPrincipal.setVisible(false);
            
           this.frmLogin.estadoInicial();
            //se muestra el formulario logueo
            this.frmLogin.setVisible(true);
            
            
        }
        
        if(ae.getActionCommand().equals("Perfiles de Usuarios")){
            
            this.frmUsuarios.setVisible(true);
            
        }
        
        //se visualiza  el formulario de  banco informacion
        if(ae.getActionCommand().equals("BancoInformacion")){
            this.frmBancoInformacion.setVisible(true);
            
        }
        
        
        
    }
    
    public   void  recargarArchivo(){
        this.frmUsuarios.controlador.archivo.crearArchivo();
        this.frmUsuarios.recargarArchivo();
    }
            
    

    
}//cierre de  clase
