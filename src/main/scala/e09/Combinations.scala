package e09

object Combinations extends App {

  def combinations[T](xs: List[T], n: Int): List[List[T]] = {
    def c(xs: List[T], selected: Vector[T], count: Int): Vector[List[T]] =
      if (n == count) Vector(selected.toList)
      else if (xs.isEmpty) Vector.empty
      else (
        c(xs.tail, selected :+ xs.head, count + 1)
          ++
        c(xs.tail, selected, count)
      )
    c(xs, Vector.empty,0).toList
  }

  println(combinations(List(), 1))
  println(combinations(List(1, 2, 3, 4, 5), 3))
}
