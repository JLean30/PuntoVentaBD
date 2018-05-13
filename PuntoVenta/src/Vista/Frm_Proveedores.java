/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_proveedores;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.Proveedores;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Frm_Proveedores extends javax.swing.JFrame {
    
    private Controlador.Controlador_FRM_proveedores controlador;
    
    private DefaultTableModel modelo;
    
    private Proveedores proveedores;

    /**
     * Creates new form Frm_Proveedores
     */
    public Frm_Proveedores() {
        initComponents();
        this.controlador = new Controlador_FRM_proveedores(this);
        this.jP_Botones1.agregarControladorProve(controlador);
        this.estadoInicial();
        
        this.modelo = new DefaultTableModel();
        
         String [] columnas = new String [7];
        columnas [0] = "Cédula Jurídica";
        columnas[1] = "Monto del crédito";
        columnas[2] = "Nombre Comercial";
        columnas[3] = "Contacto";
        columnas[4] = "Dirección Exacta";
        columnas[5] = "Días Crédito";
        columnas[6] = "Moneda";
        
        this.modelo.setColumnIdentifiers(columnas);
        
        this.jl_ListaProveedores.setModel(modelo);
    }
    
    
    
    
     public String getCedulaJuridica(){
        
        return this.jt_CedulaJuridica.getText();
    }
    
       public String getNombreComercial(){
        
        return this.jt_NombreComercial.getText();
    }
       
         public String getContacto(){
        
        return this.jt_Contacto.getText();
    }
         
           public String getDireccionExac(){
        
        return this.jt_DireccionExac.getText();
    }
           
             public String getMontoCredito(){
        
        return this.jt_MontoCredito.getText();
    }
             
             public String getDiasCredito(){
                 return  this.js_DiasCredito.getValue().toString();
                 
             }
             
             
             public String getMoneda(){
                 return this.jcb_Moneda.getSelectedItem().toString();
             }
             
             
             
             
             
              public void estadoInicial(){
             
             this.jt_CedulaJuridica.setText("");
             this.jt_NombreComercial.setText("");
             this.jt_Contacto.setText("");
             this.jt_DireccionExac.setText("");
             this.jt_MontoCredito.setText("");
             
           
             
             this.jt_CedulaJuridica.setEnabled(true);
             this.jt_NombreComercial.setEnabled(false);
             this.jt_Contacto.setEnabled(false);
             this.jt_DireccionExac.setEnabled(false);
             this.jt_MontoCredito.setEnabled(false);
             this.js_DiasCredito.setEnabled(false);
             this.jcb_Moneda.setEnabled(false);
             
             this.jP_Botones1.estadoInicialBotones();
         }

              public void habilitarAgregar(){
             
             this.jt_CedulaJuridica.setEnabled(false);
             this.jt_NombreComercial.setEnabled(true);
             this.jt_Contacto.setEnabled(true);
             this.jt_DireccionExac.setEnabled(true);
             this.jt_MontoCredito.setEnabled(true);
             this.js_DiasCredito.setEnabled(true);
             this.jcb_Moneda.setEnabled(true);
            
             this.jP_Botones1.habilitarBotoneraAgregar();
         }
              
               public void mostrarMensaje (String texto){
             
             JOptionPane.showMessageDialog(null, texto);
         }
               
   public void agregarProvedorTabla(String [] datos){
    
    this.modelo.addRow(datos);
    }
       
  public void modificarProveedoresTabla(String [] datos){
    
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
            
  public void eliminarProveedoresTabla(String   pProvee){
    for(int fila=0; fila< this.modelo.getRowCount(); fila ++){
    if(this.modelo.getValueAt(fila, 0).equals(pProvee)){
    this.modelo.removeRow(fila);
    break;
        }
      }
    }
  
  
   
   
 
  /*****************************************************************************************************/
                 public void setCedulaJuridica(String valor){
             this.jt_CedulaJuridica.setText(valor);
          
         }
      public void setNombreComercial(String valor){
             this.jt_NombreComercial.setText(valor);
          
         }
      public void setContacto(String valor){
             this.jt_Contacto.setText(valor);
          
         }
      public void setDireccionExac(String valor){
             this.jt_DireccionExac.setText(valor);
          
         }
      public void setMontoCredito(String valor){
             this.jt_MontoCredito.setText(valor);
          
         }
      
      public void setDiasCredito(String valor){
          
          this.js_DiasCredito.setValue(valor);
          
      }
      public void setMoneda (String valor){
          
          this.jcb_Moneda.setSelectedItem(valor);
      }
      
      
       public void hailitarModificarEliminar(){
               this.jt_CedulaJuridica.setEnabled(false);
               this.jt_NombreComercial.setEnabled(true);
               this.jt_Contacto.setEnabled(true);
               this.jt_DireccionExac.setEnabled(true);
               this.jt_MontoCredito.setEnabled(true);
               this.js_DiasCredito.setEnabled(true);
                 this.jcb_Moneda.setEnabled(true);
               this.jP_Botones1.habilitarBotoneraModificarEliminar();
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
        jP_Botones1 = new Vista.JP_Botones();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jt_NombreComercial = new javax.swing.JTextField();
        jt_CedulaJuridica = new javax.swing.JTextField();
        jt_DireccionExac = new javax.swing.JTextField();
        jt_Contacto = new javax.swing.JTextField();
        jt_MontoCredito = new javax.swing.JTextField();
        js_DiasCredito = new javax.swing.JSpinner();
        jcb_Moneda = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jl_ListaProveedores = new javax.swing.JTable();

        setTitle("Mantenimiento de proveedores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("Cédula jurídica:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("Contacto:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setText("Nombre comercial:");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("Monto crédito:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setText("Direccion exacta:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setText("Moneda:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel8.setText("Días crédito:");

        jt_NombreComercial.setBackground(new java.awt.Color(204, 204, 255));
        jt_NombreComercial.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_CedulaJuridica.setBackground(new java.awt.Color(204, 204, 255));
        jt_CedulaJuridica.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_DireccionExac.setBackground(new java.awt.Color(204, 204, 255));
        jt_DireccionExac.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_Contacto.setBackground(new java.awt.Color(204, 204, 255));
        jt_Contacto.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jt_MontoCredito.setBackground(new java.awt.Color(204, 204, 255));
        jt_MontoCredito.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        js_DiasCredito.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        js_DiasCredito.setModel(new javax.swing.SpinnerListModel(new String[] {"15", "30", "45", "60"}));

        jcb_Moneda.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jcb_Moneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colones", "Dolares" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt_CedulaJuridica)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_MontoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jt_Contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jt_DireccionExac))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jt_NombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(js_DiasCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcb_Moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jt_CedulaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jt_MontoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jt_NombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_Contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_DireccionExac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(js_DiasCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jcb_Moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jP_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jl_ListaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CedulaJuridica", "MontodelCredito", "NombreComercial ", "Contacto", "DireccionExacta", "DiasCredito", "Moneda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jl_ListaProveedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
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
    private Vista.JP_Botones jP_Botones1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcb_Moneda;
    private javax.swing.JTable jl_ListaProveedores;
    private javax.swing.JSpinner js_DiasCredito;
    public javax.swing.JTextField jt_CedulaJuridica;
    public javax.swing.JTextField jt_Contacto;
    public javax.swing.JTextField jt_DireccionExac;
    public javax.swing.JTextField jt_MontoCredito;
    public javax.swing.JTextField jt_NombreComercial;
    // End of variables declaration//GEN-END:variables
}
