package com.insuk;

import java.util.ArrayList;
import java.util.List;

/**
 * 영어 끝말잇기
 * https://programmers.co.kr/learn/courses/30/lessons/12981
 */
final public class Solution {
    public int[] solution(final int n, final String[] words) {
        List<String> wordList = new ArrayList<>();
        int num = 0;   // 번호
        int order = 0; // 차례
        String prev;
        for (int i = 0; i < words.length; i++) {
            if (i != 0){
                prev = wordList.get(wordList.size()-1);
                if (!prev.substring(prev.length()-1).equals(words[i].substring(0,1)) || wordList.contains(words[i])){
                    num = (i+1) % n == 0 ? n : (i+1) % n;
                    order = (i / n) + 1;
                    break;
                }
            }
            wordList.add(words[i]);
        }

        return new int[]{num, order};
    }
}
