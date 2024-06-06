public class App {
    public static void main(String[] args) throws Exception {
        Conjunto c = new Conjunto(2);
        c.agregar(1);
        c.agregar(2);
        c.agregar(3);
    
        System.out.println(c.datos[2]);
    }
}
