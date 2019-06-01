/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.Controlador_FRM_Provedores;
import javax.swing.JOptionPane;
//libreria para el manejo del modelo de la tabla
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
import modelo.Provedor;


/**
 *
 * @author JeanC
 */
public class FRM_Provedores extends javax.swing.JFrame {
    
    public Controlador_FRM_Provedores controlador;
    private DefaultTableModel modelo;

    public FRM_Provedores(ConexionBD conex) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.modelo = new DefaultTableModel();
        String[] columnas = new String[7];
        columnas[0] = "Cedula Jurídica";
        columnas[1] = "Nombre Comercial";
        columnas[2] = "Contacto";
        columnas[3] = "Dirección";
        columnas[4] = "Monto Crédito";
        columnas[5] = "Día credito";
        columnas[6] = "Moneda";
        this.modelo.setColumnIdentifiers(columnas);
        this.jt_ListaProvedores.setModel(modelo);
        // el parametro this, envia todo el esquema de la interfaz
        this.controlador = new Controlador_FRM_Provedores(this,conex);
        // Con este metodo se pueden obtener los TEXT 
        this.jP_Botones1.agregarControladorProveedores(controlador);
        this.estadoInicial();
        this.controlador.inicioTabla(conex.tablaActualizarProveedores());
  
    }
    //metodos para obtener los textos de la interfaz
    public String getCedula(){
        return this.jt_Cedula.getText();
    }
    
    public String getNombreComercial(){
        return this.jt_NombreComer.getText();
    }
    
    public String getContacto(){
        return this.jt_Contacto.getText();
    }
    
    public String getDireccion(){
        return this.jt_Direccion.getText();
    }
    
    public String getMontoCredito(){
        return this.jt_MontoCred.getText();
    }
    
    public double getDiasCredito(){
        return Double.parseDouble(this.jsp_Dias.getValue().toString());
    }
    
    public String getMoneda(){
        return this.jcmb_Moneda.getSelectedItem().toString();
    }
    
    public  void estadoInicial(){
        
        this.jt_Cedula.setText("");
        this.jt_NombreComer.setText("");
        this.jt_Contacto.setText("");
        this.jt_Direccion.setText("");
        this.jt_Direccion.setText("");
        this.jt_MontoCred.setText("");
        
        this.jt_Cedula.setEnabled(true);
        this.jt_NombreComer.setEnabled(false);
        this.jt_Contacto.setEnabled(false);
        this.jt_Direccion.setEnabled(false);
        this.jt_MontoCred.setEnabled(false);
        this.jsp_Dias.setEnabled(false);
        this.jcmb_Moneda.setEnabled(false);
        
        this.jP_Botones1.estadoInicialBotones();
    }
    
    public void habilitarAgregar(){
       
        this.jt_Cedula.setEnabled(false);
        this.jt_NombreComer.setEnabled(true);
        this.jt_Contacto.setEnabled(true);
        this.jt_Direccion.setEnabled(true);
        this.jt_MontoCred.setEnabled(true);
        this.jsp_Dias.setEnabled(true);
        this.jcmb_Moneda.setEnabled(true);
        
        this.jP_Botones1.habilitarAgregar();
    }
    
    public void mostrarMensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    
    public void setCedulaJuridica(String valor){
        this.jt_Cedula.setText(valor);
    }
    
    public void setNombreComercial(String valor){
         this.jt_NombreComer.setText(valor);
    }
    
    public void setContacto(String valor){
        this.jt_Contacto.setText(valor);
    }
    
    public void setDireccion(String valor){
        this.jt_Direccion.setText(valor);
    }
    
    public void setMontoCredito(String valor){
        this.jt_MontoCred.setText(valor);
    }
    
    public void setDiasCredito(double valor){
        
        Object temporal;
        temporal=valor;
        this.jsp_Dias.setValue(temporal);
    }
    
    public void setMoneda(String valor){
        this.jcmb_Moneda.setSelectedItem(valor);
    }
    
    public void habilitarModificarEliminar(){
        this.jt_Cedula.setEnabled(false);
        this.jt_NombreComer.setEnabled(true);
        this.jt_Contacto.setEnabled(true);
        this.jt_Direccion.setEnabled(true);
        this.jt_MontoCred.setEnabled(true);
        this.jsp_Dias.setEnabled(true);
        this.jcmb_Moneda.setEnabled(true);
        
        this.jP_Botones1.habilitarModificarEliminar();
    }
    
    public Provedor obtenerProveedor(){
        Provedor prv=new Provedor(this.getCedula(), this.getNombreComercial() ,this.getContacto(), this.getDireccion(),
                this.getMontoCredito(), this.getDiasCredito(), this.getMoneda());
        return prv;
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
                this.modelo.setValueAt(datos[5], fila, 5);
                this.modelo.setValueAt(datos[6], fila, 6);
                
                break;
                
            }
        }
    }
    
    public void eliminarUsuarioTabla(String pProveedor) {
        for(int fila=0;fila<this.modelo.getRowCount();fila++) {
            if(this.modelo.getValueAt(fila, 0).equals(pProveedor)) {
                
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jt_NombreComer = new javax.swing.JTextField();
        jt_Contacto = new javax.swing.JTextField();
        jt_Direccion = new javax.swing.JTextField();
        jt_MontoCred = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcmb_Moneda = new javax.swing.JComboBox<>();
        jsp_Dias = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jP_Botones1 = new vista.JP_Botones();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_ListaProvedores = new javax.swing.JTable();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        setTitle("Mantenimiento de provedores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cedula Jurídica: ");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre comercial:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contacto:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección exacta:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Monto crédito:");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Días crédito:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Moneda:");

        jt_Cedula.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N

        jt_NombreComer.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N

        jt_Contacto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N

        jt_Direccion.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N

        jt_MontoCred.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Provedores");

        jcmb_Moneda.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jcmb_Moneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colón", "Dólar" }));

        jsp_Dias.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        jsp_Dias.setModel(new javax.swing.SpinnerNumberModel(15, 15, 60, 15));
        jsp_Dias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jt_ListaProvedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jt_ListaProvedores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jt_MontoCred)
                                    .addComponent(jt_Contacto)
                                    .addComponent(jt_Direccion)
                                    .addComponent(jt_NombreComer)
                                    .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcmb_Moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jsp_Dias, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(jP_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jt_NombreComer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jt_Contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jt_MontoCred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jsp_Dias, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jcmb_Moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jP_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

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
    private javax.swing.JLayeredPane jLayeredPane1;
    private vista.JP_Botones jP_Botones1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcmb_Moneda;
    private javax.swing.JSpinner jsp_Dias;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_Contacto;
    private javax.swing.JTextField jt_Direccion;
    private javax.swing.JTable jt_ListaProvedores;
    private javax.swing.JTextField jt_MontoCred;
    private javax.swing.JTextField jt_NombreComer;
    // End of variables declaration//GEN-END:variables
}
