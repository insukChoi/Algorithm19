package com.insuk;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/43164
     *
     * @param tickets : String[][]
     * @return answer : String[]
     */
    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();

        List<Ticket> ticketList = Arrays.stream(tickets)
                .map(s -> new Ticket(s[0], s[1]))
                .collect(Collectors.toList());

        dfs("ICN", ticketList, answer, ticketList.size() + 1);

        return answer.toArray(new String[answer.size()]);
    }

    private void dfs(String from, List<Ticket> tickets, List<String> answer, int n) {
        if (answer.size() == n) return;
        answer.add(from);
        List<Ticket> nexts = tickets.stream()
                .filter(t -> t.getFrom().equals(from) && !t.isVisited())
                .sorted(Comparator.comparing(Ticket::getTo))
                .collect(Collectors.toList());

        for (int i = 0; i < nexts.size(); i++) {
            nexts.get(i).setVisited(true);
            dfs(nexts.get(i).getTo(), tickets, answer, n);

            if (answer.size() != n) { // 더이상 진행되는게 없으면 롤백!
                answer.remove(answer.size() - 1);
                nexts.get(i).setVisited(false);
            }
        }
    }
}

class Ticket {
    private String from;
    private String to;
    private boolean visited;

    public Ticket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}