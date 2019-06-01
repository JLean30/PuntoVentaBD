/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;//permite crear los objetos conexionw
import java.sql.DriverManager;//permite utilizar driver
import java.sql.Statement;//realizar comando sql
import java.sql.ResultSet;//permite leer los datos de las base de datos 
import java.util.ArrayList;




public class ConexionBD {
    private Connection  conexion = null;
    private Producto  producto  = null;
    private Cliente cliente=null;
    private Usuario usuario=null;
    private Provedor proveedor=null;
    private Factura factura=null;
    
    
    public ConexionBD(){
        this.realizarConexion();
    }
    
    public  void realizarConexion(){
        try{
        String usuario = controlador.Controlador_FRM_Principal.usuario;
        String password=controlador.Controlador_FRM_Principal.contraseña;
        
        String url = "jdbc:mysql://"+controlador.Controlador_FRM_Principal.servidor+":3306/"+controlador.Controlador_FRM_Principal.baseDeDatos+"";
       //String url = "jdbc:mysql://localhost:3306/puntoventa";
        
        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
         
        this.conexion = DriverManager.getConnection(url, usuario, password);
          System.out.println("Conexión Realizada");
          
        }
        catch(Exception ex){
            System.out.println("No se logró realizar la conexión " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    // metodos de conexion para productos
    
    public  boolean  registrarProducto(Producto  pProducto){
     
        Statement comando = null;
     
        
        try{
            comando = this.conexion.createStatement();
            comando.execute("INSERT INTO productos(codigo, descripcion, precioCompra, Descuento, Impuesto, FechaRegistro, PrecioVenta) VALUES ('"+
                    pProducto.getCodigo()+ "','" +  pProducto.getDescripcion() + "'," + pProducto.getPrecioCompra() + "," + pProducto.getPorDescuento()+ "," +
                    pProducto.getPorImpuesto() +",STR_TO_DATE('" + pProducto.getFechaRegistro()+ "','%d/%m/%Y ')," + pProducto.precioVenta() +")" );
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
                    "',`precioCompra`=" + pProducto.getPrecioCompra() + ",`Descuento`=" + pProducto.getPorDescuento() +
                    ",`Impuesto`="+ pProducto.getPorImpuesto()+ ",`FechaRegistro`='" + pProducto.getFechaRegistro()+
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
                if(lector.getString("codigo").equalsIgnoreCase(pCodigo)){
                    this.producto = new Producto(lector.getString("codigo"),lector.getString("descripcion"),
                            Double.parseDouble(lector.getString("preciocompra")), Double.parseDouble(lector.getString("descuento")),
                            Double.parseDouble(lector.getString("impuesto")), lector.getString("fecharegistro"));
                    
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
    //Metodos de conexion para clientes
    public boolean registrarCliente(Cliente cliente){
        Statement comando=null;
        
        try{
            comando=this.conexion.createStatement();
            comando.execute("Insert Into clientes(cedula,nombre,primerApellido,segundoApellido,telefono,direccion,email) Values('"+
                    cliente.getCedulaCliente()+"','"+cliente.getNombre()+"','"+cliente.getPrimerApellido()+"','"+
                    cliente.getSegundoApellido()+"','"+cliente.getTelefono()+"','"+cliente.getDireccion()+"','"+cliente.getEmail()+"')");
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public boolean modificarCliente(Cliente cliente){
        Statement comando=null;
        
        try{
            String sql;
            sql="UPDATE `clientes` SET"
                +"`cedula`='"+cliente.getCedulaCliente()+"',`nombre`='"+cliente.getNombre()+"',`primerApellido`='"+cliente.getPrimerApellido()+
                "',`segundoApellido`='"+cliente.getSegundoApellido()+"',`telefono`='"+cliente.getTelefono()+"',`direccion`='"+cliente.getDireccion()+
                "',`email`='"+cliente.getEmail()+ "'WHERE cedula = '"+cliente.getCedulaCliente()+"'";
            comando=this.conexion.createStatement();
            comando.execute(sql);
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public boolean  eliminarCliente(String cedula){
        Statement  comando = null;
        try{
            comando = this.conexion.createStatement();
            
            String  sql="DELETE FROM `clientes` WHERE cedula = '"+  cedula +"'";
            comando.execute(sql);
            return  true;
        }
        catch(Exception ex){
            System.out.println("No se logró eliminar el Cliente" + ex.getMessage());
            return  false;
        }
    }
    
    
    public  boolean  buscarCliente(String cedula){
        Statement  comando =  null;
        ResultSet    lector = null;
        boolean encontrado  = false;
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from clientes");
            
            while(lector.next()){
                if(lector.getString("cedula").equals(cedula)){
                    
                    this.cliente = new Cliente(lector.getString("cedula"),lector.getString("nombre"),
                            lector.getString("primerApellido"), lector.getString("segundoApellido"),
                            (lector.getString("telefono")), lector.getString("direccion"),lector.getString("email"));
                    
                    encontrado  = true;
                    break;
                    
                }
            }
            lector.close();
            return  encontrado;
          
            
        }
        catch(Exception ex){
            System.out.print("No se logró buscar el Cliente " + ex.getMessage());
            return  false;
        }
    }
    
    //Metodos de conexion para proveedores
    public boolean registrarProveedor(Provedor pProvedor){
        Statement comando=null;
        char mon=this.stringACharMonedaProveedores(pProvedor.getMoneda());
        try{
            comando=this.conexion.createStatement();
            comando.execute("Insert Into proveedores(cedula,montoCredito,nombreComercial,contacto,direccionExacta,diasCredito,moneda) Values('"+
                    pProvedor.getCedulaJuridica()+"','"+pProvedor.getMontoCredito()+"','"+pProvedor.getNombreComercial()+"','"+
                    pProvedor.getContacto()+"','"+pProvedor.getDireccion()+"','"+pProvedor.getDiasCredito()+"','"+mon+"')");
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public boolean modificarProveedor(Provedor pProveedor){
        Statement comando=null;
        char mon=this.stringACharMonedaProveedores(pProveedor.getMoneda());
        
        try{
            String sql;
            sql="UPDATE `proveedores` SET"
                +"`cedula`='"+pProveedor.getCedulaJuridica()+"',`nombreComercial`='"+pProveedor.getNombreComercial()+"',`contacto`='"+pProveedor.getContacto()+
                "',`montoCredito`='"+pProveedor.getMontoCredito()+"',`moneda`='"+mon+"',`direccionExacta`='"+pProveedor.getDireccion()+
                "',`diasCredito`='"+pProveedor.getDiasCredito()+ "'WHERE cedula = '"+pProveedor.getCedulaJuridica()+"'";
            comando=this.conexion.createStatement();
            comando.execute(sql);
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public boolean  eliminarProveedor(String cedula){
        Statement  comando = null;
        try{
            comando = this.conexion.createStatement();
            
            String  sql="DELETE FROM `proveedores` WHERE cedula = '"+  cedula +"'";
            comando.execute(sql);
            return  true;
        }
        catch(Exception ex){
            System.out.println("No se logró eliminar el Proveedor" + ex.getMessage());
            return  false;
        }
    }
    
    
    public  boolean  buscarProveedor(String cedula){
        Statement  comando =  null;
        ResultSet    lector = null;
        boolean encontrado  = false;
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from proveedores");
            
            while(lector.next()){
                if(lector.getString("cedula").equals(cedula)){
                    String mon=this.charAStringMonedaProveedores(lector.getString("moneda"));
                    
                    this.proveedor = new Provedor(lector.getString("cedula"),lector.getString("nombreComercial"),
                            lector.getString("contacto"), lector.getString("direccionExacta"),
                            (lector.getString("montoCredito")), Double.parseDouble(lector.getString("diasCredito")),mon);
                    encontrado  = true;
                    break;
                    
                }
            }
            lector.close();
            return  encontrado;
          
            
        }
        catch(Exception ex){
            System.out.print("No se logró buscar el Proveedor " + ex.getMessage());
            return  false;
        }
    }
    
    //Metodos de conexion para Usuarios
    public boolean registrarUsuario(Usuario usr){
        Statement comando=null;
        char tip=this.stringACharUsuarioTipo(usr.getTipo());
        try{
            comando=this.conexion.createStatement();
            comando.execute("Insert Into usuarios(usuario,contrasena,nombreCompleto,tipo) Values('"+
                    usr.getUsuario()+"','"+usr.getContrasena()+"','"+usr.getNombreCompleto()+"','"+
                    tip+"')");
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public boolean modificarUsuario(Usuario usr){
        Statement comando=null;
        char tip=this.stringACharUsuarioTipo(usr.getTipo());
        try{
            String sql;
            sql="UPDATE `usuarios` SET"
                +"`usuario`='"+usr.getUsuario()+"',`contrasena`='"+usr.getContrasena()+"',`nombreCompleto`='"+usr.getNombreCompleto()+
                "',`tipo`='"+tip+"'WHERE usuario = '"+usr.getUsuario()+"'";
            comando=this.conexion.createStatement();
            comando.execute(sql);
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public boolean  eliminarUsuario(String usuario){
        Statement  comando = null;
        try{
            comando = this.conexion.createStatement();
            
            String  sql="DELETE FROM `usuarios` WHERE usuario = '"+  usuario +"'";
            comando.execute(sql);
            return  true;
        }
        catch(Exception ex){
            System.out.println("No se logró eliminar el Cliente" + ex.getMessage());
            return  false;
        }
    }
    
    
    public  boolean  buscarUsuario(String usuario){
        Statement  comando =  null;
        ResultSet    lector = null;
        boolean encontrado  = false;
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from usuarios");
            
            while(lector.next()){
                if(lector.getString("usuario").equals(usuario)){
                    String tip=this.charAStringUsuarioTipo(lector.getString("tipo"));
                    
                    this.usuario = new Usuario(lector.getString("usuario"),lector.getString("contrasena"),
                            lector.getString("nombreCompleto"), tip);
                   
                    encontrado  = true;
                    break;
                    
                }
            }
            lector.close();
            return  encontrado;
          
            
        }
        catch(Exception ex){
            System.out.print("No se logró buscar el usuario " + ex.getMessage());
            return  false;
        }
    }
    
    public char stringACharUsuarioTipo(String tipo){
        char tip=' ';
        switch(tipo) {
           
            case "Administrador":
                tip='A';
            break;
            
            case "Cajero":
                tip='C';
            break;
            
            case "Vendedor":
                tip='V';
            break;
               
        }
        return tip;
        
    }
    public String charAStringUsuarioTipo(String tip){
        String tipo="";
        switch(tip) {
           
            case "A":
                tipo="Administrador";
            break;
            
            case "C":
                tipo="Cajero";
            break;
            
            case "V":
                tipo="Vendedor";
            break;
               
        }
        return tipo;
    }
    public char stringACharMonedaProveedores(String mon){
        char moneda=' ';
        switch(mon) {
           
            case "Dólar":
                moneda='D';
            break;
            
            case "Colón":
                moneda='C';
            break;
            
               
        }
        return moneda;
        
    }
    public String charAStringMonedaProveedores(String moneda){
        String mon="";
        switch(moneda) {
           
            case "C":
                mon="Colón";
            break;
            
            case "D":
                mon="Dólar";
            break;
               
        }
        return mon;
    }
    
    //Metodo facturas
    
    public boolean registrarFactura(Factura fact){
        Statement comando=null;
        try{
            comando=this.conexion.createStatement();
            comando.execute("Insert Into facturas(codFactura,codCliente,detalleFactura,fechaFactura,monto) Values('"+
                    fact.getCodFactura()+"','"+fact.getCodCliente()+"','"+fact.getDetalle()+"',STR_TO_DATE('"+
                    fact.getFecha()+"','%d/%m/%Y '),'"+fact.getMonto()+"')");

            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    
    

    
   public Usuario getUsrTemp(){
        return this.usuario;
    }
   public Cliente getClienteTemp(){
        return this.cliente;
    }
   public Provedor getProveedorTemp(){
       return this.proveedor;
   }
   public Producto  getProductoTemporal(){
        return  this.producto;
    }
    //tabla interfaz Usuario
    public ArrayList<Usuario> tablaActualizarUsuarios(){
        Statement  comando =  null;
        ResultSet    lector = null;
        ArrayList<Usuario> array=new ArrayList<Usuario>();
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from usuarios");
            
            while(lector.next()){
                
                    String tip=this.charAStringUsuarioTipo(lector.getString("tipo"));
                    Usuario usr = new Usuario(lector.getString("usuario"),lector.getString("contrasena"),
                            lector.getString("nombreCompleto"), tip);
                   
                
                array.add(usr);
                
            }
            lector.close();
          

        }
        catch(Exception ex){
            System.out.print("No se logró buscar el usuario " + ex.getMessage());
           
        }
        return array;
         
    }
    
    //tabla interfaz clientes
    public ArrayList<Cliente> tablaActualizarClientes(){
        Statement  comando =  null;
        ResultSet    lector = null;
        ArrayList<Cliente> array=new ArrayList<Cliente>();
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from clientes");
            
            while(lector.next()){
                
                     Cliente cl = new Cliente(lector.getString("cedula"),lector.getString("nombre"),
                            lector.getString("primerApellido"), lector.getString("segundoApellido"),
                            (lector.getString("telefono")), lector.getString("direccion"),lector.getString("email"));
                   
                
                array.add(cl);
                
            }
            lector.close();
          

        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
           
        }
        return array;
         
    }
    
    //tabla proveedores
    
    public ArrayList<Provedor> tablaActualizarProveedores(){
        Statement  comando =  null;
        ResultSet    lector = null;
        ArrayList<Provedor> array=new ArrayList<Provedor>();
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from proveedores");
            
            while(lector.next()){
                
                     String mon=this.charAStringMonedaProveedores(lector.getString("moneda"));
                    
                    Provedor pr = new Provedor(lector.getString("cedula"),lector.getString("nombreComercial"),
                            lector.getString("contacto"), lector.getString("direccionExacta"),
                            (lector.getString("montoCredito")), Double.parseDouble(lector.getString("diasCredito")),mon);
                   
                
                array.add(pr);
                
            }
            lector.close();
          

        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
           
        }
        return array;
         
    }
    
    //tabla productos
    
    public ArrayList<Producto> tablaActualizarProductos(){
        Statement  comando =  null;
        ResultSet    lector = null;
        ArrayList<Producto> array=new ArrayList<Producto>();
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from productos");
            
            while(lector.next()){
                
                    
                    Producto pd = new Producto(lector.getString("codigo"),lector.getString("descripcion"),
                            Double.parseDouble(lector.getString("preciocompra")), Double.parseDouble(lector.getString("descuento")),
                            Double.parseDouble(lector.getString("impuesto")), lector.getString("fecharegistro"));
                   
                
                array.add(pd);
                
            }
            lector.close();
          

        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
           
        }
        return array;
         
    }
    
     public ArrayList<Factura> tablaActualizarFacturas(){
        Statement  comando =  null;
        ResultSet    lector = null;
        ArrayList<Factura> array=new ArrayList<Factura>();
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from facturas");
            
            while(lector.next()){
                
                    
                    Factura fact = new Factura(lector.getString("codFactura"),lector.getString("codCliente"),
                            lector.getString("detalleFactura"), lector.getString("fechaFactura"),
                            lector.getString("monto"));
                   
                
                array.add(fact);
                
            }
            lector.close();
          

        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
           
        }
        return array;
         
    }
     
     public ArrayList<Factura> tablaConsultaFacturasCliente(String cedula){
        Statement  comando =  null;
        ResultSet    lector = null;
        ArrayList<Factura> array=new ArrayList<Factura>();
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  *from facturas "
                    + "where codCliente like '"+cedula+"'");
            
            
            while(lector.next()){
                
                    
                    Factura fact = new Factura(lector.getString("codFactura"),lector.getString("codCliente"),
                            lector.getString("detalleFactura"), lector.getString("fechaFactura"),
                            lector.getString("monto"));
                   
                
                array.add(fact);
                
            }
            lector.close();
          

        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
           
        }
        return array;
         
    }
     
    public ArrayList<Factura> tablaConsultaNumeroFacturas(String numFact){
        Statement  comando =  null;
        ResultSet    lector = null;
        ArrayList<Factura> array=new ArrayList<Factura>();
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  *from facturas "
                    + "where codFactura like '"+numFact+"'");
            
            
            while(lector.next()){
                
                    
                    Factura fact = new Factura(lector.getString("codFactura"),lector.getString("codCliente"),
                            lector.getString("detalleFactura"), lector.getString("fechaFactura"),
                            lector.getString("monto"));
                   
                
                array.add(fact);
                
            }
            lector.close();
          

        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
           
        }
        return array;
         
    }
    public ArrayList<Factura> tablaConsultaFechaFacturas(String fecha){
        Statement  comando =  null;
        ResultSet    lector = null;
        ArrayList<Factura> array=new ArrayList<Factura>();
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  *from `facturas` "
                    + "where fechaFactura = '"+fecha+"'");
            
            
            while(lector.next()){
                
                    
                    Factura fact = new Factura(lector.getString("codFactura"),lector.getString("codCliente"),
                            lector.getString("detalleFactura"), lector.getString("fechaFactura"),
                            lector.getString("monto"));
                   
                
                array.add(fact);
                
            }
            lector.close();
          

        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
           
        }
        return array;
         
    }
    
    public int obtenerNumeroFactura(){
        Statement  comando =  null;
        ResultSet    lector = null;
        int numFact=0;
        
        try{
            comando  = this.conexion.createStatement();
            lector  =  comando.executeQuery("select  * from facturas");
            
            while(lector.next()){
                
                   int numeroFactBd=Integer.parseInt(lector.getString("codFactura"));
                   if(numFact!=numeroFactBd){
                       numFact=numeroFactBd; 
                   }
                   numFact++;
 
            }
            lector.close();
        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
           
        }
         return numFact; 
    }
    
    
}//cierre de clase
