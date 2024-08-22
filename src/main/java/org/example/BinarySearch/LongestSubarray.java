package org.example.BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {
    public static int lenOfLongSubarr (int A[], int K) {
        int N = A.length;
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<N; i++) {

            sum += A[i];

            if(sum == K)
                max = Math.max(max, i+1);

            int remaining = sum-K;
            if(mp.containsKey(remaining)) {
                int j = mp.get(remaining);
                max = Math.max(max, i-j);
            }

            if(!mp.containsKey(sum))
                mp.put(sum, i);

        }
        return max;
    }


    public static int getLongestSubarray(int []a, long k) {
        int n = a.length;
        int max = 0;
        int sum = a[0];
        int l = 0, r = 0;

        while(r < n) {

            while (l <= r && sum > k) {
                sum -= a[l];
                l++;
            }

            if (sum == k) {
                max = Math.max(max, r - l + 1);
            }

            r++;
            if (r < n) {
                sum += a[r];
            }
        }
        return max;
    }


    public static void function(int[] arr, int k) {
        System.out.println(getLongestSubarray(arr, k));
        System.out.println(lenOfLongSubarr(arr, k));
    }

    public static void main(String[] args) {
        function(new int[] {10, 5, 2, 7, 1}, 15);

    }
}
