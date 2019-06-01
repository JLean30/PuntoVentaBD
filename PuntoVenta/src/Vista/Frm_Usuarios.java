/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.Controlador_Frm_Usuarios;
import javax.swing.JOptionPane;

//libreria para el manejo del modelo de la tabla
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;


import modelo.Usuario;

/**
 *
 * @author ucr
 */
public class FRM_Usuarios extends javax.swing.JFrame {
    
    public Controlador_Frm_Usuarios controlador;

    private  DefaultTableModel modelo;

    
    
    /**
     * Creates new form FRM_Usuarios
     */
    
    public FRM_Usuarios(ConexionBD conex) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.controlador = new Controlador_Frm_Usuarios(this,conex);
        this.jP_Botones1.agregarControladorUsuarios(controlador);
                
        //construccion del modelo de la tabla
        this.modelo = new DefaultTableModel();
        String[] columnas = new String[4];
        columnas[0] = "Usuario";
        columnas[1] = "Contraseña";
        columnas[2] = "Nombre Completo";
        columnas[3] = "Tipo";
        
        //asignamos los nombres de columnas al modelo
        this.modelo.setColumnIdentifiers(columnas);
        
        //le asignamos el modelo a la tabla
        this.jT_ListaUsuarios.setModel(modelo);
       
        this.estadoInicial();
        //this.agregarUsuarioTablaBD();
        this.controlador.inicioTabla(conex.tablaActualizarUsuarios());
        
    }
    
    public void estadoInicial() {
        
        this.jt_Usuario.setText("");
        this.jp_Contrasena.setText("");
        this.jp_ConfirmarContrasena.setText("");
        this.jt_NombreCompleto.setText("");
        this.jc_Tipo.setSelectedIndex(0);
        
        this.jt_Usuario.setEnabled(true);
        this.jp_Contrasena.setEnabled(false);
        this.jp_ConfirmarContrasena.setEnabled(false);
        this.jt_NombreCompleto.setEnabled(false);
        this.jc_Tipo.setEnabled(false);
        
        this.jP_Botones1.estadoInicialBotones();
        
  

    }
    
    public Usuario obtenerUsuario() {
        Usuario usuario = new Usuario(this.jt_Usuario.getText(),
                                   this.jp_Contrasena.getText(),
                                   this.jt_NombreCompleto.getText(),
                                   this.jc_Tipo.getSelectedItem().toString());
        
        return usuario;
    }
    
    //metodo encargado de habilitar para modificar
    public void habilitarParaModificar() {
        
        this.jt_Usuario.setEnabled(false);
        this.jp_Contrasena.setEnabled(true);
        this.jp_ConfirmarContrasena.setEnabled(true);
        this.jt_NombreCompleto.setEnabled(true);
        this.jc_Tipo.setEnabled(true);
        
        this.jP_Botones1.habilitarModificarEliminar();
        
    }
    
    public void habilitarParaAgregar() {
        
        this.jt_Usuario.setEnabled(false);
        this.jp_Contrasena.setEnabled(true);
        this.jp_ConfirmarContrasena.setEnabled(true);
        this.jt_NombreCompleto.setEnabled(true);
        this.jc_Tipo.setEnabled(true);
        
        this.jP_Botones1.habilitarAgregar();
        
    }
    
    public void cargarDatosUsuario(Usuario pUsuario) {
        
        this.jp_Contrasena.setText(pUsuario.getContrasena());
        this.jp_ConfirmarContrasena.setText(pUsuario.getContrasena());
        this.jt_NombreCompleto.setText(pUsuario.getNombreCompleto());
        
        switch(pUsuario.getTipo()) {
           
            case "Administrador":
                this.jc_Tipo.setSelectedIndex(0);
            break;
            
            case "Cajero":
                this.jc_Tipo.setSelectedIndex(1);
            break;
            
            case "Vendedor":
                this.jc_Tipo.setSelectedIndex(2);
            break;
               
        }
        
    }
    
    public boolean confirmarContrasena() {
        boolean correcta = false;
        if(this.jp_Contrasena.getText().equals(this.jp_ConfirmarContrasena.getText())) {
            correcta = true;
        }
      return correcta;
    }
    
    public void mostrarMensaje (String pMensaje) {
        JOptionPane.showMessageDialog(null, pMensaje);
    }
    
    public void agregarUsuarioTabla(Object[] datos) {
        this.modelo.addRow(datos);
    }
    /*public void agregarUsuarioTablaBD() {
        this.modelo.addRow(this.conexion.tablaActualizarUsuarios());
        
    }*/
    
    public void modificarUsuarioTabla(String[] datos) {
        for(int fila=0; fila<this.modelo.getRowCount();fila++) {
            if(this.modelo.getValueAt(fila, 0).equals(datos[0])) {
                
                this.modelo.setValueAt(datos[1], fila, 1);
                this.modelo.setValueAt(datos[2], fila, 2);
                this.modelo.setValueAt(datos[3], fila, 3);
                
                break;
                
            }
        }
    }
    
    public void eliminarUsuarioTabla(String pUsuario) {
        for(int fila=0;fila<this.modelo.getRowCount();fila++) {
            if(this.modelo.getValueAt(fila, 0).equals(pUsuario)) {
                
                this.modelo.removeRow(fila);
                break;
                
            }
        }
    }

    public String getUsuario() {
        return this.jt_Usuario.getText();
        
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
        jt_Usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jp_ConfirmarContrasena = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jp_Contrasena = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jt_NombreCompleto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jc_Tipo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jP_Botones1 = new vista.JP_Botones();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_ListaUsuarios = new javax.swing.JTable();

        setTitle("Formulario para perfiles de usuarios");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre Completo:");

        jt_Usuario.setBackground(new java.awt.Color(0, 153, 153));
        jt_Usuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Confirmar:");

        jp_ConfirmarContrasena.setBackground(new java.awt.Color(0, 153, 153));
        jp_ConfirmarContrasena.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        jp_Contrasena.setBackground(new java.awt.Color(0, 153, 153));
        jp_Contrasena.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario:");

        jt_NombreCompleto.setBackground(new java.awt.Color(0, 153, 153));
        jt_NombreCompleto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo:");

        jc_Tipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jc_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Cajero", "Vendedor" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_ConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jc_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jp_ConfirmarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jp_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jc_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jT_ListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Contraseña", "NombreCompleto", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jT_ListaUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jP_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jP_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 154, 820, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private vista.JP_Botones jP_Botones1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jT_ListaUsuarios;
    private javax.swing.JComboBox<String> jc_Tipo;
    private javax.swing.JPasswordField jp_ConfirmarContrasena;
    private javax.swing.JPasswordField jp_Contrasena;
    private javax.swing.JTextField jt_NombreCompleto;
    private javax.swing.JTextField jt_Usuario;
    // End of variables declaration//GEN-END:variables
}
