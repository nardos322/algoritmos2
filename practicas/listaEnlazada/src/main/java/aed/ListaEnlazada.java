package aed;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<T> implements Iterable<T>{
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int longitud;


    private static class Nodo <T> {
        T valor;
        Nodo<T> siguiente;

        public Nodo(T v) {
            valor = v;
            siguiente = null;
        }
    }

    public ListaEnlazada(){
        primero = null;
        ultimo = null;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo<T> agregar = new Nodo(elem);
        if(longitud == 0) {
            primero = agregar;
            ultimo = agregar;
        } else {
            agregar.siguiente = primero;
            primero = agregar;
        }
        longitud += 1;
    }

    public void agregarAtras(T elem) {
        Nodo<T> agregar = new Nodo(elem);
        if (longitud == 0) {
            primero = agregar;
            ultimo = agregar;
        } else {
            ultimo.siguiente = agregar;
            ultimo = agregar;
        }
        longitud += 1;
    }

    public T obtener(int i) {
        Nodo<T> obtener = primero;
        int j = 0;
        while(j < i) {
            obtener = obtener.siguiente;
            j += 1;
        }
        return obtener.valor;
    }

    public void eliminar(int i) {
        Nodo<T> eliminar = primero;
        int j = 0;
        while(j < i) {
            eliminar = eliminar.siguiente;
            j ++;
        }
        if (longitud == 1) {
            primero = null;
            ultimo = null;
        } else if (eliminar == primero) {
            primero = eliminar.siguiente;
        } else {
            Nodo<T> anterior = primero;
            int k = 0;
            while (k < i - 1) {
                anterior = anterior.siguiente;
                k++;
            }
            if (eliminar == ultimo) {
                ultimo = anterior;
                ultimo.siguiente = null;
            } else {
                anterior.siguiente = eliminar.siguiente;
            }
            eliminar.siguiente = null;
            eliminar = null;
        }
        longitud--;
    }
    public void modificarPosicion(int indice, T elem) {
        Nodo<T> cambiar = primero;
        int i = 0;
        while(i < indice) {
            cambiar = cambiar.siguiente;
            i++;
        }
        cambiar.valor = elem;
    }
    public T ultimo(){
        return ultimo.valor;
    }

    public T primero(){
        return primero.valor;
    }

    public String toString() {
        if (longitud == 0) {
            return "[]";
        }
        StringBuilder mensaje = new StringBuilder("[");
        for (int i = 0; i < longitud; i++) {
            if (i != longitud - 1) {
                mensaje.append(obtener(i).toString()).append(", ");
            } else {
                mensaje.append(obtener(i).toString()).append("]");
            }
        }
        return mensaje.toString();
    }

    public Iterator<T> iterator() {
        return new ListaIterador();
    }

    private class ListaIterador implements Iterator<T> {
        private Nodo<T> actual = primero;
        public ListaIterador(){
            actual = primero;
        }
        public boolean hasNext() {
            return actual != null;
        }

        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T valor = actual.valor;
            actual = actual.siguiente;
            return valor;
        }
    }

}
