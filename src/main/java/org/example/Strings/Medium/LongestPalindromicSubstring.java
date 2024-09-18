package org.example.Strings.Medium;

import java.util.Arrays;

/*
        0   1   2   3   4
      0 b   a   b   a   d
      1 a
      2 b
      3 a
      4 d
*/

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        function("babad");
        function("cbbd");
        function("hihowareracecaryoumalayalam");

    }
    private static void function(String str) {
        UsingDP(str);
        // BruteForce(str);
    }
    private static void BruteForce(String s) {
        int n = s.length();
        if (n <= 1) {
            System.out.println(s);
            return;
        }
        int max = 0;
        int start = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=1; j++) {
                int low=i;
                int high =i+j;
                while( (low >=0 && high < n) && (s.charAt(low) == s.charAt(high)) ) {
                    int currLen = high - low + 1;
                    if(currLen > max) {
                        start = low;
                        max = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }
        System.out.println(s.substring(start, start+max));
    }

    private static void UsingDP(String str) {
        int n = str.length();

        int s = 0, e = 0;
        int max = 0;
        boolean[][] dp = new boolean[n][n];

        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], false);

        for(int g=0; g<n; g++) {
            for(int i=0, j=g; j<n; i++, j++) {
                if(g == 0) {
                    dp[i][j] = true;
                }
                else if(g == 1) {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                else {
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j] && g+1 > max) {
                    s = i;
                    e = j;
                    max = g+1;
                }
            }
        }
        for(int i=0; i<dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(str.substring(s, e+1));
    }
}
