def fibo(n: Int): Int =
  if (n == 0) 0
  else if (n == 1) 1
  else fibo(n - 1) + fibo(n - 2)

(1 to 10).map(fibo)

def fibo2(n: Int): Int = {
  @scala.annotation.tailrec
  def f(x: Int, a: Int, b: Int): Int =
    if (x == n) a
    else f(x + 1, b, a + b)
  if (n <= 1) n
  else f(1, 1, 1)
}

(1 to 10).map(fibo2)

(1 to 10).forall { n =>
  fibo(n) == fibo2(n)
}