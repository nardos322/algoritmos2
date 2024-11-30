import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Integer[] A = {3, 3, 1, 4, 2, 2, 2, 4, 7, 5};

        String[] C = {"holaaaaa", "naranja", "azul"};
        String[] B = new String[C.length];

        Persona[] personas = {
                new Persona("Juan", 25),
                new Persona("Ana", 30),
                new Persona("Luis", 22),
                new Persona ("Alejandro", 16)
        };
        Persona[] salida = new Persona[personas.length];
        int charIndex = 255;

        Sort.KeyExtractor<String, Integer> stringKeyExtractor = s -> {
            return charIndex < s.length() ? (int) s.charAt(charIndex) : 0;
        };

        Sort.KeyExtractor<String,Integer> stringLength = s -> {
            return (int) s.length();
        };
        //Sort.countingSort(personas, salida, p -> {return charIndex < p.nombre.length() ? (int) p.nombre.charAt(charIndex) : 0;},  255);


//        Sort.radixSort(personas,p -> {return charIndex < p.nombre.length() ? (int) p.nombre.charAt(charIndex) : 0;},255);
//
//       for(Persona n : personas) {
//            System.out.println(n.nombre);
//        }




        Sort.countingSort(personas, salida, p -> (int) p.nombre.charAt(0),255);

/*
        for (int i = 2; i >= 0; i--) {
            int index = i;
            Sort.countingSort(personas, salida, p -> {return index < p.nombre.length() ? (int) p.nombre.charAt(index) : 0;},255);
        }
*/

        for (Persona n : salida) {
            System.out.println(n);
        }

    }
}