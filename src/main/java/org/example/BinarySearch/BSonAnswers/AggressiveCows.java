package org.example.BinarySearch.BSonAnswers;

/*
        Here the minimum distance is between the stalks so
        sort the array.
 */

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        function(new int[] {0, 3, 4, 7, 10, 9}, 4);
        function(new int[] {4, 2, 1, 3, 6}, 2);
    }
    private static void function(int[] arr, int k) {
        // bruteForce(arr, k);
        BS(arr, k);
    }

    private static void BS(int[] arr, int k) {
        int n = arr.length;

        Arrays.sort(arr);

        int s = 1;
        int e = arr[n-1] - arr[0];
        while(s <= e) {
            int m = s+(e-s)/2;
            if(canBePlaced(arr, n, m, k)) {
                s = m+1;
            }
            else
                e = m-1;
        }
        System.out.println(e);
    }

    private static void bruteForce(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int l = arr[n-1] - arr[0];
        int res = 0;
        for(int i=1; i<=l; i++) {
            if(canBePlaced(arr, n, i, k)) {
               res = i;
            }
        }
        if(res != 0)
            System.out.println(res);
        else
            System.out.println("Not found");
    }
    private static boolean canBePlaced(int[] arr, int n, int d, int k) {
        int cows = 1;
        int lastPlacedCow = arr[0];
        for(int i=1; i<n; i++) {
            if(arr[i] - lastPlacedCow >= d) {
                cows++;
                lastPlacedCow = arr[i];
            }
            if(cows >= k)
                return true;
        }
        return false;
    }
}
