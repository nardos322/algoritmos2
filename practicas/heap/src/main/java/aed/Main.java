package aed;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        PrimoComparatorMin prioridadPrimoMin = new PrimoComparatorMin();
        PrimoComparatorMax prioridadPrimoMax = new PrimoComparatorMax();
        Comparator<Empleado> empleadoComparador = new EmpleadoComparator();
        Heap<Empleado> heap = new Heap<>(empleadoComparador);
        heap.insertar(new Empleado("Nahuel", "IT", 28));
        heap.insertar(new Empleado("Sol", "IT", 19));
        heap.insertar(new Empleado("Maria", "Ventas", 19));
        heap.insertar(new Empleado("Maria", "Soporte Tecnico", 19));



        System.out.println(heap.toString());



    }
}