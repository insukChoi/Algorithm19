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
        int maxDv = s.length() / 2;
        StringBuilder sb = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        for (int i=1; i <= maxDv ; i++){ // i 개로 짜를때
            String temp = "";
            int count = 1;
            sb.delete(0, sb.length());
            for (int j=0; j < s.length(); ){
                if (j+i > s.length()){
                    sb.append(s.substring(j));
                    break;
                }

                String comp = s.substring(j, j+i);
                if(temp.equals(comp)){
                    count ++;
                }else {
                    temp = comp;
                    count = 1;
                }

                sb.append(count).append(temp);
                j = j+i;
            }
            //System.out.println(sb.toString());
            StringBuilder tempSb = new StringBuilder();
            for (int k=0; k < sb.toString().length(); k = k+(i+1)){
                if (k+(i+1) + (i+1) > sb.toString().length()){
                    tempSb.append(sb.substring(k));
                    break;
                }
                String str = sb.toString().substring(k, k+(i+1));
                String nextStr = sb.toString().substring(k+(i+1), k+(i+1) + (i+1));
                if (Integer.parseInt(str.substring(0,1)) < Integer.parseInt(nextStr.substring(0,1))){
                    tempSb.append(str.replaceAll("[a-z0-9]", "1"));
                } else{
                    tempSb.append(str);
                }
            }
            String result = tempSb.toString().replaceAll("1", "");
            //System.out.println(result);
            //System.out.println("-----------------");
            resultList.add(result);
        }

        List<Integer> sizeList = resultList.stream().map(String::length).sorted().limit(1).collect(Collectors.toList());
        return sizeList.size() == 0 ? 0 : sizeList.get(0);
    }
}
