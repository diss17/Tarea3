package tarea03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {

    public JPanel panel;
    Expendedor exp_principal;
    Comprador cliente_principal;
    JLabel Bebida_selected;
    JLabel moneda_selected;
    JLabel expendedor;
    Label Cambio;
    JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton10;
    Moneda moneda_seleccionada;
    BorradorBebidas r;
    Bebida x;
    Deposito Sprite = new Deposito();
    private int opcion;

    public Window() {
        moneda_seleccionada = null;
        setSize(1200, 700);//Establece tamaño de la ventana
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
        Bebida_selected = new JLabel();
        moneda_selected = new JLabel();
        expendedor = new JLabel();
        exp_principal = new Expendedor(6, 800, panel);
        cliente_principal = new Comprador(moneda_seleccionada, opcion, exp_principal);
        ImageIcon exp = new ImageIcon("expFinal.png");
        expendedor.setBounds(-10, -20, 1200, 700);
        expendedor.setIcon(new ImageIcon(exp.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));
        panel.add(expendedor);

        Bebida_selected.setBounds(480, 10, 240, 30);
        Bebida_selected.setOpaque(true);
        Bebida_selected.setBackground(null);
        Bebida_selected.setText(" BEBIDA SELECCIONADA:");
        panel.add(Bebida_selected);

        moneda_selected.setBounds(480, 40, 240, 30);
        moneda_selected.setOpaque(true);
        moneda_selected.setBackground(null);
        moneda_selected.setText(" MONEDA SELECCIONADA:");
        panel.add(moneda_selected);

    }

    private void Buttons() {

        boton1 = new JButton();
        boton1.addActionListener(this);
        boton2 = new JButton();
        boton2.addActionListener(this);
        boton3 = new JButton();
        boton3.addActionListener(this);
        boton4 = new JButton();
        boton4.addActionListener(this);
        boton5 = new JButton();
        boton5.addActionListener(this);
        boton6 = new JButton();
        boton6.addActionListener(this);
        boton7 = new JButton();
        boton7.addActionListener(this);
        boton8 = new JButton();
        boton8.addActionListener(this);
        boton9 = new JButton();
        boton9.addActionListener(this);
        boton10 = new JButton();
        boton10.addActionListener(this);

        //Botones de logo de selección de Bebidas.
        boton1.setText("COKE");
        ImageIcon foto1 = new ImageIcon("cokeboton2.jpg");
        boton1.setBounds(360, 101, 75, 35);
        boton1.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(boton1.getWidth() + 12, boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton1.setEnabled(true);

        boton2.setText("SPRITE");
        ImageIcon foto2 = new ImageIcon("spriteboton2.jpg");
        boton2.setBounds(360, 206, 75, 35);
        boton2.setIcon(new ImageIcon(foto2.getImage().getScaledInstance(boton2.getWidth() + 12, boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setEnabled(true);

        boton3.setText("FANTA");
        ImageIcon foto3 = new ImageIcon("fantaboton.jpg");
        boton3.setBounds(360, 153, 75, 35);
        boton3.setIcon(new ImageIcon(foto3.getImage().getScaledInstance(boton3.getWidth() + 12, boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setEnabled(true);

        //Boton Pagar.
        boton4.setText("PAGAR");
        boton4.setBounds(415, 400, 15, 45);
        boton4.setOpaque(false);
        boton4.setContentAreaFilled(false);
        boton4.setBorderPainted(true);
        boton4.setEnabled(true);

        //Boton que entrega el vuelto al hacer click.
        ImageIcon botonVuelto=new ImageIcon("boton_vuelto.png");
        boton5.setIcon(new ImageIcon(botonVuelto.getImage().getScaledInstance(51, 38, Image.SCALE_SMOOTH)));
        boton5.setBounds(398, 480, 39, 36);  
        boton5.setEnabled(true);

        //Botones de las monedas que dan a indicar el valor con el que se paga la bebida.
        //MONEDA 100
        boton6.setText("");
        ImageIcon monedaA = new ImageIcon("100.png");
        boton6.setBounds(490, 100, 55, 55);
        boton6.setOpaque(false);
        boton6.setContentAreaFilled(false);
        boton6.setBorderPainted(false);
        boton6.setIcon(new ImageIcon(monedaA.getImage().getScaledInstance(boton6.getWidth() - 15, boton6.getHeight() - 15, Image.SCALE_SMOOTH)));
        boton6.setEnabled(true);
        
        //MONEDA 500
        boton7.setText("");
        ImageIcon monedaB = new ImageIcon("500.png");
        boton7.setBounds(490, 150, 55, 55);
        boton7.setOpaque(false);
        boton7.setContentAreaFilled(false);
        boton7.setBorderPainted(false);
        boton7.setIcon(new ImageIcon(monedaB.getImage().getScaledInstance(boton7.getWidth() - 15, boton7.getHeight() - 15, Image.SCALE_SMOOTH)));
        boton7.setEnabled(true);

        //MONEDA 1000.
        boton8.setText("");
        ImageIcon monedaC = new ImageIcon("1000.png");
        boton8.setBounds(490, 200, 55, 55);
        boton8.setOpaque(false);
        boton8.setContentAreaFilled(false);
        boton8.setBorderPainted(false);
        boton8.setIcon(new ImageIcon(monedaC.getImage().getScaledInstance(boton8.getWidth() - 15, boton8.getHeight() - 15, Image.SCALE_SMOOTH)));
        boton8.setEnabled(true);

        //BOTON 1500.
        boton9.setText("");
        ImageIcon monedaD = new ImageIcon("1500.png");
        boton9.setBounds(490, 250, 55, 55);
        boton9.setOpaque(false);
        boton9.setContentAreaFilled(false);
        boton9.setBorderPainted(false);
        boton9.setIcon(new ImageIcon(monedaD.getImage().getScaledInstance(boton8.getWidth() - 15, boton8.getHeight() - 15, Image.SCALE_SMOOTH)));
        boton9.setEnabled(true);

        //Boton que al presionar el expendedor, éste se rellene con bebidas.
        boton10.setText("");
        boton10.setContentAreaFilled(false);
        boton10.setBorderPainted(true);
        boton10.setBounds(99, 13, 370, 616);
        boton10.setEnabled(true);

        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(boton5);
        panel.add(boton6);
        panel.add(boton7);
        panel.add(boton8);
        panel.add(boton9);
        panel.add(boton10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {

            Bebida_selected.setText(" BEBIDA SELECCIONADA: COCA-COLA");
            opcion = 1;
        }
        if (e.getSource() == boton3) {
            Bebida_selected.setText(" BEBIDA SELECCIONADA: FANTA");
            opcion = 3;
        }
        if (e.getSource() == boton2) {
            Bebida_selected.setText(" BEBIDA SELECCIONADA: SPRITE");
            opcion = 2;
        }
        if (e.getSource() == boton5) {
            System.out.println("tu vuelto es:" + exp_principal.Vuelto());
        }
        if (e.getSource() == boton6) {
            moneda_seleccionada = new Moneda100();
            System.out.println("Pagaras con 100");
            moneda_selected.setText(" MONEDA SELECCIONADA: 100");
        }
        if (e.getSource() == boton7) {
            moneda_seleccionada = new Moneda500();
            System.out.println("Pagaras con 500");
            moneda_selected.setText(" MONEDA SELECCIONADA: 500");
        }
        if (e.getSource() == boton8) {
            moneda_seleccionada = new Moneda1000();
            System.out.println("Pagaras con 1000");
            moneda_selected.setText(" MONEDA SELECCIONADA: 1000");
        }
        if (e.getSource() == boton9) {
            moneda_seleccionada = new Moneda1500();
            System.out.println("Pagaras con 1500");
            moneda_selected.setText(" MONEDA SELECCIONADA: 1500");
        }
        if (e.getSource() == boton10) {
            System.out.println("Rellenando");
            exp_principal = new Expendedor(6, 800, panel);
            repaint();
        }
        if (e.getSource() == boton4) {
            if (moneda_seleccionada != null) {
                if (moneda_seleccionada.getValor() > 800) {
                    switch (opcion) {
                        case 1:
                            System.out.println("Recibiendo Coca");
                            moneda_selected.setText(" MONEDA SELECCIONADA:");
                            try {
                                exp_principal.comprarBebida(moneda_seleccionada, opcion);
                                moneda_seleccionada = null;
                            } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayBebidaException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            break;

                        case 3:
                            System.out.println("Recibiendo Fanta");
                            moneda_selected.setText(" MONEDA SELECCIONADA:");
                            try {
                                exp_principal.comprarBebida(moneda_seleccionada, opcion);
                                moneda_seleccionada = null;
                            } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayBebidaException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            break;

                        case 2:
                            System.out.println("Recibiendo Sprite");
                            moneda_selected.setText(" MONEDA SELECCIONADA:");
                            try {
                                exp_principal.comprarBebida(moneda_seleccionada, opcion);
                                moneda_seleccionada = null;
                            } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayBebidaException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            break;
                        default:
                            System.out.println("Seleccione una bebida");
                            break;
                    }
                } else {
                    System.out.println("Dinero Insuficiente");
                }
            } else {
                System.out.println("No tienes ninguna moneda seleccionada");
            }
        }

    }

    public void actualizarPantalla(JLabel a) {
        JPanel temp = (JPanel) this.getContentPane();
        SwingUtilities.updateComponentTreeUI(temp);
        temp.validate();
    }
}
