package fpcoding.kakao2019.p01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.welcomekakao.com/learn/courses/30/lessons/42888
public class OpenChatJava {
    private Map<String, String> nicknames(String[] events) {
        Map<String, String> map = new HashMap<>();
        for (String event: events) {
            String[] tokens = event.split(" ");
            switch (tokens[0]) {
                case "Enter": case "Change":
                    map.put(tokens[1], tokens[2]);
            }
        }
        return map;
    }

    public String[] solution(String[] records) {
        Map<String, String> nicks = nicknames(records);
        List<String> result = new ArrayList<>();
        for (String record: records) {
            String[] tokens = record.split(" ");
            switch (tokens[0]) {
                case "Enter":
                    result.add(nicks.get(tokens[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    result.add(nicks.get(tokens[1]) + "님이 나갔습니다.");
                    break;
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
