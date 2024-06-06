import aed.ABB;


public class Prueba {
    static Integer NCLAVES = 10; 
    
    public static Integer clave(Integer i) {        
        return NCLAVES * ((i * i - 100 * i) % NCLAVES) + i;
    }
  

    public static void main(String[] args) {
        
        ABB<Integer> arbol = new ABB<>();
        ABB<Integer> arbol2 = new ABB<>();

        int[] n = new int[4];
        
    
        n[0] = 1;
        n[1] = 2;
        n[2] = 3;
    
        
        for (Integer i = 0; i < NCLAVES; i++ ){
            Integer k = clave(i);
            arbol.insertar(k);
            
        }
        
         


        System.out.println(n);



    }


}
