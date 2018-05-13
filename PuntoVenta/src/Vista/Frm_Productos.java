/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.Controlador_FRM_productos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.Producto;
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Frm_Productos extends javax.swing.JFrame {

    public Controlador_FRM_productos controlador;
    
        private DefaultTableModel modelo;
        
        private Producto producto;
    /**
     * Creates new form Frm_Productos
     */
    public Frm_Productos() {
        initComponents();
        //el parametro this, envia todo el esquema de la interfaz//
        this.controlador= new Controlador_FRM_productos(this);  /*controlador recibe todos los datos de la interfaz productos*/
        this.jP_Botones2.agregarControladorP(controlador);
        this.estadoInicial();
        
         String [] columnas = new String [7];
       columnas[0] = "Código";
       columnas[1] = "Descripción";
       columnas[2] = "Precio Compra";
       columnas[3] = "%Descuento";
       columnas[4] = "%Impuesto";
       columnas[5] = "Fecha Registro";
       columnas[6] = "Precio Venta";
       
       this.modelo = new DefaultTableModel();
       
      this.modelo.setColumnIdentifiers(columnas);
        
      this.jl_ListaProductos.setModel(modelo);
        
    }
//extraer datos digitados por el usuario//
    public String getCodigo(){
        
        return this.jt_Codigo.getText();
    }
     public String getDescripcion(){
        
        return this.jt_Descripcion.getText();
    }
      public double getPrecioCompra(){
        
        return Double.parseDouble( this.jt_PrecioCompra.getText( ) );
    }
       public double getPorDescuento(){
        
        return Double.parseDouble( this.jt_Descuento.getText() );
        
    }
        public double getPorImpuesto(){
        
        return Double.parseDouble( this.jt_Impuesto.getText());
    }
         public String getFechaRegistro(){
        
        return this.jt_FechaRegistro.getText();
    }
         
         public double getPrecioVenta(){
             return Double.parseDouble(this.jt_PrecioVenta.getText());
         }
         
         public void estadoInicial(){
             
             this.jt_Codigo.setText("");
             this.jt_Descripcion.setText("");
             this.jt_PrecioCompra.setText("0");
             this.jt_Descuento.setText("0");
             this.jt_Impuesto.setText("0");
             this.jt_PrecioVenta.setText("0");
             this.jt_FechaRegistro.setText("");
             
             this.jt_Codigo.setEnabled(true);
             this.jt_Descripcion.setEnabled(false);
             this.jt_PrecioCompra.setEnabled(false);
             this.jt_Descuento.setEnabled(false);
             this.jt_Impuesto.setEnabled(false);
             this.jt_PrecioVenta.setEnabled(false);
             this.jt_FechaRegistro.setEnabled(false);
             
             this.jP_Botones2.estadoInicialBotones();
         }
         
          
         public void habilitarAgregar(){
             
             this.jt_Codigo.setEnabled(false);
             this.jt_Descripcion.setEnabled(true);
             this.jt_PrecioCompra.setEnabled(true);
             this.jt_PrecioVenta.setEnabled(false);
             this.jt_Descuento.setEnabled(true);
             this.jt_Impuesto.setEnabled(true);
             this.jt_FechaRegistro.setEnabled(true);
            
             this.jP_Botones2.habilitarBotoneraAgregar();
         }
         
         public void mostrarMensaje (String texto){
             
             JOptionPane.showMessageDialog(null, texto);
         }
         
           public void agregarProductoTabla(String [] datos){
    
    this.modelo.addRow(datos);
    }
       
  public void modificarProductoTabla(String [] datos){
    
    for(int fila =0; fila< this.modelo.getRowCount(); fila++){
    
    if(this.modelo.getValueAt(fila, 0).equals(datos[0])){
    this.modelo.setValueAt(datos[1], fila, 1);
    this.modelo.setValueAt(datos[2], fila, 2);
    this.modelo.setValueAt(datos[3], fila, 3);
    this.modelo.setValueAt(datos[4], fila, 4);
    this.modelo.setValueAt(datos[5], fila, 5);
    this.modelo.setValueAt(datos[6], fila, 6);
    break;
        }
      }
    }
            
  public void eliminarProductoTabla(String pProducto){
    for(int fila=0; fila< this.modelo.getRowCount(); fila ++){
    if(this.modelo.getValueAt(fila, 0).equals(pProducto)){
    this.modelo.removeRow(fila);
    break;
        }
      }
    }
         
         public void setCodigo(String valor){
             this.jt_Codigo.setText(valor);
          
         }
    
         public void setDescripcion(String valor){
             
             this.jt_Descripcion.setText(valor);
         }
         
          public void setPrecioCompra(String valor){
             
             this.jt_PrecioCompra.setText(valor);
         }
          
           public void setDescuento(String valor){
             
             this.jt_Descuento.setText(valor);
         }
           
            public void setImpuesto(String valor){
             
             this.jt_Impuesto.setText(valor);
         }
         
          public void setFechaRegistro(String valor){
             
             this.jt_FechaRegistro.setText(valor);
         }
         
           public void setPrecioVenta(String valor){
             
             this.jt_PrecioVenta.setText(valor);
         }
           
           
           
           public void hailitarModificarEliminar(){
               this.jt_Codigo.setEnabled(false);
               this.jt_Descripcion.setEnabled(true);
               this.jt_Descuento.setEnabled(true);
               this.jt_FechaRegistro.setEnabled(true);
               this.jt_Impuesto.setEnabled(true);
               this.jt_PrecioCompra.setEnabled(true);
                 this.jt_PrecioVenta.setEnabled(false);
               this.jP_Botones2.habilitarBotoneraModificarEliminar();
           }
           
           
           
           
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jt_Codigo = new javax.swing.JTextField();
        jP_Botones2 = new Vista.JP_Botones();
        jLabel2 = new javax.swing.JLabel();
        jt_Descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jt_PrecioCompra = new javax.swing.JTextField();
        jt_Descuento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jt_Impuesto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jt_FechaRegistro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jt_PrecioVenta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jl_ListaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de productos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Descripción");

        jt_Codigo.setBackground(new java.awt.Color(204, 204, 255));
        jt_Codigo.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("Código");

        jt_Descripcion.setBackground(new java.awt.Color(204, 204, 255));
        jt_Descripcion.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("%Descuento");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setText("Precio Compra");

        jt_PrecioCompra.setBackground(new java.awt.Color(204, 204, 255));
        jt_PrecioCompra.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_Descuento.setBackground(new java.awt.Color(204, 204, 255));
        jt_Descuento.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("% Impuesto");

        jt_Impuesto.setBackground(new java.awt.Color(204, 204, 255));
        jt_Impuesto.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setText("Precio Venta");

        jt_FechaRegistro.setBackground(new java.awt.Color(204, 204, 255));
        jt_FechaRegistro.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setText("Fecha Registro");

        jt_PrecioVenta.setBackground(new java.awt.Color(204, 204, 255));
        jt_PrecioVenta.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jl_ListaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "PrecioCompra", "%Descuento", "%Impuesto", "FechaRegistro", "PrecioVenta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jl_ListaProductos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_PrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt_Descripcion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt_Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_FechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jP_Botones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jt_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jt_PrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jt_Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_FechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jt_PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addComponent(jP_Botones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       this.controlador.consolidarInformacion();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private Vista.JP_Botones jP_Botones2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jl_ListaProductos;
    public javax.swing.JTextField jt_Codigo;
    private javax.swing.JTextField jt_Descripcion;
    private javax.swing.JTextField jt_Descuento;
    private javax.swing.JTextField jt_FechaRegistro;
    private javax.swing.JTextField jt_Impuesto;
    private javax.swing.JTextField jt_PrecioCompra;
    private javax.swing.JTextField jt_PrecioVenta;
    // End of variables declaration//GEN-END:variables
}
