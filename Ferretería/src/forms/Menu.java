/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javafx.animation.Animation;

/**
 *
 * @author rolan
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);

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
        pnlMenu = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        pnlMenuDeslizable = new javax.swing.JPanel();
        btnAdministracion = new javax.swing.JButton();
        btnVendedores = new javax.swing.JButton();
        btnCajeros = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlVendedores = new javax.swing.JPanel();
        pnlCajeros = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlInventario = new javax.swing.JPanel();
        pnlAdministracion = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(204, 204, 255));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Nirmala UI", 3, 36)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/Salir.png"))); // NOI18N
        jButton4.setText("Salir");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnlMenu.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 20, 190, 40));

        jPanel1.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 70));

        pnlMenuDeslizable.setBackground(new java.awt.Color(204, 204, 204));
        pnlMenuDeslizable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/admistracion.png"))); // NOI18N
        btnAdministracion.setText("Administracion");
        btnAdministracion.setBorderPainted(false);
        btnAdministracion.setContentAreaFilled(false);
        btnAdministracion.setDefaultCapable(false);
        pnlMenuDeslizable.add(btnAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 200, 60));

        btnVendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/Carrito.png"))); // NOI18N
        btnVendedores.setText("Vendedores");
        btnVendedores.setBorderPainted(false);
        btnVendedores.setContentAreaFilled(false);
        pnlMenuDeslizable.add(btnVendedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 160, 60));

        btnCajeros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/caja.png"))); // NOI18N
        btnCajeros.setText("Cajeros");
        btnCajeros.setBorder(null);
        btnCajeros.setBorderPainted(false);
        btnCajeros.setContentAreaFilled(false);
        pnlMenuDeslizable.add(btnCajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 160, 60));

        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/inventario.png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setBorder(null);
        btnInventario.setContentAreaFilled(false);
        pnlMenuDeslizable.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 160, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/ferremundo_245.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setEnabled(false);
        pnlMenuDeslizable.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 160));

        jPanel1.add(pnlMenuDeslizable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 240, 610));

        pnlVendedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCajeros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/Personas.png"))); // NOI18N
        jButton1.setText("Agregar Cliente");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        pnlCajeros.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 50));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/caja.png"))); // NOI18N
        jButton2.setText("Enviar a Cajas");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        pnlCajeros.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 360, 190, 50));

        jLabel2.setText("Codigo o Producto");
        pnlCajeros.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, 20));
        pnlCajeros.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 670, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Articulo", "Stock", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        pnlCajeros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 790, 270));

        jLabel3.setText("Subtotal:");
        pnlCajeros.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, -1, -1));

        jLabel4.setText("I.V:");
        pnlCajeros.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, -1, -1));

        jLabel5.setText("Decuento:");
        pnlCajeros.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, -1, -1));

        jLabel6.setText("Total:");
        pnlCajeros.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 220, -1, -1));

        pnlVendedores.add(pnlCajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 610));

        pnlInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlVendedores.add(pnlInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 560));

        pnlAdministracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlVendedores.add(pnlAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 560));

        jPanel1.add(pnlVendedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 1240, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // JOptionPane.showMessageDialog(this, "Esta seguro que desea salir ?");
        System.exit(0);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        int posicion = pnlMenuDeslizable.getX();
        if (posicion > -1) {

            Animacion.Animacion.mover_izquierda(0, -264, 2, 2, pnlMenuDeslizable);

        } else {
            Animacion.Animacion.mover_derecha(-264, 0, 2, 2, pnlMenuDeslizable);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministracion;
    private javax.swing.JButton btnCajeros;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnVendedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnlAdministracion;
    private javax.swing.JPanel pnlCajeros;
    private javax.swing.JPanel pnlInventario;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuDeslizable;
    private javax.swing.JPanel pnlVendedores;
    // End of variables declaration//GEN-END:variables
}
