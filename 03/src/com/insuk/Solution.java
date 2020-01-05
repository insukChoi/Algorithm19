package com.insuk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    /**
     * [2020카카오공채] 문자열 압축
     * https://programmers.co.kr/learn/courses/30/lessons/60057
     * @param s
     * @return
     */
    public int solution(String s) {
        if (s.length() == 1) return s.length();
        int maxDv = s.length() / 2;
        StringBuilder sb = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        List<String> wordList;
        for (int i=1; i <= maxDv ; i++){ // i 개로 짜를때
            wordList = new ArrayList<>();
            // i 만큼 짤라서 list 에 넣어준다.
            for (int t=0; t <= s.length()-i; t+=i){
                wordList.add(s.substring(t, t+i));
            }

            int count = 1;
            sb.delete(0, sb.length());
            for (int j=0; j < wordList.size() - 1; j++){
                if(wordList.get(j).equals(wordList.get(j+1))){
                    count++;
                }else {
                    if (count > 1) sb.append(count).append(wordList.get(j));
                    else sb.append(wordList.get(j));
                    count = 1;
                }
            }
            //System.out.println(sb.toString());
            if (count > 1) sb.append(count).append(wordList.get(wordList.size() - 1));
            else  sb.append(wordList.get(wordList.size() - 1));
            //System.out.println(sb.toString());
            // i 만큼 짜르고 남은 문자들은 뒤에 덧붙여준다.
            if (s.length()  > sb.length()){
                int remainderIndex = s.length() % i;
               //System.out.println("r = " + remainderIndex);
                sb.append(s, s.length()-remainderIndex, s.length());
            }
            //System.out.println(sb.toString());
            resultList.add(sb.toString());
            //System.out.println("-----");
        }

        List<Integer> sizeList = resultList.stream().map(String::length).sorted().limit(1).collect(Collectors.toList());
        return sizeList.size() == 0 ? 0 : sizeList.get(0);
    }
}
