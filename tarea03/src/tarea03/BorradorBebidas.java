package tarea03;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

public class BorradorBebidas extends JLabel implements MouseListener, MouseMotionListener {

    JLabel objetivo;
    int serial;
    private int X, Y;

    public BorradorBebidas(JLabel a, int serie, int y) {
        X = 0;
        this.Y = y;
        this.objetivo = a;
        this.serial = serie;
        a.addMouseListener(this);
        a.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(Y<320){
            objetivo.setVisible(false);
            objetivo.setLocation(780 + Y, 50);
            objetivo.setVisible(true);
            System.out.println("""
                               Bebida retirada
                               Serie Bebida: """ + serial);      
            }else{
                objetivo.setVisible(false);
                System.out.println("Inventario Lleno,te tomas le bebida"); 
            }
    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
