package tarea03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {

    Expendedor exp;
    public JPanel panel;
    Expendedor exp_principal;
    Comprador cliente_principal;
    JLabel Bebida_selected;
    JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8,boton9;
    Moneda moneda_seleccionada;
    BorradorBebidas r;
    Bebida x;
    Deposito Sprite = new Deposito();
    private int opcion = 6;

    public Window() {
        setSize(1200, 700);//Establece tamanho de la ventana
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
        JLabel Output_b = new JLabel();
        JLabel Output_m = new JLabel();
        JLabel expendedor = new JLabel();
        exp_principal = new Expendedor(6, 800, panel);
        
        ImageIcon exp = new ImageIcon("expFinal.png");
        expendedor.setBounds(-10, -20, 1200, 700);
        expendedor.setIcon(new ImageIcon(exp.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));
        panel.add(expendedor);
        //panel.setComponentZOrder(expendedor, );
        Bebida_selected.setBounds(520, 30, 240, 40);
        Bebida_selected.setOpaque(true);
        Bebida_selected.setBackground(Color.white);
        Bebida_selected.setText(" BEBIDA SELECCIONADA:");
        panel.add(Bebida_selected);

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

        boton4.setText("PAGAR");
        boton4.setBounds(415, 400, 15, 45);
        boton4.setOpaque(false);
        boton4.setContentAreaFilled(false);
        boton4.setBorderPainted(true);
        boton4.setEnabled(true);

        boton5.setText("Agarrar Vuelto");
        boton5.setBounds(400, 480, 35, 35);
        boton5.setEnabled(true);

        boton6.setText("100");
        ImageIcon monedaA; 
        boton6.setBounds(490, 100, 35, 35);
        boton6.setEnabled(true);

        boton7.setText("500");
        boton7.setBounds(490, 140, 35, 35);
        boton7.setEnabled(true);

        boton8.setText("1000");
        boton8.setBounds(490, 180, 35, 35);
        boton8.setEnabled(true);

        boton9.setText("1500");
        boton9.setBounds(490, 220, 35, 35);
        boton9.setEnabled(true);

        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(boton5);
        panel.add(boton6);
        panel.add(boton7);
        panel.add(boton8);
        panel.add(boton9);
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
            System.out.println("Estamos trabajando para entregar vuelto, vuelva más tarde.");
        }
        if(e.getSource() == boton6){
            moneda_seleccionada = new Moneda100();
            System.out.println("Pagaras con 100");
        }
        if(e.getSource() == boton7){
            moneda_seleccionada = new Moneda500();
            System.out.println("Pagaras con 500");
        }
        if(e.getSource() == boton8){
            moneda_seleccionada = new Moneda1000();
            System.out.println("Pagaras con 1000");            
        }
        if(e.getSource() == boton9){
            moneda_seleccionada = new Moneda1500();
            System.out.println("Pagaras con 1500");
        }
        if (e.getSource() == boton4) {
            if(moneda_seleccionada.getValor()>800){

                switch (opcion) {
                    case 1:
                        
                        
                        try {
                            System.out.println("Recibiendo Coca");
                            exp_principal.comprarBebida(moneda_seleccionada, opcion);
                        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayBebidaException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        break;

                    case 3:
                        System.out.println("Recibiendo Fanta");
                        try {
                            exp_principal.comprarBebida(new Moneda1500(), opcion);
                        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayBebidaException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        break;

                    case 2:
                        System.out.println("Recibiendo Sprite");
                        try {
                            exp_principal.comprarBebida(new Moneda1500(), opcion);
                        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayBebidaException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Seleccione una bebida");
                        break;
                }
            }else{
                moneda_seleccionada=null;
            }

        }

    }
}
