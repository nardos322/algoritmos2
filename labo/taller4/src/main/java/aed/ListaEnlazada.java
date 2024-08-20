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
        this.primero = null;
        this.ultimo = null;
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
        } else {
            this.primero.anterior = nuevo;
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

            this.longitud -=1;
        } else if(nodoActual.anterior == null && nodoActual.siguiente != null) {
            this.primero = nodoActual.siguiente;
            this.primero.anterior = null;
           
            this.longitud -=1;
        } else if (nodoActual.anterior != null && nodoActual.siguiente == null) {
            this.ultimo = nodoActual.anterior;
            this.ultimo.siguiente = null;
           
            this.longitud -=1;
        } else {
            this.primero = null;
            this.ultimo = null;
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
        ListaEnlazada<T> listaCopia = new ListaEnlazada<>();
       
        for(int j = 0; j < this.longitud; j++){
            listaCopia.agregarAtras(this.obtener(j));
           
        }
        
        return listaCopia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        for(int j = 0; j < lista.longitud; j++){
            this.agregarAtras(lista.obtener(j));
        }

    }
    
    @Override
    public String toString() {
        String mensaje = "[";
        for(int j = 0; j < this.longitud; j++){
            
            if(j != this.longitud - 1){
                mensaje += this.obtener(j).toString() + ", ";
            } else {
                mensaje += this.obtener(j).toString() + "]";
            }
        }
        
       
        return mensaje;
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados
        private Nodo iterador;
        
        ListaIterador(){
           this.iterador = primero;
        }

        public boolean haySiguiente() {
            if(longitud == 0){
                return false;
            }
            if(iterador == ultimo){
        
                return iterador != null;
            }else if( iterador == null){
                return false;
            }else {
                return iterador.siguiente != null;
            }
        
            
        
        
	        
        }
        
        public boolean hayAnterior() {
            if(longitud == 0){
                return false;
            }
            if(iterador == null){
                return ultimo.anterior != null;
            } else {
                return iterador.anterior != null;
            }
	        
        }

        public T siguiente() {
            T valor = iterador.valor;
	        iterador = iterador.siguiente;
            
            return valor;
        }
        

        public T anterior() {
	        
           
            if (iterador == null) {
                return ultimo.valor;
            }else{
                iterador = iterador.anterior;
                return iterador.valor;
            }
            
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

  

}
