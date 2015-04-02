package tomek

sealed trait Square

object Empty extends Square
object Tomek extends Square
object X extends Square
object O extends Square

class Board(squares: List[Square]) {
  private def rows: List[List[Square]] = squares.grouped(4).toList
  private def cols: List[List[Square]] =
    (squares(0) :: squares(4) :: squares(8) :: squares(12) :: Nil) ::
    (squares(1) :: squares(5) :: squares(9) :: squares(13) :: Nil) ::
    (squares(2) :: squares(6) :: squares(10) :: squares(14) :: Nil) ::
    (squares(3) :: squares(7) :: squares(11) :: squares(15) :: Nil) :: Nil
  private def diagonals: List[List[Square]] =
    (squares(0) :: squares(5) :: squares(10) :: squares(15) :: Nil) ::
    (squares(3) :: squares(6) :: squares(9) :: squares(12) :: Nil) :: Nil

  private def fours: List[List[Square]] = rows ++ cols ++ diagonals

  def wins(player: Square) = fours.exists(four => four.forall(s => s == player || s == Tomek))

  def finished = !squares.contains(Empty)
}

object Board {
  def apply(input: List[String]) = new Board(
    input.foldLeft(List[Square]())((acc, row) => acc ++ row.map(c =>
      c match {
        case '.' => Empty
        case 'T' => Tomek
        case 'X' => X
        case 'O' => O
      }
    ))
  )

}


object TicTacTomek extends App {

  val input =
    "XXXT" ::
    "...." ::
    "OO.." ::
    "...." :: Nil

  val board = Board(input)

  val message = (board.wins(X), board.wins(O)) match {
    case (true, true) => "Draw"
    case (true, false) => "X won"
    case (false, true) => "O won"
    case (false, false) if board.finished => "Draw"
    case _ => "Game has not completed"
  }


//
//  XOXT
//  XXOO
//  OXOX
//  XXOO
//
//  XOX.
//    OX..
//  ....
//  ....
//
//  OOXX
//  OXXX
//  OX.T
//  O..O
//
//  XXXO
//    ..O.
//  .O..
//    T...
//
//  OXXX
//  XO..
//  ..O.
//  ...O
}
