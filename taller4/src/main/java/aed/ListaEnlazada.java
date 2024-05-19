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
        this.longitud += 1;
        if(longitud == 1){
            this.primero = nuevo;
            this.ultimo = nuevo;
        }
        this.primero = nuevo;
        
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
        
        for (int j=0; j < i; j++){ 
            nodoActual = nodoActual.siguiente;

       }
       return nodoActual.valor;

    }

    public void eliminar(int i) {
        
        Nodo nodoActual = this.primero;
       
        for(int j = 0; j < i; j++){
            nodoActual = nodoActual.siguiente;
        }
       
        if(nodoActual.anterior != null && nodoActual.siguiente != null){
            nodoActual.anterior.siguiente = nodoActual.siguiente;
            nodoActual.siguiente.anterior = nodoActual.anterior;
            nodoActual.anterior = null;
            nodoActual.siguiente = null;
            this.longitud -=1;
        } else if(nodoActual.anterior == null && nodoActual.siguiente != null) {
            this.primero = nodoActual.siguiente;
            this.primero.anterior = null;
            nodoActual.anterior = null;
            nodoActual.siguiente = null;
            this.longitud -=1;
        } else if (nodoActual.anterior != null && nodoActual.siguiente == null) {
            this.ultimo = nodoActual.anterior;
            this.ultimo.siguiente = null;
            nodoActual.anterior = null;
            nodoActual.siguiente = null;
            this.longitud -=1;
        } else {
            this.primero = null;
            this.ultimo = null;
            nodoActual.anterior = null;
            nodoActual.siguiente = null;
            this.longitud -=1;
        }
        
       
        
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nodoCambiarValor = this.primero;
        for(int j = 0; j < indice; j++){
            nodoCambiarValor = nodoCambiarValor.siguiente;
        }
        nodoCambiarValor.valor = elem;
    
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

  

}
