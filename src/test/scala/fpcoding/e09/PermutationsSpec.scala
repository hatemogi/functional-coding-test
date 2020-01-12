package fpcoding.e09

import fpcoding.SpecUtil.smallList
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

import scala.util.Random
import java.lang.Math.max

object PermutationsSpec extends Properties("순열") {
  import Permutations._

  private def factorial(n: Int) =
    (1 to max(1, n)).product

  property("[순열의 수 == n!개]") = forAll(smallList(7)) { xs =>
    permutations(xs).size == factorial(xs.size)
  }

  property("[임의로 섞은 게 있어야]") = forAll(smallList(7)) { xs =>
    permutations(xs) contains Random.shuffle(xs)
  }

}