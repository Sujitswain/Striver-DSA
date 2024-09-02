package org.example.Strings.Medium;

/*
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.



Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.

Example 2:

Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.

Example 3:

Input: s = "()(())((()()))"

Output: 3
*/

import java.util.Stack;

public class ParenthesesDepth {
    public static void main(String[] args) {
        function("(1+(2*3)+((8)/4))+1");
        function("(1)+((2))+(((3)))");
        function("()(())((()()))");
    }
    private static void function(String str) {
        int count = 0;
        int max = 0;
        for(int i=0;i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                count++;
                max = Math.max(count, max);
            }
            else if(ch == ')')
                count--;
        }
        System.out.println(max);
    }
}
