package org.example.Sorting;

import java.util.Arrays;

public class SelectionRecursion {

    public static int leastIndex(int[] arr, int i, int n) {
        int pos = i;

        for(int j=i+1; j<n; j++) {
            if(arr[j] < arr[pos]) {
                pos = j;
            }
        }

        return pos;
    }

    private static void recursion(int[] arr, int i, int n) {
        if(i >= n-1)
            return;

        int pos = leastIndex(arr, i, n);
        if(pos != i) {
            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }
        recursion(arr, i + 1, n);
    }

    public static void function(int[] arr) {
        recursion(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        function(new int[] {1, 3, 9, 7});
        function(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
    }
}




//public class SelectionRecursion {
//    public static int leastIndex(int[] arr, int i, int n) {
//        int pos = i;
//        for (int j = i + 1; j < n; j++) {
//            if (arr[j] < arr[pos]) {
//                pos = j;
//            }
//        }
//        return pos;
//    }
//    private static boolean recursion(int[] arr, int i, int n) {
//        if (i >= n - 1) {
//            return false; // No swaps made
//        }
//        int pos = leastIndex(arr, i, n);
//        boolean swapped = false;
//        if (pos != i) {
//            int temp = arr[i];
//            arr[i] = arr[pos];
//            arr[pos] = temp;
//            swapped = true;
//        }
//        boolean furtherSwapped = recursion(arr, i + 1, n);
//        return swapped || furtherSwapped; // Return true if any swap occurred
//    }
//    public static void function(int[] arr) {
//        boolean sorted = recursion(arr, 0, arr.length);
//        if (sorted) {
//            System.out.println("Array was sorted using selection sort.");
//        } else {
//            System.out.println("Array was already sorted.");
//        }
//        System.out.println(Arrays.toString(arr));
//    }
//    public static void main(String[] args) {
//        function(new int[]{1, 3, 9, 7});
//        function(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
//    }
//}
