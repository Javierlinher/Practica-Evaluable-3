package Interfaces_Graficas;

import Base_De_Datos.GestorConsultas;

import javax.swing.*;


public class Ventana_Borrar {
    private JButton yesButton;
    private JButton noButton;
    private JButton cancelButton;
    private JPanel Ventana_Borrar;
    private JLabel textoBorrar;

    //Creacion de la ventana.
    public Ventana_Borrar() {}

    //Metodo para controlar lo que pone el texto.
    public void textoBorrarPedido(int numPedido){
        textoBorrar.setText("¿Desea borrar el pedido con número "+ numPedido +"?");
    }

    //Metodo para borrar el pedido según el id.
    public void BorrarPedido(int numPedido){
        GestorConsultas.BorrarPedido(numPedido);
    }

    //Metodo para por si no has seleccionado un pedido
    public void NoHayPedido(){
        yesButton.setVisible(false);
        noButton.setVisible(false);
        textoBorrar.setText("No has seleccionado un pedido.");
    }

    //Getters.
    public JButton getYesButton() {
        return yesButton;
    }
    public JButton getNoButton() {
        return noButton;
    }
    public JButton getCancelButton() {
        return cancelButton;
    }
    public JPanel getPanel() {
        return Ventana_Borrar;
    }
}
