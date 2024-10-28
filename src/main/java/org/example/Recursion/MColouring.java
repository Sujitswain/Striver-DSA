package org.example.Recursion;

import java.util.Arrays;

public class MColouring {
    public static void main(String[] args) {
        function(4, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}}, 3);
    }

    private static void function(int v, int[][] edges, int m) {
        // for color array initial false
        int[] colorArr = new int[v];
        Arrays.fill(colorArr, 0);

        // for making an adjacency matrix
        int[][] graph = new int[v][v];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        if (recursionSolution(0, v, colorArr, graph, m)) {
            System.out.println("Solution exists: ");
            for (int i = 0; i < v; i++)
                System.out.println("Vertex " + i + " ---> Color " + colorArr[i]);
        } else {
            System.out.println("Solution does not exist");
        }
    }

    private static boolean recursionSolution(int node, int v, int[] colorArr, int[][] graph, int m) {
        if (node == v) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, graph, colorArr, c)) {
                colorArr[node] = c;

                if (recursionSolution(node + 1, v, colorArr, graph, m))
                    return true;

                colorArr[node] = 0;
            }
        }
        return false;
    }
    private static boolean isSafe(int node, int[][] graph, int[] colorArr, int color) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && colorArr[i] == color) {
                return false;
            }
        }
        return true;
    }
}
