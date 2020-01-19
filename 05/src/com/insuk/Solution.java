package com.insuk;

public class Solution {
    public String solution(final int n) {
        StringBuilder answer = new StringBuilder();
        int mock = n;
        int reminder;
        while (mock > 0){
            reminder = mock % 3;
            mock = mock / 3;

            if (reminder == 0){
                reminder = 4;
                mock = mock -1;
            }
            answer.append(reminder);
        }

        return answer.reverse().toString();
    }
}
