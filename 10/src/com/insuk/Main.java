package com.insuk;

public class Main {
    public static void main(String[] args) {
        //int[][] test = {{0,3}, {1,9}, {2,6}};
        int[][] test = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
        Solution solution = new Solution();
        System.out.println( solution.solution(test) );
    }
}
