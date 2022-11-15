package tarea03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Window extends JFrame implements ActionListener {

    public JPanel panel;
    public JLayeredPane fondo;
    Expendedor exp_principal, auxE;
    Comprador cliente_principal, auxC;
    JLabel Bebida_selected;
    JLabel moneda_selected;
    JLabel mensajePagar;
    JLabel expendedor, aux;
    JLabel precio;
    JLabel Cambio;
    JLabel Vuelto;
    JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton10;
    Moneda moneda_seleccionada, auxM;
    ;
    int cantidad;
    private int opcion, auxO;
    private int posi_X, posi_X2, posi_X3, posi_X4, posi_X5, posi_X6, posi_X7, posi_X8, posi_X9, posi_X10;

    public Window() {
        posi_X = 0;
        posi_X2 = 0;
        posi_X3 = 0;
        posi_X4 = 0;
        posi_X5 = 0;
        posi_X6 = 0;
        posi_X7 = 0;
        posi_X8 = 0;
        posi_X9 = 0;
        posi_X10 = 0;
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
        precio = new JLabel();
        expendedor = new JLabel();
        Vuelto = new JLabel();
        Cambio = new JLabel();
        exp_principal = new Expendedor(6, 800, panel);
        cliente_principal = new Comprador(moneda_seleccionada, opcion, exp_principal);
        ImageIcon exp = new ImageIcon("FONDO_FINAL.png");
        expendedor.setBounds(-10, -20, 1200, 700);
        expendedor.setIcon(new ImageIcon(exp.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));
        panel.add(expendedor);

        Bebida_selected.setBounds(480, 14, 240, 35);
        Bebida_selected.setOpaque(true);
        Bebida_selected.setBackground(null);
        Bebida_selected.setText(" BEBIDA SELECCIONADA:");
        Bebida_selected.setFont(new Font("Rockwell", Font.BOLD, 12));
        panel.add(Bebida_selected);
        panel.setComponentZOrder(Bebida_selected, 0);

        moneda_selected.setBounds(480, 40, 240, 30);
        moneda_selected.setOpaque(true);
        moneda_selected.setBackground(null);
        moneda_selected.setText(" MONEDA SELECCIONADA:");
        moneda_selected.setFont(new Font("Rockwell", Font.BOLD, 12));
        panel.add(moneda_selected);
        panel.setComponentZOrder(moneda_selected, 0);

        precio.setBounds(480, 66, 240, 30);
        precio.setOpaque(true);
        precio.setBackground(null);
        precio.setText(" VALOR:");
        precio.setFont(new Font("Rockwell", Font.BOLD, 12));
        panel.add(precio);
        panel.setComponentZOrder(precio, 0);

        Cambio.setBounds(480, 480, 100, 30);
        Cambio.setOpaque(true);
        Cambio.setBackground(null);
        Cambio.setText(" VUELTO:");
        Cambio.setFont(new Font("Rockwell", Font.BOLD, 12));
        panel.add(Cambio);
        panel.setComponentZOrder(Cambio, 0);

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
        ImageIcon foto1 = new ImageIcon("newBotonCoke.png");
        boton1.setBounds(360, 101, 75, 37);
        boton1.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(boton1.getWidth() + 16, boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton1.setBorderPainted(true);
        boton1.setBorder(new LineBorder(Color.RED));
        boton1.setEnabled(true);

        ImageIcon foto2 = new ImageIcon("newBotonSprite.png");
        boton2.setBounds(360, 206, 75, 37);
        boton2.setIcon(new ImageIcon(foto2.getImage().getScaledInstance(boton2.getWidth() + 12, boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setBorderPainted(true);
        boton2.setBorder(new LineBorder(Color.GREEN));
        boton2.setEnabled(true);

        ImageIcon foto3 = new ImageIcon("newBotonFanta.png");
        boton3.setBounds(360, 152, 75, 37);
        boton3.setIcon(new ImageIcon(foto3.getImage().getScaledInstance(boton3.getWidth() + 12, boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setBorderPainted(true);
        boton3.setBorder(new LineBorder(Color.ORANGE));
        boton3.setEnabled(true);

        //Boton Pagar.
        boton4.setText("PAGAR");
        boton4.setBounds(415, 398, 15, 53);
        boton4.setOpaque(false);
        boton4.setContentAreaFilled(false);
        boton4.setBorderPainted(true);
        boton4.setBorder(new LineBorder(Color.GREEN));
        boton4.setEnabled(true);

        //Boton que entrega el vuelto al hacer click.
        ImageIcon botonVuelto = new ImageIcon("boton_vuelto.png");
        boton5.setIcon(new ImageIcon(botonVuelto.getImage().getScaledInstance(51, 38, Image.SCALE_SMOOTH)));
        boton5.setBounds(398, 480, 39, 36);
        boton5.setEnabled(true);

        //Botones de las monedas que dan a indicar el valor con el que se paga la bebida.
        //MONEDA 100
        ImageIcon monedaA = new ImageIcon("100.png");
        boton6.setBounds(490, 100, 55, 55);
        boton6.setOpaque(false);
        boton6.setContentAreaFilled(false);
        boton6.setBorderPainted(false);
        boton6.setIcon(new ImageIcon(monedaA.getImage().getScaledInstance(boton6.getWidth() - 15, boton6.getHeight() - 15, Image.SCALE_SMOOTH)));
        boton6.setEnabled(true);

        //MONEDA 500
        ImageIcon monedaB = new ImageIcon("500.png");
        boton7.setBounds(490, 150, 55, 55);
        boton7.setOpaque(false);
        boton7.setContentAreaFilled(false);
        boton7.setBorderPainted(false);
        boton7.setIcon(new ImageIcon(monedaB.getImage().getScaledInstance(boton7.getWidth() - 15, boton7.getHeight() - 15, Image.SCALE_SMOOTH)));
        boton7.setEnabled(true);

        //MONEDA 1000.
        ImageIcon monedaC = new ImageIcon("1000.png");
        boton8.setBounds(490, 200, 55, 55);
        boton8.setOpaque(false);
        boton8.setContentAreaFilled(false);
        boton8.setBorderPainted(false);
        boton8.setIcon(new ImageIcon(monedaC.getImage().getScaledInstance(boton8.getWidth() - 15, boton8.getHeight() - 15, Image.SCALE_SMOOTH)));
        boton8.setEnabled(true);

        //BOTON 1500.
        ImageIcon monedaD = new ImageIcon("1500.png");
        boton9.setBounds(490, 250, 55, 55);
        boton9.setOpaque(false);
        boton9.setContentAreaFilled(false);
        boton9.setBorderPainted(false);
        boton9.setIcon(new ImageIcon(monedaD.getImage().getScaledInstance(boton8.getWidth() - 15, boton8.getHeight() - 15, Image.SCALE_SMOOTH)));
        boton9.setEnabled(true);

        //Boton que al presionar el expendedor, éste se rellene con bebidas.
        boton10.setContentAreaFilled(false);
        boton10.setBorderPainted(false);
        boton10.setBounds(130, 96, 218, 430);
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

    public void testExpendedor() throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException {
        if (moneda_seleccionada != null) {
            if (moneda_seleccionada.getValor() > 800) {
                switch (opcion) {
                    case 1:
                        System.out.println("Recibiendo Coca");
                        Cambio.setText(" VUELTO: " + "$" + (moneda_seleccionada.getValor() - 800));
                        moneda_selected.setText(" MONEDA SELECCIONADA:");
                        exp_principal.comprarBebida(moneda_seleccionada, opcion);
                        break;

                    case 3:
                        System.out.println("Recibiendo Fanta");
                        Cambio.setText(" VUELTO: " + "$" + (moneda_seleccionada.getValor() - 800));
                        moneda_selected.setText(" MONEDA SELECCIONADA:");
                        exp_principal.comprarBebida(moneda_seleccionada, opcion);
                        break;

                    case 2:
                        System.out.println("Recibiendo Sprite");
                        Cambio.setText(" VUELTO: " + "$" + (moneda_seleccionada.getValor() - 800));
                        moneda_selected.setText(" MONEDA SELECCIONADA:");
                        exp_principal.comprarBebida(moneda_seleccionada, opcion);
                        break;
                    default:
                        System.out.println("Seleccione una bebida");
                        break;
                }
            } else {
                throw new PagoInsuficienteException("Pago Insuficiente");
            }
        } else {
            throw new PagoIncorrectoException("No tienes ninguna moneda seleccionada");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {

            Bebida_selected.setText(" BEBIDA SELECCIONADA: COCA-COLA");
            precio.setText(" VALOR: $800");
            opcion = 1;
        }
        if (e.getSource() == boton3) {
            Bebida_selected.setText(" BEBIDA SELECCIONADA: FANTA");
            precio.setText(" VALOR: $800");
            opcion = 3;
        }
        if (e.getSource() == boton2) {
            Bebida_selected.setText(" BEBIDA SELECCIONADA: SPRITE");
            precio.setText(" VALOR: $800");
            opcion = 2;
        }
        if (e.getSource() == boton5) {
            if (exp_principal.Vuelto() > 0) {
                System.out.println("Agarraste $100,En el Expendedor quedan: " + "$" + (exp_principal.Vuelto() - 100));
                if (posi_X < 160) {
                    exp_principal.getVuelto();
                    Moneda helpin = new Moneda100(panel, posi_X, 0, true);
                    repaint();
                    posi_X = posi_X + 20;
                } else {
                    if (posi_X2 < 160) {
                        exp_principal.getVuelto();
                        Moneda helpin = new Moneda100(panel, posi_X2, +40, true);
                        repaint();
                        posi_X2 = posi_X2 + 20;
                    } else {
                        if (posi_X3 < 160) {
                            exp_principal.getVuelto();
                            Moneda helpin = new Moneda100(panel, posi_X3, +80, true);
                            repaint();
                            posi_X3 = posi_X3 + 20;
                        } else {
                            if (posi_X4 < 160) {
                                exp_principal.getVuelto();
                                Moneda helpin = new Moneda100(panel, posi_X4, +120, true);
                                repaint();
                                posi_X4 = posi_X4 + 20;
                            } else {
                                if (posi_X5 < 160) {
                                    exp_principal.getVuelto();
                                    Moneda helpin = new Moneda100(panel, posi_X5, +160, true);
                                    repaint();
                                    posi_X5 = posi_X5 + 20;
                                } else {
                                    if (posi_X6 < 160) {
                                        exp_principal.getVuelto();
                                        Moneda helpin = new Moneda100(panel, posi_X6, +200, true);
                                        repaint();
                                        posi_X6 = posi_X6 + 20;
                                    } else {
                                        if (posi_X7 < 160) {
                                            exp_principal.getVuelto();
                                            Moneda helpin = new Moneda100(panel, posi_X7, +240, true);
                                            repaint();
                                            posi_X7 = posi_X7 + 20;
                                        } else {
                                            if (posi_X8 < 160) {
                                                exp_principal.getVuelto();
                                                Moneda helpin = new Moneda100(panel, posi_X8, +280, true);
                                                repaint();
                                                posi_X8 = posi_X8 + 20;
                                            } else {
                                                JLabel advert = new JLabel();
                                                advert.setText("no tienes mas espacio en tu monedero");
                                                advert.setBounds(480, 70, 100, 20);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("no queda mas vuelto para entregar");
            }
        }
        if (e.getSource() == boton6) {
            moneda_seleccionada = new Moneda100(panel, 0, 0, false);
            System.out.println("Pagaras con $100");
            moneda_selected.setText(" MONEDA SELECCIONADA: $100");
        }
        if (e.getSource() == boton7) {
            moneda_seleccionada = new Moneda500();
            System.out.println("Pagaras con $500");
            moneda_selected.setText(" MONEDA SELECCIONADA: $500");
        }
        if (e.getSource() == boton8) {
            moneda_seleccionada = new Moneda1000();
            System.out.println("Pagaras con $1000");
            moneda_selected.setText(" MONEDA SELECCIONADA: $1000");
        }
        if (e.getSource() == boton9) {
            moneda_seleccionada = new Moneda1500();
            System.out.println("Pagaras con $1500");
            moneda_selected.setText(" MONEDA SELECCIONADA: $1500");
        }
        if (e.getSource() == boton10) {
            System.out.println("Rellenando");
            exp_principal = new Expendedor(6, 800, panel);
//            auxE = new Expendedor(6, 800, panel);
//            auxC = new Comprador(moneda_seleccionada, auxO, auxE);

            repaint();
        }
        if (e.getSource() == boton4) {
            if (exp_principal.Vuelto() == 0) {
                try {
                    testExpendedor();
                } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayBebidaException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println();
                System.out.println("AVISO: debes sacar la bebida y su vuelto para comprar denuevo");
                System.out.println();
            }
        }
    }
}
