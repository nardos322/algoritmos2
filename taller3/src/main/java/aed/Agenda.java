package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios = new ArregloRedimensionableDeRecordatorios();
    
    public Agenda(Fecha fechaActual) {
        this.fechaActual = new Fecha(fechaActual);
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);

    }

    @Override
    public String toString() {
        String mensaje = this.fechaActual + "\n" + "=====" + "\n";

        for (int i = 0; i < this.recordatorios.longitud(); i++){
            if(this.fechaActual.equals(recordatorios.obtener(i).fecha())){
                
                mensaje = mensaje.concat(this.recordatorios.obtener(i).toString() + "\n");
            }
            
        }
        
        return mensaje;

    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();

    }

    public Fecha fechaActual() {
        return this.fechaActual;
    }

}
