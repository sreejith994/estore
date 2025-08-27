package com.example.demo;

import java.util.*;

public class Test {
    Map<Integer,Integer> map  =new HashMap<>();
    Set<Integer> memo = new HashSet<>();
    int dfsb(int i, int n) {

        if(i==0){
            return 0;
        }
        if(i==1) {
            return 1;
        }

        if(map.containsKey(i)) return map.get(i);

        return dfsb(i-1,n)+dfsb(i-2,n);

    }

    int dfst(int n){

        if(n<1) return n;

        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for (int i=2;i<=n;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    void dfs(int n, List<List<Integer>> adj, int i, boolean[] visited){

        if(visited[i]) return ;
        visited[i]=true;

        System.out.println("consume "+ i);

        for (Integer nei : adj.get(i)) {

            if(!visited[nei]) {
                dfs(n, adj, nei, visited);
            }
        }
    }

    public String findLongestWord(String s, List<String> dictionary) {

        dictionary.sort(Comparator.comparingInt(String::length).reversed());
        Deque<Integer> d = new ArrayDeque<>();
        d.push(1);
        d.push(2);
        d.push(3);
        System.out.println("pop" + d.pop());
    }
}
