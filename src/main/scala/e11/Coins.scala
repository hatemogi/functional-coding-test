package e11

object Coins extends App {
  def minCoins(coins: List[Int], total: Int): List[Int] = {
    def select(leftCoins: List[Int], selected: List[Int], amount: Int): List[List[Int]] = {
      if (amount == total) List(selected)
      else if (amount > total || leftCoins.isEmpty) Nil
      else {
        select(leftCoins, leftCoins.head :: selected, leftCoins.head + amount) ++
        select(leftCoins.tail, selected, amount)
      }
    }
    select(coins, Nil, 0)
      .minByOption(_.size)
      .getOrElse(Nil)
      .sorted(Ordering[Int].reverse)
  }

  println(minCoins(List(1, 3, 4), 6))
}
