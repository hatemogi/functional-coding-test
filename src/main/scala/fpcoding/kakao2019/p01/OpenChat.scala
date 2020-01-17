package fpcoding.kakao2019.p01

/*
 2019 카카오 신입 공채 문제 풀이 #1. 오픈채팅방
 https://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/
 */
object OpenChat extends App {
  def nicknames(records: List[List[String]]) =
    records.foldLeft(Map.empty[String, String]) {
      case (map, "Leave" :: _) => map
      case (map, _ :: userId :: nickname :: _) => map.updated(userId, nickname)
    }

  def solve(records: List[String]): List[String] = {
    val tokenized = records.map { _.split(' ').toList }
    val nicks = nicknames(tokenized)
    tokenized.filterNot(_.head == "Change").map {
      case "Enter" :: userId :: _ => nicks(userId) + "님이 들어왔습니다."
      case "Leave" :: userId :: _ => nicks(userId) + "님이 나갔습니다."
    }
  }
}
