package aed;
import java.util.ArrayList;

public class Main {
    private static int R = 256; // radix
    public static class Node{
        private Object val;
        private Node[] next = new Node[R];
    }
    


   
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args){
        TrieST<Carrera> carreras = new TrieST<Carrera>();
        TrieST<Alumno> alumnos = new TrieST<Alumno>(); 
        Trie<Alumno> alumnos2 = new Trie<Alumno>();
        String nombre = "nahuel";
        Node g = new Node();




        Alumno a = new Alumno("646/20");
        Alumno b = new Alumno("645/23");

        Materia m = new Materia();
        Carrera z = new Carrera("Ciencias de la Computacion");
        Carrera x = new Carrera("Ciencia de Datos");
       
        alumnos.put(a.getLibreta(), a);
        alumnos2.insert(a.getLibreta(), a);
        m.agregarNombres("Algo 1", z);
        m.agregarNombres("Algo 2", x);

        Alumno p = alumnos.get("646/20");
        String t = p.getLibreta();
        String carrera = m.nombreEnCarrera(x.getNombre());

        alumnos2.delete(a.getLibreta());

        z.agregarMateria(m);
        x.agregarMateria(m);
        System.out.print(carrera);
        
        
    }

}

