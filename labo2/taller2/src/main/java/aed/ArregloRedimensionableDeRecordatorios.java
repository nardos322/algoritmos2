package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] recordatorios;
    private int tamaño = 2;
    private int longitud;

    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new Recordatorio[tamaño];
        longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        if(this.longitud == tamaño) {
            this.tamaño += 3;
            Recordatorio[] recordatorios = new Recordatorio[tamaño];
            for(int j = 0; j < longitud; j++){
                recordatorios[j] = this.recordatorios[j];
            }
            this.recordatorios = recordatorios;
        }
        this.recordatorios[longitud] = i;
        longitud += 1;
    }

    public Recordatorio obtener(int i) {
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        if(longitud > 0) {
            this.recordatorios[longitud-1] = null;
            this.longitud -= 1;
        }
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.recordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.recordatorios = new Recordatorio[vector.tamaño];
        this.longitud = vector.longitud;
        for(int i = 0; i < this.longitud; i++){
            this.recordatorios[i] = vector.recordatorios[i];
    }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios();
        for(int i = 0; i < this.longitud; i++){
            copia.agregarAtras(this.recordatorios[i]);
        }
        return copia;
    }
}
