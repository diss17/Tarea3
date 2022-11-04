package tarea03;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        this.setLayout(new BorderLayout());
        this.setSize(600, 600);//Establece tamanho de la ventana
        this.setTitle("Expendedor de Bebidas 3000");
        this.setLocationRelativeTo(null);//Establece posicion de la ventana

        //Paneles dentro de la ventana
        this.add(new JButton("sur"), BorderLayout.SOUTH);
        this.add(new JButton("centro"), BorderLayout.CENTER);
        this.add(new JButton("norte"), BorderLayout.NORTH);
        this.add(new JButton("este"), BorderLayout.EAST);
        this.add(new JButton("oeste"), BorderLayout.WEST);

        //Visibilidad y cierre de la ventana
        setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
