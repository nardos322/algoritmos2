import java.util.Comparator;


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


}
