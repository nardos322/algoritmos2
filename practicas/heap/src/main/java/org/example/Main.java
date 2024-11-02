package org.example;

public class Main {
    public static void main(String[] args) {
        PrimeComparator primeComparator = new PrimeComparator();
        Heap<Integer> maxHeap = new Heap<>(primeComparator);
        maxHeap.insertar(5);
        maxHeap.insertar(8);
        maxHeap.insertar(3);
        maxHeap.insertar(2);
        maxHeap.insertar(7);
        maxHeap.insertar(11);


        System.out.println(maxHeap.toString());

    }
}