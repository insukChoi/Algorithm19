package com.insuk;

/**
 * 가장 큰 정사각형 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12905
 */
class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        for(int i=1;i<board.length;i++) {
            for(int j=1;j<board[i].length;j++) {
                if(board[i][j] == 1) {
                    board[i][j] = min(
                            board[i - 1][j],
                            board[i][j - 1],
                            board[i - 1][j - 1]
                    ) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        if (answer == 0) answer = checkOnesquare(board);
        return answer * answer;
    }

    private int min(int... args) {
        int minVal = args[0];
        for (int a : args) {
            minVal = Math.min(minVal, a);
        }
        return minVal;
    }

    private int checkOnesquare(int[][] board) {
        int answer = 0;
        R:
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    answer = 1;
                    break R;
                }
            }
        }
        return answer;
    }
}