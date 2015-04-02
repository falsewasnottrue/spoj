val i = 4

i match {
  case 1 => "Januar"
  case 2 => "Februar"
  case 3 => "März"
  case 4 => "April"
  case _ => "Unbekannt"
}

val x: Any = "hello"
x match {
  case i: Int => s"Integer $i"
  case f: Float => s"Float $f"
}