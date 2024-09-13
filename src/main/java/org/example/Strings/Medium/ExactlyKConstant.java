package org.example.Strings.Medium;

/*

Input: S = "aba", K = 2
Output:3
Explanation:The substrings are: "ab", "ba" and "aba".
Input: S = "abaaca", K = 1
Output: 7
Explanation: The substrings are: "a", "b", "a", "aa", "a", "c", "a".

*/

import java.util.HashMap;
import java.util.Map;

public class ExactlyKConstant {
    public static void main(String[] args) {
        function("aba", 2);
        function("abaaca", 1);
    }
    private static void function(String str, int k) {
        System.out.println(optimalSolution(str, k) - optimalSolution(str, k-1));
    }
    private static int optimalSolution(String str, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int count = 0;

        for(int i=0, j=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            while(mp.size() > k) {
                char leftCh = str.charAt(j);
                mp.put(leftCh, mp.get(leftCh) - 1);
                if(mp.get(leftCh) == 0)
                    mp.remove(leftCh);

                j++;
            }
            count += i-j+1;
        }
        return count;
    }
}
