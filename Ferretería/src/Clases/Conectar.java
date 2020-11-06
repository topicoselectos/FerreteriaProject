/*Mae con este codigo nos vamos a conectar a la base de datos de mysql
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author e09am
 */
public class Conectar {
    
     Connection conectar = null;
     
     public Connection conexion() {
         try {
             Class.forName("com.mysql.jdbc.Driver");
             conectar = DriverManager.getConnection("jdbc:mysql://localhost:3305/ferreteriadb", "root", "Jimenez023.");
         } catch (Exception e) {
             System.out.println(e.getMessage()); 
         }
         
         return conectar;
     }
    
    
    
}
