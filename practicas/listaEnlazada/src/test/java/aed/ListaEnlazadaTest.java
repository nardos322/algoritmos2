package aed;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ListaEnlazadaTest {

    @Test
    public void testAgregarAdelante() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAdelante(1);
        lista.agregarAdelante(2);
        assertEquals(2, lista.primero());
        assertEquals(1, lista.ultimo());
    }

    @Test
    public void testAgregarAtras() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAtras(1);
        lista.agregarAtras(2);
        assertEquals(1, lista.primero());
        assertEquals(2, lista.ultimo());
    }

    @Test
    public void testObtener() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAdelante(1);
        lista.agregarAdelante(2);
        assertEquals(1, lista.obtener(1));
        assertEquals(2, lista.obtener(0));
    }

    @Test
    public void testEliminar() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAdelante(1);
        lista.agregarAdelante(2);
        lista.eliminar(0);
        assertEquals(1, lista.primero());
        assertEquals(1, lista.longitud());
    }

    @Test
    public void testModificarPosicion() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAdelante(1);
        lista.agregarAdelante(2);
        lista.modificarPosicion(0, 3);
        assertEquals(3, lista.primero());
    }

    @Test
    public void testIterador() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAdelante(1);
        lista.agregarAdelante(2);
        Iterator<Integer> iterador = lista.iterator();
        assertTrue(iterador.hasNext());
        assertEquals(2, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(1, iterador.next());
        assertFalse(iterador.hasNext());
    }
}