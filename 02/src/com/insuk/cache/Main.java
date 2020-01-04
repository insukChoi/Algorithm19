package com.insuk.cache;

public class Main {
    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

        Solution solution = new Solution();
        int answer = solution.solution(cacheSize, cities);
        System.out.println("answer = " + answer);
    }
}
