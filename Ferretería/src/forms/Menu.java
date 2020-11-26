/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Clases.Metodos;
import java.sql.Connection;
import Clases.Conectar;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
    String cod,art, nombb, cliente;
    int cm;
    Metodos m = new Metodos();

    String cc, nomfact, contfact, apfact,f;
    
    public static int filaseleccionada;
    DefaultTableModel modelo;
    DefaultTableModel model;
    
    
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
        
        num(txt_buscar);
        num(txtced);
        num(txtcantidad);
        num(txttelefono);
        num(txtcambio);
        num(txtpaga);
        
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
    
    public void Random(){
        
        String random;
        Random ran = new Random();
        int n = ran.nextInt(999999999);
        random = String.valueOf(n);
        txtnumpedido.setText(random);
        
        
    }
    
    public void facturacion(){
        tblfact();
        txtnmclfact.setText(nomfact);
        txtapcltfact.setText(apfact);
        txtcontactcltfact3.setText(contfact);
        txtsubfact.setText(txtsub.getText());
        txtivafact.setText(txtiva.getText());
        txttotalfact.setText(txtTotal.getText());
        
    }
    
    public void fecha(){
         
         Date fecha = new Date();
         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
         lblfecha.setText(formatoFecha.format(fecha));
         
    }
    
    public void dept(int d){
        try {
                DefaultTableModel modelo = new DefaultTableModel();
                jtableProducts.setModel(modelo);
                String SQL = "SELECT idtb_producto, NOMBRE, Descripcion, fk_stock, Precio FROM tb_producto WHERE dept_fk="+d;
                
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
    }
   
    public void elimfact(){
         double x = 0.0, impuesto = 0.0, nuevototal= 0.0, importa = 0.0, precioactual;
        int respuesta, fila;
        
        try {
               filaseleccionada = tblpedido.getSelectedRow();
               if(filaseleccionada==-1){
                   JOptionPane.showMessageDialog(null, "Por favor seleccione el producto que desea eliminar", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);
               }else{
                   respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este producto de su carrito?\n" +
                           "De ser así deberá agregar de nuevo el producto", "Acción", JOptionPane.YES_NO_OPTION);
                   if(respuesta == JOptionPane.YES_OPTION){
                       
                       model = (DefaultTableModel)tblpedido.getModel();
                      model.removeRow(filaseleccionada);
                      
                       importa = Double.parseDouble(tablacarrito.getValueAt(filaseleccionada, 4).toString());
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
        
    }
    
    public void tblfact(){
        
        String cod, articulo, cant,preciou, subproduct;
        DefaultTableModel model = new DefaultTableModel();
        
        try {
            model = (DefaultTableModel) tblfact.getModel();
            
            
            for (int i = 0; i < 1000; i++) {
                
                 cod = tablacarrito.getValueAt(i, 0).toString();
                 articulo = tablacarrito.getValueAt(i, 1).toString();
                 cant = tablacarrito.getValueAt(i, 2).toString();
                 preciou = tablacarrito.getValueAt(i, 3).toString();
                 subproduct = tablacarrito.getValueAt(i, 4).toString();
                 String f[] = {cod,articulo,cant, preciou,subproduct};
                 model.addRow(f);
            }
                
        } catch (Exception e) {
            
        }
    }
    
    public void pedido(){
        
               
        String cod, cant,emp, clt;
        DefaultTableModel model = new DefaultTableModel();
        
        try {
            model = (DefaultTableModel) tblpedido.getModel();
            
            
            for (int i = 0; i < 1000; i++) {
                
                 cod = tablacarrito.getValueAt(i, 0).toString();
                 cant = tablacarrito.getValueAt(i, 2).toString();
                 String f[] = {cod,cant};
                 model.addRow(f);
            }
                
        } catch (Exception e) {
            
        }
        
    }
    
    public void cargaempleado(){
        
        String emp = lbusuario.getText();
        
        try {
                String SQL = "SELECT idtb_empleado, Nombre, Apellido_1 FROM tb_empleado WHERE nom_usuario='"+emp+"'";
                
                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                while(rs.next()){
                    Object[] fila = new Object[50];
                    
                    for(int i = 0; i<50; i++){
                        fila[i] = rs.getObject(i+1);
                        
                    txtiduser.setText(""+fila[0]);
                    txtpusuario.setText(""+fila[1]+" "+fila[2]);
                    }
                }
                
                
        } catch (SQLException e) {
            
        } 
    }
    public void cargacliente(){
        
        String cliente = cc;
        
        try {
                String SQL = "SELECT idtb_cliente, Nombre_cliente, Apellidos FROM tb_cliente WHERE Cédula="+cliente;
                
                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                while(rs.next()){
                    Object[] fila = new Object[50];
                    
                    for(int i = 0; i<50; i++){
                        fila[i] = rs.getObject(i+1);
                        
                    txtidcliente.setText(""+fila[0]);
                    txtpcliente.setText(""+fila[1]+" "+fila[2]);
                    }
                }
                
                
        } catch (SQLException e) {
            
        }
    }
    
    public void limpiarTodo(){
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            jtableProducts.setModel(modelo);
            modelo.setRowCount(0);
            modelo.addColumn("Código");
                modelo.addColumn("Artículo");
                modelo.addColumn("Descripción");
                modelo.addColumn("Stock");
                modelo.addColumn("Precio");
                txtNombre.setText("");
                txt_buscar.setText("");
                txtcantidad.setText("");
                cmbdept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hogar", "Jardinería", "Iluminación", "Construcción", "Plomería", "Pinturas" }));
               
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Eroor al limpiar tabla","1Error¡",JOptionPane.ERROR);
        }
    }
    
    public void seleccion(){
        filaseleccionada = jtableProducts.getSelectedRow();
        try{
        if(filaseleccionada==-1){
                    JOptionPane.showMessageDialog(null,"Debe seleccionar una fila de la tabla","Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
            cod  = jtableProducts.getValueAt(filaseleccionada, 0).toString();
            art  = jtableProducts.getValueAt(filaseleccionada, 1).toString();
            txt_buscar.setText(cod);
            txtNombre.setText(art);
        }
        
        }catch(Exception e){
                System.err.println(e);
                }
    }
    
    public void añadir(){
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
                    String elementos[] = {codigo,articulo,cantidad,precio,importa};
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
                    limpiarTodo();
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
        btnContinuar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lbusuario1 = new javax.swing.JLabel();
        Cliente = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtnombre_cliente = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtced = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnlimpiarcliente = new javax.swing.JButton();
        btncontinuar = new javax.swing.JButton();
        Pedido = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblpedido = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtpusuario = new javax.swing.JTextField();
        txtpcliente = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtiduser = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        btncontinuarfact = new javax.swing.JButton();
        txtnumpedido = new javax.swing.JTextField();
        btneliminarproduct = new javax.swing.JButton();
        btncobro = new javax.swing.JButton();
        Facturación = new javax.swing.JDialog();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtnmclfact = new javax.swing.JTextField();
        txtapcltfact = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtcontactcltfact3 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblfact = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtsubfact = new javax.swing.JTextField();
        txtivafact = new javax.swing.JTextField();
        txttotalfact = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtpaga = new javax.swing.JTextField();
        txtcambio = new javax.swing.JTextField();
        btnpagar = new javax.swing.JButton();
        lblnfact = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        lblfecha = new javax.swing.JLabel();
        pnlMenuDeslizable = new javax.swing.JPanel();
        btnAdministracion = new javax.swing.JButton();
        btnVendedores = new javax.swing.JButton();
        btnCajeros = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlVendedores = new javax.swing.JPanel();
        pnlCajeros = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btncarrito = new javax.swing.JButton();
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
        jLabel3 = new javax.swing.JLabel();
        cmbdept = new javax.swing.JComboBox<>();
        lbusuario = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pnlInventario = new javax.swing.JPanel();
        pnlAdministracion = new javax.swing.JPanel();

        jPanel2.setMaximumSize(new java.awt.Dimension(903, 585));
        jPanel2.setMinimumSize(new java.awt.Dimension(903, 585));

        tablacarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Artículo", "Cantidad", "Precio Unitario", "Total producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        txtsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubActionPerformed(evt);
            }
        });

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("Usuario:");

        lbusuario1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
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
                                .addGap(44, 44, 44)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnContinuar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(88, 88, 88))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbusuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbusuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Detalles de Cliente");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("N° Cédula:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Nombre:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Apellidos:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Correo:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Teléfono:");

        txtnombre_cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtnombre_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombre_clienteActionPerformed(evt);
            }
        });

        txt_apellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellidosActionPerformed(evt);
            }
        });

        txtcorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });

        txttelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        txtced.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnlimpiarcliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnlimpiarcliente.setText("Limpiar");
        btnlimpiarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarclienteActionPerformed(evt);
            }
        });

        btncontinuar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btncontinuar.setText("Continuar");
        btncontinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncontinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel5))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtced, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnlimpiarcliente)
                        .addGap(84, 84, 84)
                        .addComponent(btnguardar)
                        .addGap(100, 100, 100)
                        .addComponent(btncontinuar)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlimpiarcliente)
                    .addComponent(btnguardar)
                    .addComponent(btncontinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ClienteLayout = new javax.swing.GroupLayout(Cliente.getContentPane());
        Cliente.getContentPane().setLayout(ClienteLayout);
        ClienteLayout.setHorizontalGroup(
            ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClienteLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ClienteLayout.setVerticalGroup(
            ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Detalle Pedido N°");

        tblpedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Producto", "Cantidad"
            }
        ));
        jScrollPane3.setViewportView(tblpedido);

        jLabel12.setText("Nombre Cliente:");

        jLabel18.setText("Nombre Usuario:");

        txtpusuario.setEditable(false);

        txtpcliente.setEditable(false);

        jLabel19.setText("ID Usuario:");

        txtiduser.setEditable(false);

        jLabel20.setText("ID Cliente:");

        txtidcliente.setEditable(false);

        btncontinuarfact.setText("Continuar");
        btncontinuarfact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncontinuarfactActionPerformed(evt);
            }
        });

        txtnumpedido.setEditable(false);
        txtnumpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumpedidoActionPerformed(evt);
            }
        });

        btneliminarproduct.setText("Eliminar");
        btneliminarproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarproductActionPerformed(evt);
            }
        });

        btncobro.setText("Carrito");
        btncobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncobroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtnumpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel19))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtpusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel20))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtpcliente)
                                        .addComponent(txtidcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btncontinuarfact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btneliminarproduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncobro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtnumpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtpusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtpcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btncontinuarfact)
                        .addGap(32, 32, 32)
                        .addComponent(btneliminarproduct)
                        .addGap(29, 29, 29)
                        .addComponent(btncobro)
                        .addGap(74, 74, 74))))
        );

        javax.swing.GroupLayout PedidoLayout = new javax.swing.GroupLayout(Pedido.getContentPane());
        Pedido.getContentPane().setLayout(PedidoLayout);
        PedidoLayout.setHorizontalGroup(
            PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PedidoLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PedidoLayout.setVerticalGroup(
            PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel21.setText("Facturación");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel22.setText("Infromación del cliente");

        jLabel23.setText("Nombre:");

        jLabel24.setText("Apellidos:");

        txtnmclfact.setEditable(false);

        txtapcltfact.setEditable(false);

        jLabel25.setText("Contacto:");

        txtcontactcltfact3.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(txtnmclfact, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtapcltfact))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcontactcltfact3)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(58, 58, 58))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtnmclfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtapcltfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtcontactcltfact3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        tblfact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Artículo", "Cantidad", "Precio Unitario", "Subtotal Producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblfact);

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        jLabel26.setText("Información de pago");

        jLabel27.setText("Subtotal:");

        jLabel28.setText("I.V.A:");

        jLabel29.setText("Total:");

        txtsubfact.setEditable(false);

        txtivafact.setEditable(false);

        txttotalfact.setEditable(false);

        jLabel30.setText("Paga con:");

        jLabel31.setText("Cambio:");

        txtcambio.setEditable(false);

        btnpagar.setText("Pagar");
        btnpagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel26))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsubfact, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtivafact, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(299, 299, 299)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtpaga, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(txtcambio)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txttotalfact, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnpagar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtsubfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtpaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtivafact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel31)
                    .addComponent(txtcambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotalfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpagar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FacturaciónLayout = new javax.swing.GroupLayout(Facturación.getContentPane());
        Facturación.getContentPane().setLayout(FacturaciónLayout);
        FacturaciónLayout.setHorizontalGroup(
            FacturaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FacturaciónLayout.createSequentialGroup()
                .addGroup(FacturaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FacturaciónLayout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(lblnfact, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(FacturaciónLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
                    .addGroup(FacturaciónLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        FacturaciónLayout.setVerticalGroup(
            FacturaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FacturaciónLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FacturaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblnfact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(FacturaciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        pnlMenu.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 190, 30));

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

        btncarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img menu/CarritoCompras.png"))); // NOI18N
        btncarrito.setText("Añadir al carrito");
        btncarrito.setBorder(null);
        btncarrito.setBorderPainted(false);
        btncarrito.setContentAreaFilled(false);
        btncarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarritoActionPerformed(evt);
            }
        });
        pnlCajeros.add(btncarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 200, 50));

        jLabel2.setText("Nombre:");
        pnlCajeros.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, 20));
        pnlCajeros.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 370, -1));

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
        jtableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableProductsMouseClicked(evt);
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
        pnlCajeros.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 370, -1));

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        pnlCajeros.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 80, 50));

        lbcantidad.setText("Cantidad:");
        pnlCajeros.add(lbcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, -1, -1));

        jLabel3.setText("Departamento");
        pnlCajeros.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        cmbdept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hogar", "Jardinería", "Iluminación", "Construcción", "Plomería", "Pinturas" }));
        cmbdept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdeptActionPerformed(evt);
            }
        });
        pnlCajeros.add(cmbdept, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 190, -1));

        lbusuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnlCajeros.add(lbusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 560, 210, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Usuario:");
        pnlCajeros.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 540, -1, -1));

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
            cod = txt_buscar.getText();
            nombb = txtNombre.getText();
            m.BusquedaCodigo(cod, nombb, (DefaultTableModel) jtableProducts.getModel());
            
        }else{
            cod = txtNombre.getText();
            m.BusquedaNombre(cod, (DefaultTableModel) jtableProducts.getModel());
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

    private void btncarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarritoActionPerformed
         
        añadir();
    }//GEN-LAST:event_btncarritoActionPerformed

    private void btniralcarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniralcarritoActionPerformed
        Carrito.setSize(new Dimension(903,585));
        lbusuario1.setText(lbusuario.getText());
        Carrito.setVisible(true);
        Carrito.setLocationRelativeTo(null);
      
    }//GEN-LAST:event_btniralcarritoActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
       
        limpiarTodo();
       
        
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
                       importa = Double.parseDouble(tablacarrito.getValueAt(filaseleccionada, 4).toString());
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

    private void cmbdeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdeptActionPerformed

        
        String op = (String) cmbdept.getSelectedItem();
        int d;
        
        if(null != op)switch (op) {
            case "Hogar":
                d=1;
                dept(d);
                break;
            case "Jardinería":
                d=2;
                dept(d);
                break;
            case "Iluminación":
                d=3;
                dept(d);
                break;
            case "Construcción":
                d=6;
                dept(d);
                break;
            case "Plomería":
                d=7;
                dept(d);
                break;
            case "Pinturas":
                d=8;
                dept(d);
                break;
            default:
                break;
        }
        
    }//GEN-LAST:event_cmbdeptActionPerformed

    private void jtableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableProductsMouseClicked
        seleccion();
    }//GEN-LAST:event_jtableProductsMouseClicked

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        
        Carrito.dispose();
        Cliente.setSize(new Dimension(650,585));
        Cliente.setVisible(true);
        Cliente.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void txtcedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedActionPerformed

        txtced.transferFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedActionPerformed

    private void txtnombre_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombre_clienteActionPerformed

        txtnombre_cliente.transferFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre_clienteActionPerformed

    private void txt_apellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellidosActionPerformed

        txt_apellidos.transferFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidosActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed

        txtcorreo.transferFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed

        txttelefono.transferFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
       
        String nombre, apellidos, correo;
        int cedula, telefono, n;
        String SQL;
        
        if("".equals(txtnombre_cliente.getText())||"".equals(txt_apellidos.getText())||"".equals(txtced.getText())||"".equals(txtcorreo.getText())||"".equals(txttelefono.getText())){
            JOptionPane.showMessageDialog(null, "No deje campos en blanco\n"
            +"Ingrese los faltantes","Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{
        nombre = txtnombre_cliente.getText();
        apellidos = txt_apellidos.getText();
        correo = txtcorreo.getText();
        cedula = Integer.parseInt(txtced.getText());
        telefono = Integer.parseInt(txttelefono.getText());
        
        SQL = "INSERT INTO tb_cliente (Cédula, Nombre_cliente, Apellidos, Correo, Telefono) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, cedula);
            st.setString(2, nombre);
            st.setString(3, apellidos);
            st.setString(4, correo);
            st.setInt(5, telefono);
            
            n = st.executeUpdate();
            
            if(n>0){
                cc = txtced.getText();
                nomfact = txtnombre_cliente.getText();
                apfact = txt_apellidos.getText();
                contfact = txttelefono.getText();
                JOptionPane.showMessageDialog(null, "Cliente guardado con éxito");
                txtced.setText("");
                txtnombre_cliente.setText("");
                txt_apellidos.setText("");
                txtcorreo.setText("");
                txttelefono.setText("");
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnlimpiarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarclienteActionPerformed

                txtced.setText("");
                txtnombre_cliente.setText("");
                txt_apellidos.setText("");
                txtcorreo.setText("");
                txttelefono.setText("");

    }//GEN-LAST:event_btnlimpiarclienteActionPerformed

    private void btncontinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncontinuarActionPerformed
        
        Pedido.setVisible(true);
        Pedido.setSize(new Dimension(558,566));
        Pedido.setLocationRelativeTo(null);
        Cliente.dispose();
         JOptionPane.showMessageDialog(null, "Por favor seleccione los productos\n"+
                "que desea Facturar \n"
                 + "eliminar", "Acción necesaria", JOptionPane.INFORMATION_MESSAGE);
        
        pedido();
        Random();
        lblnfact.setText(txtnumpedido.getText());
        cargaempleado();
        cargacliente();
        
        
        
    }//GEN-LAST:event_btncontinuarActionPerformed

    private void btncontinuarfactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncontinuarfactActionPerformed
        // TODO add your handling code here:
         
        int productofk, empleadofk, clientefk, cantidad,n, idfact;
        double sub, total, impuesto;
        String prfk, empfk, clfk;
        
        String SQL;
        
        filaseleccionada = tblpedido.getSelectedRow();
        
         SQL = "INSERT INTO tb_factura (idtb_facura, fecha, Subtotal, Impuesto, Total, producto_fk, cantidad, empleado_fk, cliente_fk) VALUES (?,?,?,?,?,?,?,?,?)";
          
         try{
          
          idfact = Integer.parseInt(txtnumpedido.getText());
          sub = Double.parseDouble(txtsub.getText());
          total = Double.parseDouble(txtTotal.getText());
          impuesto = Double.parseDouble(txtiva.getText());
            
         if(filaseleccionada==-1){
                   
             JOptionPane.showMessageDialog(null,"Debe seleccionar un producto","Advertencia", JOptionPane.WARNING_MESSAGE);
               
         }else{
             
          prfk  = tblpedido.getValueAt(filaseleccionada, 0).toString();
          empfk  = tblpedido.getValueAt(filaseleccionada, 1).toString();
          productofk = Integer.parseInt(prfk);
          cantidad = Integer.parseInt(empfk);
          empleadofk = Integer.parseInt(txtiduser.getText());
          clientefk = Integer.parseInt(txtidcliente.getText());
          
            
             PreparedStatement st = con.prepareStatement(SQL);
             st.setInt(1, idfact);
             st.setString(2, lblfecha.getText());
             st.setDouble(3, sub);
             st.setDouble(4, impuesto);
             st.setDouble(5, total);
             st.setInt(6, productofk);
             st.setInt(7, cantidad);
             st.setInt(8, empleadofk);
             st.setInt(9, clientefk);
             
             n = st.executeUpdate();
             
             if(n>0){
                
                JOptionPane.showMessageDialog(null, "Pedido guardado con éxito");
                
                filaseleccionada = tblpedido.getSelectedRow();
                modelo = (DefaultTableModel)tblpedido.getModel();
                modelo.removeRow(filaseleccionada);
            }
         }
        } catch (SQLException e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btncontinuarfactActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void btneliminarproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarproductActionPerformed
        // TODO add your handling code here:
        
        elimfact();
        
    }//GEN-LAST:event_btneliminarproductActionPerformed

    private void btncobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncobroActionPerformed
       
        Facturación.setVisible(true);
        Facturación.setSize(new Dimension(917,699));
        Facturación.setLocationRelativeTo(null);
        Pedido.dispose();
        facturacion();
        
        
    }//GEN-LAST:event_btncobroActionPerformed

    private void txtnumpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumpedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumpedidoActionPerformed

    private void btnpagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpagarActionPerformed
        double total, pago, cambio;
        
        total = Double.parseDouble(txttotalfact.getText());
        pago= Double.parseDouble(txtpaga.getText());

        if(pago>=total){
            
            cambio = pago-total;
            JOptionPane.showMessageDialog(null, "¡Gracias por su compra! \n"+ nomfact+
                    ", ha sido un gusto atenderte", "Gracias", JOptionPane.INFORMATION_MESSAGE);
            txtcambio.setText(""+cambio);
            
        }else{
            JOptionPane.showMessageDialog(null, "Su pago debe ser mayor o igual al total de su factura\n"+
                    "   Intente de nuevo    ", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnpagarActionPerformed

    private void txtsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubActionPerformed

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
    private javax.swing.JDialog Cliente;
    private javax.swing.JDialog Facturación;
    private javax.swing.JDialog Pedido;
    private javax.swing.JButton btnAdministracion;
    private javax.swing.JButton btnCajeros;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnVendedores;
    private javax.swing.JButton btncarrito;
    private javax.swing.JButton btncobro;
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btncontinuar;
    private javax.swing.JButton btncontinuarfact;
    private javax.swing.JButton btndesplegar;
    private javax.swing.JButton btneliminarfilacarrito;
    private javax.swing.JButton btneliminarproduct;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btniralcarrito;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnlimpiarcliente;
    private javax.swing.JButton btnpagar;
    private javax.swing.JComboBox<String> cmbdept;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtableProducts;
    private javax.swing.JLabel lbcantidad;
    private javax.swing.JLabel lblfecha;
    public static javax.swing.JLabel lblnfact;
    public static javax.swing.JLabel lbusuario;
    public static javax.swing.JLabel lbusuario1;
    private javax.swing.JPanel pnlAdministracion;
    private javax.swing.JPanel pnlCajeros;
    private javax.swing.JPanel pnlInventario;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuDeslizable;
    private javax.swing.JPanel pnlVendedores;
    private javax.swing.JTable tablacarrito;
    private javax.swing.JTable tblfact;
    private javax.swing.JTable tblpedido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txtapcltfact;
    private javax.swing.JTextField txtcambio;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtced;
    private javax.swing.JTextField txtcontactcltfact3;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtiduser;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtivafact;
    private javax.swing.JTextField txtnmclfact;
    private javax.swing.JTextField txtnombre_cliente;
    private javax.swing.JTextField txtnumpedido;
    private javax.swing.JTextField txtpaga;
    private javax.swing.JTextField txtpcliente;
    private javax.swing.JTextField txtpusuario;
    private javax.swing.JTextField txtsub;
    private javax.swing.JTextField txtsubfact;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttotalfact;
    // End of variables declaration//GEN-END:variables
}
