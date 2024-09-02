package org.example.Strings.Basic;

/*
Given two strings s and goal, return true if
and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost
character of s to the rightmost position.

For example,
    if s = "abcde", then it will be "bcdea" after one shift.

Example 1:
Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:
Input: s = "abcde", goal = "abced"
Output: false
*/

public class RotateString {
    public static void main(String[] args) {
        function("abcde", "cdeab");
        function("abcde", "abced");
    }
    private static void function(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 != n2) {
            System.out.println("Not possible");
            return;
        }

        int s = s2.lastIndexOf(s1.charAt(0));
        if(s == -1) {
            System.out.println("Not possible");
            return;
        }

        for(int i=0; i<n1; i++, s++) {
            int index = s%n1;
            if(s1.charAt(i) != s2.charAt(index)) {
                System.out.println("Not Possible");
                return;
            }
        }
        System.out.println("It is");
    }
}
