def rFact(n: BigInt): BigInt =
  if (n == 0) 1
  else n * rFact(n - 1)

//rFact(0)

(rFact(11), rFact(12), rFact(13))

rFact(450)
rFact(1024)
rFact(4096)
rFact(8192)

def tFact(n: BigInt): BigInt = {
  // 내부 보조함수
  @scala.annotation.tailrec
  def f(n: BigInt, acc: BigInt): BigInt =
    if (n == 0) acc
    else f(n - 1, n * acc)
  f(n, 1)
}

//tFact(256)
////tFact(4096)
tFact(8192)
tFact(32768)
