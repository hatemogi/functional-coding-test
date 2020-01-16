package fpcoding.kakao2019.p02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

// https://www.welcomekakao.com/learn/courses/30/lessons/42889
public class FailRatioJava {
    // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    private Double failRatio(Integer n, List<Integer> stages) {
        return
            (double)stages.stream().filter(s -> s.equals(n)).count() /
            Math.max(stages.stream().filter(s -> s.compareTo(n) >= 0).count(), 1);
    }

    public List<Integer> solve(int n, List<Integer> stages) {
        return IntStream.range(1, n + 1).boxed().sorted(
            Comparator.comparingDouble((Integer i) -> failRatio(i, stages)).reversed()
                    .thenComparing(i -> i)
        ).collect(toList());
    }

    public int[] solution(int n, int[] stages) {
        List<Integer> players = Arrays.stream(stages).boxed().collect(toList());
        List<Integer> ordered = solve(n, players);
        return ordered.stream().mapToInt(i -> i).toArray();
    }
}
