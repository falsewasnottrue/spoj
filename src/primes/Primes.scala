package primes

object Primes extends App {

  for (ln <- io.Source.stdin.getLines.drop(1)) {
    var from = ln.split(" ")(0).toInt
    var to = ln.split(" ")(1).toInt

    primes(from, to).foreach(println(_))
  }

  def primes(from: Int, to: Int): Seq[Int] =
    for {
      n <- from to to
      if isPrime(n)
    } yield n

  def isPrime(n: Int): Boolean =
    (n>1) && ((n == 2) || (2 to Math.sqrt(n).toInt).forall(i => n % i != 0))
}
