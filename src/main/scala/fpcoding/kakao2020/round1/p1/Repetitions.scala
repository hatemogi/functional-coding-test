package fpcoding.kakao2020.round1.p1

// https://tech.kakao.com/2019/10/02/kakao-blind-recruitment-2020-round1/
object Repetitions extends App {
  def compress(n: Int, cs: List[List[Char]]): (Int, String) = {
    cs match {
      case Nil => (n, "")
      case first :: second :: _ => (n, "")
    }
  }

  def compress(s: String): (Int, String) = {
    val cs = s.toList
    (1 to cs.size / 2)
      .map { n => compress(n, cs.grouped(n).toList) }
      .minBy(_._2.length)
  }

}
