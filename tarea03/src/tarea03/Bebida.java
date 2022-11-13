package tarea03;

import java.awt.*;
import javax.swing.*;

abstract class Bebida extends JLabel {

    public abstract JLabel etiqueta();
    private int num;

    public Bebida(int serie) {
        this.num = serie;
    }
    //getter Serie de bebida

    public int getSerie() {
        return num;
    }

    public String Beber() {
        return "Bebiendo: ";
    }

    abstract void mover();

}
//Clases para diferenciar los tipos de Bebiba que heredan las propiedades de la clase Bebida. Aqui 
//definimos su posición en el panel y demas características de las bebidas en el expendedor.

class Sprite extends Bebida {

    JLabel sprite = new JLabel();

    public Sprite(int px, JPanel panel, int s) {
        super(s);
        ImageIcon imagen2 = new ImageIcon("C:/Users/Gaspi/Desktop/Udec/Tarea03FINAL/Tarea3/tarea03/Sprite.png");
        sprite.setBounds(212, px, 55, 55);
        sprite.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));
        panel.add(sprite);
        panel.setComponentZOrder(sprite, 0);
    }

    @Override
    public String Beber() {
        return super.Beber() + "Sprite";
    }

    @Override
    public JLabel etiqueta() {
        return sprite;
    }

    @Override
    public void mover() {
        sprite.setLocation(207, 540);
    }

}

class CocaCola extends Bebida {

    JLabel cocacola = new JLabel();

    public CocaCola(int px, JPanel panel, int c) {
        super(c);
        ImageIcon imagen1 = new ImageIcon("C:/Users/Gaspi/Desktop/Udec/Tarea03FINAL/Tarea3/tarea03/cocacola.png");
        cocacola.setBounds(142, px, 55, 55);
        cocacola.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));
        panel.add(cocacola);
        panel.setComponentZOrder(cocacola, 0);
    }

    @Override
    public String Beber() {
        return super.Beber() + "CocaCola";
    }

    @Override
    public JLabel etiqueta() {
        return cocacola;
    }

    @Override
    public void mover() {
        cocacola.setLocation(207, 540);//207
    }
}

class Fanta extends Bebida {

    JLabel fanta = new JLabel();

    public Fanta(int px, JPanel panel, int f) {
        super(f);
        ImageIcon imagen3 = new ImageIcon("C:/Users/Gaspi/Desktop/Udec/Tarea03FINAL/Tarea3/tarea03/fanta.png");
        fanta.setBounds(282, px, 55, 55);
        fanta.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));
        panel.add(fanta);
        panel.setComponentZOrder(fanta, 0);
    }

    @Override
    public String Beber() {
        return super.Beber() + "Fanta";
    }

    @Override
    public JLabel etiqueta() {
        return fanta;
    }

    @Override
    public void mover() {
        fanta.setLocation(207, 540);
    }
}
