package aed;


public class Main {
    public static void main(String[] args) {
        LinkedListQueue<Integer> lista = new LinkedListQueue<>();
        lista.encolar(3);
        lista.encolar(2);
        lista.encolar(6);
        lista.encolar(30);

        for(Integer a : lista){
            System.out.println(a);
        }


        //System.out.println(lista.toString());
    }
}