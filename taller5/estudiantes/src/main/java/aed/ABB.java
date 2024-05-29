package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo _raiz;
    private int _cardinal;
    private Nodo nodoActual;
    private int _altura;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor;
        Nodo left;
        Nodo right;
        Nodo padre;
        // Crear Constructor del nodo
        
        Nodo(T v) {
            valor = v;
            left = null;
            right = null;
            padre = null;
        }
    
    }

    public ABB() {
        this._raiz = null;
        this._altura = 0;
        this._cardinal = 0;
    }

    public int cardinal() {
        return this._cardinal;
    }

    public T minimo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public T maximo(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void insertar(T elem){
        
        if(this._raiz == null) {
            Nodo nuevoNodo = new Nodo(elem);
            this._raiz = nuevoNodo;
            this._cardinal += 1;
        }

        if(!pertenece(elem) && elem.compareTo(this.nodoActual.valor) >= 0){
            Nodo nuevoNodo = new Nodo(elem);
            nuevoNodo.padre = this.nodoActual;
            this.nodoActual.right = nuevoNodo;
            this._cardinal += 1;
        }else if(!pertenece(elem) && elem.compareTo(this.nodoActual.valor) < 0) {
            Nodo nuevoNodo = new Nodo(elem);
            nuevoNodo.padre = this.nodoActual;
            this.nodoActual.left = nuevoNodo;
            this._cardinal += 1;
            
        }
        
    }

    public boolean pertenece(T elem){
        this.nodoActual = this._raiz;

        if(nodoActual == null){
            return false;
        } else if (elem.compareTo(nodoActual.valor) == 0){
            return true;
        } else {
            while (elem.compareTo(nodoActual.valor) != 0) {
                if(elem.compareTo(nodoActual.valor) > 0) {
                    
                    if(nodoActual.right == null){
                        return false;
                    }else {
                        nodoActual = this.nodoActual.right;
                        
                    }
                    
                }else {
                    if(nodoActual.left == null){
                        return false;
                    }else{
                        nodoActual = this.nodoActual.left;
                        
                    }
                    
                }
            }
        }
        return this.nodoActual.valor == elem;
       
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
