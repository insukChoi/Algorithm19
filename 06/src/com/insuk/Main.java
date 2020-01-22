package com.insuk;

public class Main {
    public static void main(String[] args) {
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        //String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution solution = new Solution();
        System.out.println(solution.solution(clothes));
    }
}
