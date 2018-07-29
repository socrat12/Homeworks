package com.itStep.home08.combination;

import java.util.Arrays;

public class CombinationArtem {

    public static void main (String[] args) {
        String[] array = {"A", "G", "C", "J", "E", "F", "B", "H", "I", "D"};
        
        combinateIt(array);
    }

    private static void combinateIt (String[] array) {
        Arrays.sort(array);
        
        print(array);
        while (Set(array, array.length)) {
            print(array);
        }
    }

    public static boolean Set (String[] array, int n) {
        int i = n - 2;
        while (i != -1 && array[i].compareTo(array[i + 1]) >= 0) {
            i--;
        }
        if (i == -1) return false;

        int m = n - 1;
        while (array[i].compareTo(array[m]) >= 0) {
            m--;
        }

        swap(array, i, m);

        int b = i + 1;
        int c = n - 1;

        while (b < c) {
            swap(array, b, c);
            b++;
            c--;
        }

        return true;
    }

    private static void swap (String[] array, int i, int m) {
        String temp = array[i];
        array[i] = array[m];
        array[m] = temp;
    }
    
    private static void print (String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
