package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private Recordatorio[] recordatorios;
    private int tamaño = 2;
    private int longitud;

    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new Recordatorio[tamaño];
        longitud = 0;
        
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.recordatorios = new Recordatorio[vector.tamaño];
        this.longitud = vector.longitud;
        for(int i = 0; i < this.longitud; i++){
            this.recordatorios[i] = vector.recordatorios[i];
        }

    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio n) {
        if(this.longitud == tamaño) {
            this.tamaño += 3;
            Recordatorio[] recordatorios = new Recordatorio[tamaño];
            for(int i = 0; i < longitud; i++){
                recordatorios[i] = this.recordatorios[i];
            }
            this.recordatorios = recordatorios;
        }
        this.recordatorios[longitud] = n;
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

    public ArregloRedimensionableDeRecordatorios copiar() {
        
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios();
        for(int i = 0; i < this.longitud; i++){
            copia.agregarAtras(this.recordatorios[i]); 
        }
        return copia;
    }



}
