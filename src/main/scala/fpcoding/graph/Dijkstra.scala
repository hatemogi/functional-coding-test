package fpcoding.graph

import scala.collection.immutable.SortedSet

/**
 * References
 * https://blog.frankel.ch/imperative-functional-programming/4/
 */
object Dijkstra extends App {
  type Node = Int                       // 노드ID
  type Edge = (Node, Node, Int)         // Node간 거리
  type Graph = List[Edge]               // 그래프의 Edge 모두 관리
  type Distance = (Node, Int)
  type Distances = Map[Node, Int]

  val example: Graph = List(
    (1, 2, 5),
    (1, 4, 9),
    (1, 5, 1),
    (2, 3, 2),
    (3, 4, 6),
    (4, 5, 2)
  )

  def nodes(g: Graph): Set[Node] =
    g.foldLeft(Set.empty[Node]) { (set, edge) =>
      set + edge._1 + edge._2
    }

  def shortest(starting: Node, g: Graph): Distances = {
    val que = SortedSet.empty[Distance](Ordering by { _._2 })

    Map.empty
  }

  println(shortest(1, example))
}
