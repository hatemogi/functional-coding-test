def iFact(n: Int): Int = {
  var acc: Int = 1
  for (i <- 1 to n)
    acc *= i
  acc
}
iFact(0)
iFact(3)

val (i1, i3, i10) = (iFact(1), iFact(3), iFact(10))

def rFact(n: Int): Int =
  if (n == 0) 1
  else n * rFact(n - 1)

val (f1, f3, f10) = (rFact(1), rFact(3), rFact(10))
i10 == f10

//rFact(16)
//rFact(17)

