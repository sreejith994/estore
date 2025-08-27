package com.example.demo;

import java.util.*;

class Graph {
    int n; // number of nodes
    List<List<Integer>> adj; // adjacency list

    // Constructor
    Graph(int n) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge (undirected)
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // remove this line if you want a directed graph
    }

    // Print adjacency list (for debugging)
    void printGraph() {
        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }

    void dfs(int node, boolean[] visited) {
        // 1. Mark this node as visited
        visited[node] = true;

        // 2. Do something with the node (optional, e.g. print)
        System.out.print(node + " ");

        // 3. Explore neighbors
        for (int neighbor : adj.get(node)) {
            // check if neighbor not visited
            if (!visited[neighbor]) {
                // 👉 recurse into neighbor (your part)
                dfs(neighbor, visited);
            }
        }
    }

    void bfs(int start) {
        boolean[] visited = new boolean[n]; // track visited nodes
        Queue<Integer> q = new LinkedList<>();

        // start from the given node
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " "); // process node

            // explore neighbors
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }



}