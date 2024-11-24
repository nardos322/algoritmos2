import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Integer[] intArray = {29, 19, 11, 14, 37, 11,1,3,30,2};
        Sort.quickSort(intArray);
        for(Integer n : intArray) {
            System.out.println(n);
        }
    }
}