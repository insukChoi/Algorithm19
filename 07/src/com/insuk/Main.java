package com.insuk;

public class Main {
    public static void main(String[] args) {
        int n = 3; String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        //int n = 5; String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        //int n = 2; String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        Solution solution = new Solution();
        solution.solution(n, words);
    }
}
