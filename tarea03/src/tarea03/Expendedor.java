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
    private Moneda Pago;
    private Bebida gaseosa;
    private int posicionB;
    private int posicionA;

    public Expendedor(int numBebidas, int valorBebidas, JPanel panel) {
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
        posicionB = 110;
        posicionA = 0;
        //Creacion de bebidas dependiendo de la cantidad establecida 
        //mediante un ciclo que les asigna un numero de serie
        for (int i = 0; i < cantidadBebidas; i++) {
            CocaCola.addBebida(new CocaCola(posicionB, panel, 100 + i));
            Sprite.addBebida(new Sprite(posicionB, panel, 200 + i));
            Fanta.addBebida(new Fanta(posicionB, panel, 300 + i));
            posicionB = posicionB + 69;
        }

    }

    public Bebida comprarBebida(Moneda m, int aux_b) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException {
        Pago = m;
        if (Pago != null) {
            if (Pago.getValor() >= precioBebidas) {
                for (int i = 0; i < Pago.getValor(); i = i + 100) {
                    coins.addMoneda(new Moneda100());
                }
                aux_Bebida = Pago.getValor() - precioBebidas;
                switch (aux_b) {
                    case 1:
                        //Cada intento de comprar una bebida pasara por este switch case el cual se encarga de verificar el tipo de bebida
                        //y ver si se encuentra disponible, sino para segun el caso lanzar un tipo de Exception con sus respectivos Output's
                        if (dep1 > 0) {
                            dep1 = dep1 - 1;
                        } else {
//                            System.out.println("No hay bebidas disponibles");
                        }
                        Bebida aux2 = CocaCola.getBebida(dep1);
                        CocaCola.getBebida(dep1).mover();
                        BorradorBebidas a = new BorradorBebidas(CocaCola.getBebida(dep1).etiqueta(), CocaCola.getBebida(dep1).getSerie(), posicionA);
                        posicionA = posicionA + 40;
                        if (aux2 == null) {
                            aux_Bebida = Pago.getValor();
                            throw new NoHayBebidaException("No hay bebidas disponibles");
                        } else {
                            return aux2;
                        }
                    case 2:
                        if (dep2 > 0) {
                            dep2 = dep2 - 1;
                        } else {
                           System.out.println("No hay bebidas disponibles");
                        }
                        Bebida aux3 = Sprite.getBebida(dep2);
                        Sprite.getBebida(dep2).mover();
                        BorradorBebidas b = new BorradorBebidas(Sprite.getBebida(dep2).etiqueta(), Sprite.getBebida(dep2).getSerie(), posicionA);
                        posicionA = posicionA + 40;
                        if (aux3 == null) {
                            aux_Bebida = Pago.getValor();
                            throw new NoHayBebidaException("No hay bebidas disponibles");
                        } else {
                            return aux3;
                        }

                    case 3:
                        if (dep3 > 0) {
                            dep3 = dep3 - 1;
                        } else {
                            System.out.println("No hay bebidas disponibles");
                        }
                        Bebida aux4 = Fanta.getBebida(dep3);
                        Fanta.getBebida(dep3).mover();
                        BorradorBebidas c = new BorradorBebidas(Fanta.getBebida(dep3).etiqueta(), Fanta.getBebida(dep3).getSerie(), posicionA);
                        posicionA = posicionA + 40;
                        if (aux4 == null) {
                            aux_Bebida = Pago.getValor();
                            throw new NoHayBebidaException("No hay bebidas disponibles");
                        } else {
                            return aux4;
                        }
                    default:
                        //Si la eleccion del Comprador se sale de los margenes establecida
                        //Devuelve la moneda utilizada como tal
                        aux_Bebida = Pago.getValor();
                        throw new NoHayBebidaException("Elección de bebida inválida");

                }
            } else {
                //Si la moneda utilizada para realizar el pago es inferior al precio de la bebida
                //Devuelve la moneda utilizada como tal
                aux_Bebida = Pago.getValor();
                throw new PagoInsuficienteException("Pago Insuficiente");
            }
        } else {
            //Si la moneda utilizada es de tipo null
            throw new PagoIncorrectoException("Bienvenido!!");
        }
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

}
