package aed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListQueueTest {

    @Test
    public void testEncolar() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.encolar(1);
        assertFalse(queue.vacia());
        assertEquals(1, queue.proximo());
    }

    @Test
    public void testDesencolar() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.encolar(1);
        queue.encolar(2);
        assertEquals(1, queue.desencolar());
        assertEquals(2, queue.proximo());
    }

    @Test
    public void testProximo() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.encolar(1);
        assertEquals(1, queue.proximo());
    }

    @Test
    public void testVacia() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        assertTrue(queue.vacia());
        queue.encolar(1);
        assertFalse(queue.vacia());
    }

    @Test
    public void testToString() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.encolar(1);
        queue.encolar(2);
        assertEquals("[1, 2]", queue.toString());
    }

    @Test
    public void testDesencolarEmptyQueue() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        Exception exception = assertThrows(IllegalStateException.class, queue::desencolar);
        assertEquals("la cola esta vacia", exception.getMessage());
    }

    @Test
    public void testProximoEmptyQueue() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        Exception exception = assertThrows(IllegalStateException.class, queue::proximo);
        assertEquals("la cola esta vacia", exception.getMessage());
    }
}