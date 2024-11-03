package aed;
import aed.testObjects.*;
import aed.comparadores.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;

public class HeapTest {
    @Test
    public void testRemoveFromEmptyHeap() {
        Heap<Integer> heap = new Heap<>();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            heap.extraer();
        });
        assertEquals("El heap esta vacio", exception.getMessage());
    }

    @Test
    public void testInsertElementNull(){
        Heap<Integer> heap = new Heap<>();
        assertThrows(NullPointerException.class, () -> {
            heap.insertar(null);
        });
    }
    @Test
    public void testHeapifyUp() {
        Heap<Integer> heap = new Heap<>();
        heap.insertar(10);
        heap.insertar(20);
        heap.insertar(5);
        heap.insertar(30);

        assertEquals(30, heap.extraer());
        assertEquals(20, heap.extraer());
        assertEquals(10, heap.extraer());
        assertEquals(5, heap.extraer());

    }

    @Test
    public void testHeapifyDown() {
        Heap<Integer> heap = new Heap<>();
        heap.insertar(30);
        heap.insertar(20);
        heap.insertar(10);
        heap.insertar(5);

        assertEquals(30, heap.extraer());
        assertEquals(20, heap.extraer());
        assertEquals(10, heap.extraer());
        assertEquals(5, heap.extraer());
    }

    @Test
    public void testInsertAndExtractIntegers() {
        Heap<Integer> heap = new Heap<>();
        heap.insertar(10);
        heap.insertar(20);
        heap.insertar(5);

        assertEquals(20, heap.extraer());
        assertEquals(10, heap.extraer());
        assertEquals(5, heap.extraer());
    }

    @Test
    public void testHeapWithNegativeNumbers() {
        Heap<Integer> heap = new Heap<>();
        heap.insertar(-10);
        heap.insertar(-20);
        heap.insertar(-5);
        heap.insertar(-30);

        assertEquals(-5, heap.extraer());
        assertEquals(-10, heap.extraer());
        assertEquals(-20, heap.extraer());
        assertEquals(-30, heap.extraer());
    }

    @Test
    public void testHeapWithMixedNumbers() {
        Heap<Integer> heap = new Heap<>();
        heap.insertar(10);
        heap.insertar(-20);
        heap.insertar(5);
        heap.insertar(-30);

        assertEquals(10, heap.extraer());
        assertEquals(5, heap.extraer());
        assertEquals(-20, heap.extraer());
        assertEquals(-30, heap.extraer());
    }

    @Test
    public void testHeapWithDuplicateNumbers() {
        Heap<Integer> heap = new Heap<>();
        heap.insertar(10);
        heap.insertar(10);
        heap.insertar(5);
        heap.insertar(5);

        assertEquals(10, heap.extraer());
        assertEquals(10, heap.extraer());
        assertEquals(5, heap.extraer());
        assertEquals(5, heap.extraer());
    }

    @Test
    public void testHeapSize() {
        Heap<Integer> heap = new Heap<>();
        heap.insertar(10);
        heap.insertar(20);
        heap.insertar(5);

        assertEquals(3, heap.tamaño());
        heap.extraer();
        assertEquals(2, heap.tamaño());
        heap.extraer();
        assertEquals(1, heap.tamaño());
        heap.extraer();
        assertEquals(0, heap.tamaño());
    }

    @Test
    public void testMultipleInsertionsAndExtractions() {
        Heap<Integer> heap = new Heap<>();
        heap.insertar(10);
        heap.insertar(20);
        heap.insertar(5);
        assertEquals(20, heap.extraer());
        heap.insertar(15);
        assertEquals(15, heap.extraer());
        assertEquals(10, heap.extraer());
        assertEquals(5, heap.extraer());
    }

    @Test
    public void testInsertAndExtractStrings() {
        Heap<String> heap = new Heap<>();
        heap.insertar("apple");
        heap.insertar("banana");
        heap.insertar("cherry");

        assertEquals("cherry", heap.extraer());
        assertEquals("banana", heap.extraer());
        assertEquals("apple", heap.extraer());
    }

    @Test
    public void testHeapWithCustomComparator() {
        Comparator<Integer> comparator = (a, b) -> b - a; // Min-heap
        Heap<Integer> heap = new Heap<>(comparator);
        heap.insertar(10);
        heap.insertar(20);
        heap.insertar(5);

        assertEquals(5, heap.extraer());
        assertEquals(10, heap.extraer());
        assertEquals(20, heap.extraer());
    }

    @Test
    public void testHeapWithArrayConstructor() {
        Integer[] array = {10, 20, 5};
        Heap<Integer> heap = new Heap<>(array);

        assertEquals(20, heap.extraer());
        assertEquals(10, heap.extraer());
        assertEquals(5, heap.extraer());
    }

    @Test
    public void testHeapWithArrayAndComparatorConstructor() {
        Integer[] array = {10, 20, 5};
        Comparator<Integer> comparator = (a, b) -> b - a; // Min-heap
        Heap<Integer> heap = new Heap<>(array, comparator);

        assertEquals(5, heap.extraer());
        assertEquals(10, heap.extraer());
        assertEquals(20, heap.extraer());
    }
    @Test
    public void testHeapConstructorWithArrayAndComparator() {
        Integer[] elementos = {4, 1, 7, 3};
        Comparator<Integer> comparador = Integer::compareTo;
        Heap<Integer> heap = new Heap<>(elementos, comparador);

        assertEquals(7, heap.extraer(), "El elemento de mayor prioridad debe ser 7");
        assertEquals(4, heap.extraer(), "El siguiente elemento debe ser 4");
        assertEquals(3, heap.extraer(), "El siguiente elemento debe ser 3");
        assertEquals(1, heap.extraer(), "El siguiente elemento debe ser 1");
    }

    @Test
    public void testHeapProperty(){
        Heap<Integer> heap = new Heap<>();
        for(int i = 1; i < 100; i++){
            heap.insertar(i);
        }
        int anterior = heap.extraer();
        for(int i = 1; i < heap.tamaño(); i++){
            int actual = heap.extraer();
            assertTrue(anterior >= actual);
            anterior = actual;
        }
    }

    @Test
    public void testLargeNumberOfElements() {
        Heap<Integer> heap = new Heap<>();
        for (int i = 0; i < 1000; i++) {
            heap.insertar(i);
        }
        for (int i = 999; i >= 0; i--) {
            assertEquals(i, heap.extraer());
        }
    }

    @Test
    public void testPriorityPrimeMin(){
        PrimoComparatorMin prioridadPrimoMin = new PrimoComparatorMin();
        Heap<Integer> heap = new Heap<>(prioridadPrimoMin);
        heap.insertar(4);
        heap.insertar(5);
        heap.insertar(8);
        heap.insertar(11);
        heap.insertar(15);

        assertEquals(5, heap.extraer());
        assertEquals(11, heap.extraer());
        assertEquals(15,heap.extraer());
        assertEquals(8,heap.extraer());
        assertEquals(4,heap.extraer());
    }

    @Test
    public void testPriorityPrimeMax(){
        PrimoComparatorMax prioridadPrimoMax = new PrimoComparatorMax();
        Heap<Integer> heap = new Heap<>(prioridadPrimoMax);
        heap.insertar(6);
        heap.insertar(20);
        heap.insertar(8);
        heap.insertar(11);
        heap.insertar(3);

        assertEquals(11, heap.extraer());
        assertEquals(3, heap.extraer());
        assertEquals(20, heap.extraer());
        assertEquals(8, heap.extraer());
        assertEquals(6, heap.extraer());
    }

    @Test
    public void testCustomObjects(){
        Comparator<Persona> comparadorPorEdad = Comparator.comparingInt(Persona::getEdad);
        Heap<Persona> heap = new Heap<>(comparadorPorEdad);
        heap.insertar(new Persona("Maria", 18));
        heap.insertar(new Persona("Sol", 23));
        heap.insertar(new Persona("Nahuel", 35));

        assertEquals("Nahuel", heap.extraer().getNombre());
        assertEquals("Sol", heap.extraer().getNombre());
        assertEquals("Maria", heap.extraer().getNombre());
    }

    @Test
    public void testHeapWithProductosByPrecio() {
        Comparator<Producto> comparadorPorPrecio = Comparator.comparingDouble(Producto::getPrecio);
        Heap<Producto> heap = new Heap<>(comparadorPorPrecio);

        heap.insertar(new Producto("Producto A", 10.99));
        heap.insertar(new Producto("Producto B", 5.49));
        heap.insertar(new Producto("Producto C", 20.00));

        assertEquals("Producto C", heap.extraer().getNombre(), "El producto más caro debe ser 'Producto C'");
        assertEquals("Producto A", heap.extraer().getNombre(), "El siguiente producto debe ser 'Producto A'");
        assertEquals("Producto B", heap.extraer().getNombre(), "El siguiente producto debe ser 'Producto B'");
    }

    @Test
    public void testHeapWithComparableObjects() {
        Heap<Tarjeta> heap = new Heap<>();

        heap.insertar(new Tarjeta("1111", 2));
        heap.insertar(new Tarjeta("2222", 5));
        heap.insertar(new Tarjeta("3333", 1));

        assertEquals("2222", heap.extraer().getNumero(), "La tarjeta con mayor prioridad debe ser '2222'");
        assertEquals("1111", heap.extraer().getNumero(), "El siguiente tarjeta debe ser '1111'");
        assertEquals("3333", heap.extraer().getNumero(), "El siguiente tarjeta debe ser '3333'");
    }

    @Test
    public void testHeapEmpleadosComparator() {
        Comparator<Empleado> comparador = new EmpleadoComparator();
        Heap<Empleado> heap = new Heap<>(comparador);
        heap.insertar(new Empleado("Caro", "Ventas", 20));
        heap.insertar(new Empleado("Tute", "Ventas", 21));
        heap.insertar(new Empleado("Delfina", "Recursos Humanos", 21));
        heap.insertar(new Empleado("Nahuel", "Piloto de Formula 1", 28));

        // el testeo del departamento es lexicografica  no confundir con longitud,  "ventas" > "piloto de formula1"
        // si los empleados estan en el mismo depto se comparan por edad, la edad mayor tiene prioridad
        assertEquals("Tute", heap.extraer().getNombre());
        assertEquals("Caro", heap.extraer().getNombre());
        assertEquals("Delfina", heap.extraer().getNombre());
        assertEquals("Nahuel", heap.extraer().getNombre());

    }

    @Test
    public void testUpdatePriorityMutables(){
        Comparator<Contador> contadorComparador = new ContadorComparator();
        Heap<Contador> heap = new Heap<>(contadorComparador);

        Contador contador = new Contador(10);
        Contador contador2 = new Contador(12);

        HeapHandle<Contador> handle1 = heap.insertar(contador);
        HeapHandle<Contador> handle2 = heap.insertar(contador2);

        contador.incrementar();
        contador.incrementar();
        contador.incrementar();
        heap.updatePriority(handle1);
        assertEquals(handle1.getElement(), heap.root());

        contador.decrementar();
        contador.decrementar();
        heap.updatePriority(handle1);
        assertEquals(handle2.getElement(),heap.root());
    }
}