package org.example.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateAllSubstrings {
    public static void main(String[] args) {
        function("aab");
    }
    private static void function(String str) {
        // List<String> res = iterativeSolution(str);

        List<String> res = new ArrayList<>();
        recursionSolution(str, 0, 0, res);

        System.out.println(res);
    }
    private static void recursionSolution(String str, int start, int end, List<String> result) {
        if(start >= str.length())
            return;

        if (end >= str.length()) {
            recursionSolution(str, start+1, start+1, result);
            return;
        }
        result.add(str.substring(start, end+1));
        recursionSolution(str, start, end+1, result);
    }
    private static List<String> iterativeSolution(String str) {
        List<String> res = new ArrayList<>();
        for (int start = 0; start < str.length(); start++) {
            for (int end = start; end < str.length(); end++) {
                res.add(str.substring(start, end + 1));
            }
        }
        return res;
    }
}
