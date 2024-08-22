package org.example.Sorting;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int findPivot(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l-1;

        for(int j=l; j<h; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, h);
        return i;
    }

    public static void quickSort(int[] arr, int l, int h) {
        if(l < h) {
            int pivot = findPivot(arr, l, h);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, h);
        }
    }

    public static void function(int[] arr) {
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        function(new int[] {1, 3, 9, 7});
        function(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
    }
}
