package org.example.Sorting;

import java.util.Arrays;

public class RadixSort {

    private static void countSort(int[] arr, int n, int e) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for(int i=0; i<n; i++) {
            var val = arr[i] / e;
            count[val % 10]++;
        }

        for(int i=1; i<10; i++)
            count[i] = count[i-1] + count[i];

        for(int i=n-1; i>=0; i--) {
            int val = (arr[i] / e) % 10;
            count[val]--;
            output[count[val]] = arr[i];
        }
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void radixSort(int[] arr, int n) {
        int max = Arrays.stream(arr).max().orElse(0);
        for(int i=1; (max/i) > 0; i*=10) {
            countSort(arr, n, i);
        }
    }

    public static void function(int[] arr) {
        radixSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        function(new int[] {170, 45, 75, 90, 802, 24, 2, 66});
    }
}
