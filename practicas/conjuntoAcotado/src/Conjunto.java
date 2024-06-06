
public class Conjunto {
    int[] datos;
    int largo;

    
    public Conjunto(int capacidad){
        datos =  new int[capacidad];
        largo = 0;
    }

    public void agregar(int elem){

        boolean estaElemento = false;
        int i = 0;
        while(i < largo){
            if(datos[i] == elem){
                estaElemento = true;

            }
            i++;
        }

        if(largo < datos.length && !estaElemento){
            datos[largo] = elem;
            largo ++;
        } else 
        {
           
            int[] nuevosDatos = new int[largo + 10];
            int j = 0;
            while(j < largo){
                nuevosDatos[j] = datos[j];
                j++;

            }
            
            datos = nuevosDatos;
            datos[largo] = elem;
            largo ++;
        }
        
    }
}

