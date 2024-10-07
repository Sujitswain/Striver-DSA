package org.example.Recursion;

/*
    A number n is called a factorial number if it is
    the factorial of a positive integer.

    For example, the first few factorial numbers
    are 1, 2, 6, 24, 120,

    Given a number n, the task is to return the
    list/vector of the factorial numbers smaller than or
    equal to n.

    Examples:
        Input: n = 3
        Output: 1 2
        Explanation:
            The first factorial number is 1 which is less
            than equal to n.
            The second number is 2 which is less than equal
            to n,but the third factorial number is 6 which
            is greater than n. So we print only 1 and 2.

        Input: n = 6
        Output: 1 2 6
        Explanation:
            The first three factorial numbers are less than
            equal to n but the fourth factorial number 24
            is greater than n.
            So we print only first three factorial numbers.

        Expected Time Complexity: O(k),
            Where k is the number of factorial numbers.

        Expected Auxiliary Space: O(1)
 */

import java.util.ArrayList;

public class Factorial {
    public static void recursion(ArrayList<Integer> res, int n, int fact, int multiplier) {
        if(fact > n)
            return;

        res.add(fact);
        recursion(res, n, fact * (multiplier+1), (multiplier+1));
    }
    public static void function(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        recursion(res, n, 1, 1);
        System.out.println(res);
    }
    public static int recursiveFact(int n) {
        if(n == 1)
            return 1;

        return n * recursiveFact(n-1);
    }
    public static void iterativeFact(int n) {
        int fact = 1;
        for(int i=1; i<=n; i++) {
            fact *= i;
        }
        System.out.println(fact);
    }
    public static void main(String[] args) {
        // function(3);
        // function(6);

        // iterativeFact(1);
        // iterativeFact(2);
        // iterativeFact(3);
        // iterativeFact(4);
        // iterativeFact(5);
        // iterativeFact(6);

        // System.out.println(recursiveFact(1));
        // System.out.println(recursiveFact(2));
        // System.out.println(recursiveFact(3));
        // System.out.println(recursiveFact(4));
        // System.out.println(recursiveFact(5));
        // System.out.println(recursiveFact(6));
    }
}
