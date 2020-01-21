package fpcoding.kakao2020.round1.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

// https://tech.kakao.com/2019/10/02/kakao-blind-recruitment-2020-round1/
public class RepetitionsJava {

    String compress(List<String> cs) {
        if (cs.isEmpty()) return "";
        else {
            String head = cs.get(0);
            int reps = 0;
            for (String s: cs) {
                if (s.equals(head)) reps++;
                else break;
            }
            return (reps == 1 ? "" : reps) + head
                    + compress(cs.subList(reps, cs.size()));
        }
    }

    private List<String> grouped(String s, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= s.length(); i += n) {
            res.add(s.substring(i, Math.min(i + n, s.length())));
        }
        return res;
    }

    public String solve(String s) {
        return IntStream.rangeClosed(1, Math.max(1, s.length() / 2)).boxed()
                .map(n -> compress(grouped(s, n)))
                .min(comparing(String::length))
                .orElse("");
    }

    public int solution(String s) {
        return solve(s).length();
    }

    private static void pcompress(String s) {
        String compressed = new RepetitionsJava().solve(s);
        System.out.println("compress(" + s + ") = " + compressed.length() + ", " + compressed);
    }

    public static void main(String[] args) {
        pcompress("aabbaccc");
        pcompress("ababcdcdababcdcd");
        pcompress("abcabcdede");
        pcompress("abcabcabcabcdededededede");
        pcompress("xababcdcdababcdcd");
    }
}
