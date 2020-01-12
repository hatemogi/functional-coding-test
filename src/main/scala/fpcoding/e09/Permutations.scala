package fpcoding.e09

object Permutations extends App {

  def permutations[T](xs: List[T]): List[List[T]] = {
    if (xs.isEmpty) List(Nil)
    else xs.zipWithIndex.flatMap { case (h, i) =>
      permutations(removeAt(xs, i)).map(h :: _)
    }
  }

  // 리스트의 i번째 요소만 제외한 리스트 구하기
  def removeAt[T](xs: List[T], i: Int): List[T] =
    xs.take(i) ++ xs.drop(i + 1)

  private def pperm[T](xs: List[T]): Unit =
    println(s"permutations($xs) == " + permutations(xs))

  pperm(List())
  pperm(List(1))
  pperm(List(1, 2, 3))
}
