package org.example.Arrays.Easy;

/*
Input: arr[] = {15,-2,2,-8,1,7,10,23}, n = 8
Output: 5
Explanation: The largest subarray with sum 0 is -2 2 -8 1 7.
Input: arr[] = {2,10,4}, n = 3
Output: 0
Explanation: There is no subarray with 0 sum.
Input: arr[] = {1, 0, -4, 3, 1, 0}, n = 6
Output: 5
Explanation: The subarray is 0 -4 3 1 0.
*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumZero {
    public static void main(String[] args) {
        function(new int[] {15,-2,2,-8,1,7,10,23});
        function(new int[] {2,10,4});
        function(new int[] {1, 0, -4, 3, 1, 0});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        int max = 0;
        for(int i=0;i<n; i++) {
            sum += arr[i];

            if(sum == 0)
                max = Math.max(max, i+1);
            else if(mp.containsKey(sum))
                max = Math.max(max, i-mp.get(sum));
            else
                mp.put(sum, i);
        }
        System.out.println(max);
    }
}
