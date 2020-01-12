package com.insuk;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        //String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        //String[][] tickets = {{"ICN", "ATL"}, {"ICN", "ATL"}, {"ATL", "TAL"}, {"ATL", "SFO"}, {"SFO", "ICN"}, {"TAL", "ICN"}};
        // ICN -> ATL -> SFO -> ICN -> ATL -> TAL -> ICN
        // ICN -> ATL -> TAL -> ICN -> ATL -> SFO -> ICN
        String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
        //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}, {"ICN", "JFK"}, {"HND", "ICN"}, {"JFK", "HND"}};
        Solution solution = new Solution();
        String[] answer = solution.solution(tickets);
        System.out.println(Arrays.toString(answer));
    }
}
