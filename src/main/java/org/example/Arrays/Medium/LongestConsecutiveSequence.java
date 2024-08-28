package org.example.Arrays.Medium;

/*
* Given an unsorted array of integers nums,
* return the length of the longest consecutive elements sequence.
* You must write an algorithm that runs in O(n) time.
* Example 1:
*
* Input: nums = [100,4,200,1,3,2]
* Output: 4
* Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4
* Example 2:
*
* Input: nums = [0,3,7,2,5,8,4,6,0,1]
* Output: 9
* */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        function(new int[] {100, 4,200, 1,3,2});
    }
    private static void function(int[] arr) {
        int n = arr.length;
        Set<Integer> set =  new HashSet<>();
        int maxCount = 0;

        for (int num : arr)
            set.add(num);

        for(int i=0; i<n; i++) {
            if(!set.contains(arr[i]-1)) {
                int num = arr[i];
                int count = 1;
                while(set.contains(num+1)) {
                    count++;
                    num++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        System.out.println(maxCount);
    }
}
