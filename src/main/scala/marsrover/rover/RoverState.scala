package marsrover.rover

import marsrover.model._

final case class RoverState(
  coordinates: Coordinates,
  heading: Direction
) {

  def moveForward: RoverState =
    moveHeadingAmount(1)

  def moveBackwards: RoverState =
    moveHeadingAmount(-1)

  def rotateLeft: RoverState =
    copy(heading = this.heading.left)

  def rotateRight: RoverState =
    copy(heading = this.heading.right)

  private def moveHeadingAmount(delta: Int): RoverState = {
    val newCoords = heading match {
      case Direction.North =>
        Coordinates(coordinates.x, coordinates.y + delta)
      case Direction.East =>
        Coordinates(coordinates.x + delta, coordinates.y)
      case Direction.South =>
        Coordinates(coordinates.x, coordinates.y - delta)
      case Direction.West =>
        Coordinates(coordinates.x - delta, coordinates.y)
    }

    copy(coordinates = newCoords)
  }

}
