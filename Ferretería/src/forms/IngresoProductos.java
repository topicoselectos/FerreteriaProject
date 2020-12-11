/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Clases.Conectar;
import Clases.Metodos;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author e09am
 */
public class IngresoProductos extends javax.swing.JFrame {

    
    Conectar co = new Conectar();   
    Connection con = co.conexion();
    
    int d;
    int filaseleccionada;
    
    PreparedStatement ps = null;
    ResultSet rs;
    
    public IngresoProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        num(txtcant);
        num(txtcantidad);
        num(txtcod);
        num(txtprecio);
    }
    
    public void num(JTextField a){
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e){
            char c = e.getKeyChar();
            if(!Character.isDigit(c)&& c!= '.'){
                e.consume();
            }
            if(c=='.'&& txtcantidad.getText().contains(".")){
                e.consume();
            }
        }
        
        });
    }
    public void despliegaproducots(){
        filaseleccionada = jtableproductos.getSelectedRow();
        
        try {
                DefaultTableModel modelo = new DefaultTableModel();
                jtableproductos.setModel(modelo);
                String SQL = "SELECT idtb_producto, NOMBRE, Descripcion, Precio FROM tb_producto";
                
                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumna = rsMd.getColumnCount();
                modelo.addColumn("Código");
                modelo.addColumn("Artículo");
                modelo.addColumn("Descripción");
                modelo.addColumn("Precio");
                while(rs.next()){
                    Object[] fila = new Object[cantidadColumna];
                    
                    for(int i = 0; i<cantidadColumna; i++){
                        fila[i] = rs.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                
                
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void dept(){
        
        
        
        if(cmbdept.getSelectedItem()=="Hogar"){
            d=1;
        }else 
            if(cmbdept.getSelectedItem()=="Jardinería"){
            d=2;
        }else 
                if(cmbdept.getSelectedItem()=="Iluminación"){
            d=3;
        }else 
                    if(cmbdept.getSelectedItem()=="Construcción"){
            d=6;
        }else 
             if(cmbdept.getSelectedItem()=="Plomería"){
            d=7;
        }else  
                 if(cmbdept.getSelectedItem()=="Pinturas"){
            
                     d=8;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        djnuev = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtenomproducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareadesc = new javax.swing.JTextArea();
        cmbdept = new javax.swing.JComboBox<>();
        txtcant = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        djexistente = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableproductos = new javax.swing.JTable();
        btnbusproducto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        btnvolver2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        btnguardarprod = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnexistente = new javax.swing.JButton();
        btnmenu = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Ingreso de nuevo producto");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Descripción:");

        jLabel5.setText("Departamento:");

        jLabel6.setText("Cantidad:");

        jLabel7.setText("Precio:");

        txtenomproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtenomproductoActionPerformed(evt);
            }
        });

        txtareadesc.setColumns(20);
        txtareadesc.setRows(5);
        jScrollPane1.setViewportView(txtareadesc);

        cmbdept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hogar", "Jardinería", "Iluminación", "Construcción", "Plomería", "Pinturas" }));

        txtcant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantActionPerformed(evt);
            }
        });

        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnvolver.setText(" Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout djnuevLayout = new javax.swing.GroupLayout(djnuev.getContentPane());
        djnuev.getContentPane().setLayout(djnuevLayout);
        djnuevLayout.setHorizontalGroup(
            djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(djnuevLayout.createSequentialGroup()
                .addGroup(djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, djnuevLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, djnuevLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(48, 48, 48)
                        .addComponent(txtenomproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, djnuevLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, djnuevLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcant)
                            .addComponent(txtprecio)
                            .addComponent(cmbdept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(djnuevLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnvolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar)
                        .addGap(25, 25, 25)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        djnuevLayout.setVerticalGroup(
            djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(djnuevLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(djnuevLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addGroup(djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtenomproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4)
                        .addGap(61, 61, 61))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbdept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(djnuevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnvolver))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText(" Ingresar cantidad a productos existentes");

        jtableproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", "Precio"
            }
        ));
        jScrollPane2.setViewportView(jtableproductos);

        btnbusproducto.setText("Buscar");
        btnbusproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusproductoActionPerformed(evt);
            }
        });

        jLabel9.setText("Código:");

        jLabel10.setText("Nombre:");

        btnvolver2.setText("Volver");
        btnvolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolver2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Cantidad:");

        btnguardarprod.setText("Guardar");
        btnguardarprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarprodActionPerformed(evt);
            }
        });

        jButton2.setText("Desplegar tiodo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout djexistenteLayout = new javax.swing.GroupLayout(djexistente.getContentPane());
        djexistente.getContentPane().setLayout(djexistenteLayout);
        djexistenteLayout.setHorizontalGroup(
            djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(djexistenteLayout.createSequentialGroup()
                .addGroup(djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(djexistenteLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel8))
                    .addGroup(djexistenteLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(djexistenteLayout.createSequentialGroup()
                                .addGroup(djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(30, 30, 30)
                                .addGroup(djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcod)
                                    .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnbusproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(24, 24, 24))
                            .addGroup(djexistenteLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(djexistenteLayout.createSequentialGroup()
                                .addComponent(btnvolver2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnguardarprod)
                                .addGap(27, 27, 27)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        djexistenteLayout.setVerticalGroup(
            djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(djexistenteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addGap(36, 36, 36)
                .addGroup(djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbusproducto))
                .addGap(20, 20, 20)
                .addGroup(djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(djexistenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnvolver2)
                    .addComponent(btnguardarprod))
                .addGap(40, 40, 40))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("INVENTARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/lista-de-verificacion.png"))); // NOI18N
        btnnuevo.setText("Agregar Nuevos Productos");
        btnnuevo.setOpaque(false);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 50));

        btnexistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/lista-de-verificacion.png"))); // NOI18N
        btnexistente.setText("Agregar o Modificar Existencias");
        btnexistente.setOpaque(false);
        btnexistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexistenteActionPerformed(evt);
            }
        });
        getContentPane().add(btnexistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, 50));

        btnmenu.setForeground(new java.awt.Color(255, 0, 0));
        btnmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/menu.png"))); // NOI18N
        btnmenu.setText("Menu Principal");
        btnmenu.setOpaque(false);
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 160, 70));

        jLabel12.setBackground(new java.awt.Color(204, 204, 255));
        jLabel12.setOpaque(true);
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 70));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 470, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        
        
        this.dispose();
        djnuev.setSize(new Dimension(603,530));
        djnuev.setVisible(true);
        djnuev.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        
        String nompro, desc, cant, precio;
        int canti, pre, n, dep;
        String SQL;
        
        dept();
        
        if("".equals(txtareadesc.getText())||"".equals(txtcant.getText())||"".equals(txtenomproducto.getText())||"".equals(txtprecio.getText())){
            JOptionPane.showMessageDialog(null, "No deje campos en blanco\n"
            +"Ingrese los faltantes","Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{
            
            try{
            nompro = txtenomproducto.getText();
            desc = txtareadesc.getText();
            cant = txtcant.getText();
            precio = txtprecio.getText();
            
            canti = Integer.parseInt(cant);
            pre = Integer.parseInt(precio);
            
            SQL = "INSERT INTO tb_producto (Nombre, Descripcion, dept_fk, Precio, Stock) VALUES (?,?,?,?,?)";
        
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, nompro);
            st.setString(2, desc);
            st.setInt(3, d);
            st.setInt(4, pre);
            st.setInt(5, canti);
            
            n = st.executeUpdate();
            
            if(n>0){
                JOptionPane.showMessageDialog(null, "Producto guardado con éxito");
                
                
            }
            
            }catch(HeadlessException | NumberFormatException | SQLException e){
                
            } 
        }
        
        
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnexistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexistenteActionPerformed
        
        
        this.dispose();
        djexistente.setSize(new Dimension(814,575));
        djexistente.setVisible(true);
        djexistente.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnexistenteActionPerformed

    private void btnbusproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusproductoActionPerformed
       Metodos m = new Metodos();
        
        
        String cod, nombb;
        
        if("".equals(txtcod.getText())&&"".equals(txtnom.getText())){
               JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE DATOS VÁLIDOS A BUSCAR");
        }else
            if("".equals(txtnom.getText())){
            cod = txtcod.getText();
            nombb = txtnom.getText();
            m.ingresocod(cod, nombb, (DefaultTableModel) jtableproductos.getModel());
            
        }else{
            cod = txtnom.getText();
            m.ingresnombre(cod, (DefaultTableModel) jtableproductos.getModel());
        }
            
        
    }//GEN-LAST:event_btnbusproductoActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        
        IngresoProductos i = new IngresoProductos();
        i.setVisible(true);
        djnuev.dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnvolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolver2ActionPerformed
       
        
        IngresoProductos i = new IngresoProductos();
        i.setVisible(true);
        djexistente.dispose();
        
    }//GEN-LAST:event_btnvolver2ActionPerformed

    private void btnguardarprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarprodActionPerformed
       
        try{
        
        int productoexistente;
        int produtoexistente, sstock, actsumstock;
        
        String stock;
        filaseleccionada = jtableproductos.getSelectedRow();
        
        String codigo = jtableproductos.getValueAt(filaseleccionada, 0).toString();
         
        
         String SQL = "SELECT stock FROM tb_producto WHERE idtb_producto=" + codigo;
          
         
                       ps = con.prepareStatement(SQL);
                       rs = ps.executeQuery();
                       
                       if(rs.next()){
                           
                           produtoexistente = rs.getInt("stock");
                       
                           stock = txtcantidad.getText();
                      
                            sstock = Integer.parseInt(stock);

                            actsumstock = produtoexistente+sstock;
                            
                            //Actualizamos las unidades en stock

                                String SQL2 = "UPDATE tb_producto SET stock=? WHERE idtb_producto ="+codigo; 
                                PreparedStatement st2 = con.prepareStatement(SQL2);

                                st2.setInt(1,actsumstock);

                                st2.executeUpdate();

                               JOptionPane.showMessageDialog(null, "Producto actualizado");

                       }
                       
                       
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de tipo: "+ e );
        }
    }//GEN-LAST:event_btnguardarprodActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        despliegaproducots();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_btnmenuActionPerformed

    private void txtenomproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtenomproductoActionPerformed
        
        txtenomproducto.transferFocus();
    }//GEN-LAST:event_txtenomproductoActionPerformed

    private void txtcantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantActionPerformed
       txtcant.transferFocus();
    }//GEN-LAST:event_txtcantActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        txtprecio.transferFocus();
    }//GEN-LAST:event_txtprecioActionPerformed

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
            java.util.logging.Logger.getLogger(IngresoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbusproducto;
    private javax.swing.JButton btnexistente;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardarprod;
    private javax.swing.JButton btnmenu;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnvolver;
    private javax.swing.JButton btnvolver2;
    private javax.swing.JComboBox<String> cmbdept;
    private javax.swing.JDialog djexistente;
    private javax.swing.JDialog djnuev;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtableproductos;
    private javax.swing.JTextArea txtareadesc;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtenomproducto;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
