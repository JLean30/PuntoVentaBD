/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class ConexionBD {
    private Connection  conexion = null;
    private Producto  producto  = null;
    
    public ConexionBD(){
        this.realizarConexion();
    }
    
    public  void realizarConexion(){
        try{
        String usuario = "root";
        String password="";
        String url = "jdbc:mysql://localhost:3306/PuntoVenta";
        
        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
         
        this.conexion = DriverManager.getConnection(url, usuario, password);
          System.out.println("Conexión Realizada");
          
        }
        catch(Exception ex){
            System.out.println("No se logró realizar la conexión " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
    public  boolean  registrarProducto(Producto  pProducto){
     
        Statement comando = null;
     
        
        try{
            comando = this.conexion.createStatement();
            comando.execute("INSERT INTO productos(codigo, descripcion, precioCompra, Descuento, Impuesto, FechaRegistro, PrecioVenta) VALUES ('"+
                    pProducto.getCodigo()+ "','" +  pProducto.getDescripcion() + "'," + pProducto.getPrecioCompra() + "," + pProducto.getDescuento() + "," +
                    pProducto.getImpuesto() +",STR_TO_DATE('" + pProducto.getFecha() + "','%m/%d/%Y')," + pProducto.precioVenta() +")" );
            return  true;
            
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public  boolean  modificarProducto(Producto pProducto){
        Statement  comando = null;
        try{
            String  sql;
            sql = "UPDATE `productos` SET "
                    + " `codigo`='" + pProducto.getCodigo() +"',`descripcion`= '" + pProducto.getDescripcion() +
                    "',`precioCompra`=" + pProducto.getPrecioCompra() + ",`Descuento`=" + pProducto.getDescuento() +
                    ",`Impuesto`="+ pProducto.getImpuesto() + ",`FechaRegistro`='" + pProducto.getFecha()+
                    "',`PrecioVenta`=" + pProducto.precioVenta()+ " WHERE codigo = '" + pProducto.getCodigo() +"'";
            
            comando  =  this.conexion.createStatement();
            comando.execute(sql);
            return  true;
        }
        catch(Exception ex){
            System.out.println("No se logró modificar el producto " +ex.getMessage());
            return  false;
        }
    }
    
    
    public boolean  eliminarProducto(String pCodigo){
        Statement  comando = null;
        try{
            comando = this.conexion.createStatement();
            
            String  sql="DELETE FROM `productos` WHERE codigo = '"+  pCodigo +"'";
            comando.execute(sql);
            return  true;
        }
        catch(Exception ex){
            System.out.println("No se logró eliminar el producto" + ex.getMessage());
            return  false;
        }
    }
    
    
    public  boolean  buscarProducto(String pCodigo){
        Statement  comando =  null;
        ResultSet    lector = null;
        boolean encontrado  = false;
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from productos");
            
            while(lector.next()){
                if(lector.getString("codigo").equals(pCodigo)){
                    this.producto = new Producto(lector.getString("codigo"),lector.getString("descripcion"), lector.getString("FechaRegistro"),
                            Double.parseDouble(lector.getString("precioCompra")), Double.parseDouble(lector.getString("Descuento")),
                            Double.parseDouble(lector.getString("Impuesto")));
                    encontrado  = true;
                    break;
                    
                }
            }
            lector.close();
            return  encontrado;
          
            
        }
        catch(Exception ex){
            System.out.print("No se logró buscar el producto " + ex.getMessage());
            return  false;
        }
    }
    
    
    public Producto  getProductoTemporal(){
        return  this.producto;
    }
    
}//cierre de clase
