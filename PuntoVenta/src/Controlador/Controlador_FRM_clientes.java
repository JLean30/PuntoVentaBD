/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.Cliente;
import vista.FRM_Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import java.util.ArrayList;

/**
 *
 * @author JeanC
 */
public class Controlador_FRM_Clientes implements ActionListener {
    
    private  FRM_Clientes frmClientes;
    private ConexionBD conexion;


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Limpiar")){

                //Metodo que mantiene los botones en limpios sin poder ser editados
                this.frmClientes.estadoInicial();
        
       }
        if(e.getActionCommand().equals("Buscar")){
            
                Cliente temporal = null;
                if(this.conexion.buscarCliente(this.frmClientes.getCedulaCliente())){
                    temporal = this.conexion.getClienteTemp();
                }
        //En caso de que exista un producto puede Eliminarlo/Modificarlo ..... Si existe puede agregarlo 
                if(temporal != null){
                    
                    this.frmClientes.setCedulaCliente(temporal.getCedulaCliente());
                    this.frmClientes.setNombre(temporal.getNombre());
                    this.frmClientes.setPrimerApellido(temporal.getPrimerApellido());
                    this.frmClientes.setSegundoApellido((temporal.getSegundoApellido()));
                    this.frmClientes.setTelefono((temporal.getTelefono()));
                    this.frmClientes.setDireccion(temporal.getDireccion());
                    this.frmClientes.setEmail((temporal.getEmail()));
                    
                    this.frmClientes.habilitarModificarEliminar();

                }
                else{
                    this.frmClientes.habilitarAgregar();
                    


                }
        }
        
        if(e.getActionCommand().equals("Registrar")){
                    Cliente cliente = null;
                    cliente = this.frmClientes.obtenerCliente();
                    this.conexion.registrarCliente(cliente);
                    String[] datos = new String[5];
                        datos[0] = cliente.getCedulaCliente();
                        datos[1] = cliente.getNombre()+""+cliente.getPrimerApellido()+""+cliente.getSegundoApellido();
                        datos[2] = cliente.getTelefono();
                        datos[3] = cliente.getDireccion();
                        datos[4]= cliente.getEmail();
                    this.frmClientes.agregarUsuarioTabla(datos);
                    this.frmClientes.mostrarMensaje("Cliente registrado correctamente");
                    this.frmClientes.estadoInicial();
        }
        
        if(e.getActionCommand().equals("Modificar")){
                    Cliente nuevoCliente = null;
                    nuevoCliente = this.frmClientes.obtenerCliente();
                    this.conexion.modificarCliente(nuevoCliente);
                    String[] datos = new String[5];
                        datos[0] = nuevoCliente.getCedulaCliente();
                        datos[1] = nuevoCliente.getNombre()+""+nuevoCliente.getPrimerApellido()+""+nuevoCliente.getSegundoApellido();
                        datos[2] = nuevoCliente.getTelefono();
                        datos[3] = nuevoCliente.getDireccion();
                        datos[4]= nuevoCliente.getEmail();
                    this.frmClientes.modificarUsuarioTabla(datos);
                    this.frmClientes.estadoInicial();
                    this.frmClientes.mostrarMensaje("Cliente modificado");
                }
        
        if(e.getActionCommand().equals("Eliminar")){

                    this.conexion.eliminarCliente(this.frmClientes.getCedulaCliente());
                    this.frmClientes.eliminarUsuarioTabla(this.frmClientes.getCedulaCliente());
                    this.frmClientes.estadoInicial();
                    this.frmClientes.mostrarMensaje("Cliente eliminado");
                }
    }
    public void inicioTabla(ArrayList<Cliente> array){
        for(Cliente item:array){
            if(item!=null){
                String[] datos=new String[5];
                datos[0] = item.getCedulaCliente();
                        datos[1] = item.getNombre()+""+item.getPrimerApellido()+""+item.getSegundoApellido();
                        datos[2] = item.getTelefono();
                        datos[3] = item.getDireccion();
                        datos[4]= item.getEmail();
                this.frmClientes.agregarUsuarioTabla(datos);
                
            }
        }
    }
    
   
        public Controlador_FRM_Clientes(FRM_Clientes frm, ConexionBD conex){//frm es la interfaz
            this.frmClientes = frm;
            this.conexion=conex;

        }
    
}
