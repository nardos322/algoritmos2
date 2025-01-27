package aed;

import java.util.Comparator;

public class EmpleadoComparator implements Comparator<Empleado> {

    public int compare(Empleado e1, Empleado e2) {
        int deptoComparacion = e1.getDepartamento().compareTo(e2.getDepartamento());
        if (deptoComparacion != 0) {
            return deptoComparacion;
        } else {
            return Integer.compare(e1.getEdad(), e2.getEdad());
        }
    }
}
