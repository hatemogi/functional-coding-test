package fpcoding.kakao2019.p01

import org.scalatest.flatspec.AnyFlatSpec

class OpenChatSpec extends AnyFlatSpec {
  import OpenChat.solve

  "기본예제#1" should "주어진 답변과 같아야" in {
    assert(
      solve(
        List("Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan")
      ) == List("Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."))
  }
}
