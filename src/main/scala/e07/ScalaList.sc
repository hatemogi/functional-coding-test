// https://www.scala-lang.org/api/2.13.1/scala/collection/immutable/List.html

val numbers = List(1, 2, 3, 4, 5)

numbers.map(n => n * 2)
numbers.map(n => Math.sqrt(n.toDouble))

numbers.filter(n => n % 2 == 0)
numbers.max
numbers.exists(n => n % 7 == 0)

numbers.reduce((a, b) => a + b)
numbers.sum

numbers.reduce((a, b) => a * b)
numbers.product

numbers.partition(n => n % 2 == 0)

numbers.mkString(",")

numbers.zip(List("A", "B", "C", "D", "E"))
List("A", "B", "C").zipWithIndex

val nested = List(List(1,3), List(2, 4))
nested.flatten

numbers.map(x => List(x, x * x))
numbers.flatMap(x => List(x, x * x))