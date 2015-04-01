package primes

object Primes extends App {

  println(primes(1, 10))
  println(primes(3, 5))

  def primes(from: Int, to: Int): Seq[Int] =
    for {
      p <- from until to
      if ((p == 2) || (2 to p).forall(i => p % i != 0))
    } yield p
}
