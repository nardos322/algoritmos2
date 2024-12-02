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

        String[] strings = {"apple", "zoe","anana", "cherry"};

       // Sort.radixSort(strings, s-> (int) (5 < s.length() ? s.charAt(5) : 255), 6, 256);

        Sort.KeyExtractor<String, Integer> stringExtractor = new Sort.KeyExtractor<>() {
            public Integer getKey(String n) {
                return 0;
            }

            @Override
            public Integer getKey(String n, int position) {
                return (int) (position < n.length() ? n.charAt(position) : 0);
            }

        };
        Sort.radixSort(strings, stringExtractor, 6, 256);
    //    System.out.println(Arrays.toString(strings));

        Sort.KeyExtractor<Tupla, Integer> primerComp = new Sort.KeyExtractor<>() {
            @Override
            public Integer getKey(Tupla n) {
                return (Integer) n.first;
            }

            @Override
            public Integer getKey(Tupla n, int position) {
                return ((Integer) n.first / (int) Math.pow(10, position)) % 10;
            }
        };

        Sort.KeyExtractor<Tupla, Integer> segComp = new Sort.KeyExtractor<>() {
            @Override
            public Integer getKey(Tupla n) {
                return (Integer) n.second;
            }

            @Override
            public Integer getKey(Tupla n, int position) {
                return ((Integer) n.second / (int) Math.pow(10, position)) % 10;
            }
        };

        Sort.KeyExtractor<Integer, Integer> numberKeyExtractor = new Sort.KeyExtractor<>() {
            @Override
            public Integer getKey(Integer number) {
                return number; // Método básico para simplemente devolver el número si no se usa posición.
            }

            @Override
            public Integer getKey(Integer number, int position) {
                // Calcula el dígito en la posición específica usando división y módulo.
                int divisor = (int) Math.pow(10, position); // Divide por 10^position
                return (number / divisor) % 10; // Obtén el dígito en la posición.
            }
        };

        Integer[] d = {100, 33, 1424, 4, 10};
        int[] z = {100, 33, 1424, 4, 10};

        Sort.radixSort(d, numberKeyExtractor, 4, 10);
        Sort.radixSortInt(z);
        System.out.println(Arrays.toString(z));
    }
}