import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Integer[] intArray = {3,2,1,2,2,5,8};
        Integer[] B = new Integer[intArray.length];
        Sort.KeyExtractor<Integer> keyExtractor = x -> x;
        Sort.countingSort(intArray, B, keyExtractor, 8);
        for(Integer n : B) {
            System.out.println(n);
        }

    }
}