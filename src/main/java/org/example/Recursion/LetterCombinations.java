package org.example.Recursion;

import java.util.HashMap;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        function("234");
    }
    private static void function(String str) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(0, "");
        mp.put(1, "");
        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");

        recursion(str, mp, 0, new StringBuilder());
    }
    private static void recursion(String str, Map<Integer, String> mp, int index, StringBuilder temp) {
        if(temp.length() == str.length()){
            System.out.println(temp);
            return;
        }

        int digit = str.charAt(index)-48;
        String letters = mp.get(digit);
        for(int i=0; i<letters.length(); i++) {
            temp.append(letters.charAt(i));
            recursion(str, mp, index+1, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
