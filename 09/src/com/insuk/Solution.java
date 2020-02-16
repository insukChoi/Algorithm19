package com.insuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int columnCnt = relation[0].length;
        int rowCnt = relation.length;
        List<HashMap<String, Integer>> allCombinationList = new ArrayList<>();

        // 모든 조합 구하기
        int index = 1;
        while (index <= columnCnt){
            allCombinationList.add( getCombination(index, relation, columnCnt, rowCnt) );
            index ++;
        }

        // 모든 조합 중 유일키가 아닌것 제외
        for (int i=0; i<allCombinationList.size(); i++){
            for(String key : allCombinationList.get(i).keySet()){
                int v = allCombinationList.get(i).get(key);
                if (v != 1){
                    allCombinationList.remove(i);
                    break;
                }
            }
        }

        // 후보키가 아닌것 제외

        /*for (int i=0; i<allCombinationList.size(); i++){
            System.out.println("i = " + i);
            HashMap<String, Integer> hashMap = allCombinationList.get(i);
            for(String key : hashMap.keySet()){
                int value = hashMap.get(key);
                System.out.print(key + ":" + value + ", ");
            }
            System.out.println();
        }*/

        return answer;
    }

    private HashMap<String, Integer> getCombination(int index, String[][] relation, int columnCnt, int rowCnt) {
        HashMap<String, Integer> hashMap = new HashMap();

        /*for (int i=0; i < columnCnt; i=i+index){
            for (int j=0; j < rowCnt; j++) {
                tempStr = getKeyStr(index, relation, i, j, columnCnt);
                hashMap.put(tempStr, hashMap.getOrDefault(tempStr, 0) + 1);
            }
        }*/
        StringBuilder temp;
        for (int i=0; i < columnCnt; i++){
            for (int j=0; j < rowCnt; j++) {
                temp = new StringBuilder(relation[j][i]);
                if (index == 1){
                    hashMap.put(temp.toString(), hashMap.getOrDefault(temp.toString(), 0) + 1);
                } else {
                    for (int k=0; k < index; k++){
                        for (int q=k+1; q < columnCnt; q++){
                            if (relation[j][i] == relation[j][q]) continue;
                            temp.append("_").append(relation[j][q]);
                            hashMap.put(temp.toString(), hashMap.getOrDefault(temp.toString(), 0) + 1);
                        }
                    }
                }
            }
        }

        return hashMap;
    }

    private String getKeyStr(int index, String[][] relation, int i, int j, int columnCnt) {
        StringBuilder temp = new StringBuilder(relation[j][i]);
        for (int k=1; k < index; k++){
            for (int q=k+1; q < columnCnt; q++){
                temp.delete(0, temp.length());
                temp.append("_").append(relation[j][q]);
            }
        }
        return temp.toString();
    }
}
