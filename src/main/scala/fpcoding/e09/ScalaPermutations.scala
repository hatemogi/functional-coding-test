package fpcoding.e09

object ScalaPermutations extends App {
  private def pperm[T](xs: List[T]) {
    println(s"${xs}.permutations == " +
      xs.permutations
        .mkString("[\n  ", "\n  ", "\n]"))
  }

  pperm(List("a", "b"))
  pperm(List(1, 2, 3))
}
