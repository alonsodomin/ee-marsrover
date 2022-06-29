package marsrover.model

sealed trait Direction {
  def left: Direction
  def right: Direction
}
object Direction {
  case object North extends Direction {
    def left: Direction = West
    def right: Direction = East
  }
  case object West extends Direction {
    def left: Direction = South
    def right: Direction = North
  }
  case object East extends Direction {
    def left: Direction = North
    def right: Direction = South
  }
  case object South extends Direction {
    def left: Direction = East
    def right: Direction = West
  }
}
