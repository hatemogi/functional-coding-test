package fpcoding.kakao2019.p02

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
}
