package org.example.BinarySearch.BSonAnswers;

import java.util.Arrays;

public class SmallestDivisor {

    private static int sumByDivisor(int[] arr, int n, int div) {
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += Math.ceil((double)arr[i]/(double)div);
        }
        return sum;
    }
    private static void bruteForce(int[] arr, int l) {
        int n = arr.length;
        if(n > l) {
            System.out.println("Not Possible");
            return;
        }
        int max = Arrays.stream(arr).max().orElse(0);
        for(int i=1; i<=max; i++) {
            if(sumByDivisor(arr, n, i) <= l) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
    private static void BS(int[] arr, int l) {
        int n = arr.length;
        if(n > l) {
            System.out.println("Not Possible");
            return;
        }

        int max = Arrays.stream(arr).max().orElse(0);
        int s=1, e=max;
        while(s <= e) {
            int m = s+(e-s)/2;
            if(sumByDivisor(arr, n, m) <= l)
                e=m-1;
            else
                s=m+1;
        }
        System.out.println(s);
    }
    private static void function(int[] arr, int l) {
        // bruteForce(arr, l);
        BS(arr, l);
    }
    public static void main(String[] args) {
        function(new int[] {1,2,3,4,5}, 8);
    }
}
