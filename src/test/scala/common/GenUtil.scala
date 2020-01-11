package common

import org.scalacheck.Gen

object GenUtil {
  def smallList(maxN: Int = 16): Gen[List[Int]] =
    Gen.choose(0, maxN)
      .flatMap(n => Gen.listOfN(n, Gen.chooseNum(1, 100)))
}
