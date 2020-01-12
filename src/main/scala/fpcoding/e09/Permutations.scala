package fpcoding.e09

object Permutations extends App {
  def permutations[T](xs: List[T]): List[List[T]] = {
    if (xs.isEmpty) List(Nil)
    else xs.zipWithIndex.flatMap { case (h, i) =>
      permutations(xs.take(i) ++ xs.drop(i + 1)).map(h :: _)
    }
  }

  println(permutations(List()))
  println(permutations(List(1)))
  println(permutations(List(1, 2, 3)))
}
