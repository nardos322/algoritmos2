package org.example;
import java.util.Comparator;

public class PrimeComparator implements Comparator<Integer> {


    private boolean isPrime(Integer number) {
        if (number <= 1) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }

    @Override
    public int compare(Integer a, Integer b) {
        boolean isAPrime = isPrime(a);
        boolean isBPrime = isPrime(b);


        if (isAPrime && isBPrime) {
            return Integer.compare(b,a);
        }


        if (isAPrime && !isBPrime) {
            return 1;
        }

        if(!isAPrime && isBPrime) {
            return -1;
        }


        return Integer.compare(a, b);
    }

}
