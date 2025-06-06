/*
Linares, Herrero, Javier
*/

import Base_De_Datos.GestorConsultas;
import Interfaces_Graficas.Ventana_Borrar;
import Interfaces_Graficas.Ventana_Encargar;
import Interfaces_Graficas.Ventana_Principal;

import javax.swing.*;
import java.awt.event.ActionListener;

//Clase principal de la aplicación.
public class AplicacionConcesionario {

    public static void main(String[] args) {

        //Se crea la ventana principal.
        Ventana_Principal ventanaPrincipal = new Ventana_Principal();

        //Dar al boton de hacer pedidos.
        ventanaPrincipal.getHacerPedidoButton().addActionListener(e -> {
            Ventana_Encargar ventanaEncargar = new Ventana_Encargar();
            JFrame frameEncargar = new JFrame("Confirmar Pedido");
            frameEncargar.setContentPane(ventanaEncargar.getPanel());
            frameEncargar.pack();
            frameEncargar.setVisible(true);
            frameEncargar.setLocationRelativeTo(null);

            //Se da a yes.
            ventanaEncargar.getYesButton().addActionListener(ev -> {

                String modelo = ventanaPrincipal.getModeloSeleccionado();
                String motor = ventanaPrincipal.getMotorSeleccionado();
                String color = ventanaPrincipal.getColorSeleccionado();
                int ruedas = ventanaPrincipal.getRuedasSeleccionadas();
                int piloto = ventanaPrincipal.getPilotoSeleccionado();

                GestorConsultas.InsertarPedido(modelo, motor, color, ruedas, piloto);
                frameEncargar.dispose();

            });

            //Se da a no o a cancel.
            ActionListener cerrarSinGuardar = ev -> frameEncargar.dispose();
            ventanaEncargar.getNoButton().addActionListener(cerrarSinGuardar);
            ventanaEncargar.getCancelButton().addActionListener(cerrarSinGuardar);
        });

        //Se da al boton de visualizar pedidos
        ventanaPrincipal.getVisualizarPedidosButton().addActionListener(e -> {
            ventanaPrincipal.mostrarPedidos();
        });

        //Se da al boton de dar de baja un pedido.
        ventanaPrincipal.getBajaPedidoSeleccionadoButton().addActionListener(e -> {

            Ventana_Borrar ventanaBorrar = new Ventana_Borrar();
            JFrame frameBorrar = new JFrame("Borrar Pedido");
            frameBorrar.setContentPane(ventanaBorrar.getPanel());
            frameBorrar.pack();
            frameBorrar.setVisible(true);
            frameBorrar.setLocationRelativeTo(null);

            //Saco el pedido seleccionado y su id
            String pedidoParaBorrar = (String) ventanaPrincipal.getListaPedidos().getSelectedValue();
            //Si no has seleccionado pedido
            if (pedidoParaBorrar == null || pedidoParaBorrar.trim().isEmpty()) {
                ventanaBorrar.NoHayPedido();
                //Cancel para salir
                ActionListener cerrarSinGuardar = ev -> frameBorrar.dispose();
                ventanaBorrar.getCancelButton().addActionListener(cerrarSinGuardar);
            } else {
                //Si hay un pedido seleccionado
                try {
                    int numPedidoBorrar = Integer.parseInt(pedidoParaBorrar.split(" ")[0]);
                    ventanaBorrar.textoBorrarPedido(numPedidoBorrar);

                    //Se da a yes
                    ventanaBorrar.getYesButton().addActionListener(ev -> {

                        ventanaBorrar.BorrarPedido(numPedidoBorrar);
                        frameBorrar.dispose();
                    });

                    //Se da a no o cancel
                    ActionListener cerrarSinGuardar = ev -> frameBorrar.dispose();
                    ventanaBorrar.getNoButton().addActionListener(cerrarSinGuardar);
                    ventanaBorrar.getCancelButton().addActionListener(cerrarSinGuardar);

                } catch (NumberFormatException ex) {
                    //Por si lo que hubiera no fuera un pedido que empieza por un int
                    ventanaBorrar.NoHayPedido();
                }
            }
        });
    }
}
