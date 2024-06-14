package aed;

public class Alumno {
    private int cantidadMateriasInscripto;
    private String libreta;
    
    public Alumno(String libreta){
        this.cantidadMateriasInscripto = 0;
        this.libreta = libreta;
    }

    public String getLibreta(){
        return libreta;
    }

    public int getCantidadMaterias(){
        return cantidadMateriasInscripto;
    }

    public void incribrirMateria(){
        cantidadMateriasInscripto += 1;
    }
    
}
