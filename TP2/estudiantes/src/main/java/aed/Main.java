package aed;
import java.util.ArrayList;

public class Main {
    
    public static class Nodo<T>{
        ArrayList<Nodo> siguientes;
        T definicion;
        Nodo(){
            definicion = null;
            siguientes = new ArrayList<>();
        }


    }


   
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args){
     
        Trie n = new Trie();

        n.insert("hola",0);
        n.insert("hooz",1);
        n.insert("h", 2);
        n.insert("Ciencias de la Computacion", 2);

        System.out.println(n.get("Ciencias de la Computacion"));
      
       
        
    }

}

