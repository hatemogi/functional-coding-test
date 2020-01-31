package fpcoding.kakao2020.round1.p2;

import java.util.Iterator;

import static java.util.Arrays.asList;

public class ParensJava {
    static boolean balanced(String s) {
        return s.chars().filter(c -> c == '(').count()
                == s.chars().filter(c -> c == ')').count();
    }

    private static boolean r(int open, Iterator<Integer> cs) {
        if (open < 0) return false;
        else if (!cs.hasNext()) return open == 0;
        else {
            int next = open;
            char c = (char)cs.next().intValue();
            switch (c) {
                case '(':
                    next++;
                    break;
                case ')':
                    next--;
                    break;
            }
            return r(next, cs);
        }
    }

    static boolean right(String s) {
        return r(0, s.chars().boxed().iterator());
    }

    static String[] split(String s) {
        if (s.isEmpty()) return new String[]{"", ""};
        for (int i = 1; i <= s.length(); i++) {
            if (balanced(s.substring(0, i)))
                return new String[]{s.substring(0, i), s.substring(i)};
        }
        throw new IllegalArgumentException();
    }

    static String trimReverse(String s) {
        StringBuilder out = new StringBuilder();
        for (char c: s.substring(1, s.length() - 1).toCharArray()) {
            if (c == '(')
                out.append(")");
            else if (c == ')')
                out.append("(");
        }
        return out.toString();
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

    public static void main(String[] args) {
        System.out.println(asList(
            balanced("(()())()"), balanced(")("), balanced("()))((()")));
        System.out.println(asList(
                right("(()())()"), right(")("), right("()))((()")));
        System.out.println(correct(")("));
    }
}
