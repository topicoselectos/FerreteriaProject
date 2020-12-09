/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Clases.Conectar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author e09am
 */
public class Registro_Empleados extends javax.swing.JFrame {

    Conectar co = new Conectar();   
    Connection con = co.conexion();
    
    PreparedStatement ps = null;
    ResultSet rs;
    /**
     * Creates new form Registro_Empleados
     */
    public Registro_Empleados() {
       
        initComponents();
        setLocationRelativeTo(null);
        num(txtced);
        num(txttelf);
    }
    
    public void registro(){
        
        String nom, ap1, ap2, nomuser, psw1, psw2, correo, direccion, de, SQL;
        int ced, telf, dept, n;
        
        try{
            
             SQL = "INSERT INTO tb_empleado (Nombre, Apellido_1, Apellido_2, Cedula, Nom_usuario, Contraseña, Telefono, Correo, Direccion, fk_dept) VALUES (?,?,?,?,?,?,?,?,?,?)";
             
        nom = txtnombre.getText();
        ap1 = txtap1.getText();
        ap2 = txtap2.getText();
        nomuser = txtnomuser.getText();
        psw1 = String.valueOf(txtpass1.getPassword());
        psw2 = String.valueOf(txtpass2.getPassword());
        correo = txtcorreo.getText();
        direccion = txtdireccion.getText();
        ced = Integer.parseInt(txtced.getText());
        telf = Integer.parseInt(txttelf.getText());
        
        if(  psw1 == null ? psw2 == null : psw1.equals(psw2)){
             de = (String) cmbdept3.getSelectedItem();
        if(      null != de)switch (de) {
                     case "Hogar":
                         dept = 1;
                         dept(nom, ap1, ap2, ced, nomuser, psw2, telf, correo, direccion, dept);
                               break;
                     case "Jardinería":
                         dept = 2;
                         dept(nom, ap1, ap2, ced, nomuser, psw2, telf, correo, direccion, dept);
                         break;
                     case "Iluminación":
                         dept = 3;
                         dept(nom, ap1, ap2, ced, nomuser, psw2, telf, correo, direccion, dept);
                         break;
                     case "Construcción":
                         dept = 6;
                         dept(nom, ap1, ap2, ced, nomuser, psw2, telf, correo, direccion, dept);
                         break;
                     case "Plomería":
                         dept = 7;
                         dept(nom, ap1, ap2, ced, nomuser, psw2, telf, correo, direccion, dept);
                         break;
                     case "Pinturas":
                         dept = 8;
                         dept(nom, ap1, ap2, ced, nomuser, psw2, telf, correo, direccion, dept);
                         break;
                     default:
                         break;
                 }
         
        }else{
            JOptionPane.showMessageDialog(null, "Sus contraseñas deben ser iguales");
        }
          }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error de tipo: "+e);
    }
        
    }
    public void dept(String nom, String ap1, String ap2, int ced, String nomuser, String psw2, int telf, String correo, String direccion, int dept){
        String SQL;
        try{
         SQL = "INSERT INTO tb_empleado (Nombre, Apellido_1, Apellido_2, Cedula, Nom_usuario, Contraseña, Telefono, Correo, Direccion, fk_dept) VALUES (?,?,?,?,?,?,?,?,?,?)";
        int n ;
        PreparedStatement st = con.prepareStatement(SQL);
                         st.setString(1, nom);
                         st.setString(2, ap1);
                         st.setString(3, ap2);
                         st.setInt(4, ced);
                         st.setString(5, nomuser);
                         st.setString(6, psw2);
                         st.setInt(7, telf);
                         st.setString(8, correo);
                         st.setString(9, direccion);
                         st.setInt(10, dept);
                         n = st.executeUpdate();
                         if(n>0){
                             JOptionPane.showMessageDialog(null, "Empleado guardado con éxito");
                             limpiar();
                         }      
        
                         this.dispose();
                         
        }catch(Exception e){
            
        }
    }
    public void num(JTextField a){
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e){
            char c = e.getKeyChar();
            if(!Character.isDigit(c)&& c!= '.'){
                e.consume();
            }
            if(c=='.'&& txtced.getText().contains(".")){
                e.consume();
            }
        }
        
        });
    }
    
    public void limpiar(){
        txtap1.setText("");
        txtap2.setText("");
        txtced.setText("");
        txtcorreo.setText("");
        txtnombre.setText("");
        txtnomuser.setText("");
        txtpass1.setText("");
        txtpass2.setText("");
        txttelf.setText("");
        txtdireccion.setText("");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtap1 = new javax.swing.JTextField();
        txtap2 = new javax.swing.JTextField();
        txtced = new javax.swing.JTextField();
        txtnomuser = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtpass2 = new javax.swing.JPasswordField();
        txtpass1 = new javax.swing.JPasswordField();
        cmbdept3 = new javax.swing.JComboBox<>();
        btnguardar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txttelf = new javax.swing.JTextField();
        btnmenupricnipal = new javax.swing.JToggleButton();

        jLabel10.setText("Repita su contraseña:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registro de empleados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido Paterno:");

        jLabel4.setText("Apellido Materno:");

        jLabel5.setText("Nombre usuario:");

        jLabel6.setText("N° Cédula:");

        jLabel7.setText("Contraseña:");

        jLabel8.setText("Correo electrónico:");

        jLabel9.setText("Repita su contraseña:");

        jLabel12.setText("Dirección:");

        jLabel13.setText("Departamento:");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        txtap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtap1ActionPerformed(evt);
            }
        });

        txtap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtap2ActionPerformed(evt);
            }
        });

        txtced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedActionPerformed(evt);
            }
        });

        txtnomuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomuserActionPerformed(evt);
            }
        });

        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });

        txtpass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpass2ActionPerformed(evt);
            }
        });

        txtpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpass1ActionPerformed(evt);
            }
        });

        cmbdept3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hogar", "Jardinería", "Iluminación", "Construcción", "Plomería", "Pinturas" }));
        cmbdept3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdept3ActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel11.setText("Teléfono:");

        txttelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelfActionPerformed(evt);
            }
        });

        btnmenupricnipal.setText("Menú principal");
        btnmenupricnipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenupricnipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtap2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnomuser, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttelf, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpass2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtced, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(58, 58, 58)
                                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtap1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbdept3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(btnguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnmenupricnipal)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtap1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtap2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtnomuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtpass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtpass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(cmbdept3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnguardar)
                        .addComponent(btnmenupricnipal)))
                .addGap(0, 86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbdept3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdept3ActionPerformed
        // TODO add your handling code here:
        
        cmbdept3.transferFocus();
    }//GEN-LAST:event_cmbdept3ActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        
        registro();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
        txtnombre.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtap1ActionPerformed
        // TODO add your handling code here:
        
        txtap1.transferFocus();
    }//GEN-LAST:event_txtap1ActionPerformed

    private void txtap2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtap2ActionPerformed
        // TODO add your handling code here:
        
        txtap2.transferFocus();
    }//GEN-LAST:event_txtap2ActionPerformed

    private void txtcedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedActionPerformed
        // TODO add your handling code here:
        txtced.transferFocus();
    }//GEN-LAST:event_txtcedActionPerformed

    private void txtnomuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomuserActionPerformed
        // TODO add your handling code here:
        txtnomuser.transferFocus();
    }//GEN-LAST:event_txtnomuserActionPerformed

    private void txtpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpass1ActionPerformed
        // TODO add your handling code here:
        txtpass1.transferFocus();
    }//GEN-LAST:event_txtpass1ActionPerformed

    private void txtpass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpass2ActionPerformed
        // TODO add your handling code here:
        txtpass2.transferFocus();
    }//GEN-LAST:event_txtpass2ActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:
        
        txtcorreo.transferFocus();
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void txttelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelfActionPerformed
        // TODO add your handling code here:
        txttelf.transferFocus();
    }//GEN-LAST:event_txttelfActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
        txtdireccion.transferFocus();
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void btnmenupricnipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenupricnipalActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnmenupricnipalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registro_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JToggleButton btnmenupricnipal;
    private javax.swing.JComboBox<String> cmbdept3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtap1;
    private javax.swing.JTextField txtap2;
    private javax.swing.JTextField txtced;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnomuser;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JPasswordField txtpass2;
    private javax.swing.JTextField txttelf;
    // End of variables declaration//GEN-END:variables
}
