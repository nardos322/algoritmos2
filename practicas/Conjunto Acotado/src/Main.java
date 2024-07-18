public class Main {
    public static void main(String[] args) {
        Conjunto a = new Conjunto(5);
        a.agregar(2);
        a.agregar(3);

        System.out.println(a.datos[1]);
    }
}