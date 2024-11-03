package aed;
import java.util.ArrayList;
import java.util.Comparator;




public class Heap<T> {
    private ArrayList<T> heap;
    private Comparator<? super T> comparator;

    public Heap() {
        heap = new ArrayList<>();
        comparator = null;
    }

    public Heap(Comparator<? super T> comparator) {
        heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public Heap(T[] array){
        heap = new ArrayList<>(array.length);
        comparator = null;
        int i = 0;
        while(i < array.length) {
            heap.add(array[i]);
            i++;
        }
        buildHeap();
    }

    public Heap(T[] array, Comparator<? super T> comparator) {
        heap = new ArrayList<>(array.length);
        this.comparator = comparator;
        int i = 0;
        while (i < array.length) {
            heap.add(array[i]);
            i++;
        }
        buildHeap();
    }

    private int padre(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2*i + 1;
    }

    private int right(int i) {
        return 2*i + 2;
    }

    public void insertar (T e) {
        if(e == null) {
            throw new NullPointerException("no se puede insertar valores nulos");
        }
        heap.add(e);
        heapifyUp(heap.size() - 1);

    }

    public T raiz(){
        if(heap.isEmpty()) {
            throw new IllegalStateException("Heap vacio");
        }
        return heap.get(0);
    }

    public T extraer() {
        if(heap.isEmpty()) {
            throw new IllegalStateException("El heap esta vacio");
        }
        T raiz = heap.get(0);
        T ultimoElemento = heap.get(tamaño() - 1);
        heap.set(0, ultimoElemento);
        heap.remove(tamaño() - 1);
        if(!heap.isEmpty()) {
            heapifyDown(0);
        }

        return raiz;

    }

    private void heapifyUp(int index) {
        if(index == 0) {
            return;
        }
        int padreIndex = padre(index);
        if (compare(heap.get(index), heap.get(padreIndex)) > 0) {
            swap(index, padreIndex);
            heapifyUp(padreIndex);
        }
    }

    private void heapifyDown(int index) {
        int mayorIndex = index; // inicialmente asumimos que el nodo actual es el mayor
        int leftIndex = left(index);
        int rightIndex = right(index);

        // verifica si el hijo izquiero es mayor que el nodo actual
        if(leftIndex < heap.size() && compare(heap.get(leftIndex), heap.get(mayorIndex)) > 0) {
            mayorIndex = leftIndex;
        }

        // verifica si el hijo derecho es mayor el nodo mas grande encontrado hasta ahora
        if(rightIndex < heap.size() && compare(heap.get(rightIndex), heap.get(mayorIndex)) > 0) {
            mayorIndex = rightIndex;
        }

        if(mayorIndex != index) {
            swap(index, mayorIndex);
            heapifyDown(mayorIndex);
        }
    }

    private void buildHeap(){
        int ultimoNoHoja = (tamaño() / 2) - 1;
        for(int i = ultimoNoHoja; i >= 0; i-- ){
            heapifyDown(i);
        }
    }

    private void swap(int i, int j) {
        T elemento = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, elemento);
    }

    private int compare(T first, T second) {
        if (comparator != null) {
            return comparator.compare(first, second);
        } else {
            // Invertimos el orden para que el mayor tenga mayor prioridad
            return ((Comparable<? super T>) first).compareTo(second);
        }
    }
    public String toString() {
        return heap.toString();
    }

    public int tamaño(){
        return heap.size();
    }


}
