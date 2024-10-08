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
        Nodo(T v){
            valor = v;
            siguiente = null;
            anterior = null;
        }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nodo = new Nodo(elem);
        nodo.siguiente = primero;
        longitud += 1;
        if (longitud == 1) {
            primero = nodo;
            ultimo = nodo;
        } else {
           primero.anterior = nodo;
        }
        primero = nodo;
    }

    public void agregarAtras(T elem) {
        Nodo nodo = new Nodo(elem);
        nodo.anterior = ultimo;
        longitud += 1;
        if (longitud == 1) {
            primero = nodo;
            ultimo = nodo;
        } else {
            ultimo.siguiente = nodo;
        }
        ultimo = nodo;
    }

    public T obtener(int i) {
        Nodo obtener = primero;
        for (int j = 0; j < i; j++) {
            obtener = obtener.siguiente;
        }
        return obtener.valor;
    }

    public void eliminar(int i) {
        Nodo eliminar = primero;
        for (int j = 0; j < i; j++) {
            eliminar = eliminar.siguiente;
        }
        if (eliminar.anterior != null && eliminar.siguiente != null) {
            eliminar.anterior.siguiente = eliminar.siguiente;
            eliminar.siguiente.anterior = eliminar.anterior;
            longitud -= 1;
        } else if (eliminar.anterior == null && eliminar.siguiente != null) {
            primero = eliminar.siguiente;
            primero.anterior = null;
            longitud -= 1;
        } else if (eliminar.anterior != null && eliminar.siguiente == null) {
            ultimo = eliminar.anterior;
            ultimo.siguiente = null;
            longitud -= 1;
        } else {
            primero = null;
            ultimo = null;
            longitud -= 1;
        }
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo cambiar = primero;
        for (int i = 0; i < indice; i++) {
            cambiar = cambiar.siguiente;
        }
        cambiar.valor = elem;
    }


    public ListaEnlazada(ListaEnlazada<T> lista) {
        for(int j = 0; j < lista.longitud; j++){
            agregarAtras(lista.obtener(j));
        }
    }
    
    @Override
    public String toString() {
        String mensaje = "[";
        for (int i = 0; i < longitud; i++) {
            if (i != longitud - 1) {
                mensaje += obtener(i).toString() + ", ";
            } else {
                mensaje += obtener(i).toString() + "]";
            }
        }
        return mensaje;
    }

    private class ListaIterador implements Iterador<T> {
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
                iterador = ultimo;
                return iterador.valor;
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
