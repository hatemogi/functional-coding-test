package fpcoding

import org.scalacheck.Gen

object SpecUtil {
  def factorial(n: Int): Int =
    (1 to Math.max(n, 1)).product

  def smallList(maxN: Int = 16): Gen[List[Int]] =
    Gen.choose(0, maxN)
      .flatMap(n => Gen.listOfN(n, Gen.chooseNum(1, 100)))
}
