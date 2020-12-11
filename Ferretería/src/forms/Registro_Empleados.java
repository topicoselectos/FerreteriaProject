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
        btnmenupricnipal = new javax.swing.JToggleButton();
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

        jLabel10.setText("Repita su contraseña:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel1.setText("Registro Empleados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        btnmenupricnipal.setBackground(new java.awt.Color(0, 255, 0));
        btnmenupricnipal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnmenupricnipal.setForeground(new java.awt.Color(255, 0, 0));
        btnmenupricnipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/menu.png"))); // NOI18N
        btnmenupricnipal.setText("Menú principal");
        btnmenupricnipal.setContentAreaFilled(false);
        btnmenupricnipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenupricnipalActionPerformed(evt);
            }
        });
        jPanel1.add(btnmenupricnipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 160, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 821, 80));

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel3.setText("Segundo Apellido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        jLabel4.setText("Primer Apellido");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel5.setText("Nombre usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel6.setText("N° Cédula:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel7.setText("Contraseña:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, -1));

        jLabel8.setText("Correo electrónico:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        jLabel9.setText("Confirmar Contraseña");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel12.setText("Dirección:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        jLabel13.setText("Departamento:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 221, -1));

        txtap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtap1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 221, -1));

        txtap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtap2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 221, -1));

        txtced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedActionPerformed(evt);
            }
        });
        getContentPane().add(txtced, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 221, -1));

        txtnomuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomuserActionPerformed(evt);
            }
        });
        getContentPane().add(txtnomuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 221, -1));

        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 221, -1));

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 221, -1));

        txtpass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpass2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 221, -1));

        txtpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpass1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 221, -1));

        cmbdept3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hogar", "Jardinería", "Iluminación", "Construcción", "Plomería", "Pinturas" }));
        cmbdept3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdept3ActionPerformed(evt);
            }
        });
        getContentPane().add(cmbdept3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 181, -1));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/cheque.png"))); // NOI18N
        btnguardar.setContentAreaFilled(false);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 160, 80));

        jLabel11.setText("Teléfono:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        txttelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelfActionPerformed(evt);
            }
        });
        getContentPane().add(txttelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 221, -1));

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
