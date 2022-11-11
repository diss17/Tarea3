package tarea03;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
public class Reposicion  extends JLabel implements MouseListener, MouseMotionListener {

    JLabel objetivo;
    int serial;
    private int X, Y;

    public Reposicion(JLabel a) {
        this.objetivo = a;
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
        objetivo.setVisible(false);
        objetivo.setBounds(780+40, 50, 55, 55); 
        objetivo.setVisible(true);                                                          
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

