package org.example.BinarySearch.BSonAnswers;

import java.util.Arrays;

public class KoKoEatingBananas {
    private static int check(int[] arr, int eb) {
        int eh = 0;
        for(int i=0; i<arr.length; i++) {
            var val = (arr[i]+eb-1)/eb;                 // maths.ceil
            eh += val;
        }
        return eh;
    }
    private static void bruteForce(int[] arr, int h) {

        int max = Arrays.stream(arr).max().orElse(0);
        int ans = 0;
        for(int i=1; i<=max; i++) {
            if(check(arr, i) == h) {
                ans = i;
                break;
            }
        }
        System.out.printf("KoKo should eat %d so it matches %d\n", ans, h);
    }

    public static void BS(int[] arr, int h) {
        int max = Arrays.stream(arr).max().orElse(0);

        int ans = 0;
        int s = 1;
        int e = max;

        while(s <= e) {
            int m = s+(e-s)/2;
            int val = check(arr, m);
            if(val <= h) {
                ans = m;
                e = m-1;
            }
            else
                s = m+1;
        }
        System.out.printf("KoKo should eat %d so it matches %d\n", ans, h);
    }

    public static void function(int[] arr, int h) {
        // bruteForce(arr, h);
        BS(arr, h);
    }

    public static void main(String[] args) {
        function(new int[] {25, 12, 8, 14, 19}, 5);
        function(new int[] {7, 15, 6, 3}, 8);
    }
}
