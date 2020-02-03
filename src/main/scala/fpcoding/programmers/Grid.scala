package fpcoding.programmers

object Grid extends App {
  def solution(w: Int, h: Int) = {
    val deg: Double = h.toDouble / w
    (for {
      x <- (0 until w)
      y <- (0 until h)
      if y > deg * x && y < deg * (x + 1) ||
        y + 1 > deg * x && y + 1 < deg * (x + 1)
    } yield {
      (x, y)
    })
  }

  println(solution(8, 12))
}
