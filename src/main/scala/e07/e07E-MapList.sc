val numbers = List(1, 2, 3, 4, 5)

def mapIntList(f: Int => Int)(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else f(xs.head) :: mapIntList(f)(xs.tail)

def double(n: Int): Int = n * 2
def square(n: Int): Int = n * n

mapIntList(double)(numbers)
mapIntList(square)(numbers)
// mapIntList(n => Math.sqrt(n.toDouble))(numbers)

