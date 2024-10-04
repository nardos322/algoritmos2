package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return new Fecha(fecha);
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje +" @ "+ this.fecha +" "+ this.horario;
    }

    @Override
    public boolean equals(Object otro) {
        boolean esNull = (otro == null);
        boolean claseDistinta = otro.getClass() != this.getClass();

        if(esNull || claseDistinta ){
            return false;
        }
        Recordatorio otroRecordatorio = (Recordatorio) otro;

        return this.mensaje.equals(otroRecordatorio.mensaje) &&
                this.fecha.equals(otroRecordatorio.fecha) && this.horario.equals(otroRecordatorio.horario) ;
    }


}
