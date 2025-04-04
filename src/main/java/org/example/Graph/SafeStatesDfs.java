package org.example.Graph;

import java.util.*;

public class SafeStates {
    /*
     *
     *   0 -----------> 1
     *   |\            / |
     *   | \          /  |
     *   |  \        /   |
     *   |   \      /    |
     *   |    \    /     |
     *   |     \  /      |
     *   |      \        |
     *   |     / \       |
     *   |    /   \      |
     *   |   /     \     |
     *   | |/       \/  \/
     *   2             3
     *   |
     *   |                        6
     *   |
     *   |
     *   \/
     *   5 <---------- 4
     *
     * */
    public static void main(String[] args) {

        int N = 7;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3},
                {3, 0},
                {2, 5},
                {4, 5}
        };

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] visited = new int[N];
        int[] pathVisited = new int[N];
        int[] safeNodes = new int[N];

        // preparing adjList
        for (int i = 0; i < N; i++) {
            adjList.putIfAbsent(i, new ArrayList<>());
            visited[i] = 0;
        }

        for (int[] arr : edges)
            adjList.get(arr[0]).add(arr[1]);

        for (int i = 0; i < N; i++) {
            dfsSolution(i, adjList, visited, pathVisited, safeNodes);
        }
        System.out.println(Arrays.toString(safeNodes));
    }

    private static boolean dfsSolution(int vertex, Map<Integer, List<Integer>> adjList, int[] visited, int[] pathVisited, int[] safeNodes) {
        safeNodes[vertex] = 0;
        visited[vertex] = 1;
        pathVisited[vertex] = 1;

        for (int neighobour : adjList.get(vertex)) {
            if (visited[neighobour] == 0) {
                if(dfsSolution(neighobour, adjList, visited, pathVisited, safeNodes))
                    return true;
            }
            else if (pathVisited[neighobour] == 1) {
                return true;
            }
        }

        safeNodes[vertex] = 1;
        pathVisited[vertex] = 0;
        return false;
    }
}