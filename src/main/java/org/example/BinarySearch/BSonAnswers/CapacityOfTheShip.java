package org.example.BinarySearch.BSonAnswers;

import java.util.Arrays;

public class CapacityOfTheShip {

    public static void main(String[] args) {
        function(new int[] {5,4,5,2,3,4,5,6}, 5);
        function(new int[] {1,2,3,4,5,6,7,8,9,10}, 1);
    }

    private static void function(int[] arr, int d) {
        bruteForce(arr, d);
        BS(arr, d);
    }

    private static void BS(int[] arr, int d) {
        int n = arr.length;

        int max = Arrays.stream(arr).max().orElse(0);
        int total = Arrays.stream(arr).sum();

        int s = max, e = total;
        while(s <= e) {
            int m = s+(e-s)/2;
            int totDays = getDays(arr, m, n);
            if(totDays <= d) {
                e = m-1;
            }
            else {
                s = m+1;
            }
        }
        System.out.println(s);
    }

    private static void bruteForce(int[] arr, int d) {
        int n = arr.length;

        int max = Arrays.stream(arr).max().orElse(0);
        int total = Arrays.stream(arr).sum();
        for(int i=max; i<=total; i++) {
            if(getDays(arr, i, n) == d) {
                System.out.println("Weights: " + i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static int getDays(int[] arr, int maxLoad, int n) {
        int totalLoad = 0;
        int days = 1;
        for(int i=0; i<n; i++) {
            if(totalLoad + arr[i] > maxLoad) {
                days++;
                totalLoad = arr[i];
            }
            else
                totalLoad += arr[i];
        }
        return days;
    }
}
