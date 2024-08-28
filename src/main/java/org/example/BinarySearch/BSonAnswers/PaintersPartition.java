package org.example.BinarySearch.BSonAnswers;

import java.util.Arrays;

public class PaintersPartition {
    public static void main(String[] args) {
        function(new int[] {5, 5, 5, 5}, 2);
        function(new int[] {10, 20, 30, 40}, 2);
    }
    private static void function(int[] arr, int k) {
        bruteForce(arr, k);
    }
    private static void bruteForce(int[] arr, int k) {
        int start = Arrays.stream(arr).max().orElse(0);
        int end = Arrays.stream(arr).sum();

        for(int i=start; i<=end; i++) {
            if(countPainters(arr, i) == k) {
                System.out.println(i);
                return;
            }
        }

    }
    private static int countPainters(int[] arr, int t) {
        int n = arr.length;
        int countPainters = 1;
        int sum = 0;

        for(int i=0; i<n; i++) {
            if(sum + arr[i] <= t)
                sum += arr[i];
            else {
                countPainters++;
                sum = arr[i];
            }
        }
        return countPainters;
    }
}
