package fpcoding.e09

object Permutations extends App {
  def removeAt[T](xs: List[T], i: Int): List[T] =
    xs.take(i) ++ xs.drop(i + 1)

  def permutations[T](xs: List[T]): List[List[T]] = {
    if (xs.isEmpty) List(Nil)
    else xs.zipWithIndex.flatMap { case (h, i) =>
      permutations(removeAt(xs, i)).map(h :: _)
    }
  }

  private def pperm[T](xs: List[T]): Unit =
    println(s"permutations($xs) == " + permutations(xs))

  pperm(List())
  pperm(List(1))
  pperm(List(1, 2, 3))
}
