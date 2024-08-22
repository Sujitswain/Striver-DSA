package org.example.Sorting;

import java.util.Arrays;

public class Insertion {

    public static void insertionSort(int[] arr, int i) {
        int j=i-1;
        int val = arr[i];
        while(j>=0 && arr[j] > val) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = val;
    }

    public static void function(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {
            insertionSort(arr, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        function(new int[] {13,46,24,52,20,9});
        function(new int[] {5,4,3,2,1});
    }
}
