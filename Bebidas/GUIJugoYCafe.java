package Bebidas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class GUIJugoYCafe extends JFrame{

    // << Atributos >>
    private JLabel imagenLabel;
    private JButton botonCafe,botonJugo;
    private int contCafe,contJugo;
    private String strImage;
    private Container container = getContentPane();
    private Panel buttonPanel = new Panel(),imagePanel = new Panel();

    // << Constructor >>
    public GUIJugoYCafe(){
        setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        setSize(new Dimension(640, 480));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contCafe = 0;contJugo = 0; strImage = "Bebidas/Cafe.gif";

        hacerGUI();
    }

    private void hacerGUI(){

        // Establezco los valores predeterminados de imagenLabel+
        imagenLabel = new JLabel("Cafe: "+contCafe);
        imagenLabel.setIcon(new ImageIcon(""+strImage));
        imagenLabel.setVerticalTextPosition(JLabel.TOP);
        imagenLabel.setHorizontalTextPosition(JLabel.CENTER);
        imagenLabel.setVerticalAlignment(JLabel.TOP);
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);
        imagenLabel.setSize(new Dimension(40, 60));
        imagePanel.add(imagenLabel);

        // Implementacion de Botones
        botonCafe = new JButton("Cafe");
        botonCafe.setHorizontalAlignment(JLabel.CENTER);
        ListenerCafe oyenteCafe = new ListenerCafe();
        botonCafe.addActionListener(oyenteCafe);

        botonJugo = new JButton("Jugo");
        botonJugo.setHorizontalAlignment(JLabel.CENTER);
        ListenerJugo oyenteJugo = new ListenerJugo();
        botonJugo.addActionListener(oyenteJugo);

        // Añadimos los botones al panel de botones
        buttonPanel.add(botonCafe);
        buttonPanel.add(botonJugo);

        // Añadimos nuestros componentes a la pantalla
        container.add(imagenLabel);
        container.add(buttonPanel);

    }

    private class ListenerCafe implements ActionListener {
        public void actionPerformed(ActionEvent e){
            contCafe++;
            if(strImage.equals("Bebidas/Jugo.gif")){
                strImage = "Bebidas/Cafe.gif";
            }
            imagenLabel.setIcon(new ImageIcon(""+strImage));
            imagenLabel.setText("Cafe: "+contCafe);
        }
    }
    private class ListenerJugo implements ActionListener {
        public void actionPerformed(ActionEvent e){
            contJugo++;
            if(strImage.equals("Bebidas/Cafe.gif")){
                strImage = "Bebidas/Jugo.gif";
            }
            imagenLabel.setIcon(new ImageIcon(""+strImage));
            imagenLabel.setText("Jugo: "+contJugo);
        }
    }
}