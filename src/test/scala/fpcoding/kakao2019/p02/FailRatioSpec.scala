package fpcoding.kakao2019.p02

import scala.jdk.CollectionConverters._
import org.scalatest.flatspec.AnyFlatSpec

class FailRatioSpec extends AnyFlatSpec {
  import FailRatio.solve

  "기본예제#1" should "주어진 답변과 같아야" in {
    assert(
      solve(5, List(2, 1, 2, 6, 2, 4, 3, 3))
      == List(3, 4, 2, 1, 5))
    assert(
      solve(4, List(4, 4, 4, 4)) == List(4, 1, 2, 3)
    )
  }

  "자바풀이도" should "주어진 답변과 같아야" in {
    val java = new FailRatioJava();
    def toJava(xs: List[Int]) =
      xs.map(i => new Integer(i)).toBuffer.asJava
    def solve(n: Int, stages: List[Int]) =
      java.solve(n, toJava(stages)).asScala.toList.map(i => Int.unbox(i))
    assert(
      solve(5, List(2, 1, 2, 6, 2, 4, 3, 3))
        == List(3, 4, 2, 1, 5))
    assert(
      solve(4, List(4, 4, 4, 4)) == List(4, 1, 2, 3)
    )
  }

}
