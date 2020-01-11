package e08

object ScalaSubsets extends App {
  psubsets(List())
  psubsets(List(1))
  psubsets(List(1, 2, 3))

  private def psubsets[T](xs: List[T]) {
    println(s"subsets(${xs}) == "
      + xs.toSet.subsets().mkString("List(\n  ", "\n  ", "\n)"))
  }

}
