val numbers = List(1, 2, 3, 4, 5)

def timesList(n: Int)(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else n * xs.head :: timesList(n)(xs.tail)

timesList(2)(numbers)

def squareList(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else xs.head * xs.head :: squareList(xs.tail)

squareList(numbers)
