/*Mae con este codigo nos vamos a conectar a la base de datos de mysql
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author e09am
 */
public class Conectar {
    Connection conectar = null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/ferreteriadb"+
                    "?userTimezone=true&serverTimezone=UTC", "root", "Jimenez023.");  
            System.out.println("Conexión exitosa.....");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de tipo: "+ e);
            
        }
        return conectar;
    }
    
    public void Desconectar(){
        conectar=null;
        if(conectar==null){
            System.out.println("El servicio se encuentra desconectado");
        }
    }
    
    public static void main(String[] args) {
        
        Conectar con;
        con = new Conectar();
        con.conexion();
    }
}


