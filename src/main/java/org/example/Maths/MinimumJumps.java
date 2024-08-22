package org.example.Maths;

/*
    Given an array arr[] of size n of non-negative integers. Each array element represents the maximum length of the jumps that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
    Find the minimum number of jumps to reach the end of the array starting from the first element. If an element is 0, then you cannot move through that element.
    Note:  Return -1 if you can't reach the end of the array.

    Examples :
        Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}, n = 11
        Output: 3
        Explanation:
            First jump from 1st element to 2nd element
            with value 3. From here we jump to 5th element
            with value 9, and from here we will jump to
            the last.

        Input: arr = {1, 4, 3, 2, 6, 7}, n = 6
        Output: 2
        Explanation:
            First we jump from the 1st to 2nd
            element and then jump to the last element.

        Input: arr = {0, 10, 20}, n = 3
        Output: -1
        Explanation:
            We cannot go anywhere from the 1st element.

        Expected Time Complexity: O(n)
        Expected Space Complexity: O(1)
 */

public class MinimumJumps {

    public static void function(int[] arr) {
        int n = arr.length;

        if(n <= 1) {
            System.out.println("Jump: " + -1);
            return;
        }
        else if(arr[0] == 0) {
            System.out.println("Jump: " + -1);
            return;
        }

        int jumps=0;
        int currentJump=0;
        int farthestJump=0;

        for(int i=0; i<n; i++) {
            farthestJump = Math.max(i+arr[i], farthestJump);
            if(i == currentJump) {
                jumps++;
                currentJump = farthestJump;
                if(currentJump >= n-1) {
                    System.out.println("Jump: " + jumps);
                    return;
                }
            }
        }
        System.out.println("Jump: " + jumps);
    }

    public static void main(String[] args) {
        function(new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
        function(new int[] {1, 4, 3, 2, 6, 7});
        function(new int[] {0, 10, 20});
    }
}
