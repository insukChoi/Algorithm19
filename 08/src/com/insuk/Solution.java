package com.insuk;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 * 조이스틱
 */
public class Solution {
    public int solution(String name) {
        int[] answer = new int[2];

        char ch;
        int topCnt;
        int downCnt;
        String temp;

        // 1) 노빠꾸
        for (int i=0; i < name.length(); i++){
            ch = name.charAt(i);
            if (ch != 'A'){
                topCnt = ch - 'A';
                downCnt = ('Z' - ch) + 1;
                answer[0] += Math.min(topCnt, downCnt);
            }
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
        if (backIndex == name.length() -1){
            backIndex = 0;
        }

        answer[1] = backIndex;

        // 2 -3) backIndex 부터 무조건 계속 빠꾸만
        int i=backIndex;
        do{
            ch = name.charAt(i);
            if (ch != 'A') {
                topCnt = ch - 'A';
                downCnt = ('Z' - ch) + 1;
                answer[1] += Math.min(topCnt, downCnt);
            }
            if (i == 0) i = name.length();  // i가 0이니.. 맨뒤 인덱스로..
            if (i > backIndex){ // A 이외의 문자가 있는지 체크
                temp = name.substring(backIndex + 1, i);
                if (!hasNotA(temp)) break;
            }
            answer[1] ++;
            i --;

        }while (i != backIndex);
        System.out.println("한번 빠꾸 후 계속 빠꾸 : " + answer[1]);

        return Math.min(answer[0], answer[1]);
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
