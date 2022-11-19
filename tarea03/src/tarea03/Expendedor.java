package tarea03;

import javax.swing.*;

class Expendedor extends JPanel {

    private int cantidadBebidas;
    private int precioBebidas;
    private int aux_Bebida;
    private int dep1;
    private int dep2;
    private int dep3;
    private Deposito CocaCola;
    private Deposito Sprite;
    private Deposito Fanta;
    private Deposito coins;
    Bebida aux2, aux3, aux4;
    private Moneda Pago;
    JPanel panelito;
    private int posicionB;
    private int posicionA;

    public Expendedor(int numBebidas, int valorBebidas, JPanel panel) {
        panelito = panel;
        cantidadBebidas = numBebidas;
        precioBebidas = valorBebidas;
        CocaCola = new Deposito();
        dep1 = numBebidas;
        Sprite = new Deposito();
        dep2 = numBebidas;
        Fanta = new Deposito();
        dep3 = numBebidas;
        coins = new Deposito();
        if (numBebidas >= 6) {
            numBebidas = 6;
        }
        posicionB = 460;
        posicionA = 0;
        //Creacion de bebidas dependiendo de la cantidad establecida 
        //mediante un ciclo que les asigna un numero de serie
        for (int i = 0; i < cantidadBebidas; i++) {
            CocaCola.addBebida(new CocaCola(posicionB, panel, 100 + Bebida.contador));
            Sprite.addBebida(new Sprite(posicionB, panel, 200 + Bebida.contador));
            Fanta.addBebida(new Fanta(posicionB, panel, 300 + Bebida.contador));
            posicionB = posicionB - 69;
            Bebida.contador++;
        }
    }

    public Bebida comprarBebida(Moneda m, int aux_b) throws NoHayBebidaException {
        Pago = m;
        if (Pago != null) {
            if (Pago.getValor() >= precioBebidas) {
                for (int i = 0; i < Pago.getValor(); i = i + 100) {
                    coins.addMoneda(new Moneda100(panelito, posicionA, 0, false));
                }
                aux_Bebida = Pago.getValor() - precioBebidas;
                switch (aux_b) {
                    case 1 -> {
                        //Cada intento de comprar una bebida pasara por este switch case el cual se encarga de verificar el tipo de bebida
                        //y ver si se encuentra disponible, sino para segun el caso lanzar un tipo de Exception con sus respectivos Output's
                        if (dep1 > 0) {
                            dep1 = dep1 - 1;
                        } else {
                            aux_Bebida = 0;
                        }
                        aux2 = CocaCola.getBebida(0);
                        if (aux2 == null) {
                            throw new NoHayBebidaException("No hay bebidas disponibles");
                        }
                        CocaCola.actualizarC();
                        BorradorBebidas a = new BorradorBebidas(aux2.etiqueta(), aux2.getSerie(), posicionA);
                        posicionA = posicionA + 40;
                        aux2.mover();
                        return aux2;
                    }
                    case 2 -> {
                        if (dep2 > 0) {
                            dep2 = dep2 - 1;
                        } else {
                            aux_Bebida = 0;
                        }
                        aux3 = Sprite.getBebida(0);
                        if (aux3 == null) {
                            throw new NoHayBebidaException("No hay bebidas disponibles");
                        }
                        Sprite.actualizarS();
                        BorradorBebidas b = new BorradorBebidas(aux3.etiqueta(), aux3.getSerie(), posicionA);
                        posicionA = posicionA + 40;
                        aux3.mover();
                        return aux3;
                    }

                    case 3 -> {
                        if (dep3 > 0) {
                            dep3 = dep3 - 1;
                        } else {
                            aux_Bebida = 0;
                        }
                        aux4 = Fanta.getBebida(0);
                        if (aux4 == null) {
                            throw new NoHayBebidaException("No hay bebidas disponibles");
                        }
                        Fanta.actualizarF();
                        BorradorBebidas c = new BorradorBebidas(aux4.etiqueta(), aux4.getSerie(), posicionA);
                        posicionA = posicionA + 40;
                        aux4.mover();
                        return aux4;
                    }
                    default -> //Si la eleccion del Comprador se sale de los margenes establecida
                        //Devuelve la moneda utilizada como tal
                        aux_Bebida = Pago.getValor();

                }
            }
        } else {
            System.out.println("Bienvenido!!!");
        }
        return null;
    }

    public Moneda getVuelto() {
        //Sistema que devuelve el vuelto en monedas de tipo 100
        Moneda ayuda;
        int ayuda2 = aux_Bebida;
        if (aux_Bebida == 0) {
            Pago = null;
            ayuda = new Moneda0();
            return ayuda;
        } else {
            aux_Bebida = aux_Bebida - 100;
            for (int i = 0; i < ayuda2; i = i + 100) {
                return coins.getMoneda();
            }
            return Pago;
        }
    }

    public int Vuelto() {
        int vuelto = aux_Bebida;
        return (vuelto);
    }

    public void rellenar() {
        //Metodo utilizado para rellenar bebidas 
        dep1 = 6;
        posicionB = 460;
        CocaCola.rellenadoC(posicionB, panelito, cantidadBebidas);
        Sprite.rellenadoS(posicionB, panelito, cantidadBebidas);
        Fanta.rellenadoF(posicionB, panelito, cantidadBebidas);
    }
}
