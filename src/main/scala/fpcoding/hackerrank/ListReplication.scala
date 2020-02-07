package fpcoding.hackerrank

object ListReplication extends App {
  def f(num: Int, arr: List[Int]): List[Int] = {
    def inner(n: Int, xs: List[Int]): List[Int] =
      if (xs.isEmpty) Nil
      else if (n > 0) xs.head :: inner(n - 1, xs)
      else inner(num, xs.tail)
    inner(num, arr)
  }

  println(f(3, List(1, 2, 3, 4)).mkString("\n"))
}
