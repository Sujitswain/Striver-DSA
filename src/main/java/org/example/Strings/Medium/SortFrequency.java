package org.example.Strings.Medium;

/*
Given a string s, sort it in decreasing order based on the
frequency of the characters.

The frequency of a character is the number of times
it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortFrequency {
    public static void main(String[] args) {
        function("tree");
        // function("cccaaa");
        // function("Aabb");
    }
    private static void function(String str) {
        Map<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<str.length(); i++) {
            mp.put(str.charAt(i),
                    mp.getOrDefault(str.charAt(i), 0) +1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(mp.entrySet());
        System.out.println(pq);
        String s = "";

        while(!pq.isEmpty())
            s += pq.poll().getKey();


        System.out.println(s);
    }
}