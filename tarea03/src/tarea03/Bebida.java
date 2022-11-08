package tarea03;

import java.awt.*;
import javax.swing.*;

abstract class Bebida extends JLabel {

    abstract JLabel etiqueta();
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
}
//Clases para diferenciar los tipos de Bebiba que heredan las propiedades de la clase Bebida

class Sprite extends Bebida {

    JLabel sprite = new JLabel();

    public Sprite(int px, JPanel panel, int s) {
        super(s);
        ImageIcon imagen2 = new ImageIcon("Sprite.png");
        sprite.setBounds(212, px, 300, 300);
        sprite.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));
        panel.add(sprite);
    }

    @Override
    public String Beber() {
        return super.Beber() + "Sprite";
    }

    @Override
    JLabel etiqueta() {
        return sprite;
    }

}

class CocaCola extends Bebida {

    JLabel cocacola = new JLabel();

    public CocaCola(int px, JPanel panel, int c) {
        super(c);
        ImageIcon imagen1 = new ImageIcon("cocacola.png");
        cocacola.setBounds(152, px, 300, 300);
        cocacola.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));
        panel.add(cocacola);
    }

    @Override
    public String Beber() {
        return super.Beber() + "CocaCola";
    }

    @Override
    JLabel etiqueta() {
        return cocacola;
    }
}

class Fanta extends Bebida {

    JLabel fanta = new JLabel();

    public Fanta(int px,JPanel panel, int f) {
        super(f);

        ImageIcon imagen3 = new ImageIcon("fanta.png");
        fanta.setBounds(272, px, 300, 300);
        fanta.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));
        panel.add(fanta);
    }

    @Override
    public String Beber() {
        return super.Beber() + "Fanta";
    }

    @Override
    JLabel etiqueta() {
        return fanta;
    }
}
