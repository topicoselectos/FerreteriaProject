/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import forms.Menu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author e09am
 */


public class Metodos {
        Conectar co = new Conectar();   
        Connection con = co.conexion();
        PreparedStatement ps = null;
        ResultSet rs;
         public static int filasel;
    
    public void BusquedaCodigo(String cod, String nom, DefaultTableModel model){
         
         try {
                
                String SQL = "SELECT idtb_producto, NOMBRE, Descripcion, stock, Precio FROM tb_producto WHERE idtb_producto=" + cod;
                
                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumna = rsMd.getColumnCount();
                do{
                if(rs.next()){
                    Object[] fila = new Object[cantidadColumna];
                    
                    for(int i = 0; i<cantidadColumna; i++){
                        fila[i] = rs.getObject(i+1);
                    }
                    model.addRow(fila);
                    nom =(""+fila[1]);
                }else{
                    JOptionPane.showMessageDialog(null, "Artículo no encontrado en nuestra base de datos", "¡Consulta Fallida!", JOptionPane.OK_OPTION);
                    nom = "";
                    cod = "";
                }
                }while(rs.next());  
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor inrgese el dato a buscar en la parte de arriba de la pestaña","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void BusquedaNombre(String nom, DefaultTableModel model)
    {
        
        try {
                String SQL = "SELECT idtb_producto, NOMBRE, Descripcion, stock, Precio FROM tb_producto WHERE Nombre LIKE '%" + nom+"%'";
                
                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();
                
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumna = rsMd.getColumnCount();
                
                
                while(rs.next()){
                    Object[] fila = new Object[cantidadColumna];
                    
                    for(int i = 0; i<cantidadColumna; i++){
                        fila[i] = rs.getObject(i+1);
                    }
                    model.addRow(fila);
                    nom=(""+fila[0]);
                }
                
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Artículo no encontrado","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
        
        
        
    }    
    
        public void num(JTextField a, String s){
        a.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e){
            char c = e.getKeyChar();
            if(!Character.isDigit(c)&& c!= '.'){
                e.consume();
            }
            if(c=='.'&& s.contains(".")){
                e.consume();
            }
        }
        
        });
        
    
    }
        
        
        
     
}
