/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Clases.Conectar;
import com.mysql.cj.jdbc.Blob;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author e09am
 */
public class login extends javax.swing.JFrame {

    Conectar co = new Conectar();   
    Connection con = co.conexion();

    
    public login() {
        initComponents();
        this.setResizable(false);
        setLocationRelativeTo(this);  
    
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RecupContraseña = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnmusr = new javax.swing.JTextField();
        txtpsw1 = new javax.swing.JTextField();
        txtpsw2 = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        login = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        pswd = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel6.setText("Recuperar contraseña");

        jLabel7.setText("Nombre de usuario:");

        jLabel8.setText("Nueva Contraseña:");

        jLabel9.setText("Repita su contraseña:");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RecupContraseñaLayout = new javax.swing.GroupLayout(RecupContraseña.getContentPane());
        RecupContraseña.getContentPane().setLayout(RecupContraseñaLayout);
        RecupContraseñaLayout.setHorizontalGroup(
            RecupContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecupContraseñaLayout.createSequentialGroup()
                .addGroup(RecupContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RecupContraseñaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(RecupContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RecupContraseñaLayout.createSequentialGroup()
                            .addGap(195, 195, 195)
                            .addComponent(jLabel6))
                        .addGroup(RecupContraseñaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(RecupContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(RecupContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnmusr)
                                .addComponent(txtpsw1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RecupContraseñaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtpsw2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RecupContraseñaLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btnguardar)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        RecupContraseñaLayout.setVerticalGroup(
            RecupContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecupContraseñaLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addGroup(RecupContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtnmusr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(RecupContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtpsw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(RecupContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtpsw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(btnguardar)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("LOGIN"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Usuario: ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Contraseña: ");

        txtusuario.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });

        pswd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswdActionPerformed(evt);
            }
        });

        btnlogin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnlogin.setText("CONTINUAR");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\e09am\\Desktop\\Archivos temporales de cursos\\ProyectoNetbeans gupia videp\\Imagenes de forms para proyecto\\20201117_000231_0000.png")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel5.setText("¿Olvidó su contraseña? Por favor ingrese aquí ");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlogin)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswd, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel5)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(46, 46, 46)
                .addComponent(btnlogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed

       btnlogin.transferFocus();
        ValidarUsuario();
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnloginActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        txtusuario.transferFocus();
        
        
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void pswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswdActionPerformed
        
        pswd.transferFocus();
    }//GEN-LAST:event_pswdActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
       
        RecupContraseña.setSize(new Dimension(550,419));
        RecupContraseña.setVisible(true);
        RecupContraseña.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jLabel5MousePressed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        
        recupsw();
    }//GEN-LAST:event_btnguardarActionPerformed

    public void recupsw(){
        
        String psw1, psw2;
        int resultado = 0;
        String usuario = txtnmusr.getText();
        String SQL = "SELECT * FROM tb_empleado where Nom_usuario='"+usuario+"'";
        String SQL2 ;
         try{
            Statement st = con.createStatement();
            ResultSet ra=st.executeQuery(SQL);
            
            if(ra.next()){
                resultado = 1;
                
                if(resultado == 1){
                    
                    psw1 = txtpsw1.getText();
                    psw2 = txtpsw2.getText();
                    
                    if(psw1.equals(psw2)){
                        
                        
                        try {
                            
                            SQL2 = "UPDATE tb_empleado SET Contraseña=? WHERE Nom_usuario ='"+usuario +"'"; 
                            PreparedStatement st2 = con.prepareStatement(SQL2);
                            
                            st2.setBytes(1, psw2.getBytes());
                            
                            st2.executeUpdate();
                            
                            
                            JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito");
                            
                            login l = new login();
                            l.setVisible(true);
                            this.dispose();
                            
                            
                        } catch (Exception e) {
                            
                            JOptionPane.showMessageDialog(null, "Error de tipo: "+e);
                            
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Sus contraseñas deben ser iguales", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);
                    }
                       
                    
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "¡Por favor ingrese sus datos correctamente!", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);
                txtnmusr.setText("");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }
      
    }
   
    public void ValidarUsuario(){
        
        
        int resultado  = 0; 
        String pass= String.valueOf(pswd.getPassword());
        String usuario = txtusuario.getText();
        String SQL = "SELECT * FROM tb_empleado where Nom_usuario='"+usuario+"' AND Contraseña='"+pass+"'";
        
        try{
            Statement st = con.createStatement();
            ResultSet ra=st.executeQuery(SQL);
            
            if(ra.next()){
                resultado = 1;
                
                if(resultado == 1){
                    
                     Menu m = new Menu();
                     m.setVisible(true);
                     Menu.lbusuario.setText(txtusuario.getText());
                     this.dispose();
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "¡Por favor ingrese sus datos correctamente!", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);
                txtusuario.setText("");
                pswd.setText("");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }
    }    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog RecupContraseña;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel login;
    private javax.swing.JPasswordField pswd;
    private javax.swing.JTextField txtnmusr;
    private javax.swing.JTextField txtpsw1;
    private javax.swing.JTextField txtpsw2;
    public static javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
