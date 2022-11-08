package tarea03;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {

    Expendedor exp;
    public JPanel panel;

    public Window() {
        setSize(900, 700);//Establece tamanho de la ventana
        setTitle("Expendedor de Bebidas 3000");
        setLocationRelativeTo(null);//Establece posicion de la ventana
        IniciarVentana();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void IniciarVentana() {
        Paneles();
    }

    private void Paneles() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        Buttons();
        Etiquetas();
    }

    private void Etiquetas() {
        exp = new Expendedor(6, 500, panel);
        JLabel expendedor = new JLabel();
        //A la imagén importada le damos la dirección por problemas técnicos.
        ImageIcon exp = new ImageIcon("C:/Users/franc/OneDrive/Escritorio/Tarea3REAL/Tarea3/tarea03/src/exp5.png");
        expendedor.setBounds(-10, -20, 800, 700);
        expendedor.setIcon(new ImageIcon(exp.getImage().getScaledInstance(800, 700, Image.SCALE_SMOOTH)));
        panel.add(expendedor);
    }

    private void Buttons() {
        JButton boton1 = new JButton();
        JButton boton2 = new JButton();
        JButton boton3 = new JButton();

        boton1.setText("COKE");
        ImageIcon foto1 = new ImageIcon("C:/Users/franc/OneDrive/Escritorio/Tarea3REAL/Tarea3/tarea03/src/cokeboton2.jpg");
        boton1.setBounds(370, 102, 81, 35);
        boton1.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(boton1.getWidth()+12, boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton1.setEnabled(true);
        panel.add(boton1);

        boton2.setText("SPRITE");
        ImageIcon foto2 = new ImageIcon("C:/Users/franc/OneDrive/Escritorio/Tarea3REAL/Tarea3/tarea03/src/spriteboton.png");
        boton2.setBounds(370,207, 81, 35);
        boton2.setIcon(new ImageIcon(foto2.getImage().getScaledInstance(boton2.getWidth()+12, boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setEnabled(true);
        panel.add(boton2);

        boton3.setText("FANTA");
        ImageIcon foto3 = new ImageIcon("C:/Users/franc/OneDrive/Escritorio/Tarea3REAL/Tarea3/tarea03/src/fantaboton.jpg");
        boton3.setBounds(370, 154, 81, 35);
        boton3.setIcon(new ImageIcon(foto3.getImage().getScaledInstance(boton3.getWidth()+12, boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setEnabled(true);
        panel.add(boton3);
    }
}
