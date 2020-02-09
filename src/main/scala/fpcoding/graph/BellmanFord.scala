package fpcoding.graph

/**
 * 벨만-포드 알고리즘은 노드 x에서 다른 모든 노드로 가는 최단 경로를 찾는다.
 */
object BellmanFord extends App {
  type Node = Int                       // 노드ID
  type Edge = (Node, Node, Int)         // Node간 거리
  type Graph = List[Edge]               // 그래프의 Edge 모두 관리
  type Distances = Map[Node, Int]

  val example: Graph = List(
    (1, 2, 2),
    (1, 3, 3),
    (1, 4, 7),
    (2, 4, 3),
    (2, 5, 5),
    (3, 4, 1),
    (4, 5, 2)
  )

  def nodes(g: Graph): Set[Node] =
    g.foldLeft(Set.empty[Node]) { (set, edge) =>
      set + edge._1 + edge._2
    }

  // 최단 경로 "길이'만 판단
  def shortest(starting: Node, g: Graph): Distances = {
    val initial: Distances = Map[Node, Int](starting -> 0)
    nodes(g).foldLeft(initial) { case (distances, _) =>
      g.foldLeft(distances) { case (distances, (from, to, weight)) =>
        val newLength = distances.get(from).map(_ + weight)
        if (newLength.exists(l => l <= distances.getOrElse(to, l)))
          distances.updated(to, newLength.get)
        else
          distances
      }
    }
  }
  // 최단 경로 자체를 계산
  def shortestPaths(starting: Node, g: Graph): Map[Node, List[Node]] = {
    val initial = Map[Node, (Int, List[Node])](starting -> (0, List(starting)))
    nodes(g).foldLeft(initial) { case (paths, _) =>
      g.foldLeft(paths) { case (paths, (from, to, weight)) =>
        val newLen: Option[Int] = paths.get(from).map { case (len, _) => len + weight }
        if (newLen.exists(l => l <= paths.getOrElse(to, (l, Nil))._1))
          paths.updated(to, (newLen.get, to :: paths(from)._2))
        else
          paths
      }
    }.map { case (node, (dist, path)) => node -> path }
  }
  
  println(shortest(1, example))
  println(shortestPaths(1, example))
}
