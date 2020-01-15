package fpcoding.e10

object Combinations extends App {

  def combinations[T](xs: List[T], n: Int): List[List[T]] =
    if (n == 0) List(Nil)
    else if (xs.isEmpty) Nil
    else (
      combinations(xs.tail, n - 1).map(xs.head :: _)
      ++ combinations(xs.tail, n)
    )

  println(combinations(List(1, 2, 3), 2))
  println(combinations(List(1, 2, 3, 4, 5), 3))
}