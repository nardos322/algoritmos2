package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz;
    private int cardinal;


    private class Nodo {
        T valor;
        Nodo left;
        Nodo right;
        Nodo padre;

        Nodo(T v) {
            valor = v;
            left = null;
            right = null;
            padre  = null;
        }
    }

    public ABB() {
        raiz = null;
        cardinal = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        Nodo minimo = encontrarMinimo(raiz);
        return minimo.valor;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
       if(nodo.left == null){
           return nodo;
       }
       return encontrarMinimo(nodo.left);
    }

    private Nodo encontrarMaximo(Nodo nodo) {
        if(nodo.right == null){
            return nodo;
        }
        return encontrarMaximo(nodo.right);
    }

    public T maximo(){
        Nodo maximo = encontrarMaximo(raiz);
        return maximo.valor;
    }

    private Nodo insertar (Nodo nodo, T valor){
        if(nodo == null){
            return new Nodo(valor);
        }

        if(valor.compareTo(nodo.valor) < 0) {
            nodo.left = insertar(nodo.left, valor);
        } else if (valor.compareTo(nodo.valor) > 0) {
            nodo.right = insertar(nodo.right, valor);
        }
        return nodo;
    }
    public void insertar(T elem){
        if(!pertenece(elem)){
            raiz = insertar(raiz, elem);
            cardinal += 1;
        }

    }

    private boolean busquedaRecursiva(Nodo nodo, T elem) {
        if(nodo == null) {
            return false;
        }
        if(elem.compareTo(nodo.valor) == 0) {
            return true;
        }
        if(elem.compareTo(nodo.valor) < 0) {
            return busquedaRecursiva(nodo.left, elem);
        }
        return busquedaRecursiva(nodo.right, elem);
    }
    public boolean pertenece(T elem){
        return busquedaRecursiva(raiz, elem);
    }

    private Nodo sucesorRecursivo(Nodo actual, Nodo nodo, Nodo sucesor ){
        if(actual == null) {
            return sucesor;
        }
        if(nodo.valor.compareTo(actual.valor) < 0) {
            sucesor = actual;
            return sucesorRecursivo(actual.left, nodo, sucesor);
        } else if (nodo.valor.compareTo(actual.valor) > 0) {
            return sucesorRecursivo(actual.right, nodo, sucesor);
        } else {
            if(actual.right != null){
                return encontrarMinimo(actual.right);
            } else {
                return sucesor;
            }
        }
    }

    private Nodo sucesor(Nodo nodo) {
        return sucesorRecursivo(raiz, nodo, null);
    }
    private Nodo eliminarRecursivo(Nodo actual, T valor ) {
      if(actual == null) {
          // nodo no encontrado
          return null;
      }

      //Buscamos el nodo que queremos eliminar
      if(valor.compareTo(actual.valor) < 0) {
          actual.left = eliminarRecursivo(actual.left, valor);
      } else if (valor.compareTo(actual.valor) > 0) {
          actual.right = eliminarRecursivo(actual.right, valor);
      } else {
          //nodo encontrado se procede a eliminar
          //caso 1: Nodo sin hijos
          if(actual.left == null && actual.right == null) {
              return null;
          }
          //Caso 2: Nodo con 1 hijo
          else if (actual.left == null) {
              return actual.right;
          } else if (actual.right == null) {
              return actual.left;
          }
          //Caso 3: Modo con 2 hijos
          else {
              //Encontramos sucesor
              Nodo sucesor = sucesor(actual);
              actual.valor = sucesor.valor;
              //eliminamos el sucesor
              actual.right = eliminarRecursivo(actual.right, sucesor.valor);
          }
      }
      return actual;
    }
    public void eliminar(T elem){
        cardinal -= 1;
        raiz = eliminarRecursivo(raiz, elem);
    }

    private String toStringRecursivo(Nodo nodo) {
        StringBuilder arbol = new StringBuilder();
        if(cardinal == 1) {
            return arbol.append(nodo.valor).append("}").toString();
        }
        else if(sucesor(nodo) == null){
            return nodo.valor + "}";
        } else {
            arbol.append(nodo.valor).append(",").append(toStringRecursivo(sucesor(nodo)));

        }
        return arbol.toString();

    }
    public String toString(){
        if(cardinal == 0) {
            return "{}";
        }
        Nodo minimo = encontrarMinimo(raiz);
        return "{"+ toStringRecursivo(minimo);

    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual = encontrarMinimo(raiz);

        public boolean haySiguiente() {            
            return sucesor(_actual) != null;
        }
    
        public T siguiente() {
            T valor = _actual.valor;
            _actual = sucesor(_actual);
            return valor;

        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
