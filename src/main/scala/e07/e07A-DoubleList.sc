val numbers = List(1, 2, 3, 4, 5)

def doubleList(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else (xs.head * 2) :: doubleList(xs.tail)

doubleList(numbers)

def doubleListPM(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case x :: tail => (x * 2) :: doubleListPM(tail)
}

doubleListPM(numbers)







