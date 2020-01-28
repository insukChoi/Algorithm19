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
        int backIndex = 0;
        for (int i=0; i < name.length(); i++){
            ch = name.charAt(i);
            if (ch != 'A'){
                backIndex = i;
                break;
            }
        }

        answer[1] = backIndex;

        System.out.println("시작 : answer[1] = " + answer[1]);
        int i=backIndex;
        do{
            System.out.println("index = " + i);
            ch = name.charAt(i);
            System.out.println("ch = " + ch);
            if (ch != 'A') {
                topCnt = ch - 'A';
                downCnt = ('Z' - ch) + 1;
                answer[1] += Math.min(topCnt, downCnt);
            }

            System.out.println("answer[1] = " + answer[1]);
            if (i == 0) {
                i = name.length();
                System.out.println("i가 0이니 ... " + i);
            }
            // 체크한다.
            if (i > backIndex){
                temp = name.substring(backIndex + 1, i);
                System.out.println("1) temp = " + temp);
                if (!hasNotA(temp)) break;
            }else{
                temp = name.substring(i, backIndex+1);
                System.out.println("2) temp = " + temp);
                if (!hasNotA(temp)) break;
            }
            answer[1] ++;
            i --;
            System.out.println("answer[1] = " + answer[1]);
            System.out.println("--------------");

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
