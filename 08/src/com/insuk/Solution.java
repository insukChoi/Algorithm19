package com.insuk;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 * 조이스틱
 */
public class Solution {
    public int solution(String name) {
        int[] answer = new int[2];
        char ch;

        // 1) 노빠꾸
        for (int i=0; i < name.length(); i++){
            ch = name.charAt(i);
            if (ch != 'A') answer[0] += getMinCnt(ch);
            if (!hasNotA(name.substring(i))) break;
            if (i != 0) answer[0] ++;
        }
        System.out.println("노빠꾸 : " + answer[0]);

        // 2) 한번 빠꾸하면 그대로 계속 빠꾸만!
        // 2 -1) 어디서부터 빠꾸해야할지 backIndex 를 찾는다.
        int backIndex = 0;
        for (int i=0; i < name.length(); i++){
            ch = name.charAt(i);
            if (ch != 'A'){
                backIndex = i;
                break;
            }
        }

        // 2 -2) backIndex가 맨마지막이면 맨첫번째 A부터 빠꾸
        if (backIndex == name.length() -1) backIndex = 0;

        // 2 -3) backIndex 부터 무조건 계속 빠꾸만
        answer[1] = backIndex;
        int i = backIndex;
        do{
            ch = name.charAt(i);
            if (ch != 'A') answer[1] += getMinCnt(ch);
            if (i == 0) i = name.length();  // i가 0이니.. 맨뒤 인덱스로..
            if (i > backIndex){ // A 이외의 문자가 있는지 체크
                if (!hasNotA(name.substring(backIndex + 1, i)))
                    break;
            }
            answer[1] ++;
            i --;
        }while (i != backIndex);
        System.out.println("한번 빠꾸 후 계속 빠꾸 : " + answer[1]);

        return Math.min(answer[0], answer[1]);
    }

    /**
     * 주어진 파라미터가 A에서 가장 가까운 방향의 카운트
     * @param ch
     * @return
     */
    private int getMinCnt(char ch) {
        int topCnt = ch - 'A';
        int downCnt = ('Z' - ch) + 1;
        return Math.min(topCnt, downCnt);
    }

    /**
     *  A 이외의 문자가 포함되어있는지 획인
     * @param temp
     * @return
     */
    private boolean hasNotA(String temp) {
        for (int k=0; k< temp.length(); k++){
            char t = temp.charAt(k);
            if (t != 'A') return true;
        }
        return false;
    }

}
