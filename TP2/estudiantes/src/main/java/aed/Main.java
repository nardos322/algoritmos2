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
        Materia m = new Materia();
        Carrera z = new Carrera("Ciencias de la Computacion");
        Carrera x = new Carrera("Ciencia de Datos");
       
        
        m.agregarNombres("Algo 1", z);
        m.agregarNombres("Algo 2", x);

        
        String carrera = m.nombreEnCarrera(x.getNombre());

        z.agregarMateria(m);
        x.agregarMateria(m);
        System.out.print(carrera);
        
        
    }

}

