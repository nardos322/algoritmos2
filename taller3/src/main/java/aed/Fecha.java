package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        dia = this.dia;
        mes = this.mes;
        
    }

    public Fecha(Fecha fecha) {
        dia = fecha.dia;
        mes = fecha.mes;
    }

    public Integer dia() {
        return this.dia();
    }

    public Integer mes() {
        return this.mes();
    }

    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    @Override
    public boolean equals(Object otra) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void incrementarDia() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
