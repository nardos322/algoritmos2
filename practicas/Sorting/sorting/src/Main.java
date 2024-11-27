import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Double[] intArray = {0.78, 0.50, 0.20, 0.33, 0.30, 0.10, 0.05};

        Sort.bucketSort(intArray, num -> num);

        for(Double n : intArray) {
            System.out.println(n);
        }

    }
}