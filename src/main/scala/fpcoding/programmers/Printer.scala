package fpcoding.programmers

object Printer extends App {
  def solution(priorities: Vector[Int], location: Int): Int = {
    if (priorities.isEmpty || location < 0) 0
    else if (priorities.tail.exists(_ > priorities.head))
      solution(priorities.tail :+ priorities.head,
        (if (location == 0) priorities.size else location) - 1)
    else 1 + solution(priorities.tail, location - 1)
  }

  println(solution(Vector(2, 1, 3, 2), 2))
  println(solution(Vector(1, 1, 9, 1, 1, 1), 0))
}
