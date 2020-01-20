package fpcoding.kakao2020.round1.p1

// https://tech.kakao.com/2019/10/02/kakao-blind-recruitment-2020-round1/
object Repetitions extends App {
  def compress(cs: List[String]): String = {
    if (cs.isEmpty) ""
    else {
      val reps = cs.takeWhile(cs.head == _).size
      (if (reps == 1) "" else reps.toString) + cs.head +
      compress(cs.drop(reps))
    }
  }

  def compress(s: String): String =
    (1 to s.length / 2 + 1)
      .map { n => compress(s.grouped(n).toList) }
      .minBy(_.length)

  private def pcompress(s: String): Unit = {
    val compressed = compress(s)
    println(s"compress(${s}) = ${compressed.length}, $compressed")
  }

  pcompress("aabbaccc")
  pcompress("ababcdcdababcdcd")
  pcompress("abcabcdede")
  pcompress("abcabcabcabcdededededede")
  pcompress("xababcdcdababcdcd")
}
