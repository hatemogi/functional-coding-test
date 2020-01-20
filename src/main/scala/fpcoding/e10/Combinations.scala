package fpcoding.e10

object Combinations extends App {

  def combinations[T](xs: List[T], k: Int): List[List[T]] =
    if (k == 0) List(Nil)
    else if (xs.isEmpty) Nil
    else (
      combinations(xs.tail, k - 1).map(xs.head :: _)
      ++ combinations(xs.tail, k)
    )

  println(combinations(List(1, 2, 3), 2))
  println(combinations(List(1, 2, 3, 4, 5), 3))
}


