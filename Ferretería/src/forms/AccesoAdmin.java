/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Clases.Conectar;
import static forms.login.txtusuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author e09am
 */
public class AccesoAdmin extends javax.swing.JFrame {
Conectar co = new Conectar();   
    Connection con = co.conexion();
    
    PreparedStatement ps = null;
    ResultSet rs;
    /**
     * Creates new form AccesoAdmin
     */
    public AccesoAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pswdadmin = new javax.swing.JPasswordField();
        btnveerify = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Por favor ingrese su contraseña:");

        btnveerify.setText("Verificar");
        btnveerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnveerifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(pswdadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnveerify)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pswdadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnveerify)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnveerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnveerifyActionPerformed
        
        
        int resultado  = 0; 
        int op = 0 ;
        String opcion;
        String pass= String.valueOf(pswdadmin.getPassword());
        String usuario = txtusuario.getText();
        String SQL = "SELECT * FROM tb_empleado where Nom_usuario='edwardarcem' AND Contraseña='"+pass+"'";
        
        try{
            Statement st = con.createStatement();
            ResultSet ra=st.executeQuery(SQL);
            
            if(ra.next()){
                resultado = 1;
                
                if(resultado == 1){
                    
                    opcion = JOptionPane.showInputDialog(null,"1. Registro de Empleados\n"
                            + "2.Ingreso de Productos");
                    op= Integer.parseInt(opcion);
                    
                    switch (op) {
                        case 1:
                            Registro_Empleados re = new Registro_Empleados();
                            re.setVisible(true);
                            this.dispose();
                            break;
                        case 2:
                            IngresoProductos in = new IngresoProductos();
                            in.setVisible(true);
                            this.dispose();
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Ingrese un dato válido");
                            break;
                    }
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "¡Por favor ingrese sus datos correctamente!", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);
                txtusuario.setText("");
                pswdadmin.setText("");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de Registro " + e.getMessage());
        }
    }//GEN-LAST:event_btnveerifyActionPerformed

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
            java.util.logging.Logger.getLogger(AccesoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccesoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccesoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccesoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccesoAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnveerify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField pswdadmin;
    // End of variables declaration//GEN-END:variables
}
