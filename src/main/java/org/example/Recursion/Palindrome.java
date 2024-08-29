package org.example.Recursion;

/*
    A phrase is a palindrome if, after converting all
    uppercase letters into lowercase letters and removing
    all non-alphanumeric characters, it reads the same
    forward and backward. Alphanumeric characters include
    letters and numbers.

    Given a string s, return true if it is a palindrome,
    or false otherwise.

    Example 1:
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:
        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.

    Example 3:
        Input: s = " "
        Output: true
        Explanation:
            s is an empty string "" after removing
            non-alphanumeric characters.
            Since an empty string reads the same
            forward and backward, it is a palindrome.

    Constraints:
        1 <= s.length <= 2 * 105
        s consists only of printable ASCII characters.
 */

public class Palindrome {

    public static boolean recursion(StringBuilder sb, int s, int e) {
        if(s >= e)
            return true;
        if(sb.charAt(s) != sb.charAt(e))
            return false;
        return recursion(sb, s+1, e-1);
    }

    public static void function(String s) {
        int n = s.length();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'){
                sb.append(""+s.charAt(i));
            }
        }
        n = sb.length();
        System.out.println(s.toUpperCase() + " : " +
                recursion(sb, 0, n-1));
    }

    public static void main(String[] args) {
        function("A man, a plan, a canal: Panama");
        function("race a car");
        function("  ");
    }
}
