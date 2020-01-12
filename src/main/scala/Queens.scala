object Queens extends App {
  @scala.annotation.tailrec
  def attacked(qs: List[Int]): Boolean = qs match {
    case Nil => false
    case h :: t =>
      t.zipWithIndex.exists {
        case (q, i) => List(q, q - (i + 1), q + i + 1) contains h
      } || (attacked(qs.tail))
  }

  def queens(n: Int): List[List[Int]] = {
    def assign(count: Int, assigned: List[Int]): List[List[Int]] =
      if (attacked(assigned)) Nil
      else if (count <= 0) List(assigned)
      else (0 until n).flatMap { i =>
        assign(count - 1, i :: assigned)
      }.toList

    assign(n, Nil)
  }

  (1 to 8).foreach(pqueens)

  private def pqueens(n: Int): Unit = {
    val qs = queens(n).sortBy { qs => qs.foldLeft(1) { (s, q) => s * n + q }}
    println(s"queens($n) => ${qs.size}\n" +
      (if (qs.isEmpty) " []" else qs.mkString(" [", "\n  ", "]")))
  }

}
