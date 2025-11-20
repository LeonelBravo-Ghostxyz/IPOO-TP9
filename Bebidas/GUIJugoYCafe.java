package Bebidas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIJugoYCafe extends JFrame {

    // << Atributos >>
    private int contJugo, contCafe;
    private JLabel etiquetaContadorJugo, etiquetaContadorCafe, etiquetaImagen;
    private JButton botonJugo, botonCafe;
    private String rutaImagen;
    private Container container = getContentPane();

    public GUIJugoYCafe() {
        // 3 filas, 3 columnas
        setLayout(new GridLayout(3, 3)); 
        setSize(800, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        contJugo = 0;
        contCafe = 0;
        rutaImagen = "Bebidas/Jugo.gif"; 
        
        hacerGUI();
    }

    private void hacerGUI() {
        // 1. Inicializamos los componentes
        etiquetaContadorJugo = new JLabel("Jugo: " + contJugo, SwingConstants.CENTER);
        etiquetaContadorCafe = new JLabel("Cafe: " + contCafe, SwingConstants.CENTER);
        
        etiquetaImagen = new JLabel();
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);

        etiquetaImagen.setIcon(new ImageIcon(rutaImagen));

        botonJugo = new JButton("Jugo");
        botonJugo.addActionListener(new ListenerJugo());

        botonCafe = new JButton("Cafe");
        botonCafe.addActionListener(new ListenerCafe());

        // << INSERTAR EN EL ORDEN DEL GRID (De Izquierda a Derecha) >>

        // --- FILA 1 ---
        container.add(etiquetaContadorJugo);      // Pos 1 (0,0)
        container.add(new JLabel(""));            // Pos 2 (0,1) - VACÍO
        container.add(etiquetaContadorCafe);      // Pos 3 (0,2)

        // --- FILA 2 ---
        container.add(new JLabel(""));            // Pos 4 (1,0) - VACÍO
        container.add(etiquetaImagen);            // Pos 5 (1,1) - CENTRO
        container.add(new JLabel(""));            // Pos 6 (1,2) - VACÍO

        // --- FILA 3 ---
        container.add(botonJugo);                 // Pos 7 (2,0)
        container.add(new JLabel(""));            // Pos 8 (2,1) - VACÍO
        container.add(botonCafe);                 // Pos 9 (2,2)
    }

    private class ListenerJugo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!rutaImagen.equals("Bebidas/Jugo.gif")) {
                rutaImagen = "Bebidas/Jugo.gif";
                etiquetaImagen.setIcon(new ImageIcon(rutaImagen));
            }
            contJugo++;
            etiquetaContadorJugo.setText("Jugo: " + contJugo);
        }
    }

    private class ListenerCafe implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!rutaImagen.equals("Bebidas/Cafe.gif")) {
                rutaImagen = "Bebidas/Cafe.gif";
                etiquetaImagen.setIcon(new ImageIcon(rutaImagen));
            }
            contCafe++;
            etiquetaContadorCafe.setText("Cafe: " + contCafe);
        }
    }
}