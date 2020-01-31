package fpcoding.kakao2020.round1.p2

import org.scalatest.flatspec.AnyFlatSpec

class ParenSpec extends AnyFlatSpec {
  import Parens._

  "기본 예제#1" should "주어진 답변과 같아야" in {
    assert(correct("(()())()") == "(()())()")
    assert(correct(")(") == "()")
    assert(correct("()))((()") == "()(())()")
  }

  "자바 예제도" should "주어진 답변과 같아야" in {
    assert(ParensJava.correct("(()())()") == "(()())()")
    assert(ParensJava.correct(")(") == "()")
    assert(ParensJava.correct("()))((()") == "()(())()")
  }

}