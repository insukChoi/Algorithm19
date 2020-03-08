package com.insuk;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int t = 10;
        int m = 2;
        //String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
        String[] timetable = {"09:10", "09:09", "08:00"};
        //String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
        //String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        /*String[] timetable = {
                "23:59","23:59","23:59","23:59",
                "23:59","23:59","23:59","23:59",
                "23:59","23:59","23:59","23:59",
                "23:59","23:59","23:59","23:59"};*/

        Solution solution = new Solution();
        System.out.println(solution.solution(n, t, m, timetable));
    }
}
