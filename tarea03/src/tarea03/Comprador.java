package tarea03;

class Comprador {

    private int cantidad;
    private String tipoBebida;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Bebida aux;
        //Try and Catch los cuales se encargan de testear el aux de tipo Bebida y detectar errores
        try {
            aux = exp.comprarBebida(m, cualBebida);
            cantidad = exp.Vuelto();
        } catch (PagoIncorrectoException b) {
            aux = null;
            System.out.println(b.getMessage());
        } catch (PagoInsuficienteException a) {
            aux = null;
            cantidad = exp.Vuelto();
            System.out.println(a.getMessage());
        } catch (NoHayBebidaException z) {
            aux = null;
            cantidad = exp.Vuelto();
            System.out.println(z.getMessage());
        }
        //En caso de que el try and catch verifique que el aux tipo Bebida es distinto del null
        //Le da un atributo que señala el tipo de bebida consumida
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
