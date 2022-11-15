package tarea03;

import java.util.ArrayList;

import javax.swing.JPanel;

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
            b.get(x);
            b.remove(x);
            return a;
        }
    }
    public void rellenado(int x,JPanel panel){
        while(b.size()<6){
            addBebida(new CocaCola(x-69*b.size(),panel, CocaCola.contador));
        }
    }
    public void actualizarlo(){
        for(int i=0;i<b.size();i++){
            ((CocaCola) b.get(i)).updatelabel(i);
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
