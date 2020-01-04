val numbers = List(1, 2, 3, 4, 5)

def mapIntList(f: Int => Int)(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else f(xs.head) :: mapIntList(f)(xs.tail)

mapIntList(n => n * 2)(numbers)
mapIntList(n => n * n)(numbers)
// mapIntList(n => Math.sqrt(n.toDouble))(numbers)

// 제네릭 적용
def mapList[T, U](f: T => U)(xs: List[T]): List[U] =
  if (xs.isEmpty) Nil
  else f(xs.head) :: mapList(f)(xs.tail)

mapList((n: Int) => n * 2)(numbers)
mapList((n: Int) => Math.sqrt(n))(numbers)

