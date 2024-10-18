package aed;

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
        longitud += 1;
        if (primero == null && ultimo == null) {
            primero = nodo;
            ultimo = nodo;
        } else {
            nodo.siguiente = primero;
            primero.anterior = nodo;
            primero = nodo;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nodo = new Nodo(elem);
        longitud += 1;
        if (primero == null && ultimo == null) {
            primero = nodo;
            ultimo = nodo;
        } else {
           nodo.anterior = ultimo;
           ultimo.siguiente = nodo;
           ultimo = nodo;
        }

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
        longitud -= 1;
        for (int j = 0; j < i; j++) {
            eliminar = eliminar.siguiente;
        }
        if (primero == ultimo) {
            primero = null;
            ultimo = null;
        }
        else if (eliminar == primero) {
            primero = eliminar.siguiente;
            primero.anterior = null;
        } else if (eliminar == ultimo) {
            ultimo = eliminar.anterior;
            ultimo.siguiente = null;
        } else {
            eliminar.anterior.siguiente = eliminar.siguiente;
            eliminar.siguiente.anterior = eliminar.anterior;
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
            iterador = primero;
        }
        public boolean haySiguiente() {
            if(longitud == 0) {
                return false;
            }
            if(iterador == ultimo) {
                return true;
            }
            return iterador != null && iterador.siguiente != null;
        }

        public boolean hayAnterior() {
            if(longitud == 0) {
                return false;
            }
            if (iterador == null) {
                return true;
            }
            return  iterador != null && iterador.anterior != null;
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
            } else {
                iterador = iterador.anterior;
                return iterador.valor;
            }
        }

    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
