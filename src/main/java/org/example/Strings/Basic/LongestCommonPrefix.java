package org.example.Strings.Basic;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""

Explanation: There is no common prefix among the input strings.
*/

public class LongestCommonPrefix {
    public static void main(String[] args) {
        function(new String[] {"flower","flow","flight"});
        function(new String[] {"dog","racecar","car"});
        function(new String[] {"abab","aba", ""});
    }
    private static void function(String[] str) {
        int min = Integer.MAX_VALUE;

        for(int i=1; i<str.length; i++) {
            String s1 = str[0];
            String s2 = str[i];
            int j = 0;
            int minLen = Math.min(s1.length(), s2.length());

            if(minLen == 0)
                return;

            while(j < minLen && s1.charAt(j) == s2.charAt(j))
                j++;

            min = Math.min(min, j);

            if(min == 0)
                return;
        }
        System.out.println(str[0].substring(0, min));
    }
}
