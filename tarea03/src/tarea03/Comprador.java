package tarea03;

import java.util.logging.Level;
import java.util.logging.Logger;

class Comprador {

    private int cantidad;
    private String tipoBebida;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Bebida aux;
        try {
            aux = exp.comprarBebida(m, cualBebida);
            cantidad = exp.Vuelto();
        } catch (NoHayBebidaException ex) {
            aux = null;
            cantidad = exp.Vuelto();
            System.out.println(ex.getMessage());
        }
        if (aux != null) {
            tipoBebida = aux.Beber();
        }
    }

    public int cuantoVuelto() {
        return (cantidad);
    }

    public String queBebiste() {
        return (tipoBebida);
    }

}
