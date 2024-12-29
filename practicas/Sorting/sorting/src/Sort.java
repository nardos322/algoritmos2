import java.util.Comparator;
import java.util.*;


public class Sort {

    public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(comparator.compare(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        selectionSort(array, Comparable::compareTo);
    }

    public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
        for (int j = 1; j < array.length; j++) {
            T key = array[j];
            int i = j - 1;
            while ( i >= 0 && comparator.compare(array[i], key) > 0) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
    }

    // Método auxiliar para listas porque despues uso este algortimo para bucketSort y tengo que tener una version que reciba ListaEnlazada como parametro
    public static <T> void insertionSort(List<T> list, Comparator<T> comparator) {
        T[] array = (T[]) list.toArray();
        insertionSort(array,comparator);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, array[i]);
        }
    }

    public static <T extends  Comparable<T>> void insertionSort(T[] array) {
        insertionSort(array, Comparable::compareTo);
    }

    public static <T> void heapSort(T[] array, Comparator<T> comparator) {
        int heapSize = array.length;
        buildHeap(array, heapSize, comparator);

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapSize --;
            heapify(array, heapSize, 0, comparator);
        }
    }

    public static <T extends Comparable<T>> void heapSort(T[] array) {
        heapSort(array, Comparable::compareTo);
    }

    private static <T> void buildHeap(T[] A, int heapSize, Comparator<T> comparator) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(A, heapSize, i, comparator);
        }
    }

    private static <T> void heapify(T[] A, int heapSize, int i, Comparator<T> comparator) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < heapSize && comparator.compare(A[left], A[largest]) > 0) {
            largest = left;
        }

        if (right < heapSize && comparator.compare(A[right], A[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(A, i, largest);
            heapify(A, heapSize, largest, comparator);
        }
    }

    public static <T> void quickSort(T[] A, Comparator<T> comparator) {
        quickSort(A, 0, A.length - 1, comparator);
    }

    public static <T> void randomQuickSort(T[] A, Comparator<T> comparator) {
        randomQuickSort(A, 0, A.length - 1, comparator);
    }

    public static <T extends Comparable<T>> void quickSort(T[] A) {
        quickSort(A, Comparable::compareTo);
    }

    public static <T extends  Comparable<T>> void randomQuickSort(T[] A) {
        randomQuickSort(A, Comparable::compareTo);
    }

    private static <T> void quickSort(T[]A, int p, int r, Comparator<T> comparator) {
        if (p < r) {
            int q = partition(A, p, r, comparator); // Particiona el arreglo
            quickSort(A, p, q - 1, comparator); // Ordena el subarreglo izquierdo
            quickSort(A, q + 1, r, comparator ); // Ordena el subarreglo derecho
        }
    }

    private static <T> void randomQuickSort(T[] A, int p, int r, Comparator<T> comparator) {
        if (p < r) {
            int q = randomPartition(A, p, r, comparator);
            randomQuickSort(A, p, q - 1, comparator);
            randomQuickSort(A, q + 1, r, comparator);
        }
    }

    private static <T> int partition(T[] A, int p, int r, Comparator<T> comparator) {
        T pivot = A[r];  // Elegir pivote como el ultimo elemento
        int i = p - 1;  // Inicializar el limite para los elementos menores o iguales
        for (int j = p; j < r; j++) {
            if (comparator.compare(A[j], pivot) <= 0) { // Si el elemento actual es menor o igual al pivot
                i = i + 1;
                swap(A,i, j);
            }
        }
        swap(A,i + 1, r); // colocar el pivot en su posicion final
        return i + 1;  // Retornar la posicion final del pivot
    }

    private static <T> int randomPartition(T[] A, int p, int r, Comparator<T> comparator) {
        int i = random(p, r);
        swap(A, r, i);
        return partition(A, p, r, comparator);
    }

    private static int random(int p, int r) {
        return (int)(Math.random() * (r - p + 1)) + p;// Generar un número aleatorio entre p y r
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> void mergeSort(T[] array, Comparator<T> comparator) {
        mergeSort(array, 0, array.length - 1, comparator);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        mergeSort(array, Comparable::compareTo);
    }

    private static <T> void mergeSort(T[] A, int p, int r, Comparator<T> comparator) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q, comparator);   // Ordenar la primera mitad
            mergeSort(A, q + 1, r, comparator);   // Ordenar la segunda mitad
            merge(A, p, q, r, comparator);   // Mezclar ambas mitadas
        }
    }

    private static <T> void merge(T[] A, int p, int q, int r, Comparator<T> comparator ) {
        int n1 = q - p + 1;  // Tamaño del subarreglo izquiero
        int n2 = r - q;     // Tamaño del subarreglo derecho

        T[] left = (T[]) new Object[n1 + 1]; // Espacio adional para el sentinela
        T[] right = (T[]) new Object[n2 + 1]; // Espacio adional para el sentinela

        for (int i = 0; i < n1; i++) {
            left[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = A[q + 1 + j];
        }

        // Agregar Sentinelas al final de ambos subarreglos
        left[n1] = null;
        right[n2] = null;

        // Mezclar los subarreglos en el arreglo original
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (right[j] == null || (left[i] != null && comparator.compare(left[i], right[j]) <= 0)) {
                A[k] = left[i];
                i++;
            } else {
                A[k] = right[j];
                j++;
            }
        }
    }

    public static <T> void countingSort(T[] A, KeyExtractor<T, Integer> keyExtractor , int k) {
        int[] C = new int[k + 1];  // Arreglo de conteo
        T[] B = (T[]) new Object[A.length];
        // Paso 1: Inicializar el arreglo de conteo
        for (int i = 0; i < k; i++) {
            C[i] = 0;
        }
        // Paso 2: Contar las frecuencias de las claves en A
        for (int j = 0; j < A.length; j++) {
            int key = keyExtractor.getKey(A[j]); // Usar KeyExtractpr para obtener la clave
            C[key] ++;
        }

        // Paso 3: Conteo acumulado
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        // Paso 4: Construir el arreglo de salida B
        for (int j = A.length - 1; j >= 0; j--) {
            T element = A[j];
            int key = keyExtractor.getKey(element);
            B[C[key] - 1] = element;
            C[key]--;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }
    }


    public static <T> void radixSort(T[]A, KeyExtractor<T, Integer> keyExtractor, int d, int k) {
        for (int i = 0; i < d; i++) {
            int finalExp = i;
            countingSort(A, (element) -> keyExtractor.getKey(element, finalExp), k);
        }
    }

    public static <T> void bucketSort(T[]A, KeyExtractor<T, Double> keyExtractor) {
        LinkedList<T>[] B = new LinkedList[A.length];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            B[i] = new LinkedList<>();
        }

        for (T value : A) {
            double key = keyExtractor.getKey(value); // Extraer clave entre [0, 1)
            int bucketIndex = (int) (key * n); // Calcular la cubeta
            B[bucketIndex].add(value);
        }

        for (int i = 0; i < n; i++) {
            insertionSort(B[i], Comparator.comparing(keyExtractor::getKey));
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (T value : B[i]) {
                A[index++] = value;
            }
        }
    }

    public static void radixSortStrings(String[] arr) {
        int maxLength = findMaxLength(arr);

        for (int pos = maxLength - 1; pos >= 0; pos--) {
            countingSortByCharacter(arr, pos);
        }
    }

    static void countingSortByCharacter(String[] arr, int pos) {
        int[] count = new int[256]; // Rango ASCII extendido
        String[] output = new String[arr.length];

        // Contar ocurrencias de caracteres
        for (String str : arr) {
            char ch = pos < str.length() ? str.charAt(pos) : 0; // Manejar cadenas más cortas
            count[ch]++;
        }

        // Conteo acumulado
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo ordenado
        for (int i = arr.length - 1; i >= 0; i--) {
            char ch = pos < arr[i].length() ? arr[i].charAt(pos) : 0;
            output[count[ch] - 1] = arr[i];
            count[ch]--;
        }

        // Copiar a arr
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    static int findMaxLength(String[] arr) {
        int maxLength = 0; // Inicializa la longitud máxima como 0
        for (String str : arr) {
            if (str.length() > maxLength) {
                maxLength = str.length(); // Actualiza si se encuentra una cadena más larga
            }
        }
        return maxLength;
    }


    @FunctionalInterface
    public interface KeyExtractor<T, R> {
        R getKey(T element); // Extrae la clave

        default R getKey(T element, int position) {
            return getKey(element);
        }
    }


}
