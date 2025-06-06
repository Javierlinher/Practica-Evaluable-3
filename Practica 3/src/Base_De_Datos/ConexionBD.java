package Base_De_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Clase para establecer la conexion con la base de datos.
public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/finalcoches";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "root";

    //Metodo para establecer la conexion.
    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }
}
