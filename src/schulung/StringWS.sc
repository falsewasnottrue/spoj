val s1 = "Hello"
val s2 = "Hello"
val s3 = "H" + "ello"

s1 == s2
s1 == s3

val foo =
"""This is
  |a multiline
  |String""".stripMargin

foo.replaceAll("\n", "")

val name = "Rasmus"
val age = 35
s"$name is $age years old"

s"$name will be ${age+1} next year"

val score = 10.0 / 3

s"$name has a score of $score%.0f"

raw"foo\nbar"
