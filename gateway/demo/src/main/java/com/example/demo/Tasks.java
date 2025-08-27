package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tasks {

    public static void main(String[] args) {
        String s = "abc";
        String res = get(s);
        System.out.println(res);

        Comparator.comparingInt();
        var list = List.of("myron", "fresh", "zherka", "organic");

        Map<String, Integer> collect = list.stream()

                .collect(Collectors.toMap(
                        n -> n,
                        String::length
                ));

        int[] intArray = new int[]{1,2,3,4,5};

        List<Integer> list1 = IntStream.of(intArray)
                .filter(n -> n > 2)
                .boxed()
                .toList();

        String[] strings = new String[]{"ab","bb","ct"};

        List<String> b = Arrays.stream(strings)
                .filter(str -> str.contains("b"))
                .toList();

        System.out.println("fib "+getFib(5));

        System.out.println("lis "+ lis(new int[]{1,2,4,3},3));


        // Create a graph with 5 nodes (0 to 4)
        Graph g = new Graph(5);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        // Print adjacency list
        g.printGraph();

        // 👉 Your task: implement DFS starting from node 0
        System.out.println("DFS");
        g.dfs(0, new boolean[5]);

        var map = new HashMap<Integer,Integer>();
        long count = map.keySet().stream().count();
    }





    public static String get(String s) {
        int count =1;
        StringBuilder res = new StringBuilder();
        for (int i=0;i < s.length(); i++){

            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)){
                count++;
            } else {
                res.append(String.valueOf(s.charAt(i))).append(count);
                count = 1;
            }

        }

        return res.toString();
    }

    public static void doEncode(String str) {
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                System.out.print(str.charAt(i));
                System.out.print(count);
                count=1;
            }
        }
    }

    public static int getFib(int n) {
        // 1 1 2 3 5 8 13
        int res = 0;
        if (n == 1 || n==2) {
            res = 1;
        }else {


             res = getFib(n - 1) + getFib(n - 2);
        }
        return res;

    }

    public static int lis(int[] nums, int n){
        if(nums.length-1==n) {
            return 1;
        };

        if(nums[n]<nums[n+1]){
            return lis(nums,n+1)+1;
        } else{
            return 1;
        }
    }

    public boolean validWordAbbr(String w, String a) {

        int wLen = w.length();
        int aLen = a.length();
        int i=0, j=0;
        while(i< aLen && j< wLen ){
            StringBuilder s = new StringBuilder();
            if(Character.isAlphabetic(a.charAt(i))){
                if(a.charAt(i) == w.charAt(j)){
                    i++;
                    j++;
                    continue;
                }
                return false;
            } while ( i< aLen && Character.isDigit(a.charAt(i))) {
                if (a.charAt(i) == '0'){
                    return false;
                }
                s.append(a.charAt(i));
                i++;
            }
            if(Integer.parseInt(s.toString()) > (wLen-j)){
                return false;
            } else {
                j += Integer.parseInt(s.toString());
            }
        }
        return i == aLen && j== wLen;
    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            q.offer(num);

        }

        if(q.size()>k){
            for(int i=1;i<k;i++){
                q.poll();
            }
            return q.peek();
        }

        String s = "test";


        Queue<String> queue = new PriorityQueue<>(Comparator.comparingInt(String::length).reversed());

        List<Integer[]> list = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        list.sort((a,b) -> b[0] - a[0]);
        strings.sort();

    }




}


// 1 2 3 4 -> even (a[length/2] + a[length/2+1])/2
// 1 2 3 4 5 -> odd a[int length/2 +1]