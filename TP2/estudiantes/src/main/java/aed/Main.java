package aed;
import java.util.ArrayList;

public class Main {
    private static int R = 256; // radix
    public static class Node{
        private Object val;
        private Node[] next = new Node[R];
    }
    
    private static class Nodo<T> {
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

    public static int suma(int a, int b) {
        return a + b;
    }

    public static int factorial(int n) {
        if(n == 0){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static int arraySearch(int[] arr, int x){
        return arraySearch1(arr, 0,x);
    }

    public static int arraySearch1(int[] arr, int n, int x){
        if(n == arr.length) {
            return -1;
        }
        if(arr[n] == x){
            return n;
        }else{
            return arraySearch1(arr, n+1, x);
        }

    }

   
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args){
        TrieST<Carrera> carreras = new TrieST<Carrera>();
        ArrayList<Node> a1 = new ArrayList<>(6);
        TrieST<Alumno> alumnos = new TrieST<Alumno>(); 
        Trie<Alumno> alumnos2 = new Trie<Alumno>();
        char[] numeros = new char[256];
        String nombre = "nahuel";
        Node g = new Node();
        Nodo g1 = new Nodo();
        Alumno a2 = new Alumno("646/20");
        ArrayList t1 = new ArrayList<>();

        Alumno copia = a2;

        a2.incribrirMateria();
      
        int[] k = {10,5,3,4};

        int res = arraySearch(k,0);
        
        System.out.print(res);
        
        

        // alumnos.put(a2.getLibreta(), a2);
        alumnos.put("123", new Alumno("123"));
        alumnos.put("124",new Alumno("124"));
     
        alumnos2.insert("123", new Alumno("123"));
        alumnos2.insert("124", new Alumno("124"));
        // alumnos2.delete(a2.getLibreta());
        
        Alumno id = alumnos.get("123");
        System.out.print(id);
        // System.out.print(g.next[0] == null);

        

   
        
    }

}

