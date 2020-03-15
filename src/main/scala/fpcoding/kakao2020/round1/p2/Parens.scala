package fpcoding.kakao2020.round1.p2

/*
    https://tech.kakao.com/2019/10/02/kakao-blind-recruitment-2020-round1/
    https://programmers.co.kr/learn/courses/30/lessons/60058
 */
object Parens extends App {
  def balanced(s: String): Boolean =
    s.count(_ == '(') == s.count(_ == ')')

  def right(s: String): Boolean =
    s.foldLeft(Option(0)) {
      case (open, '(') => open.map(_ + 1)
      case (open, ')') => open.map(_ - 1).filter(_ >= 0)
    }.contains(0)

  def correct(s: String): String =
    if (right(s)) s
    else {
      val (u, v) = split(s)
      if (right(u)) u + correct(v)
      else "(" + correct(v) + ")" + trimReverse(u)
    }

  def split(s: String): (String, String) = {
    @scala.annotation.tailrec
    def sp(u: String, v: String): (String, String) =
      if (balanced(u)) (u, v)
      else sp(u + v.head, v.tail)
    sp(s.head.toString, s.tail)
  }

  def trimReverse(s: String): String =
    s.substring(1, s.length - 1).map {
      case '(' => ')'
      case ')' => '('
    }

  println(balanced("(()())()"), balanced(")("), balanced("()))((()"))
  println(right("(()())()"), right(")("), right("()))((()"))
  println(correct(")("))
}
