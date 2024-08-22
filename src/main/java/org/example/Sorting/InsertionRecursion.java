package org.example.Sorting;

import java.util.Arrays;

public class InsertionRecursion {

    public static void recursion(int[] arr, int n) {
        if(n <= 1)
            return;

        recursion(arr, n-1);
        int val = arr[n-1];
        int j = n-2;

        while(j>=0 && arr[j] > val) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = val;
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
