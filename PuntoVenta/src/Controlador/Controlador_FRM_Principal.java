/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import  vista.FRM_Productos;
import  vista.FRM_Login;
import  vista.FRM_Principal;
import  vista.FRM_Usuarios;
import vista.FRM_Clientes;
import vista.FRM_Provedores;
import vista.FRM_ControlVentas;
import vista.FRM_Facturacion;
import modelo.ConexionBD;
import vista.FRM_ParametrosConexion;
import controlador.ArchivoConexion;
import modelo.Conexion;





/**
 *
 * @author Melber
 */
public class Controlador_FRM_Principal implements ActionListener {

    //Formulario de productos
    private FRM_Productos frmProductos;
 //formulario de login
    public  FRM_Login  frmLogin;
    
    //formulario  principal
    public  FRM_Principal frmPrincipal;
    private FRM_Provedores frmProvedores;
    private FRM_Clientes frmClientes;
    private FRM_ControlVentas frmControlVentas;

    //formulario de usuarios
    private FRM_Usuarios frmUsuarios;
    private FRM_Facturacion frmFacturacion;
    private ConexionBD conexion;
    private FRM_ParametrosConexion frmConexion;
    private ArchivoConexion archivo;
    
    public static String usuario="root";
    public static String servidor="127.0.0.1";
    public static String contraseña="";
    public static String baseDeDatos="puntoVenta";
    public static String usuarioLogueo="";

    public Controlador_FRM_Principal(FRM_Principal pFRMPrincipal){
        this.frmPrincipal = pFRMPrincipal;
        
        this.archivo=new ArchivoConexion();
        if(this.archivo.verificarArchivo()){
            Conexion temp=this.archivo.getLista().get(0);
            usuario=temp.getUsuario();
            servidor=temp.getServidor();
            contraseña=temp.getContrasenna();
            baseDeDatos=temp.getBaseDeDatos();
            this.frmPrincipal.mostrarMensaje("base de datos cargada con configuración guardada");
            
        }else{
            this.frmPrincipal.mostrarMensaje("base de datos cargada con configuración default");
        }
        this.conexion=new ConexionBD();
        
        //instancia de formulario productos
        this.frmProductos = new FRM_Productos(this.conexion);

        //instancia de formulario de usuarios Version Clase08
        this.frmUsuarios  = new FRM_Usuarios(this.conexion);
        
        ///referencia de formulario principal
        
        
        this.frmConexion=new FRM_ParametrosConexion();
        //ESTO LO PUSE YO PARA QUE ABRIERA LA VENTANA XD
        this.frmControlVentas=new FRM_ControlVentas(conexion);
        
        //intancia de formulario login
        this.frmLogin = new FRM_Login(this.frmPrincipal,this.conexion);
        this.frmProvedores = new FRM_Provedores(this.conexion);
        this.frmClientes = new FRM_Clientes(this.conexion);
        this.frmFacturacion=new FRM_Facturacion(conexion, this.frmControlVentas);
        
        
        
        
        this.frmPrincipal.setVisible(false);
        this.frmLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Salir")){
            System.exit(0);
        }
        
        if(e.getActionCommand().equals("Productos")){
            this.frmProductos.setVisible(true);
        }
        if(e.getActionCommand().equals("Provedores")){
                    this.frmProvedores.setVisible(true);
                    
                }
                
                if(e.getActionCommand().equals("Clientes")){
                    this.frmClientes.setVisible(true);
                }
                if(e.getActionCommand().equals("Facturación")){
                    this.frmFacturacion.setJTUsuario(usuarioLogueo);
                    //establecer numero de factura Disponible
                    this.frmFacturacion.countFact=this.conexion.obtenerNumeroFactura();
                    this.frmFacturacion.setJtxNumero(this.frmFacturacion.countFact);
                    this.frmFacturacion.setVisible(true);
                }
                if(e.getActionCommand().equals("Control de Ventas")){
                    this.frmControlVentas.totalF();
                    this.frmControlVentas.setVisible(true);
                }
        
        if(e.getActionCommand().equals("CerrarSesion")){
            //cerrar el principal
            this.frmPrincipal.setVisible(false);
    
            this.frmLogin.estadoInicial();
            //Se muestra  el formulario de login
            this.frmLogin.setVisible(true);
            
        
            
        }
        
        if(e.getActionCommand().equals("Perfiles de Usuarios")){
            this.frmUsuarios.setVisible(true);
        }
        if(e.getActionCommand().equals("ParametrosConexion")){
            this.frmConexion.setVisible(true);
         
        }
        
    }

    
    
    
    
}//cierra clase
