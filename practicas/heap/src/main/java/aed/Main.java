package aed;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
            PrimoComparatorMin prioridadPrimoMin = new PrimoComparatorMin();
            PrimoComparatorMax prioridadPrimoMax = new PrimoComparatorMax();
            Comparator<Empleado> empleadoComparador = new EmpleadoComparator();
            Comparator<Contador> contadorComparador = new ContadorComparator();
            Heap<Contador> heap = new Heap<>(contadorComparador);

            Contador contador = new Contador(10);
            Contador contador2 = new Contador(12);

            HeapHandle<Contador> handle1 = heap.encolar(contador);
            HeapHandle<Contador> handle2 = heap.encolar(contador2);

            contador.incrementar();
            contador.incrementar();
            contador.incrementar();
            heap.cambiarPrioridad(handle1);
            contador.decrementar();
            contador.decrementar();
            heap.cambiarPrioridad(handle1);


            System.out.println(heap.toString());
            System.out.println(heap.root());





    }
}