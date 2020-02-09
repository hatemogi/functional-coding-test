package fpcoding.programmers

/**
 * https://www.hackerrank.com/challenges/functions-or-not/problem
 */
object ValidFunction {

  def valid(pairs: List[(Int, Int)]): Boolean =
    pairs.groupBy(_._1).forall { case (_, outs) => outs.size == 1}
  /*
  2
  3
  1 1
  2 2
  3 3
  4
  1 2
  2 4
  3 6
  4 8

   */
  def main(args: Array[String]) {
    import scala.io.StdIn._
    val cases = readLine().trim.toInt
    (1 to cases).foreach { n =>
      val v = valid((1 to readLine().trim.toInt).map { n =>
        val ns = readLine().trim.split(" ").map(_.toInt)
        (ns(0), ns(1))
      }.toList)
      println(if (v) "YES" else "NO")
    }
  }

}
