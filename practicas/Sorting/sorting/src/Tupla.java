public class Tupla<A, B>{
    public final A first;
    public final B second;

    public Tupla(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
