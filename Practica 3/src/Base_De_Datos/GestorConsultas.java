package Base_De_Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Clase para gestionar las distintas consultas a la base de datos.
public class GestorConsultas {

    //Metodo para obtener una lista de todas las opciones de una tabla.
    public static ArrayList<String> ObtenerOpciones(TablasBaseDeDatos tabla){
        ArrayList<String> opciones = new ArrayList<>();
        String consulta = "SELECT * FROM " + tabla;

        try(Connection con = ConexionBD.getConexion()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next()){
                opciones.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de la tabla: " + tabla + ". - " + e.getMessage());
        }
        return opciones;
    }

    //Metodo para insertar un pedido.
    public static void InsertarPedido(String modelo, String motor, String color, int ruedas, int pilotoAutomatico){
        String consulta = "INSERT INTO pedidos(modelo,motor,color,ruedas,pilotoAutomatico) " +
                          "VALUES('" + modelo + "','" + motor + "','" + color + "'," + ruedas + "," + pilotoAutomatico + ")";

        try(Connection con = ConexionBD.getConexion()){
            Statement st = con.createStatement();
            int i = st.executeUpdate(consulta);

        } catch (SQLException e) {
            System.out.println("Error al insertar los datos en la tabla pedidos: " + e.getMessage());
        }
    }

    //Metodo para borrar un pedido desde su id.
    public static void BorrarPedido(int id){
        String consulta = "DELETE FROM pedidos WHERE id = " + id;

        try(Connection con = ConexionBD.getConexion()){
            Statement st = con.createStatement();
            int i = st.executeUpdate(consulta);

        } catch (SQLException e) {
            System.out.println("Error al borrar los datos de la tabla pedidos: " + e.getMessage());
        }
    }

    //Metodo para obtener los pedidos de manera legible para el JList.
    public static ArrayList<String> ObtenerPedidosLegibles() {
        ArrayList<String> pedidos = new ArrayList<>();
        String consulta = "SELECT * FROM pedidos";

        try (Connection con = ConexionBD.getConexion()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                int id = rs.getInt(1);
                String modelo = rs.getString(2);
                String motor = rs.getString(3);
                String color = rs.getString(4);
                int ruedas = rs.getInt(5);
                int piloto = rs.getInt(6);
                String piloto2;
                if(piloto == 1){
                    piloto2 = "True";
                }else{
                    piloto2 = "False";
                }

                String pedido = id + " " + modelo + " " + motor + " " + color + " " + ruedas + " " + piloto2;
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener pedidos: " + e.getMessage());
        }

        return pedidos;
    }
}
