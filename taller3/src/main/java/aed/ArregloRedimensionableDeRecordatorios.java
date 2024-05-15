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
        throw new UnsupportedOperationException("No implementada aun");
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
        throw new UnsupportedOperationException("No implementada aun");
        
    }


    public static void main(String[] args) {
      

        System.out.println("holsa");
       
    }
}
