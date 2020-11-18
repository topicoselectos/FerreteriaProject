/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.sql.Connection;
import Clases.Conectar;
import forms.CarritoCompras;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javafx.animation.Animation;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rolan
 */
public class Menu extends javax.swing.JFrame {

    Conectar co = new Conectar();   
    Connection con = co.conexion();
    
    PreparedStatement ps = null;
    ResultSet rs;
    
    double sub_total;
    double iva;
    double total;
    
    public static int filaseleccionada;
    DefaultTableModel modelo;
    
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
        
 
    }

    public void BusquedaCodigo(){
        String cod = txt_buscar.getText();
        
        try {
                DefaultTableModel modelo = new DefaultTableModel();
                jtableProducts.setModel(modelo);
                String SQL = "SELECT idtb_producto, NOMBRE, Descripcion, fk_stock, Precio FROM tb_producto WHERE idtb_producto=" + cod;
                
                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumna = rsMd.getColumnCount();
                modelo.addColumn("Código");
                modelo.addColumn("Artículo");
                modelo.addColumn("Descripción");
                modelo.addColumn("Stock");
                modelo.addColumn("Precio");
                do{
                if(rs.next()){
                    Object[] fila = new Object[cantidadColumna];
                    
                    for(int i = 0; i<cantidadColumna; i++){
                        fila[i] = rs.getObject(i+1);
                    }
                    modelo.addRow(fila);
                    txtNombre.setText(""+fila[1]);
                }else{
                    JOptionPane.showMessageDialog(null, "Artículo no encontrado en nuestra base de datos", "¡Consulta Fallida!", JOptionPane.OK_OPTION);
                    txtNombre.setText("");
                    txt_buscar.setText("");
                }
                }while(rs.next());  
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor inrgese el dato a buscar en la parte de arriba de la pestaña","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void BusquedaNombre(){
         String cod = txtNombre.getText();
        int a = 0;
         
        try {
                DefaultTableModel modelo = new DefaultTableModel();
                jtableProducts.setModel(modelo);
                String SQL = "SELECT idtb_producto, NOMBRE, Descripcion, fk_stock, Precio FROM tb_producto WHERE Nombre LIKE '%" + cod+"%'";
                
                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumna = rsMd.getColumnCount();
                
                
                modelo.addColumn("Código");
                modelo.addColumn("Artículo");
                modelo.addColumn("Descripción");
                modelo.addColumn("Stock");
                modelo.addColumn("Precio");
                while(rs.next()){
                    Object[] fila = new Object[cantidadColumna];
                    
                    for(int i = 0; i<cantidadColumna; i++){
                        fila[i] = rs.getObject(i+1);
                    }
                    modelo.addRow(fila);
                    txt_buscar.setText(""+fila[0]);
                }
                
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Artículo no encontrado","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void limpiarTabla(){
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            jtableProducts.setModel(modelo);
            modelo.setRowCount(0);
            modelo.addColumn("Código");
                modelo.addColumn("Artículo");
                modelo.addColumn("Descripción");
                modelo.addColumn("Stock");
                modelo.addColumn("Precio");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Eroor al limpiar tabla","1Error¡",JOptionPane.ERROR);
        }
    }
    
    public void colaborador(){
        int res = 0;
        String colaborador;
        String SQL = "SELECT NOMBRE, Apellido_1 AS 'Apellido'";
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Carrito = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacarrito = new javax.swing.JTable();
        btneliminarfilacarrito = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtsub = new javax.swing.JTextField();
        txtiva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
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
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableProducts = new javax.swing.JTable();
        btnconsulta = new javax.swing.JButton();
        btndesplegar = new javax.swing.JButton();
        txtcantidad = new javax.swing.JTextField();
        btniralcarrito = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btnlimpiar = new javax.swing.JButton();
        lbcantidad = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlbcolaborador = new javax.swing.JLabel();
        pnlInventario = new javax.swing.JPanel();
        pnlAdministracion = new javax.swing.JPanel();

        jPanel2.setMaximumSize(new java.awt.Dimension(903, 585));
        jPanel2.setMinimumSize(new java.awt.Dimension(903, 585));

        tablacarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artículo", "Cantidad", "Precio Unitario", "Total producto"
            }
        ));
        jScrollPane2.setViewportView(tablacarrito);

        btneliminarfilacarrito.setText("Eliminar Fila");
        btneliminarfilacarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarfilacarritoActionPerformed(evt);
            }
        });

        jLabel8.setText("Subtotal:");

        jLabel9.setText("I.V.A:");

        jLabel10.setText("Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsub)
                            .addComponent(txtiva)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btneliminarfilacarrito)
                        .addGap(30, 30, 30)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminarfilacarrito)
                    .addComponent(jLabel8)
                    .addComponent(txtsub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CarritoLayout = new javax.swing.GroupLayout(Carrito.getContentPane());
        Carrito.getContentPane().setLayout(CarritoLayout);
        CarritoLayout.setHorizontalGroup(
            CarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CarritoLayout.setVerticalGroup(
            CarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
        pnlMenuDeslizable.add(btnAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 200, 60));

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
        pnlMenuDeslizable.add(btnCajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 160, 60));

        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/inventario.png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setBorder(null);
        btnInventario.setContentAreaFilled(false);
        pnlMenuDeslizable.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 160, 60));

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/CarritoCompras.png"))); // NOI18N
        jButton2.setText("Añadir al carrito");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlCajeros.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 200, 50));

        jLabel2.setText("Nombre:");
        pnlCajeros.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, 20));
        pnlCajeros.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 670, -1));

        jtableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Articulo", "Descripción", "Stock", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtableProducts);

        pnlCajeros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 790, 270));

        btnconsulta.setText("Consultar Producto");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });
        pnlCajeros.add(btnconsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, 50));

        btndesplegar.setText("Desplegar todos los productos");
        btndesplegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndesplegarActionPerformed(evt);
            }
        });
        pnlCajeros.add(btndesplegar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, -1, 50));
        pnlCajeros.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 220, -1));

        btniralcarrito.setText("Ir al carrito");
        btniralcarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniralcarritoActionPerformed(evt);
            }
        });
        pnlCajeros.add(btniralcarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 90, -1, -1));

        jLabel7.setText("Codigo:");
        pnlCajeros.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, 20));
        pnlCajeros.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 670, -1));

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        pnlCajeros.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 80, 50));

        lbcantidad.setText("Cantidad:");
        pnlCajeros.add(lbcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, -1, -1));

        jLabel12.setText("Colaborador:");
        pnlCajeros.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 450, -1, -1));

        jlbcolaborador.setText("jLabel13");
        pnlCajeros.add(jlbcolaborador, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 500, -1, -1));

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
       
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        if("".equals(txtNombre.getText())&&"".equals(txt_buscar.getText())){
               JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE DATOS VÁLIDOS A BUSCAR");
        }else
        if("".equals(txtNombre.getText())){
            BusquedaCodigo();
        }else{
            BusquedaNombre();
        }
    }//GEN-LAST:event_btnconsultaActionPerformed

    private void btndesplegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndesplegarActionPerformed

        filaseleccionada = jtableProducts.getSelectedRow();
        
        try {
                DefaultTableModel modelo = new DefaultTableModel();
                jtableProducts.setModel(modelo);
                String SQL = "SELECT idtb_producto, NOMBRE, Descripcion, fk_stock, Precio FROM tb_producto";
                
                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumna = rsMd.getColumnCount();
                modelo.addColumn("Código");
                modelo.addColumn("Artículo");
                modelo.addColumn("Descripción");
                modelo.addColumn("Stock");
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
        
    }//GEN-LAST:event_btndesplegarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           
        filaseleccionada = jtableProducts.getSelectedRow();
        int ct;
        double stockk;
        
        try {
                String codigo, articulo, descripcion,stock, precio, cantidad, importa;
                double calc = 0.0, sub = 0.0, igv =0.0;
                int cant = 0;
                
                if(filaseleccionada==-1){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar una fila de la tabla","Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
                    modelo = (DefaultTableModel) jtableProducts.getModel();
                    codigo  = jtableProducts.getValueAt(filaseleccionada, 0).toString();
                    articulo  = jtableProducts.getValueAt(filaseleccionada, 1).toString();
                    descripcion  = jtableProducts.getValueAt(filaseleccionada, 2).toString();
                    stock  = jtableProducts.getValueAt(filaseleccionada, 3).toString();
                    precio = jtableProducts.getValueAt(filaseleccionada, 4).toString();
                    
                    cantidad = txtcantidad.getText();
                    
                    if(!"".equals(txtcantidad.getText())){
                    
                     ct = (int)jtableProducts.getValueAt(filaseleccionada, 3);
                     stockk = (Double.parseDouble(txtcantidad.getText()));
                        
                        if(stockk<=ct&&stockk>0){
                    //Aquí vamos a realizar los cálculos 
                    sub=(Double.parseDouble(precio)*Integer.parseInt(cantidad));
                    importa = String.valueOf(sub);
                    
                    modelo = (DefaultTableModel) tablacarrito.getModel();
                    String elementos[] = {articulo,cantidad,precio,importa};
                    modelo.addRow(elementos);
                    
                    calc = (Double.parseDouble(precio) * Integer.parseInt(cantidad));
                    sub_total = sub_total + calc;
                    iva = sub_total * 0.13;
                    igv = iva;
                    total = sub_total+igv;
                    
                    txtTotal.setText(""+total);
                    txtiva.setText(""+igv);
                    txtsub.setText(""+sub_total);
                    
                    JOptionPane.showMessageDialog(null, "¡Elemento agregado correctamente al carrito de Compras!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarTabla();
                    txtcantidad.setText("");
                    txtNombre.setText("");
                    txt_buscar.setText("");
                        }else
                        if(stockk==0||stockk<0){
                             JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida\n"+
                                     "Igrese un nuevo valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                             txtcantidad.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "La cantidad a llevar es insuficiente en nuestro inventario\n"+
                                     "Igrese un nuevo valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                             txtcantidad.setText("");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida del producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de tipo: "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btniralcarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniralcarritoActionPerformed
        Carrito.setSize(new Dimension(903,585));
        Carrito.setVisible(true);
        Carrito.setLocationRelativeTo(null);
      
    }//GEN-LAST:event_btniralcarritoActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        
        txtNombre.setText("");
        txt_buscar.setText("");
        txtcantidad.setText("");
        limpiarTabla();
        
        
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btneliminarfilacarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarfilacarritoActionPerformed

        double x = 0.0, impuesto = 0.0, nuevototal= 0.0, importa = 0.0, precioactual;
        int respuesta, fila;
        
        try {
               filaseleccionada = tablacarrito.getSelectedRow();
               if(filaseleccionada==-1){
                   JOptionPane.showMessageDialog(null, "Por favor seleccione el producto que desea eliminar", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);
               }else{
                   respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este producto de su carrito?\n" +
                           "De ser así deberá agregar de nuevo el producto", "Acción", JOptionPane.YES_NO_OPTION);
                   if(respuesta == JOptionPane.YES_OPTION){
                       importa = Double.parseDouble(tablacarrito.getValueAt(filaseleccionada, 3).toString());
                       precioactual = Double.parseDouble(txtsub.getText())-importa;
                       sub_total = precioactual;
                       txtsub.setText(""+sub_total);
                       
                       impuesto = sub_total * 0.13;
                       txtiva.setText(""+impuesto);
                       
                       nuevototal = sub_total+impuesto;
                       
                      txtTotal.setText(""+nuevototal);
                      
                      modelo = (DefaultTableModel)tablacarrito.getModel();
                      modelo.removeRow(filaseleccionada);
                      
                   }
               }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha realizado la eliminación del producto", "Verifique", JOptionPane.ERROR_MESSAGE);
        }
        





        
    }//GEN-LAST:event_btneliminarfilacarritoActionPerformed

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
    private javax.swing.JDialog Carrito;
    private javax.swing.JButton btnAdministracion;
    private javax.swing.JButton btnCajeros;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnVendedores;
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btndesplegar;
    private javax.swing.JButton btneliminarfilacarrito;
    private javax.swing.JButton btniralcarrito;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlbcolaborador;
    private javax.swing.JTable jtableProducts;
    private javax.swing.JLabel lbcantidad;
    private javax.swing.JPanel pnlAdministracion;
    private javax.swing.JPanel pnlCajeros;
    private javax.swing.JPanel pnlInventario;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuDeslizable;
    private javax.swing.JPanel pnlVendedores;
    private javax.swing.JTable tablacarrito;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtsub;
    // End of variables declaration//GEN-END:variables
}
