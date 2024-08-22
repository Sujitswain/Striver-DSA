package org.example.Sorting;

import java.util.Arrays;

public class Selection {
    public static int selectionSort(int arr[], int i, int n)
    {
        int pos = i;
        for(int j=i+1; j<n; j++) {
            if(arr[pos] > arr[j]) {
                pos = j;
            }
        }
        return pos;
    }

    public static void function(int arr[])
    {
        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            int pos = selectionSort(arr, i, n);

            if(pos != i) {
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        function(new int[] {1, 3, 9, 7});
        function(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
    }
}
