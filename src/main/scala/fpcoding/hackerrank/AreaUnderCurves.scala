package fpcoding.hackerrank

/**
 * https://www.hackerrank.com/challenges/area-under-curves-and-volume-of-revolving-a-curv/problem
 */
object AreaUnderCurves extends App {
  // This function will be used while invoking "Summation" to compute
  // The area under the curve.
  def f(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    //Fill Up this function body
    // To compute the value of the function
    // For the given coefficients, powers and value of x
    (coefficients zip powers).map { case (c, p) =>
      c * Math.pow(x, p)
    }.sum
  }

  // This function will be used while invoking "Summation" to compute
  // The Volume of revolution of the curve around the X-Axis
  // The 'Area' referred to here is the area of the circle obtained
  // By rotating the point on the curve (x,f(x)) around the X-Axis
  def area(coefficients: List[Int], powers: List[Int], x: Double): Double = {
    //Fill Up this function body
    // To compute the area of the circle on revolving the point
    // (x,f(x)) around the X-Axis
    // For the given coefficients, powers and value of x
    val r = f(coefficients, powers, x)
    r * r * Math.PI
  }

  // This is the part where the series is summed up
  // This function is invoked once with func = f to compute the area 	     // under the curve
  // Then it is invoked again with func = area to compute the volume
  // of revolution of the curve
  def summation(func: (List[Int], List[Int], Double) => Double, upperLimit: Int, lowerLimit: Int, coefficients: List[Int], powers: List[Int]): Double = {
    // Fill up this function
    Math.round((lowerLimit * 1000L to upperLimit * 1000L).map { x =>
      func(coefficients, powers, x / 1000.0) * 0.001
    }.sum * 10.0) / 10.0
  }

  printf("%.1f\n", summation(f, 4, 1, List(1, 2, 3, 4, 5), List(6, 7, 8, 9, 10)))
  printf("%.1f\n", summation(area, 4, 1, List(1, 2, 3, 4, 5), List(6, 7, 8, 9, 10)))
  printf("%.1f", summation(f, 2, 1, List(1, 2, 3, 4, 5, 6, 7, 8), List(-1, -2, -3, -4, 1, 2, 3, 4)))
}

