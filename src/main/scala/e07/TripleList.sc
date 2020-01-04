val numbers = List(1, 2, 3, 4, 5)

def doubleList(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else (2 * xs.head) :: doubleList(xs.tail)

doubleList(numbers)

def tripleList(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else (3 * xs.head) :: tripleList(xs.tail)

tripleList(numbers)

