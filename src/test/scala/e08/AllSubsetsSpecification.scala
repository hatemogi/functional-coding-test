package e08

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalacheck.Gen

object AllSubsetsSpecification extends Properties("Subsets") {
  private val smallList: Gen[List[Int]] =
    Gen.choose(0, 16)
      .flatMap(n => Gen.listOfN(n, Gen.chooseNum(1, 100)))

  property("count") = forAll(smallList) { xs =>
    AllSubsets.subsets(xs).size == Math.pow(2, xs.size)
  }

}