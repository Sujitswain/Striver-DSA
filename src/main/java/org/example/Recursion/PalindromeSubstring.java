package org.example.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: [["a","a","b","b"],["aa","b","b"],["a","a","bb"],["aa","bb"]]
 *
 */

public class PalindromeSubstring {
    public static void main(String[] args) {
        List<List<String>> result = function("aab");
        System.out.println(result);
    }

    private static boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }

    private static List<List<String>> function(String str) {
        List<List<String>> res = new ArrayList<>();
        recursion(str, 0, new ArrayList<>(), res);
        return res;
    }

    private static void recursion(String str, int start, List<String> temp, List<List<String>> res) {
        if (start == str.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                temp.add(str.substring(start, i + 1));
                recursion(str, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
