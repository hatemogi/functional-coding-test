package fpcoding.kakao2020.round1.p1

// https://tech.kakao.com/2019/10/02/kakao-blind-recruitment-2020-round1/
object Repetitions extends App {
  def compress(cs: List[List[Char]]): String = {
    if (cs.isEmpty) ""
    else {
      val reps = cs.takeWhile(cs.head == _)
      (if (reps.size == 1) "" else reps.size.toString) +
      cs.head.mkString("") +
      compress(cs.drop(reps.size))
    }
  }

  def compress(s: String): String = {
    val cs = s.toList
    (1 to cs.size / 2)
      .map { n => compress(cs.grouped(n).toList) }
      .minBy(_.length)
  }

  private def pcompress(s: String) = {
    val compressed = compress(s)
    println(s"compress(${s}) = ${compressed.length}, $compressed")
  }

  pcompress("aabbaccc")
  pcompress("ababcdcdababcdcd")
  pcompress("abcabcdede")
  pcompress("abcabcabcabcdededededede")
  pcompress("xababcdcdababcdcd")
}
