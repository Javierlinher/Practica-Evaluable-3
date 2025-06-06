package Interfaces_Graficas;

import Base_De_Datos.GestorConsultas;
import Base_De_Datos.TablasBaseDeDatos;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

public class Ventana_Principal {
    private JFrame ventana;
    private JPanel PanelPrincipal;
    private JComboBox comboBoxModelo;
    private JComboBox comboBoxMotor;
    private JComboBox comboColor;
    private JComboBox comboBoxRuedas;
    private JComboBox comboBoxPiloto;
    private JButton HACERPEDIDOButton;
    private JButton VISUALIZARPEDIDOSButton;
    private JButton BAJAPEDIDOSELECCIONADOButton;
    private JList listaPedidos;

    private ArrayList<String> modelos;
    private ArrayList<String> motores;
    private ArrayList<String> colores;
    private ArrayList<String> ruedas;
    private ArrayList<String> pilotos;
    private static DefaultListModel modelo = new DefaultListModel();

    //Creacion de la ventana.
    public Ventana_Principal() {
        ventana = new JFrame("Encarga tu coche");
        ventana.setContentPane(PanelPrincipal);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);

        cargarComboBoxes();

    }

    //Metodo para cargar las combo boxes.
    private void cargarComboBoxes(){
        modelos = GestorConsultas.ObtenerOpciones(TablasBaseDeDatos.opcionesmodelo);
        motores = GestorConsultas.ObtenerOpciones(TablasBaseDeDatos.opcionesmotor);
        colores = GestorConsultas.ObtenerOpciones(TablasBaseDeDatos.opcionescolor);
        ruedas = GestorConsultas.ObtenerOpciones(TablasBaseDeDatos.opcionesruedas);
        pilotos = GestorConsultas.ObtenerOpciones(TablasBaseDeDatos.opcionespilotoautomatico);

        for (String modelo : modelos) {
            comboBoxModelo.addItem(modelo);
        }
        for (String motor : motores) {
            comboBoxMotor.addItem(motor);
        }
        for (String color : colores) {
            comboColor.addItem(color);
        }
        for (String rueda : ruedas) {
            int r = Integer.parseInt(rueda);
            comboBoxRuedas.addItem(r);
        }
        for (String piloto : pilotos) {
            int p = Integer.parseInt(piloto);
            if(p==1){
                comboBoxPiloto.addItem("true");
            }else{
                comboBoxPiloto.addItem("false");
            }
        }
    }

    //Metodo para mostrar los pedidos en el JList.
    public void mostrarPedidos(){
        DefaultListModel modeloVacio = new DefaultListModel();
        modelo = modeloVacio;

        ArrayList<String> pedidos = GestorConsultas.ObtenerPedidosLegibles();

        for (String pedido : pedidos) {
            modelo.addElement(pedido);
        }
        listaPedidos.setModel(modelo);

        if (modelo.isEmpty()) {
            BAJAPEDIDOSELECCIONADOButton.setEnabled(false);
            modelo.addElement("No hay pedidos");
        }else{
            BAJAPEDIDOSELECCIONADOButton.setEnabled(true);
        }
    }

    //Getters.
    public JList getListaPedidos() {
        return listaPedidos;
    }
    public JButton getHacerPedidoButton() {
        return HACERPEDIDOButton;
    }

    public JButton getVisualizarPedidosButton() {
        return VISUALIZARPEDIDOSButton;
    }

    public JButton getBajaPedidoSeleccionadoButton() {
        return BAJAPEDIDOSELECCIONADOButton;
    }

    public String getModeloSeleccionado() {
        return (String) comboBoxModelo.getSelectedItem();
    }

    public String getMotorSeleccionado() {
        return (String) comboBoxMotor.getSelectedItem();
    }

    public String getColorSeleccionado() {
        return (String) comboColor.getSelectedItem();
    }

    public int getRuedasSeleccionadas() {
        return (int) comboBoxRuedas.getSelectedItem();
    }

    public int getPilotoSeleccionado() {
        String value = (String) comboBoxPiloto.getSelectedItem();
        return value.equals("true") ? 1 : 0;
    }

}
