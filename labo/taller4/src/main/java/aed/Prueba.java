package aed;

public class Prueba {
    public static void main(String[] args) {
        // crear una lista con numeros random despues retornar un numero alazar por consola
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        for (int i = 0; i < 10; i++) {
            lista.agregarAdelante((int) (Math.random() * 100));
        }
        String listaPrint = lista.toString();
        System.out.println(lista.obtener(5));
        System.out.println(listaPrint);

        //crear una funcion que sume 2 numeros enteros
        System.out.println(sumar(2, 3));



    }

    private static int sumar(int i, int j) {
        return i + j;

    }

}