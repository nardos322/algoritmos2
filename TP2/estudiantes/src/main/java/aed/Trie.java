package aed;
import java.util.ArrayList;

public class Trie<T>{

    private Nodo root;
    private int size;


    private static class Nodo {
        // Array de nodos hijos para 256 caracteres
       // ArrayList<Nodo> children;
        Nodo[] children = new Nodo[256];
        Object definicion;
        // Marca si este nodo es el final de una palabra

       
    }

   
    // Constructor
    public Trie() {
        this.size = 0;
    }

    public void insert(String key, T value){
        if(root == null) {
            root = new Nodo();
        }

        Nodo nodo = root;

        for(int i = 0; i < key.length(); i++){
            char index = key.charAt(i);
            if(nodo.children[index] == null){
                nodo.children[index] = new Nodo();
            }

            nodo =  nodo.children[index];
        }

        nodo.definicion = value;
        size += 1;
    }

    // Método para insertar una palabra en el trie
    // public void insert(String key, T value) {
        
    //     Nodo node = root;
    //     for (int i = 0; i < key.length(); i++) {
    //         char index = key.charAt(i);
        
    //         if (node.children.get(index) == null) {
    //             node.children.set(index, new Nodo());
    //         }   
    //         node = node.children.get(index); 
    //     }
    //     node.definicion = value;
    //     size += 1;

       
    // }

    public T get(String key){
        Nodo nodo = root;
        for(int i = 0; i < key.length(); i++){
            char index = key.charAt(i);
            if(nodo.children[index] == null){
                return null;
            }
            nodo = nodo.children[index];
        }
        if(nodo.definicion != null){
            return  (T) nodo.definicion;
        } else {
            return null;
        }
    }

   
    // public void delete(String key) { 
    //     root = delete(root, key, 0); 
    //     size -= 1;
   
    // }
    // private Nodo delete(Nodo x, String key, int d) {
    //     Nodo nodo;
    //     if (x == null) return null;
    //     if (d == key.length())
    //         x.definicion = null;
    //     else {
    //         char c = key.charAt(d);
    //         nodo =  x.children.get(c);
    //         nodo = delete(nodo, key, d+1);
    //     }
    //     if (x.definicion != null) return x;
    //     for (char c = 0; c < 256; c++)
    //         if (x.children.get(c) != null) return x;
    //     return null;
    // }

    

}