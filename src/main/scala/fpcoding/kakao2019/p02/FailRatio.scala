package fpcoding.kakao2019.p02

// 2019 카카오 신입 공채 1라운드 2번 문제 - 실패율
// https://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/
object FailRatio {

  // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
  def failRatio(stage: Int, players: List[Int]): Double =
    players.count(_ == stage).toDouble / Math.max(players.count(_ >= stage), 1)

  def solve(stages: Int, players: List[Int]): List[Int] =
    (1 to stages).sortBy {
      stage => (-failRatio(stage, players), stage)
    }.toList
}
