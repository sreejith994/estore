package com.example.demo;

import java.util.*;

public class GraphV2 {

    int n;
    List<List<Integer>> adjecentMatrix = new ArrayList<>();

    public GraphV2(int n) {
        this.n=n;
        for (int i = 0; i < n; i++) {
            adjecentMatrix.add(new ArrayList<>());
        }
    }

    void addNode(int v, int u){
        adjecentMatrix.get(v).add(u);
        adjecentMatrix.get(u).add(v);
    }

    void dfs(int v, Set<Integer> memory){

        System.out.println("node: v");
        if (!memory.add(v)) {
            return;
        }

        for (Integer neighbour : adjecentMatrix.get(v)) {
            if(memory.contains(neighbour)){
                dfs(neighbour,memory);
            }
        }
    }

    void bsf(int v){
        Set<Integer> memory = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        memory.add(v);
        q.offer(v);

        while(!q.isEmpty()){

            Integer poll = q.poll();
            System.out.println(poll);

            for (Integer neighbour : adjecentMatrix.get(poll)) {
                if(!memory.contains(neighbour)){
                    q.offer(neighbour);
                }
            }
        }
    }
}
