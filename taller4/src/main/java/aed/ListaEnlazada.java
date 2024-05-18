package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
   private Nodo primero;
   private Nodo ultimo;
   private int longitud;

    
   private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo anterior;

        Nodo(T v)   {   valor = v;
                        siguiente = null;
                        anterior = null; 
                    }


    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        nuevo.siguiente = this.primero;
        this.primero = nuevo;
        this.longitud += 1;
        
        
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo (elem);
        
        nuevo.anterior = this.ultimo;
        
        this.longitud += 1;
        if(longitud == 1){
            this.primero = nuevo;
            this.ultimo = nuevo;
            
        } else {
            this.ultimo.siguiente = nuevo;
        }
        this.ultimo = nuevo;
    }

    public T obtener(int i) {
        Nodo nodoActual = this.primero;
        Nodo nodoSiguiente = nodoActual.siguiente;
        for (int j=0; j < i; j++){ 
            nodoActual = nodoSiguiente;
            nodoSiguiente = nodoSiguiente.siguiente;
       }
       return nodoActual.valor;

    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        System.out.println(lista);
    }

}
