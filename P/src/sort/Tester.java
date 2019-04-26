/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author INT303
 */
public class Tester {
    
    private static final int size = 30;
    
    public static void main(String[] args) {
        Integer[] data = new Integer[size];
        Integer[] data2 = new Integer[size];
        Random r = new Random();
        for (int i = 0; i < data.length; i++) {
//            data[i] = i;
            data[i] = r.nextInt(100);
        }
//        System.arraycopy(data, 0, data2, 0, data.length);
//        long before = System.currentTimeMillis();
//        Arrays.parallelSort(data2);
//        long duration1 = System.currentTimeMillis()-before;
//        
//        before = System.currentTimeMillis();
//        Sorter.insertionSort(data);
//        long duration2 = System.currentTimeMillis()-before;
//        
//        System.out.println("Parallel sort: "+duration1+" milliseconds");
//        System.out.println("Insertion sort: "+duration2+" milliseconds");
        System.out.println("Original order: ");
        printArray(data);
//        Sorter.insertionSort(data);
//        Sorter.insertionSort(data, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//Sorter.selectionSort(data);
//        Sorter.bubbleSort(data);
        Sorter.quickSort(data);
        System.out.println("After sorted: ");
        printArray(data);
    }
    
    private static void printArray(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%2d%s", data[i], (i + 1) % 10 == 0 ? "\n" : "\t");
        }
        System.out.println("");
    }
}
