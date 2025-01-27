package aed;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void buildHeap(int[]a) {
        int ultimoNodo = (a.length / 2) - 1;
        for(int i = ultimoNodo; i >= 0; i--){
            heapifyDown(a, i);
        }
    }

    public static void heapifyDown(int[] a, int i){
        int max = i;
        int padre = (i - 1) / 2;
        int izquierdo = 2*i + 1;
        int derecho = 2*i + 2;

        if(izquierdo < a.length && a[izquierdo] > a[max]) {
            max = izquierdo;
        }

        if(derecho < a.length && a[derecho]  > a[max]){
            max = derecho;
        }

        if(max != i) {
            int temp = a[i];
            a[i] = a[max];
            a[max] = temp;
            heapifyDown(a, max);
        }

    }

    public static void main(String[] args) {
        PrimoComparatorMin prioridadPrimoMin = new PrimoComparatorMin();
        PrimoComparatorMax prioridadPrimoMax = new PrimoComparatorMax();
        Comparator<Empleado> empleadoComparador = new EmpleadoComparator();
        Comparator<Contador> contadorComparador = new ContadorComparator();
        Heap<Contador> heap = new Heap<>(contadorComparador);

        Contador contador = new Contador(10);
        Contador contador2 = new Contador(12);


        // heap.cambiarPrioridad(handle1);
        Contador[] contadores = {contador,contador2, new Contador(90)};
        ArrayList<HeapHandle<Contador>> handles = new ArrayList<>();
        for(Contador a : contadores) {
            HeapHandle<Contador> handle = heap.encolar(a);
            handles.add(handle);
        }
        ArrayList<Integer> h = new ArrayList<>(10);



        h.add(1,10);
        System.out.println(h.get(1));
        //System.out.println(b[0]);
        //System.out.println(heap.root());




    }
}