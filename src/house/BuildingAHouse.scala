package house

sealed trait Lot {
  def name: Char
  def usable: Boolean
}

object Lot {
  def forName(c: Char): Lot = c match {
    case 'G' => Grass
    case 'R' => Rock
    case 'W' => Water
    case 'S' => Shrubs
    case 'T' => Trees
  }
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

case class Land(lots: Array[Array[Lot]]) {
  override def toString = lots.foldLeft("")((acc, row) => acc + row.foldLeft("")((a, lot) => a + lot.name) + "\n")

  def length = lots(0).length
  def width = lots.length

  def usable(x: Int, y: Int, w: Int, h: Int) = {
    val bs = for {
      posx <- x until x+w
      posy <- y until y+h
    } yield lots(posx)(posy)
    bs.foldLeft(true)((acc, lot) => acc && lot.usable)
  }

  def apply(x: Int, y: Int) = lots(x)(y)
}

object Land {
  def apply(ss: List[String]) =
    new Land(
      ss.map(s => s.toCharArray.map(Lot.forName(_))).toArray
    )
}

object BuildingAHouse extends App {

//  1 1
//  G
//  2 2
//  GS
//  SG
//  2 2
//  GT
//  GG
//  5 8

  val plan =
    "GGTGG" ::
    "TGGGG" ::
    "GSSGT" ::
    "GGGGT" ::
    "GWGGG" ::
    "RGTRT" ::
    "RTGWT" ::
    "WTWGR" :: Nil

  println(maxRect(plan))

  def maxRect(plan: List[String]): Int = {
    val land = Land(plan)

    val cs = for {
      x <- 0 until land.lots.length
      y <- 0 until land.lots(x).length
      w <- 1 to land.lots.length - x
      l <- 1 to land.lots(x).length - y

      if land.usable(x,y,w,l)
    } yield w*l

    cs.max
  }
}
