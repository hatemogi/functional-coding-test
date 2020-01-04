val numbers = List(1, 2, 3, 4, 5)

def timesList(n: Int)(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else n * xs.head :: timesList(n)(xs.tail)

timesList(2)(numbers)
timesList(3)(numbers)

type ListFun[T] = List[T] => List[T]

// currying
val doubleList: ListFun[Int] = timesList(2)
val tripleList: ListFun[Int] = timesList(3)
val quadList: ListFun[Int] = timesList(4)

doubleList(numbers)
tripleList(numbers)
quadList(numbers)

// 그런데 제곱을 하고 싶으면 어떻게 하지?
