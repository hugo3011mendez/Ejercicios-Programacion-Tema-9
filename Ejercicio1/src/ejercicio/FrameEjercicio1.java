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
    JButton btn1, btn2;
    JLabel lblTeclas;

    public FrameEjercicio1() {
        super("Control de Ratón");
        setLayout(null);

        class MouseHandler extends MouseAdapter { // También uso el adaptador para no escribir funciones vacías

            @Override
            public void mouseExited(MouseEvent e) {
                setTitle("Control de Ratón");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                setTitle(String.format("Posición X:%d Y:%d ", e.getX(), e.getY()));
            }
        }

        MouseHandler mh = new MouseHandler();

        lblTeclas = new JLabel("Teclas");
        lblTeclas.setSize(lblTeclas.getPreferredSize());
        add(lblTeclas);

        addMouseListener(mh);
        addMouseMotionListener(mh);

    }
}