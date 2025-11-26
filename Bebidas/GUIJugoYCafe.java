package Bebidas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class GUIJugoYCafe extends JFrame{

    // << Atributos >>
    private JLabel imagenLabel,ventasCafeLabel, ventasJugoLabel;
    private JButton botonCafe,botonJugo;
    private int contCafe,contJugo;
    private String strImage;
    private Container container = getContentPane();
    private Panel buttonPanel = new Panel(),imagePanel = new Panel(), ventasPanel = new Panel();

    // << Constructor >>
    public GUIJugoYCafe(){
        setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        setSize(new Dimension(480, 800));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contCafe = 0;contJugo = 0; strImage = "";

        hacerGUI();
    }

    private void hacerGUI(){

        // Establezco los valores predeterminados de imagenLabel+
        imagenLabel = new JLabel("");
        imagenLabel.setIcon(new ImageIcon(""+strImage));
        imagenLabel.setVerticalTextPosition(JLabel.TOP);
        imagenLabel.setHorizontalTextPosition(JLabel.CENTER);
        imagenLabel.setVerticalAlignment(JLabel.TOP);
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);
        imagePanel.add(imagenLabel);
        imagenLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 10, 0));
        imagenLabel.setBackground(Color.GRAY);

        // Implementación del Panel Central (Contará las ventas)
        ventasCafeLabel = new JLabel();
        ventasJugoLabel = new JLabel();
        ventasPanel.setLayout(new GridLayout(0,1));
        ventasPanel.add(ventasCafeLabel);
        ventasPanel.add(ventasJugoLabel);
        ventasPanel.setBackground(Color.WHITE);

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
        container.setBackground(Color.GRAY);
        container.add(imagenLabel);
        container.add(ventasPanel);
        container.add(buttonPanel);

    }

    private class ListenerCafe implements ActionListener {
        public void actionPerformed(ActionEvent e){
            contCafe++;
            if(!strImage.equals("Bebidas/Cafe.gif")){
                strImage = "Bebidas/Cafe.gif";
            }
            imagenLabel.setIcon(new ImageIcon(""+strImage));
            imagenLabel.setText("Cafe");
            ventasCafeLabel.setText("Cantidad de Cafes vendidos: "+contCafe);
            if(contCafe >= 10){
                botonCafe.setEnabled(false);
            }
        }
    }
    private class ListenerJugo implements ActionListener {
        public void actionPerformed(ActionEvent e){
            contJugo++;
            if(!strImage.equals("Bebidas/Jugo.gif")){
                strImage = "Bebidas/Jugo.gif";
            }
            imagenLabel.setIcon(new ImageIcon(""+strImage));
            imagenLabel.setText("Jugo");
            ventasJugoLabel.setText("Cantidad de Jugos vendidos: "+contJugo);
            if(contJugo >= 10){
                botonJugo.setEnabled(false);
            }
        }
    }
}