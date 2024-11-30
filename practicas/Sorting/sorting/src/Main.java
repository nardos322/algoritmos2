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
                new Persona("Luis", 16),
                new Persona ("Alejandro", 13)
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

//        Sort.KeyExtractor<Persona, Integer> extractor = p -> p.edad;
//        Sort.radixSort(personas, extractor, 3);

        String[] strings = {"apple", "zoe","anana", "cherry"};

        Sort.KeyExtractor<String, Integer> strExtractor = new Sort.KeyExtractor<>() {

            @Override
            public Integer getKey(String element) {
                return element.length();
            }

            @Override
            public Integer getKey(String s, int position) {
                // Implementación para posiciones específicas
                if (position < s.length()) {
                    return (int) s.charAt(position); // Valor ASCII
                } else {
                    return -1; // Valor neutro
                }
            }
        };

        Sort.radixSort(strings, strExtractor, 6);

        for (String n : strings) {
            System.out.println(n);
        }

/*
        for (int i = 2; i >= 0; i--) {
            int index = i;
            Sort.countingSort(personas, salida, p -> {return index < p.nombre.length() ? (int) p.nombre.charAt(index) : 0;},255);
        }
*/

//        for (Persona n : personas) {
//            System.out.println(n);
//        }

    }
}