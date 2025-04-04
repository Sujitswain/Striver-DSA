package org.example.Graph;

import java.util.*;

public class DetectCycleBFSUndirectedGraph {
    /*
    *      0
          / \
         1   2
        / \   \
       3   4   5
        \ /
         6
    */
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {2, 5},
                {4, 6},
                {3, 6}
        };

        // Preparing adjlist
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] arr : edges) {
            adjList.putIfAbsent(arr[0], new ArrayList<>());
            adjList.putIfAbsent(arr[1], new ArrayList<>());

            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }

        // Printing the adjacency list
        System.out.println("Adjacency List:");
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        Set<Integer> visitedSet = new HashSet<>();
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        q.offer(new Pair<>(0, -1));
        visitedSet.add(0);

        while(!q.isEmpty()) {
            Pair<Integer, Integer> front = q.poll();
            Integer vertex = front.first;
            Integer parent = front.second;
            for(int neighbour : adjList.get(vertex)) {
                if(!visitedSet.contains(neighbour)) {
                    visitedSet.add(neighbour);
                    q.offer(new Pair<>(neighbour, vertex));
                }
                else if(parent != neighbour) {
                    System.out.println("Cycle present: " + vertex + " : " + neighbour);
                    return;
                }
            }
        }
        System.out.println("Cycle not present...");
    }
}
