package primes

object Primes extends App {

  println(primes(1, 10))
  println(primes(3, 5))

  def primes(from: Int, to: Int): Seq[Int] =
    for {
      n <- from to to
      if isPrime(n)
    } yield n

  def isPrime(n: Int): Boolean =
    (n>1) && ((n == 2) || (2 until n).forall(i => n % i != 0))
}
