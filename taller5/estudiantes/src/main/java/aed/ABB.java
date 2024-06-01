package aed;
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2

public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo _raiz;
    private int _cardinal;
    private Nodo nodoActual;


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
        this._cardinal = 0;
    }

    public int cardinal() {
        return this._cardinal;
    }

    public T minimo(){
        Nodo minimo = this._raiz;
        if(this._cardinal == 1){
            return minimo.valor;
        }else{
            while(minimo.left != null){
                minimo = minimo.left;
            }
        }
        return minimo.valor;
    }

    public T maximo(){
        Nodo maximo = this._raiz;
        if(this._cardinal == 1){
            return maximo.valor;
        }else{
            while(maximo.right != null){
                maximo = maximo.right;
            }
        }
        return maximo.valor;
    }

    public void insertar(T elem){
        
        if(this._raiz == null) {
            Nodo nuevoNodo = new Nodo(elem);
            this._raiz = nuevoNodo;
            this._cardinal += 1;
        }

        if(!pertenece(elem) && elem.compareTo(this.nodoActual.valor) > 0){
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
                    
                }else if (elem.compareTo(nodoActual.valor) < 0) {
                    if(nodoActual.left == null){
                        return false;
                    }else{
                        nodoActual = this.nodoActual.left;
                        
                    }
                    
                }
            }
        }
        return elem.compareTo(nodoActual.valor) == 0;
       
    }

    public void eliminar(T elem){
        if(pertenece(elem) && this.nodoActual.left == null && this.nodoActual.right == null){
            this.nodoActual = this.nodoActual.padre;
            if(nodoActual.left != null){
                nodoActual.left = null;
            }else{
                nodoActual.right = null;
            }
            this._cardinal -= 1;
            if(this._cardinal == 0){
                this._raiz = null;
            }else{
                if(this._raiz.left != null && this._raiz.right == null){
                    this._raiz.left = nodoActual;
                }
            }
        } else if(pertenece(elem) && (nodoActual.left != null && nodoActual.right == null)){
            if(nodoActual == this._raiz) {
                this._raiz = this.nodoActual.left;
                this._cardinal -= 1;
            }else{
                this.nodoActual.valor = this.nodoActual.left.valor;
                nodoActual.left = null;
                this._cardinal -= 1;
            }
           
        } else if(pertenece(elem) && nodoActual.left == null && nodoActual.right != null){
            this.nodoActual.valor = this.nodoActual.right.valor;
            nodoActual.right = null;
            this._cardinal -= 1;
        }else if (pertenece(elem) && nodoActual.left != null && nodoActual.right != null){
            Nodo subArbolDerechoMin = this.nodoActual.right;
            while(subArbolDerechoMin.left != null){
                subArbolDerechoMin = subArbolDerechoMin.left;
               
            }
            this.nodoActual.valor = subArbolDerechoMin.valor;
            this.nodoActual.right = null;
            
            this._cardinal -= 1;

        }
    
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
