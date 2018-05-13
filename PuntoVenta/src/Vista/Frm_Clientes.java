/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_clientes;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.Clientes;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Frm_Clientes extends javax.swing.JFrame {

    public Controlador.Controlador_FRM_clientes controlador;
    
    private DefaultTableModel modelo;
    
    private Clientes clientes;
    
    
    public Frm_Clientes() {
       initComponents();
       
       this.controlador = new Controlador_FRM_clientes(this);
       this.jP_Botones2.agregarControladorC(controlador);
       this.estadoInicial();
       
       this.modelo = new DefaultTableModel();
        
         String [] columnas = new String [7];
        columnas [0] = "Cédula";
        columnas[1] = "Nombre";
        columnas[2] = "Primer Apellido";
        columnas[3] = "Segundo Apellido";
        columnas[4] = "Teléfono";
        columnas[5] = "Dirección";
        columnas[6] = "Email";
        
        this.modelo.setColumnIdentifiers(columnas);
        
        this.jl_ListaClientes.setModel(modelo);
    }
    
    

     public String getCedula(){
        
        return this.jt_Cedula.getText();
    }
    
       public String getApellido1(){
        
        return this.jt_Apellido1.getText();
    }
       
         public String getApellido2(){
        
        return this.jt_Apellido2.getText();
    }
         
           public String getDireccion(){
        
        return this.jt_Direccion.getText();
    }
           
             public String getTelefono(){
        
        return this.jt_Telefono.getText();
    }
             
               public String getEmail(){
        
        return this.jt_Email.getText();
    }
               
                 public String getNombre(){
        
        return this.jt_Nombre.getText();
    }
    
    public void estadoInicial(){
             
             this.jt_Cedula.setText("");
             this.jt_Nombre.setText("");
             this.jt_Apellido1.setText("");
             this.jt_Apellido2.setText("");
             this.jt_Direccion.setText("");
             this.jt_Telefono.setText("");
             this.jt_Email.setText("");
             
             this.jt_Cedula.setEnabled(true);
             this.jt_Nombre.setEnabled(false);
             this.jt_Apellido1.setEnabled(false);
             this.jt_Apellido2.setEnabled(false);
             this.jt_Direccion.setEnabled(false);
             this.jt_Telefono.setEnabled(false);
             this.jt_Email.setEnabled(false);
             
             this.jP_Botones2.estadoInicialBotones();
         }
    
    
     public void habilitarAgregar(){
             
             this.jt_Cedula.setEnabled(false);
             this.jt_Apellido1.setEnabled(true);
             this.jt_Apellido2.setEnabled(true);
             this.jt_Direccion.setEnabled(true);
             this.jt_Nombre.setEnabled(true);
             this.jt_Telefono.setEnabled(true);
             this.jt_Email.setEnabled(true);
            
             this.jP_Botones2.habilitarBotoneraAgregar();
         }
    
      public void mostrarMensaje (String texto){
             
             JOptionPane.showMessageDialog(null, texto);
         }
      
      
      public void agregarClienteTabla(String [] datos){
    
    this.modelo.addRow(datos);
    }
       
  public void modificarClienteTabla(String [] datos){
    
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
            
  public void eliminarClienteTabla(String pClientes){
    for(int fila=0; fila< this.modelo.getRowCount(); fila ++){
    if(this.modelo.getValueAt(fila, 0).equals(pClientes)){
    this.modelo.removeRow(fila);
    break;
        }
      }
    }
      
      public void setCedula(String valor){
             this.jt_Cedula.setText(valor);
          
         }
      public void setNombre(String valor){
             this.jt_Nombre.setText(valor);
          
         }
      public void setApellido1(String valor){
             this.jt_Apellido1.setText(valor);
          
         }
      public void setApellido2(String valor){
             this.jt_Apellido2.setText(valor);
          
         }
      public void setDireccion(String valor){
             this.jt_Direccion.setText(valor);
          
         }
      public void setTelefono(String valor){
             this.jt_Telefono.setText(valor);
          
         }
      public void setEmail(String valor){
             this.jt_Email.setText(valor);
          
         }
      
        public void hailitarModificarEliminar(){
               this.jt_Cedula.setEnabled(false);
               this.jt_Nombre.setEnabled(true);
               this.jt_Apellido1.setEnabled(true);
               this.jt_Apellido2.setEnabled(true);
               this.jt_Direccion.setEnabled(true);
               this.jt_Telefono.setEnabled(true);
                 this.jt_Email.setEnabled(true);
               this.jP_Botones2.habilitarBotoneraModificarEliminar();
           }
      
      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jP_Botones2 = new Vista.JP_Botones();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jt_Nombre = new javax.swing.JTextField();
        jt_Apellido1 = new javax.swing.JTextField();
        jt_Apellido2 = new javax.swing.JTextField();
        jt_Telefono = new javax.swing.JTextField();
        jt_Direccion = new javax.swing.JTextField();
        jt_Email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jl_ListaClientes = new javax.swing.JTable();

        setTitle("Mantenimiento de clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("Cédula:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setText("Primer apellido:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setText("Dirección:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setText("Email:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setText("Segundo apellido:");

        jt_Cedula.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_Nombre.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_Apellido1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_Apellido2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_Telefono.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_Direccion.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_Email.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jl_ListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Dirección", "PrimerApellido", "SegundoApellido", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jl_ListaClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt_Apellido2)
                        .addGap(242, 242, 242))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jP_Botones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jt_Apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jt_Nombre))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 60, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jt_Direccion))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 43, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addGap(30, 30, 30)
                                        .addComponent(jt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(32, 32, 32))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jt_Apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jt_Apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_Botones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private Vista.JP_Botones jP_Botones2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jl_ListaClientes;
    private javax.swing.JTextField jt_Apellido1;
    private javax.swing.JTextField jt_Apellido2;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_Direccion;
    private javax.swing.JTextField jt_Email;
    private javax.swing.JTextField jt_Nombre;
    private javax.swing.JTextField jt_Telefono;
    // End of variables declaration//GEN-END:variables
}
