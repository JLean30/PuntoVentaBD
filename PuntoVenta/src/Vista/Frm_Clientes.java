/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.Controlador_FRM_Clientes;
import javax.swing.JOptionPane;
//libreria para el manejo del modelo de la tabla
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ConexionBD;

/**
 *
 * @author JeanC
 */
public class FRM_Clientes extends javax.swing.JFrame {
    
    public Controlador_FRM_Clientes controlador;
    private DefaultTableModel modelo;

    /**
     * Creates new form FRM_Clientes
     */
    public FRM_Clientes(ConexionBD conex) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controlador = new Controlador_FRM_Clientes(this,conex);
        this.modelo = new DefaultTableModel();
        String[] columnas = new String[5];
        columnas[0] = "Cedula";
        columnas[1] = "Nombre Completo";
        columnas[2] = "Telefono";
        columnas[3] = "Dirección";
        columnas[4]= "Email";
      
        //asignamos los nombres de columnas al modelo
        this.modelo.setColumnIdentifiers(columnas);
        
        //le asignamos el modelo a la tabla
        this.jt_ListaClientes.setModel(modelo);
        // Con este metodo se pueden obtener los TEXT 
        
        this.jP_Botones1.agregarControladorClientes(controlador);
        this.estadoInicial();
        this.controlador.inicioTabla(conex.tablaActualizarClientes());
    }
    
    public String getCedulaCliente(){
        return this.jt_CedulaCliente.getText();
    }
    
    public String getNombre(){
        return this.jt_Nombre.getText();
    }
    
    public String getPrimerApellido(){
        return this.jt_PriApellido.getText();
    }
    
    public String getSegundoApellido(){
        return this.jt_SegApell.getText();
    }
    
    public String getTelefono(){
        return this.jt_Telefono.getText();
    }
    
    public String getDireccion(){
        return this.jt_DireccionCliente.getText();
    }
    
    public String getEmail(){
        return this.jt_Email.getText();
    }
    
    public  void estadoInicial(){
        
        this.jt_CedulaCliente.setText("");
        this.jt_Nombre.setText("");
        this.jt_PriApellido.setText("");
        this.jt_SegApell.setText("");
        this.jt_DireccionCliente.setText("");
        this.jt_Email.setText("");
        this.jt_Telefono.setText("");
        
        this.jt_CedulaCliente.setEnabled(true);
        this.jt_Nombre.setEnabled(false);
        this.jt_PriApellido.setEnabled(false);
        this.jt_DireccionCliente.setEnabled(false);
        this.jt_Telefono.setEnabled(false);
        this.jt_SegApell.setEnabled(false);
        this.jt_Email.setEnabled(false);
       
        this.jP_Botones1.estadoInicialBotones();
    }
    
    public void habilitarAgregar(){
        
        this.jt_CedulaCliente.setEnabled(false);
        this.jt_Nombre.setEnabled(true);
        this.jt_PriApellido.setEnabled(true);
        this.jt_SegApell.setEnabled(true);
        this.jt_DireccionCliente.setEnabled(true);
        this.jt_Email.setEnabled(true);
        this.jt_Telefono.setEnabled(true);
        
        this.jP_Botones1.habilitarAgregar();
    }
    
    public void mostrarMensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    
    public void setNombre(String valor){
        this.jt_Nombre.setText(valor);
    }
    
    public void setCedulaCliente(String valor){
        this.jt_CedulaCliente.setText(valor);
    }
    
     public void setPrimerApellido(String valor){
         this.jt_PriApellido.setText(valor);
     }
     
     public void setSegundoApellido(String valor){
         this.jt_SegApell.setText(valor);
     }
     
     public void setTelefono(String valor){
         this.jt_Telefono.setText(valor);
     }
     
     public void setDireccion(String valor){
         this.jt_DireccionCliente.setText(valor);
     }
     
     public void setEmail(String valor){
         this.jt_Email.setText(valor);
     }
     
     public Cliente obtenerCliente(){
         Cliente cl=new Cliente(this.getCedulaCliente(), this.getNombre(), this.getPrimerApellido(), this.getSegundoApellido(), this.getTelefono(),
                 this.getDireccion(), this.getEmail());
         return cl;
     }
     
     public void habilitarModificarEliminar(){
         
        this.jt_CedulaCliente.setEnabled(false);
        this.jt_Nombre.setEnabled(true);
        this.jt_Email.setEnabled(true);
        this.jt_PriApellido.setEnabled(true);
        this.jt_SegApell.setEnabled(true);
        this.jt_Telefono.setEnabled(true);
        this.jt_DireccionCliente.setEnabled(true);
        
        this.jP_Botones1.habilitarModificarEliminar();
    }
     public void agregarUsuarioTabla(String[] datos) {
        this.modelo.addRow(datos);
    }
    
    public void modificarUsuarioTabla(String[] datos) {
        for(int fila=0; fila<this.modelo.getRowCount();fila++) {
            if(this.modelo.getValueAt(fila, 0).equals(datos[0])) {
                
                this.modelo.setValueAt(datos[1], fila, 1);
                this.modelo.setValueAt(datos[2], fila, 2);
                this.modelo.setValueAt(datos[3], fila, 3);
                this.modelo.setValueAt(datos[4], fila, 4);
                
                break;
                
            }
        }
    }
    
    public void eliminarUsuarioTabla(String pCedula) {
        for(int fila=0;fila<this.modelo.getRowCount();fila++) {
            if(this.modelo.getValueAt(fila, 0).equals(pCedula)) {
                
                this.modelo.removeRow(fila);
                break;
                
            }
        }
    }
    
   
     
     
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jt_CedulaCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jt_Nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jt_SegApell = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jt_Telefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jt_DireccionCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jt_Email = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jt_PriApellido = new javax.swing.JTextField();
        jP_Botones1 = new vista.JP_Botones();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_ListaClientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setText("Cedula Jurídica: ");

        jt_Cedula.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N

        setTitle("Mantenimiento de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clientes:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 31, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cédula:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 87, -1, -1));

        jt_CedulaCliente.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jPanel1.add(jt_CedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 84, 117, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 142, -1, -1));

        jt_Nombre.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jPanel1.add(jt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 139, 197, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Primer Apellido:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 205, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Segundo Apellido:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 268, -1, -1));

        jt_SegApell.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jPanel1.add(jt_SegApell, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 265, 191, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Teléfono:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 334, -1, -1));

        jt_Telefono.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jPanel1.add(jt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 331, 136, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dirección:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 419, -1, -1));

        jt_DireccionCliente.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jPanel1.add(jt_DireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 416, 266, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 487, -1, -1));

        jt_Email.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jPanel1.add(jt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 484, 238, -1));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 620, 1240, 10));

        jt_PriApellido.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jPanel1.add(jt_PriApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 202, 197, -1));
        jPanel1.add(jP_Botones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 416, -1, -1));

        jt_ListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_ListaClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 79, 773, 270));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1230, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1230, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       //this.controlador.consolidarInformacion();
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private vista.JP_Botones jP_Botones1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CedulaCliente;
    private javax.swing.JTextField jt_DireccionCliente;
    private javax.swing.JTextField jt_Email;
    private javax.swing.JTable jt_ListaClientes;
    private javax.swing.JTextField jt_Nombre;
    private javax.swing.JTextField jt_PriApellido;
    private javax.swing.JTextField jt_SegApell;
    private javax.swing.JTextField jt_Telefono;
    // End of variables declaration//GEN-END:variables
}
