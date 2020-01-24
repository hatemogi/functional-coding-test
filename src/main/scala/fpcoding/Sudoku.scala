package fpcoding

object Sudoku extends App {
  val game =
    """
      |123 456 789
      |456 789 123
      |089 123 456
      |
      |234 567 891
      |567 801 234
      |891 234 567
      |
      |345 678 912
      |678 912 345
      |912 345 678
      |""".stripMargin

  def parseGame(s: String): List[List[Int]] =
    s.split("\n").filterNot(_.isEmpty)
      .map(_.replace(" ", ""))
      .map(_.toCharArray.map(_.toInt - '0'.toInt).toList)
      .toList

  // 1..9 0 => empty
  // no duplicates && (1 .. 9) ?

  def validNumbers(ns: List[Int]): Boolean = {
    val numbers = ns.filter(n => n > 0 && n < 10)
    ns.size == 9 &&
      numbers.toSet.size == (if (ns contains 0) numbers.size else 9)
  }

//  println((1 to 9).toList)
//  println(validNumbers((1 to 9).toList))
//  println(validNumbers((1 to 32).map(_ => 0).toList))

  // complete or not
  def validGame(g: List[List[Int]]): Boolean = {
    val rows = g
    val cols = (0 to 8).map(n => g.map(row => row(n)))
    val blocks = for {
      r <- (0 to 8 by 3)
      c <- (0 to 8 by 3)
    } yield g.slice(r, r + 3).flatMap(_.slice(c, c + 3))
    println(blocks)

    rows.forall(validNumbers) &&
      cols.forall(validNumbers) &&
      blocks.forall(validNumbers)
  }

  def parsed = parseGame(game)
//  println(parsed)
  println(validGame(parsed))
}
