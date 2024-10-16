package org.example.Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class substringWithoutConsecutive1 {
    public static void main(String[] args) {
        function(3);
    }
    private static void function(int n) {
        // iterativeSolution(n);

        ArrayList<String> res = new ArrayList<>();
        recursiveSolution(n, "", res);
        System.out.println(res);
    }
    private static void iterativeSolution(int n) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("");
        while(!q.isEmpty()) {
            String str = q.poll();

            if(str.length() == n)
                res.add(str);
            else {
                q.add(str + "0");

                if(str.length() == 0 || str.charAt(str.length()-1) != '1')
                    q.add(str + "1");
            }
        }
        System.out.println(res);
    }
    private static void recursiveSolution(int n, String str, ArrayList<String> res) {
        if(str.length() == n) {
            res.add(str);
            return;
        }

        recursiveSolution(n, str + "0", res);

        if (str.length() == 0 || str.charAt(str.length() - 1) != '1')
            recursiveSolution(n, str + "1", res);
    }
}
