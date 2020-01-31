package fpcoding.kakao2020.round1.p2

object Parens extends App {
  def balanced(s: List[Char]): Boolean =
    s.count(_ == '(') == s.count(_ == ')')

  def right(s: List[Char]): Boolean = {
    @scala.annotation.tailrec
    def r(open: Int, cs: List[Char]): Boolean =
      if (open < 0) false
      else if (cs.isEmpty) open == 0
      else
        r(open + (cs.head match {
          case '(' => 1
          case ')' => -1
          case _ => 0
        }), cs.tail)
    r(0, s)
  }

  /*
    1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며,
       v는 빈 문자열이 될 수 있습니다.
    3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
      3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
      4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
      4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
      4-3. ')'를 다시 붙입니다.
      4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
      4-5. 생성된 문자열을 반환합니다.
   */

  def split(s: List[Char]): (List[Char], List[Char]) = {
    @scala.annotation.tailrec
    def sp(u: List[Char], v: List[Char]): (List[Char], List[Char]) =
      if (balanced(u)) (u, v)
      else sp(u.appended(v.head), v.tail)
    if (s.isEmpty) (Nil, Nil)
    else sp(s.head :: Nil, s.tail)
  }

  def correct(s: String): String = {
    def trimReverse(cs: List[Char]): List[Char] =
      cs.tail.reverse.tail.foldLeft(List[Char]()) {
        case (cs, '(') => ')' :: cs
        case (cs, ')') => '(' :: cs
      }

    def c(cs: List[Char]): List[Char] = {
      if (cs.isEmpty) Nil
      else if (right(cs)) cs
      else {
        val (u, v) = split(cs)
        if (right(u)) u ++ c(v)
        else ('(' :: c(v)).appended(')') ++ trimReverse(u)
      }
    }
    c(s.toList).mkString
  }


  println(balanced("(()())()".toList), balanced(")(".toList), balanced("()))((()".toList))
  println(right("(()())()".toList), right(")(".toList), right("()))((()".toList))
  println(correct(")("))
}
