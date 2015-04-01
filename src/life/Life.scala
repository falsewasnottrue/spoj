package life

object Life extends App {

  do {
    val number = readLine().toInt
    if (number == 42) {
      System.exit(0)
    }

    println(number)
  } while (true)
}
