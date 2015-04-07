package ugly

object UglyNumbers extends App {

  val us = for {
    x <-1 to 100
    if isUgly(x)
  } yield x

  println(us)

  def isUgly(n: Int): Boolean =
    (n % 2 == 0) || (n % 3 == 0) || (n % 5 == 0) || (n % 7 == 0)
}
