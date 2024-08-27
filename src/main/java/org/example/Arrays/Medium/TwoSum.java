package org.example.Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        function(new int[] {2,6,5,8,11}, 14);
        function(new int[] {2,6,5,8,11}, 15);
    }
    private static void function(int[] arr, int t) {
        System.out.println(Arrays.toString(optimalSolution(arr, t)));
    }
    private static int[] optimalSolution(int[] arr, int t) {
        int n = arr.length;

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(arr[0], 0);

        for(int i=1; i<n; i++) {
            int r = t-arr[i];
            if(mp.containsKey(r)) {
                return new int[] {mp.get(r), i};
            }
            mp.putIfAbsent(arr[i], i);
        }
        return new int[] {};
    }
}
