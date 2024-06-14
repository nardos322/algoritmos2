package aed;
import java.util.ArrayList;

public class Trie<T>{

    private Nodo root;
    private int size;


    private class Nodo {
        // Array de nodos hijos para 256 caracteres
        ArrayList<Nodo> children;
        T definicion;
        // Marca si este nodo es el final de una palabra
      
    
        // Constructor
        public Nodo() {
            // Inicializamos el ArrayList con capacidad 256
            children = new ArrayList<>(256);
            // Llenamos el ArrayList con valores nulos
            for (int i = 0; i < 256; i++) {
                children.add(null);
            }
    
            
        }
    }

   
    // Constructor
    public Trie() {
        root = new Nodo();
        this.size = 0;
    }

    // Método para insertar una palabra en el trie
    public void insert(String key, T value) {
        
        Nodo node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i);
        
            if (node.children.get(index) == null) {
                node.children.set(index, new Nodo());
            }   
            node = node.children.get(index); 
        }
        node.definicion = value;
        size += 1;

       
    }

    public T get(String key){
        Nodo node = root;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i);
            if(node.children.get(index) == null){
                return null;
            }
            node = node.children.get(index);
        }
        if(node.definicion != null){
            return node.definicion;
        } else {
            return null;
        }
    }

   
    public void delete(String key){

        Nodo node = root;
        
        for(int i = 0; i < key.length(); i++){
            
            char index = key.charAt(i);
            System.out.print(index);
            
            
        }

        
        

        
        
        
        
    }
    

}