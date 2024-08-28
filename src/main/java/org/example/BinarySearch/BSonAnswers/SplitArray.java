package org.example.BinarySearch.BSonAnswers;

import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {
        function(new int[] {1,2,3,4,5}, 3);
        function(new int[] {3,5,1}, 3);
    }
    private static void function(int[] arr, int k) {
        // bruteForce(arr, k);
        BS(arr, k);
    }
    private static void BS(int[] arr, int k) {
        int s = Arrays.stream(arr).max().orElse(0);
        int e = Arrays.stream(arr).sum();

        while(s <= e) {
            int m = s+(e-s)/2;
            if(splitCount(arr, m) > k)
                s = m+1;
            else
                e = m-1;
        }
        System.out.println("Minimized largest sum: " + s);
    }
    private static void bruteForce(int[] arr, int k) {
        int max = Arrays.stream(arr).max().orElse(0);
        int total = Arrays.stream(arr).sum();
        for(int i=max; i<=total; i++) {
            if(splitCount(arr, i) == k) {
                System.out.println(i);
                return;
            }
        }
    }
    private static int splitCount(int[] arr, int capacity) {
        int n = arr.length;
        int splitCount = 1;
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(sum + arr[i] <= capacity)
                sum += arr[i];
            else {
                splitCount++;
                sum = arr[i];
            }
        }
        return splitCount;
    }
}
