package com.insuk;

import java.math.BigInteger;
import java.util.HashMap;

public class Solution {
    public int solution(final String[][] clothes) {
        BigInteger answer = new BigInteger("1");
        final HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] clo : clothes){
            hashMap.put(clo[1], hashMap.getOrDefault(clo[1], 1) + 1);
        }

        for (String key : hashMap.keySet()){
            //System.out.println(key + " : " +hashMap.get(key));
            answer = answer.multiply(BigInteger.valueOf(hashMap.get(key)));
        }

        return answer.subtract(BigInteger.valueOf(1)).intValue();
    }
}
