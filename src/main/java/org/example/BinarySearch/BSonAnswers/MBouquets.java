package org.example.BinarySearch.BSonAnswers;

import java.util.Arrays;

public class MBouquets {

    public static int check(int[] arr, int k, int days) {
        int ans = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(days >= arr[i])
                count++;
            else {
                ans += count / k;
                count = 0;
            }
        }
        ans += count / k;
        return ans;
    }
    public static void bruteForce(int[] arr, int m, int k) {

        if(m*k > arr.length) {
            System.out.println("Not possible");
            return;
        }

        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(0);

        for(int i=min; i<=max; i++) {
            if(check(arr, k, i) == m) {
                System.out.printf("Days: %d\n", i);
                return;
            }
        }
        System.out.println("No solution: -1");
    }
    public static void BS(int[] arr, int m, int k) {

        if(m*k > arr.length) {
            System.out.println("Not possible");
            return;
        }

        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(0);

        int s = min;
        int e = max;

        while(s <= e) {
            int mid = s+(e-s)/2;
            int val = check(arr, k, mid);
            if(val >= m )
                e = mid-1;
            else
                s = mid+1;
        }
        System.out.println("Days: " + s);
    }
    public static void function(int[] arr, int m, int k) {
        // bruteForce(arr, m, k);
        BS(arr, m, k);
    }
    public static void main(String[] args) {
        function(new int[] {7, 7, 7, 7, 13, 11, 12, 7}, 2, 3);
        function(new int[] {1, 10, 3, 10, 2}, 3, 2);
    }
}
