import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    @Test
    void testSortAlreadySortedArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        Sort.selectionSort(array);
        assertArrayEquals(expected, array);
    }
    @Test
    public void testQuickSortLargeArray() {
        // Tamaño del arreglo
        int size = 10000000; // 10 millónes de elementos

        // Generar un arreglo aleatorio
        Integer[] largeArray = generateRandomArray(size);
        Sort.KeyExtractor<Integer, Integer> keyExtractor = x -> x;
        // Copiar el arreglo para comparar después
        Integer[] expectedArray = Arrays.copyOf(largeArray, largeArray.length);

        // Ordenar usando Arrays.sort (esto será nuestra referencia correcta)
        Arrays.sort(expectedArray);

        // Ordenar usando nuestra implementación de QuickSort
        long startTime = System.currentTimeMillis();
        Sort.quickSort(largeArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Ordenamiento completado en: " + (endTime - startTime) + " ms");

        // Verificar que ambos arreglos sean iguales
        assertArrayEquals(expectedArray, largeArray);
    }

    private Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = (Integer) random.nextInt(10000000); // Números entre 0 y 10 millónes
        }
        return array;
    }

    @Test
    public void testQuickSortWithLargeStringsArray(){
        int size = 1_000_000; // Tamaño del arreglo
        int stringLength = 10; // Longitud promedio de las cadenas

        // Generar un arreglo aleatorio de cadenas
        String[] randomStrings = generateRandomStrings(size, stringLength);

        // Crear una copia para ordenar con Arrays.sort
        String[] expectedArray = Arrays.copyOf(randomStrings, randomStrings.length);

        // Ordenar usando Arrays.sort (referencia confiable)
        Arrays.sort(expectedArray);

        // Ordenar usando nuestra implementación de QuickSort
        long startTime = System.currentTimeMillis();
        Sort.mergeSort(randomStrings);
        long endTime = System.currentTimeMillis();

        System.out.println("Ordenamiento completado en: " + (endTime - startTime) + " ms");

        // Verificar que ambos arreglos sean iguales
        assertArrayEquals(expectedArray, randomStrings);
    }

    // Método para generar un arreglo de cadenas aleatorias
    private String[] generateRandomStrings(int size, int length) {
        Random random = new Random();
        String[] strings = new String[size];

        for (int i = 0; i < size; i++) {
            strings[i] = generateRandomString(random, length);
        }

        return strings;
    }

    // Generar una cadena aleatoria de una longitud específica
    private String generateRandomString(Random random, int length) {
        StringBuilder sb = new StringBuilder(length);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < length; i++) {
            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            sb.append(c);
        }

        return sb.toString();
    }

    @Test
    public void ordenarStringsConCounting() {// voy a ordenar Strings tomando su primer letra
        String[] C = {"holaaaaa", "naranja", "azul"};

        int charIndex = 0;
        Sort.KeyExtractor<String, Integer> stringKeyExtractor = s -> {
            return charIndex < s.length() ? (int) s.charAt(charIndex) : 0;
        };
        String[] expected = {"azul", "holaaaaa", "naranja"};

        Sort.countingSort(C, stringKeyExtractor, 255);
        assertArrayEquals(expected, C);

    }

    @Test
    public void ordenarStringsPorLengthConCounting() {
        String[] C = {"holaaaaa", "naranja", "azul"};
        Sort.KeyExtractor<String, Integer> stringLength = s -> {return (int) s.length();};
        String[] expected = {"azul", "naranja", "holaaaaa"};

        Sort.countingSort(C, stringLength, 255);
        assertArrayEquals(expected, C);

    }

    @Test
    public void ordenarPersonasPorEdad() {
        Persona p1 = new Persona("Juan", 25);
        Persona p2 = new Persona("Ana", 30);
        Persona p3 = new Persona("Luis", 22);
        Persona p4 = new Persona("Alejandro", 18);
        Persona[] personas = {p2, p1, p3, p4};

        Sort.KeyExtractor<Persona, Integer> edad = p -> p.edad;
        Persona[] expected = {p4, p3, p1, p2};

        Sort.countingSort(personas, edad, 80);

        assertArrayEquals(expected, personas);

    }

    @Test
    public void ordernarPersonasPorPrimerLetra() {
        Persona p1 = new Persona("Juan", 25);
        Persona p2 = new Persona("Ana", 30);
        Persona p3 = new Persona("Luis", 22);
        Persona p4 = new Persona("Alejandro", 18);
        Persona[] personas = {p1, p2, p3, p4};



        Sort.countingSort(personas, p -> {return (int) p.nombre.charAt(0);},255);


        Persona[] expected = {p2, p4, p1, p3};
        assertArrayEquals(expected, personas);
    }

    @Test
    public void odernarTuplasIntConRadix() {
        Tupla<Integer, Integer> t1 = new Tupla(3,50);
        Tupla<Integer, Integer> t2 = new Tupla(2,11);
        Tupla<Integer, Integer> t3 = new Tupla(3,42);
        Tupla<Integer, Integer> t4 = new Tupla(20,23);

        Tupla[] tuplas = {t1, t2, t3, t4};
        Tupla[] expectedPrimerComp = {t2, t4, t3, t1};
        Tupla[] expectedTotal = {t2, t3, t1, t4};

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


        // Ordena las tuplas solo por la primer componente
        Sort.radixSort(tuplas, segComp, 2,256);

        // Tuplas ordenadas de forma parcial, solo pro la primer componente
       assertArrayEquals(expectedPrimerComp, tuplas);  // [(2,11), (2,23), (3,42), (3,50)]


        // Ordena las tuplas tomando la segunda componente

       Sort.radixSort(tuplas, primerComp, 2, 256);
       //Orden total de las tuplas ordenadas por primer y segunda compnente
       assertArrayEquals(expectedTotal, tuplas);    // [(2,11), (2,23), (3,42), (3,50)]



    }

    @Test
    public void ordenarNum3CifrasConRadix() {
        Integer[] num = {132,111,232,101};
        Integer[] expected = {101, 111, 132,232};
        Sort.KeyExtractor<Integer, Integer> numberExtractor = new Sort.KeyExtractor<>() {
            @Override
            public Integer getKey(Integer n) {
                return n;
            }

            @Override
            public Integer getKey(Integer n, int position) {
                return (n / (int) Math.pow(10, position)) % 10;
            }
        };

        Sort.radixSort(num, numberExtractor, 3, 10);
        assertArrayEquals(expected, num);
    }

    @Test
    public void ordenarIntsConDiffLength(){
        // uso el radix mas "generico" que hice para ver las diferencias, notar que la clave esta en
        // como defino el keyExtractor ya que esta abstraccion es la clave para que el radixSort generico funcione poara otros tipos de datos
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
        Integer[] expected = {4, 10, 33, 100, 1424};

        Sort.radixSort(d, numberKeyExtractor, 4, 10);

        assertArrayEquals(expected, d);

        // ahora ordeno con el radixInt que hice que esta pensado especialmente para ordenar ints con diff length
        int[] a = {423, 45, 1, 23,4212,25};
        int[] expected2 = {1, 23, 25, 45, 423, 4212};

        Sort.radixSortInt(a);

        assertArrayEquals(expected2, a);

    }


    @Test
    public void ordenarDoubleConBucket() {
        Double[] x = {0.3, 0.1, 0.02, 0.4, 0.2};
        Double[] expected = {0.02, 0.1, 0.2, 0.3, 0.4};

        Sort.bucketSort(x, num -> num);

        assertArrayEquals(expected, x);
    }



}