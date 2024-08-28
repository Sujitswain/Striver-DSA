package org.example.Arrays.Medium;

/*
Given an array arr of n positive integers, your task is to find all the leaders in the array. An element of the array is considered a leader if it is greater than all the elements on its right side or if it is equal to the maximum element on its right side. The rightmost element is always a leader.

Examples:
Input: n = 6, arr[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.

Input: n = 5, arr[] = {10,4,2,4,1}
Output: 10 4 4 1
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side

Input: n = 4, arr[] = {5, 10, 20, 40}
Output: 40
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.

Input: n = 4, arr[] = {30, 10, 10, 5}
Output: 30 10 10 5
Explanation: When an array is sorted in non-increasing order, all elements are leaders.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
*/

import java.util.Arrays;

public class LeadersInArray {
    private static void function(int[] arr) {
        int n = arr.length;
        int max = arr[n-1];
        int[] res = new int[0];
        res = Arrays.copyOf(res, res.length+1);
        res[res.length-1] = max;

        for(int i=n-2; i>=0; i--) {
            if(max <= arr[i]) {
                res = Arrays.copyOf(res, res.length+1);
                res[res.length-1] = arr[i];
                max = arr[i];
            }
        }

        System.out.println(Arrays.toString(res));
    }
    public static void main(String[] args) {
        function(new int[] {16,17,4,3,5,2});
        function(new int[] {10,4,2,4,1});
        function(new int[] {5, 10, 20, 40});
        function(new int[] {30, 10, 10, 5});
    }
}
