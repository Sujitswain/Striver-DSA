package org.example.Sorting;

import java.util.Arrays;

public class BubbleRecursion {

    public static void recursion(int[] arr, int n) {
        if(n <= 1)
            return;

        boolean swap = false;
        for(int i=0; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                swap = true;
                int t = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = t;
            }
        }

        if(!swap)
            return;

        recursion(arr, n-1);
    }

    public static void function(int[] arr) {
        recursion(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        function(new int[] {13,46,24,52,20,9});
        function(new int[] {5,4,3,2,1});
    }
}
