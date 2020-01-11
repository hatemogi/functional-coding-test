package e09

import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

import scala.util.Random

object PermutationsSpecification extends Properties("순열") {
  import Permutations._

  val smallList: Gen[List[Int]] =
    Gen.choose(0, 7)
      .flatMap(n => Gen.listOfN(n, Gen.chooseNum(1, 100)))

  private def factorial(n: Int) =
    if (n == 0) 1
    else (1 to n).product

  property("[순열의 수 == n!개]") = forAll(smallList) { xs =>
    permutations(xs).size == factorial(xs.size)
  }

  property("[임의로 섞은 게 있어야]") = forAll(smallList) { xs =>
    permutations(xs) contains Random.shuffle(xs)
  }

}