// 제네릭 적용
def mapList[T, U](f: T => U)(xs: List[T]): List[U] =
  if (xs.isEmpty) Nil
  else f(xs.head) :: mapList(f)(xs.tail)

def double(n: Int): Int = n * 2
def upper(c: Char): Char = c.toUpper

mapList(double)(List(1, 2, 3))
mapList(upper)(List('a', 'b', 'c'))
mapList((n: Int) => n * n)(List(1, 2, 3))
