package com.insuk.java;

public class Solution {
    public int solution(final String s) {
        int maxLen, start, end, answer = 1;
        for(int i=0; i < s.length(); i++) {
            // 홀수 팰린드롬
            start = i-1; end = i+1;
            maxLen = 1;
            answer = getPalindromeLength(s, maxLen, answer, start, end);

            //짝수 팰린드롬
            start = i-1; end = i;
            maxLen = 0;
            answer = getPalindromeLength(s, maxLen, answer, start, end);
        }
        return answer;
    }

    private int getPalindromeLength(String s, int maxLen, int answer, int start, int end) {
        while(start >= 0 && end <= s.length()-1) {
            if(s.charAt(start) == s.charAt(end)) {
                maxLen += 2;
                answer = Math.max(answer, maxLen);
                start--;
                end++;
            }
            else break;
        }
        return answer;
    }
}
