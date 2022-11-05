package tarea03;

public class mainExpendedorBebida {
    public static void main(String[] string){
         //Test NoHayBebidaException 
        Expendedor e = new Expendedor(0, 500);
        Moneda m = new Moneda1500();
        Comprador c = new Comprador(m, 1, e);
        System.out.println("Vuelto: " + c.cuantoVuelto());
        System.out.println(c.queBebiste());
        System.out.println();

        //Test Exception de PAGOINSUFICIENTE
        Expendedor h = new Expendedor(1, 6000);
        Moneda a = new Moneda1000();
        Comprador z = new Comprador(a, 1, h);
        System.out.println("Vuelto: " + z.cuantoVuelto());
        System.out.println(z.queBebiste());
        System.out.println();

        //Test Exception de PAGO NULL
        Expendedor t = new Expendedor(1, 1000);
        Comprador j = new Comprador(null, 1, t);
        System.out.println("Vuelto: " + j.cuantoVuelto());
        System.out.println(j.queBebiste());
        System.out.println();

        //Test Sistema de VUELTO
        Expendedor v = new Expendedor(1, 600);
        Moneda b = new Moneda1500();
        Comprador y = new Comprador(b, 1, v);
        System.out.println("Vuelto: " + y.cuantoVuelto());
        System.out.println(y.queBebiste());
        System.out.println();
        
        //Test Expendedor para ver si tiramonedas
        Expendedor v2 = new Expendedor(1,800);
        Moneda b2 = new Moneda1000();
        Comprador y2= new Comprador(b2,1,v2);
        System.out.println("Vuelto: " + y2.cuantoVuelto());
        System.out.println(y2.queBebiste());
        Moneda mon1=v2.getVuelto();
        Moneda mon2=v2.getVuelto();
        Moneda mon3=v2.getVuelto();
        System.out.println(mon1.getValor());
        System.out.println(mon2.getValor());
        System.out.println(mon3.getValor());
        System.out.println();
    }
    
}
