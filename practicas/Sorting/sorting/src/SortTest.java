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

        // Copiar el arreglo para comparar después
        Integer[] expectedArray = Arrays.copyOf(largeArray, largeArray.length);

        // Ordenar usando Arrays.sort (esto será nuestra referencia correcta)
        Arrays.sort(expectedArray);

        // Ordenar usando nuestra implementación de QuickSort
        long startTime = System.currentTimeMillis();
        Sort.mergeSort(largeArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Ordenamiento completado en: " + (endTime - startTime) + " ms");

        // Verificar que ambos arreglos sean iguales
        assertArrayEquals(expectedArray, largeArray);
    }

    private Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000000); // Números entre 0 y 10 millónes
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
        Sort.randomQuickSort(randomStrings);
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
}