/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Comparator;

/**
 *
 * @author INT303
 */
public class Sorter {

    public static void insertionSort(Object data[]) {
        insertionSort(data, null);
    }

    public static void insertionSort(Object data[], Comparator c) {
        if (c == null) {
            insertionUsingComparable(data);
        } else {
            insertionUsingComparator(data, c);
        }
    }

    private static void insertionUsingComparable(Object x[]) {
        for (int i = 0; i < x.length; i++) {
            Comparable tmp = (Comparable) x[i];
            int j = i;
            for (; j > 0 && tmp.compareTo(x[j - 1]) < 0; j--) {
                x[j] = x[j - 1];
            }
            x[j] = tmp;
        }
    }

    private static void insertionUsingComparator(Object x[], Comparator c) {
        for (int i = 0; i < x.length; i++) {
            Comparable tmp = (Comparable) x[i];
            int j = i;
            for (; j > 0 && c.compare(tmp, x[j - 1]) < 0; j--) {
                x[j] = x[j - 1];
            }
            x[j] = tmp;
        }
    }

    public static void selectionSort(Object x[]) {
        for (int i = x.length - 1; i > 0; i--) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                if (((Comparable) x[j]).compareTo(x[max]) > 0) {
                    max = j;
                }
            }
            if (max != i) {
                swap(x, max, i);
            }
        }
    }

    private static void swap(Object[] x, int i, int j) {
        Object tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public static void bubbleSort(Object x[]) {
        int length = x.length;
        Comparator c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (c.compare(x[j], x[j + 1]) > 0) {
                    swap(x, j, j + 1);
                }
            }
        }
    }

    public static void quickSort(Comparable x[]) {
        quickSort(x, 0, x.length - 1);
        insertionSort(x);

    }
    private final static int CUTOFF = 10;
    private static int selectPivot(Comparable x[], int left, int right) {
        int middle = (left + right) / 2;

        if (x[middle].compareTo(x[left]) < 0) {
            swap(x, left, middle);
        }
        if (x[right].compareTo(x[left]) < 0) {
            swap(x, left, right);
        }
        if (x[right].compareTo(x[middle]) < 0) {
            swap(x, middle, right);
        }
        return middle;

    }

    private static void quickSort(Comparable x[], int left, int right) {
        if (right - left >= CUTOFF) {
            int p = selectPivot(x, left, right);
            swap(x, p, right);
            Comparable pivot = x[right];
            int i, j;
            for (i = left, j = right - 1;;) {
                while (i <= j && x[i].compareTo(pivot) < 0) {
                    i++;
                }
                while (i <= j && x[j].compareTo(pivot) >= 0) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                swap(x, i++, j--);
            }
            if (x[i].compareTo(pivot) > 0) {
                swap(x, i, right);
            }
            if (left < i) {
                quickSort(x, left, i - 1);
            }
            if (right > i) {
                quickSort(x, i + 1, right);
            }
        }

    }
}
