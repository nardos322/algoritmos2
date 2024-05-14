package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
        
    }

    public Fecha(Fecha fecha) {
        dia = fecha.dia;
        mes = fecha.mes;
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    public String toString() {
        return this.dia+ "/"+ this.mes;
    }

    @Override
    public boolean equals(Object otra) {
        boolean esNull = (otra == null);
        boolean claseDistinta = otra.getClass() != this.getClass();

        if(esNull || claseDistinta ){
            return false;
        }
        Fecha otraFecha = (Fecha) otra;
       
        return this.dia == otraFecha.dia && this.mes == otraFecha.mes;

    }

    public void incrementarDia() {
        
        if (!(this.dia == this.diasEnMes(this.mes))) {
            this.dia += 1;
        } else {
            this.dia = 1;
            this.mes = this.mes + 1;
        }

        if (this.mes > 12) {
            this.mes = 1;
        }
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

    // public static void main(String[] args) {
    //     Fecha fecha = new Fecha(30, 11);
    //     Fecha f1 = new Fecha(20,11);
    //     boolean esCinco = (5 == 5);
       
        
        
        
    //     System.out.println(esCinco);
    // }

}
