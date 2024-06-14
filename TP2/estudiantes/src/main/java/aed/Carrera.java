package aed;

public class Carrera {
    private String nombre;
    private Trie<Materia> materias;

    public Carrera(String nombre) {
        this.nombre = nombre;
        this.materias = new Trie<Materia>();
    }

    public String getNombre(){
        return nombre;
    }

    public void agregarMateria(Materia materia){
        this.materias.insert(materia.nombreEnCarrera(nombre), materia);
    }
}