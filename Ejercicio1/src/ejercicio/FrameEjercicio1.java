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

public class FrameEjercicio1 extends JFrame {
    JButton btnClickIzquierdo, btnClickDerecho;
    JLabel lblTeclas;

    public FrameEjercicio1() {
        super("Control de Ratón");
        setLayout(new FlowLayout());

        class MouseHandler extends MouseAdapter { // Uso el adaptador para no escribir funciones vacías

            @Override
            public void mouseExited(MouseEvent e) {
                setTitle("Control de Ratón");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                setTitle(String.format("Control de ratón - (X:%d Y:%d)", e.getX(), e.getY()));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == 1){
                    btnClickIzquierdo.setBackground(Color.RED);
                }
                else if(e.getButton() == 3){
                    btnClickDerecho.setBackground(Color.RED);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                btnClickIzquierdo.setBackground(null);
                btnClickDerecho.setBackground(null);
            }
        }

        MouseHandler mh = new MouseHandler(); // Creo el MouseHandler
        // Añado los listeners al formulario
        addMouseListener(mh);
        addMouseMotionListener(mh);


        btnClickIzquierdo = new JButton("Click Izquierdo");
        btnClickIzquierdo.setSize(btnClickIzquierdo.getPreferredSize());
        add(btnClickIzquierdo);

        btnClickDerecho = new JButton("Click Derecho");
        btnClickDerecho.setSize(btnClickDerecho.getPreferredSize());
        add(btnClickDerecho);

        
        lblTeclas = new JLabel("Teclas");
        lblTeclas.setSize(lblTeclas.getPreferredSize());
        add(lblTeclas);



    }
}