package org.example.Sorting;

import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] arr, int n) {
        for(int gap = n/2; gap > 0; gap /= 2) {
            System.out.println("Gap: " + gap);
            for(int i=gap; i<n; i++) {
                int j = i;
                int val = arr[i];

                while (j >= gap && arr[j - gap] > val) {

                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = val;
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    public static void function(int[] arr) {
        shellSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        function(new int[] {73, 67, 56, 32, 52, 41, 83, 37, 32, 10});
    }
}
