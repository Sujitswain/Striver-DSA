package org.example.Strings.Medium;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral,
just two ones added together.
12 is written as XII, which is simply X + II.
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII.
Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
                                 1    5    10   50   100 500  1000
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/

import java.util.HashMap;
import java.util.Map;

public class RI {
    public static void main(String[] args) {
        function("III");
        function("LVIII");
        function("MCMXCIV");
    }
    private static void function(String str) {
        int n = str.length();

        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);

        int number = 0;

        for(int i=0; i<n; i++) {
            if(i < n-1 && mp.get(str.charAt(i)) < mp.get(str.charAt(i+1))) {
                number += mp.get(str.charAt(i + 1)) - mp.get(str.charAt(i));
                i++;
            }
            else
                number += mp.get(str.charAt(i));
        }
        System.out.println(number);
    }
}
