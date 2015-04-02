val greetings = new Array[String](3)

val g1 = greetings(0) = "Hello"
greetings(1) = ", "
greetings(2) = "world!\n"

for (i <- 0 to 2) {
  print(greetings(i))
}

greetings.fold("")((acc, s) => acc ++ s)

val s = 0.to(2)

val t = 1.+(2)

val g2 = greetings.update(0, "Hallo")

g1 == g2

val onetwo = List(1,2)
val threefour = List(3,4)

val a = onetwo ::: threefour

val onetwothree = 1 :: 2 :: 3 :: Nil


onetwothree.map(i => i+1).filter(i => i % 2 == 0)

"hello".map(_.toUpper)