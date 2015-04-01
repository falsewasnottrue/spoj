package house

sealed trait Lot {
  def name: Char
  def usable: Boolean
}

object Grass extends Lot {
  val name = 'G'
  val usable = true
}
object Rock extends Lot {
  val name = 'R'
  val usable = false
}
object Water extends Lot {
  val name = 'W'
  val usable = false
}
object Shrubs extends Lot {
  val name = 'S'
  val usable = true
}
object Trees extends Lot {
  val name = 'T'
  val usable = false
}

object BuildingAHouse extends App {
  println("Hallo")
}
