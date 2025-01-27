package aed;


import java.util.Iterator;

public class LinkedListQueue<T> implements Iterable<T>{
    private ListaEnlazada<T> elementos;

    public LinkedListQueue(){
        elementos = new ListaEnlazada<>();
    }

    public void encolar(T e){
        elementos.agregarAtras(e);
    }

    public T desencolar() {
        if(vacia()) {
            throw new IllegalStateException("la cola esta vacia");
        }
        T elemento = elementos.primero();
        elementos.eliminar(0);
        return  elemento;
    }

    public T proximo(){
        if(vacia()) {
            throw new IllegalStateException("la cola esta vacia");
        }
        return elementos.primero();
    }

    public boolean vacia() {
        return elementos.vacia();
    }

    public String toString(){
        return elementos.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return elementos.iterator();
    }
}
