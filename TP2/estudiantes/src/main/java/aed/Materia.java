package aed;
import java.util.ArrayList;



public class Materia {
    private int cantidadInscriptos;
    private int[] docentes;
    private ArrayList<Tupla<String,Carrera>> nombresAlternativos;


    public Materia(){
        this.cantidadInscriptos = 0;
        this.nombresAlternativos = new ArrayList<Tupla<String,Carrera>>();
        this.docentes = new int[]{0, 0, 0, 0};
    }

    public void agregarNombres(String nombre, Carrera carrera){
        nombresAlternativos.add(new Tupla<String,Carrera>(nombre, carrera));
    }

    public String nombreEnCarrera(String carrera){
        for (Tupla<String,Carrera> i : nombresAlternativos){
            if (i.carrera.getNombre().equals(carrera)){
                return i.nombre;
            }
        }
        //devuelvo error porque algo tengo que poner
        throw new UnsupportedOperationException("La carrera no tiene esta materia");
    }

    
}
