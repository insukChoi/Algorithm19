package com.insuk;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String solution(final int n /*셔틀 운행 횟수*/,
                           final int t /*셔틀 운행 간격*/,
                           final int m /*한 셔틀에 탈 수 있는 최대 크루 수*/,
                           final String[] timetable /*크루 대기열 시간들*/
    ) {
        /* 첫 차 시간*/
            LocalTime shuttleTime = LocalTime.of(9, 0);

        /* 크루들 시간 마이그레이션*/
        final List<LocalTime> crews = new ArrayList<>();
        for (String time : timetable){
            crews.add(LocalTime.parse(time));
        }
        crews.sort(LocalTime::compareTo);

        int shuttleCnt = n;
        int boardingMember = 0;
        int lastShuttleEmptySeat = 0; // 마지막 셔틀의 빈 좌석 수
        LocalTime lastShuttleLastCrewTime = LocalTime.from(shuttleTime); // 마지막 셔틀의 맨 마지막으로 탄 크루의 시간
        while (shuttleCnt > 0){
            for (int i = 0; i < crews.size(); i++) {
                if (shuttleTime.isAfter(crews.get(i)) || shuttleTime.equals(crews.get(i))) {
                    lastShuttleLastCrewTime = crews.get(i);
                    crews.set(i, LocalTime.MAX); // 셔틀 탄 인원들은 LocalTime.MAX로 전환
                    boardingMember++;
                }
                if (boardingMember == m) break;
            }

            shuttleTime = shuttleTime.plusMinutes(t);
            if (shuttleCnt == 1) lastShuttleEmptySeat = (m - boardingMember);
            boardingMember = 0;
            shuttleCnt --;
        }

       /* System.out.println("마지막 셔틀의 빈 좌석 수 = " + lastShuttleEmptySeat);
        System.out.println("마지막 셔틀의 맨 마지막으로 탄 크루의 시간 = " + lastShuttleLastCrewTime);*/

        /* 콘이 가장 마지막에 탈 수 있는 시간 구하기*/
        if (lastShuttleEmptySeat == 0) return lastShuttleLastCrewTime.minusMinutes(1).toString();
        else return shuttleTime.minusMinutes(t).toString();
    }
}
