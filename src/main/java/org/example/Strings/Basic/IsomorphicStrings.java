package org.example.Strings.Basic;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true
*/

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        function("paper", "title");
        function("foo", "bar");
        function("egg", "add");
    }
    private static void function(String s1, String s2) {
        // UsingTwoMaps(s1, s2);
        UsingOneMap(s1, s2);
    }
    private static void UsingOneMap(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 != n2) {
            System.out.println("Not Possible");
            return;
        }

        Map<Character, Character> mp = new HashMap<>();
        for(int i=0; i<n1; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if(mp.containsKey(a)) {
                if(mp.get(a) != b) {
                    System.out.println("Not Possible");
                    return;
                }
            }
            else {
                if(mp.containsValue(b)) {
                    System.out.println("Not Possible");
                    return;
                }
                mp.put(a, b);
            }
        }
        System.out.println("It is");
    }
    private static void UsingTwoMaps(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 != n2) {
            System.out.println("No isomorphic");
            return;
        }

        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for(int i=0; i<n1; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if(mp1.get(a) != mp2.get(b)) {
                System.out.println("Not Possible");
                return;
            }
            mp1.put(a, i+1);
            mp2.put(b, i+1);
        }
        System.out.println("It is");
    }
}
