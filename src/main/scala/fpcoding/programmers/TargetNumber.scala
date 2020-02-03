package fpcoding.programmers

object TargetNumber extends App {
  def prime(n: Int): Boolean =
    n >= 2 && (2 until n).forall { x => n % x != 0}

  def solution(numbers: String) = {
    def s(ns: List[Int]) =
      (for {
        i <- 1 to ns.size
        cs <- ns.combinations(i)
        n <- cs.permutations
        if n.nonEmpty
      } yield n.mkString.toInt).toSet - 0

    s(numbers.toList.map(_.toInt - '0'.toInt)).count(prime)
  }

  println(solution("17"))
  println(solution("011"))
}
