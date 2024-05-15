package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private Recordatorio[] recordatorios;
    private int tamaño = 2;
    private int len;

    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new Recordatorio[tamaño];
        this.len = 0;
        
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public int longitud() {
        return this.len;
    }

    public void agregarAtras(Recordatorio n) {
        if(len == tamaño) {
            this.tamaño += 3;
            Recordatorio[] recordatorios = new Recordatorio[tamaño];
            for(int i = 0; i < len; i++){
                recordatorios[i] = this.recordatorios[i];
            }
            this.recordatorios = recordatorios;
        }
        this.recordatorios[len] = n;
        len += 1;
    }

    public Recordatorio obtener(int i) {
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        if(len > 0) {
            this.recordatorios[len-1] = null;
            this.len -= 1;
        }
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }


    public static void main(String[] args) {
        Fecha f = new Fecha(10, 6);
        Horario h = new Horario(9, 45);
        String mensaje = "Consulta con dentista";
        Fecha g = new Fecha(11, 7);
        Horario i = new Horario(10, 45);
        String mensaje2 = "Consulta con otorrino";
        Recordatorio a = new Recordatorio(mensaje, f, h);
        Recordatorio b = new Recordatorio(mensaje2, g, i);
        ArregloRedimensionableDeRecordatorios x = new ArregloRedimensionableDeRecordatorios();
        x.agregarAtras(a);
        x.agregarAtras(b);
        x.quitarAtras();
        x.quitarAtras();
        x.quitarAtras();
        x.quitarAtras();
        System.out.println(x.obtener(1));
        System.out.println(x.longitud());
    }
}
