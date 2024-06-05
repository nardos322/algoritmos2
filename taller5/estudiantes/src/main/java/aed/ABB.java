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

    public Nodo sucesor(Nodo nodo) {
        // Si el nodo tiene un hijo right, entonces el sucesor es el nodo más a la izquierda en el subárbol right
        if (nodo.right != null) {
            return encontrarMinimo(nodo.right);
        }

        // Si no tiene hijo right, subimos por el árbol hasta encontrar un ancestro que sea hijo izquierdo de su padre
        Nodo padre = nodo.padre;
        while (padre != null && nodo == padre.right) {
            nodo = padre;
            padre = padre.padre;
        }

        return padre;
    }
    public Nodo encontrarMinimo(Nodo nodo) {
        Nodo minimo = nodo;
        while (minimo.left != null) {
            minimo = minimo.left;
        }
        return minimo;
    }

    public void eliminar(T elem){
    

        if(pertenece(elem) && this.nodoActual.left == null && this.nodoActual.right == null){
          if(this._raiz == nodoActual){
            this._raiz = null;
            this._cardinal -= 1;
          }else{    
            if(nodoActual.padre.left == nodoActual){
                nodoActual = nodoActual.padre;
                nodoActual.left = null;
                this._cardinal -= 1;
            }  else {
                nodoActual = nodoActual.padre;
                nodoActual.right = null;
                this._cardinal -= 1;
            }
            
          }
        } else if(pertenece(elem) && (nodoActual.left != null && nodoActual.right == null)){
            if(nodoActual == this._raiz) {
                this._raiz = this.nodoActual.left;
                this._raiz.padre = null;
                this._cardinal -= 1;
            }else{
                Nodo conectar = nodoActual.left;
                if(nodoActual.padre.left == nodoActual){
                    nodoActual.padre.left = conectar;
                    conectar.padre = nodoActual.padre;
                    this._cardinal -= 1;
                }else if(nodoActual.padre.right == nodoActual){
                    nodoActual.padre.right = conectar;
                    conectar.padre = nodoActual.padre;
                    this._cardinal -= 1;
                }
            }
           
        } else if(pertenece(elem) && nodoActual.left == null && nodoActual.right != null){
            if(nodoActual == this._raiz){
                this._raiz = this.nodoActual.right;
                this._raiz.padre = null;
                this._cardinal -= 1;
            }else{
                Nodo conectar = nodoActual.right;
                if(nodoActual.padre.left == nodoActual){
                    nodoActual.padre.left = conectar;
                    conectar.padre = nodoActual.padre;
                    this._cardinal -= 1;
                }else if(nodoActual.padre.right == nodoActual){
                    nodoActual.padre.right = conectar;
                    conectar.padre = nodoActual.padre;
                    this._cardinal -= 1;
                }

            }
          
        }else if (pertenece(elem) && nodoActual.left != null && nodoActual.right != null){
            Nodo subArbolDerechoMin = this.nodoActual.right;
            while(subArbolDerechoMin.left != null){
                subArbolDerechoMin = encontrarMinimo(subArbolDerechoMin.left);
               
            }
            nodoActual.valor = subArbolDerechoMin.valor;
            if(subArbolDerechoMin.right == null &&  subArbolDerechoMin.padre.left == subArbolDerechoMin){
                subArbolDerechoMin.padre.left = null;
            }else if(subArbolDerechoMin.right == null && subArbolDerechoMin.padre.right == subArbolDerechoMin){
                subArbolDerechoMin.padre.right = null;

            } else if(subArbolDerechoMin.right != null){
                Nodo conectar = subArbolDerechoMin.right;
                if(subArbolDerechoMin.padre.right == subArbolDerechoMin){
                    subArbolDerechoMin.padre.right = conectar;
                    conectar.padre = subArbolDerechoMin.padre;
                }else if(subArbolDerechoMin.padre.left == subArbolDerechoMin){
                    subArbolDerechoMin.padre.left = conectar;
                    conectar.padre = subArbolDerechoMin.padre;
                }
            }
            
            this._cardinal -= 1;

           

        }
    
    }   
    public String toString(){
        String mensaje = "{";
        Nodo actual = encontrarMinimo(_raiz);
        int i = 0;
        while(i < _cardinal ){
            if(i == _cardinal - 1){
                mensaje += actual.valor+"}";
                i++;
            }else{
                mensaje += actual.valor + ",";
                actual = sucesor(actual);
            
                i++;
            }
            
        }
        
        return mensaje;
    
      
        
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;
        private boolean pasamosMin;
        ABB_Iterador(){
            _actual = _raiz;
            pasamosMin = false;
            while(_actual.left != null){
                _actual = _actual.left;
            }
        }
        public boolean haySiguiente() {            
            if (_actual == maximo()){
                return true;
            } else {
                return false;
            }
        }
    
        public T siguiente() {
            
            if(_actual.valor == minimo() && pasamosMin == false){
                pasamosMin = true;
                return minimo();
            }
            else if (_actual.valor == minimo()){
                if (_actual.left != null){
                    while(_actual.right != null){
                        _actual = _actual.right;
                    }
                } else {
                    Nodo tmp = _actual;
                    _actual = _actual.padre;
                    while(tmp.valor.compareTo(_actual.valor) > 0){
                        _actual = _actual.padre;
                    }
                }
                return _actual.valor;
            }
            
            else if(_actual == _raiz){
                _actual = _actual.right;
                while (_actual.left != null){
                    _actual = _actual.left;
                }
                return _actual.valor;
            }
            else {
               
                if (_actual.left != null){
                    _actual = _actual.right;
                    while(_actual.left != null){
                        _actual = _actual.left;
                    }}
                else {
                    Nodo tmp = _actual;
                    _actual = _actual.padre;
                    while(tmp.valor.compareTo(_actual.valor) > 0){
                        _actual = _actual.padre;
                    }
                }
                return _actual.valor;
                }
            }
    }

    

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
