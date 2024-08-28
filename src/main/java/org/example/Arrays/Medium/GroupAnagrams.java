package org.example.Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        function(new String[] {"eat","tea","tan","ate","nat","bat"});
    }
    private static void function(String[] strs) {
        Map<String, ArrayList<String>> mp = new HashMap<>();
        for(String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort((charArr));
            String sortStr = String.valueOf(charArr);

            mp.computeIfAbsent(sortStr, k -> new ArrayList<>()).add(s);
        }

        System.out.println(mp.values());

    }
}
