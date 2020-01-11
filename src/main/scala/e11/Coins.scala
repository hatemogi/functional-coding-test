package e11

object Coins extends App {
  def minCoins(coins: List[Int], total: Int): List[Int] = {
    def select(cs: List[Int], selected: List[Int], money: Int): List[List[Int]] = {
      if (money == 0) List(selected)
      else if (money < 0 || cs.isEmpty) Nil
      else {
        select(cs, cs.head :: selected, money - cs.head) ++
        select(cs.tail, selected, money)
      }
    }
    select(coins, Nil, total)
      .minByOption(_.size)
      .getOrElse(Nil)
      .sorted(Ordering[Int].reverse)
  }

  println(minCoins(List(1, 3, 4), 6))
}
