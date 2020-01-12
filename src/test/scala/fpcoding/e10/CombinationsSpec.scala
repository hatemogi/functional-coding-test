package fpcoding.e10

import fpcoding.SpecUtil._
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object CombinationsSpec extends Properties("조합") {
  import Combinations._

  property("[순열의 수 == n!개]") = forAll(smallList(7)) { xs =>
    combinations(xs, xs.size).size == factorial(xs.size)
  }

}