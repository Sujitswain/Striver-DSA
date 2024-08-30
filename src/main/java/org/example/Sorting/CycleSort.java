package org.example.Sorting;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        function(new int[] {2,3,1,4,5});
        function(new int[] {4,4,3,2,1});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] != i + 1) {
                int j = arr[i] - 1;

                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    break;
                }

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
