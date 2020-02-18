package com.insuk;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };*/

        String[][] relation = {
                {"100","ryan","music"},
                {"200","apeach","math"},
                {"300","tube","computer"},
                {"400","con","computer"},
                {"500","muzi","music"},
                {"600","apeach","music"}
        };

        String[][] relation1 = {
                {"100","ryan"},
                {"200","apeach"},
                {"300","tube"},
                {"400","con"},
                {"500","muzi"},
                {"600","apeach"}
        };


        int r = solution.solution(relation);
        System.out.println(r);
    }

}
