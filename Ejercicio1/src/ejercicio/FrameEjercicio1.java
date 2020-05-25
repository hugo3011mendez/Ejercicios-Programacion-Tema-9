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

public class FrameEjercicio1 extends JFrame implements KeyListener {
    JButton btnClickIzquierdo, btnClickDerecho;
    JLabel lblTeclas;

    Color colorFondoBotones = Color.RED; // Declaro una variable para gestionar el color al que cambia el fondo de los botones

    public FrameEjercicio1() {
        super("Control de Ratón");
        setLayout(new FlowLayout());
        setFocusable(true);

        class MouseHandler extends MouseAdapter { // Uso el adaptador para no escribir funciones vacías

            int xFormulario = 0;
            int yFormulario = 0;        

            @Override
            public void mouseExited(MouseEvent e) {
                setTitle("Control de Ratón");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if(e.getSource() == btnClickIzquierdo && e.getSource() == btnClickDerecho){
                    setTitle(String.format("Control de ratón - (X:%d Y:%d)", e.getX() + xFormulario, e.getY() + yFormulario));
                }
                else{
                    setTitle(String.format("Control de ratón - (X:%d Y:%d)", e.getX(), e.getY()));
                    xFormulario = e.getX();
                    yFormulario = e.getY();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == 1) {
                    btnClickIzquierdo.setBackground(colorFondoBotones);
                } else if (e.getButton() == 3) {
                    btnClickDerecho.setBackground(colorFondoBotones);
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
        
        addKeyListener(this); // Añado el KeyListener

        btnClickIzquierdo = new JButton("Click Izquierdo");
        btnClickIzquierdo.setSize(btnClickIzquierdo.getPreferredSize());
        btnClickIzquierdo.addMouseMotionListener(mh); // También añado el MotionListener a los botones para que muestre las coordenadas aún cuando esté encima de ellos
        add(btnClickIzquierdo);

        btnClickDerecho = new JButton("Click Derecho");
        btnClickDerecho.setSize(btnClickDerecho.getPreferredSize());
        btnClickDerecho.addMouseMotionListener(mh);
        add(btnClickDerecho);

        lblTeclas = new JLabel("Teclas");
        lblTeclas.setSize(lblTeclas.getPreferredSize());
        add(lblTeclas);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        lblTeclas.setText("Tecla pulsada : " + e.getKeyCode());

        if (e.getKeyCode() == KeyEvent.VK_C && e.isControlDown()){
            VentanaDeControl panelDeControl = new VentanaDeControl(this); // Declaro el formulario del panel de configuración
            panelDeControl.pack();
            panelDeControl.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Y le digo que no haga nada al cerrarse para lanzar la confirmación
            panelDeControl.setVisible(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        lblTeclas.setText(lblTeclas.getText() + ", " + e.getKeyChar());
    }
}