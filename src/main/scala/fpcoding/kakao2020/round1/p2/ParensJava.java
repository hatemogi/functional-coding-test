package fpcoding.kakao2020.round1.p2;

import static java.util.Arrays.asList;

/*
    https://tech.kakao.com/2019/10/02/kakao-blind-recruitment-2020-round1/
    https://programmers.co.kr/learn/courses/30/lessons/60058
 */
public class ParensJava {
    static boolean balanced(String s) {
        return s.chars().filter(c -> c == '(').count()
                == s.chars().filter(c -> c == ')').count();
    }

    static boolean right(String s) {
        return s.chars().reduce(0, (open, c) -> {
            if (c == '(' && open >= 0)
                return open + 1;
            else
                return open - 1;
        }) == 0;
    }

    static String correct(String s) {
        if (right(s)) return s;
        else {
            String[] uv = split(s);
            String u = uv[0], v = uv[1];
            if (right(u))
                return u + correct(v);
            else
                return "(" + correct(v) + ")" + trimReverse(u);
        }
    }

    static String[] split(String s) {
        for (int i = 1; i <= s.length(); i++) {
            if (balanced(s.substring(0, i)))
                return new String[]{s.substring(0, i), s.substring(i)};
        }
        return new String[]{"", ""};
    }

    static String trimReverse(String s) {
        return s.substring(1, s.length() - 1)
                .replace('(', 'T')
                .replace(')', '(')
                .replace('T', ')');
    }

    public static void main(String[] args) {
        System.out.println(asList(
            balanced("(()())()"), balanced(")("), balanced("()))((()")));
        System.out.println(asList(
                right("(()())()"), right(")("), right("()))((()")));
        System.out.println(correct(")("));
    }
}
