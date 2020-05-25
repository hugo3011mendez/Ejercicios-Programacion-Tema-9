package ejercicio;

import java.util.Scanner;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.filechooser.*;

import jdk.internal.org.objectweb.asm.tree.analysis.Frame;

public class VentanaDeControl extends JDialog implements ActionListener, ItemListener {
    JTextField txtNuevoTitulo;
    JLabel lblNuevoTitulo;
    JButton btnCambiarTitulo;
    JComboBox cbColores;

    public VentanaDeControl(FrameEjercicio1 panelDeControl) {
        super(panelDeControl, true); // Es un formulario de diálogo, que indica que hasta que es cerrado no se puede hacer nada con el formulario principal
        setLayout(new FlowLayout());
        setTitle("Configuración");

        lblNuevoTitulo = new JLabel("Escribe el nuevo título de la ventana principal : ");
        lblNuevoTitulo.setSize(lblNuevoTitulo.getPreferredSize());
        add(lblNuevoTitulo);

        txtNuevoTitulo = new JTextField(20);
        add(txtNuevoTitulo);

        btnCambiarTitulo = new JButton("Cambiar título");
        btnCambiarTitulo.setSize(btnCambiarTitulo.getPreferredSize());
        btnCambiarTitulo.addActionListener(this);
        add(btnCambiarTitulo);

        String[] colores = { "Rojo", "Amarillo", "Verde", "Cyan" }; // Creo un array de colores para meterlos en el ComboBox
        cbColores = new JComboBox<String>(colores);
        cbColores.addItemListener(this);
        add(cbColores);

        addWindowListener(new WindowAdapter() { // Aquí programo la confirmación al salir de esta ventana usando el adaptador de WindowListener
            public void windowClosing(WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Deseas cerrar el programa?", "Configuración",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (res == JOptionPane.OK_OPTION) {
                    e.getWindow().dispose();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FrameEjercicio1 panelDeControl = (FrameEjercicio1)this.getOwner(); // Declaro el formulario principal del ejercicio para poder trabajar con él
        panelDeControl.setTitle(txtNuevoTitulo.getText());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        FrameEjercicio1 panelDeControl = (FrameEjercicio1)this.getOwner(); // Declaro el formulario principal del ejercicio para poder trabajar con él

        if(cbColores.getSelectedItem() == "Rojo"){
            panelDeControl.colorFondoBotones = Color.RED;
        }
        else if(cbColores.getSelectedItem() == "Amarillo"){
            panelDeControl.colorFondoBotones = Color.YELLOW;
        }
        else if(cbColores.getSelectedItem() == "Verde"){
            panelDeControl.colorFondoBotones = Color.GREEN; 
        }
        else if(cbColores.getSelectedItem() == "Cyan"){
            panelDeControl.colorFondoBotones = Color.CYAN; 
        }
    }
}