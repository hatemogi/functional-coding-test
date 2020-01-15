package fpcoding.e10

import fpcoding.SpecUtil._
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

import scala.util.Random

object CombinationsSpec extends Properties("조합") {
  import Combinations._

  property("[조합의 수 검증]") = forAll(smallList(10)) { xs =>
    val n = xs.size
    (0 to n).forall { k =>
      combinations(xs, k).size == factorial(n) / factorial(k) / factorial(n - k)
    }
  }

  property("[n개 중 k개를 뽑은 조합이 있어야]") = forAll(smallList(10)) { xs =>
    (0 to xs.size).forall { k =>
      combinations(xs, k).map(_.toSet) contains
        Random.shuffle(xs).take(k).toSet
    }
  }
}