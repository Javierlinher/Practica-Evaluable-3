package Interfaces_Graficas;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Ventana_Encargar {
    private JButton yesButton;
    private JButton noButton;
    private JButton cancelButton;
    private JPanel Ventana_Encargar;

    //Creación de la ventana.
    public Ventana_Encargar() {}

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
        return Ventana_Encargar;
    }

}
