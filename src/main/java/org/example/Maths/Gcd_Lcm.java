package org.example.Maths;

/*
    Given two integers a and b, write a function lcmAndGcd() to compute
    their LCM and GCD.

    The function takes two integers a and b as input and returns a list
    containing their LCM and GCD.

    Example 1:
        Input: a = 5 , b = 10
        Output: 10 5
        Explanation: LCM of 5 and 10 is 10, while thier GCD is 5.

        Input: a = 14 , b = 8
        Output: 56 2
        Explanation: LCM of 14 and 8 is 56, while thier GCD is 2.

        Expected Time Complexity: O(log(min(a, b))
        Expected Auxiliary Space: O(1)
 */

public class Gcd_Lcm {

    public static int GCD(int a, int b) {
        if(b == 0)
            return a;

        return GCD(b, a%b);
    }

    public static void function(int a, int b) {
        int gcd = GCD(a,b);
        int lcm = a*b / gcd;

        System.out.println("LCM: " + lcm + ", GCD: " + gcd);
    }

    public static void main(String[] args) {
        function(5, 10);
        function(14, 8);
    }
}
