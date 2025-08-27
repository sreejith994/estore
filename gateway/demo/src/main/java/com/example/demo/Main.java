package com.example.demo;

public class Main {

    public static void main(String[] args) {
        int[][] adjMatrix = {
                //0  1  2  3  4
                {0, 1, 1, 0, 0}, // 0 connected to 1,2
                {1, 0, 0, 1, 0}, // 1 connected to 0,3
                {1, 0, 0, 0, 1}, // 2 connected to 0,4
                {0, 1, 0, 0, 1}, // 3 connected to 1,4
                {0, 0, 1, 1, 0}  // 4 connected to 2,3
        };



    }
}
