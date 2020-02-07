package fpcoding.hackerrank

/**
 * https://www.hackerrank.com/challenges/eval-ex/problem
 */
object EvalEx {

  def ex(x: Double): Double = {
    def term(t: Int): Double =
      if (t == 0) 1
      else term(t - 1) * x / t
    (0 until 10).map(term).sum
  }

  printf("%.4f\n", ex(20.0))

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    for (nItr <- 1 to n) {
      val x = stdin.readLine.trim.toDouble
      printf("%.4f\n", ex(x))
    }
  }
}
