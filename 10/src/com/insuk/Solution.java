package com.insuk;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(final int[][] jobs) {
        int answer = 0, ms = 0;
        List<int[]> exeList = new ArrayList<>(); // 실행가능한 jobs 리스트
        List<int[]> doneJob = new ArrayList<>(); // 완료된 jobs 리스트

        while (jobs.length != doneJob.size()){
            exeList.clear();
            // 현재 ms 에서 실행 가능한 job 찾기
            for (int[] job : jobs){
                if (ms >= job[0] && !doneJob.contains(job)) exeList.add(job);
            }

            // 현재 ms 에서 실행 가능한 job이 없으면, ms 한칸 증가시키고 continue
            if (exeList.size() < 1) {
                ms ++;
                continue;
            }

            // 실행 가능한 job 중에 실행시간이 가장 작은 것 찾아서 실행시키기
            int[] minExe = exeList.get(0);
            for (int[] exe : exeList) {
                if (minExe[1] > exe[1]) minExe = exe;
            }
            doneJob.add(minExe);

            answer += (ms - minExe[0]) + minExe[1]; // answer += (대기시간 + job 실행시간)
            ms += minExe[1];
        }

        return answer / jobs.length;
    }
}