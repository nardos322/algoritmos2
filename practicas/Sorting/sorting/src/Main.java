import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Integer[] A = {3, 3, 1, 4, 2, 2, 2, 4, 7, 5};

        String[] C = {"holaaaaa", "naranja", "azul"};


//        Persona[] personas = {
//                new Persona("Juan", 25),
//                new Persona("Ana", 30),
//                new Persona("Luis", 16),
//                new Persona ("Alejandro", 13)
//        };
//        Persona[] salida = new Persona[personas.length];
//        int charIndex = 255;
//
//        Sort.KeyExtractor<String, Integer> stringKeyExtractor = s -> {
//            return charIndex < s.length() ? (int) s.charAt(charIndex) : 0;
//        };
//
//        Sort.KeyExtractor<String,Integer> stringLength = s -> {
//            return (int) s.length();
//        };
//
//        String[] strings = {"apple", "zoe","anana", "cherry"};
//
//        Sort.radixSort(strings, s -> (int) s.charAt(3), 6, 256);
//
//        System.out.println(Arrays.toString(strings));

        Sort.countingSort(A, p -> p, 7);
        System.out.println(Arrays.toString(A));

    }
}