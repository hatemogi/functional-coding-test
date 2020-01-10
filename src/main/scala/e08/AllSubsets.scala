package e08

object AllSubsets extends App {
  def subsets[T](xs: List[T]): List[List[T]] =
    if (xs.isEmpty) List(Nil)
    else subsets(xs.tail)
      .flatMap(ys => List(ys, xs.head :: ys))

  private def psubsets[T](xs: List[T]) {
    val ys = subsets(xs)
    println(s"subsets(${xs}) == $ys")
  }

  psubsets(List())
  psubsets(List(1))
  psubsets(List(1, 2, 3))
}
