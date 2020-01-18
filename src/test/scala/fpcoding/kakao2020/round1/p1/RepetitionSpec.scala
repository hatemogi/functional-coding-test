package fpcoding.kakao2020.round1.p1

import org.scalatest.flatspec.AnyFlatSpec

class RepetitionSpec extends AnyFlatSpec {
  import Repetitions.compress
  "기본예제#1" should "주어진 답변과 같아야" in {
    assert(compress("aabbaccc").length == 7)
    assert(compress("ababcdcdababcdcd").length == 9)
    assert(compress("abcabcdede").length == 8)
    assert(compress("abcabcabcabcdededededede").length == 14)
    assert(compress("xababcdcdababcdcd").length == 17)
  }
}