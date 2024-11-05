package aed;


public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> a = new ListaEnlazada<>();
        a.agregarAdelante(3);
        a.agregarAdelante(6);
        a.agregarAtras(2);
        a.agregarAtras(7);

        for (Integer integer : a) {
            System.out.println(integer);
        }

        //System.out.println(a.primero());
    }
}
