package org.example.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayEqualsK {
    public static void main(String[] args) {
        function(new int[] {1,1,1}, 2);
        function(new int[] {1,2,3}, 3);
    }
    private static void function(int[] arr, int k) {
        // bruteForce(arr, k);
        OptimalSolutionMap(arr, k);
    }
    private static void bruteForce(int[] arr, int t) {
        int n = arr.length;
        int count = 0;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int sum=0;
                for(int k=i; k<=j; k++)
                    sum += arr[k];
                if(sum == t)
                    count++;
            }
        }
        System.out.println(count);
    }
    private static void OptimalSolutionMap(int[] arr, int t) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0;
        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += arr[i];

            if(sum == t)
                count += 1;

            if(mp.containsKey(sum - t))
                count += mp.get(sum - t);

            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        System.out.println(count);
    }
}
