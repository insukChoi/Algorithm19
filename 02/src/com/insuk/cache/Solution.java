package com.insuk.cache;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final int CACHE_HIT_TIME = 1;
    private final int CACHE_MISS_TIME = 5;

    /**
     * 2018 KAKAO BLIND RECRUITMENT > [1차]캐시
     * https://programmers.co.kr/learn/courses/30/lessons/17680
     * @param cacheSize
     * @param cities
     * @return
     */
    public int solution(final int cacheSize, final String[] cities) {
        if (cacheSize == 0) return cities.length * CACHE_MISS_TIME;
        int answer = 0;
        Queue<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += CACHE_HIT_TIME;
            } else {
                if (cache.size() < cacheSize) {
                    cache.add(city);
                    answer += CACHE_MISS_TIME;
                } else {
                    cache.poll();
                    cache.add(city);
                    answer += CACHE_MISS_TIME;
                }
            }
        }
        return answer;
    }
}
