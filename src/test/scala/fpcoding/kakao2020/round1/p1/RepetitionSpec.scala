package fpcoding.kakao2020.round1.p1

import org.scalatest.flatspec.AnyFlatSpec

class RepetitionSpec extends AnyFlatSpec {
  import Repetitions.compress
  "기본예제#1" should "주어진 답변과 같아야" in {
    assert(compress("aabbaccc") == (1, "2a2ba3c"))
  }


}