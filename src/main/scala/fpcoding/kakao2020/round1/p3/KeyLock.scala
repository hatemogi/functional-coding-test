package fpcoding.kakao2020.round1.p3

object KeyLock extends App {
  type Grid = Vector[Vector[Int]]

  def rotate(g: Grid): Grid = g.transpose

  def unlocked(lock: Grid): Boolean =
    lock.flatten.forall { _ > 0 }

  def place(lock: Grid, key: Grid, x: Int, y: Int): Grid = {
    lock.zipWithIndex.map { case (row, rowIdx) =>
      row.zipWithIndex.map { case (col, colIdx) =>
        val keyCell = key(rowIdx)(colIdx)

      }
    }
  }

  def expand(g: Grid, n: Int): Grid = {
    val emptyRows = Vector.fill(n)(Vector.fill(n + g.size + n)(0))
    val emptyCols = Vector.fill(n)(0)
    emptyRows ++ (g.map { row => emptyCols ++ row ++ emptyCols }) ++ emptyRows
  }

  def shrink(g: Grid, n: Int): Grid =
    g.slice(n, g.size - n).map { r => r.slice(n, r.size - n) }

  implicit def gridToString(g: Grid): String =
    g.map { r => r.mkString }.mkString("\n")

  val sample: Grid = Vector(Vector(1, 0), Vector(0, 1))
  println(gridToString(place(expand(sample, 2), sample, 0, 0)))
}