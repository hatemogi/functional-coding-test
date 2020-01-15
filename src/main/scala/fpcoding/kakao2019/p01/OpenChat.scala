package fpcoding.kakao2019.p01

/*
 2019 카카오 신입 공채 문제 풀이 #1. 오픈채팅방
 https://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/
 */
object OpenChat extends App {
  def nicknames(events: List[String]): Map[String, String] =
    events.foldLeft(Map.empty[String, String]) { (map, event) =>
      event.split(' ') match {
        case Array("Leave", _) => map
        case Array(_, userId, nickname) =>
          map.updated(userId, nickname)
      }
    }

  def solve(events: List[String]): List[String] = {
    val nicks = nicknames(events)
    events.filterNot(_.startsWith("Change")).map { event =>
      event.split(' ') match {
        case Array("Enter", userId, _) => nicks(userId) + "님이 들어왔습니다."
        case Array("Leave", userId) => nicks(userId) + "님이 나갔습니다."
      }
    }
  }
}
