package tarea03;

import java.util.ArrayList;

class Deposito {
    //Arraylist que se encargan de añadir o quitar elementos tipo moneda o bebida segun corresponda
    private ArrayList b;
    private ArrayList m;

    public Deposito() {
        b = new ArrayList();
        m = new ArrayList();
    }

    public void addBebida(Bebida num) {
        b.add(num);
    }

    public Bebida getBebida(int x) {
        if (b.size() <= 0) {
            return null;
        } else {           
            Bebida a = (Bebida) b.get(x);
            b.remove(x);
            return a;
        }
    }
    public void actualizarlo(int x){
        for(int i=0;i<x;i++){
            b.set(i,(Bebida) b.get(i+1));
        }
    }

    public void addMoneda(Moneda x) {
        m.add(x);
    }

    public Moneda getMoneda() {
        if (m.size() <= 0) {
            return null;
        } else {
            Moneda a = (Moneda) m.remove(0);
            return a;
        }
    }
}
