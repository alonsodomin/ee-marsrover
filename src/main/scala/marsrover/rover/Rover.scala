package marsrover.rover

import marsrover.model.Coordinates
import marsrover.model.Direction

final class Rover private (coordinates: Coordinates, heading: Direction) {
  private var state: RoverState = RoverState(coordinates, heading)

  def executeCommands(commandStr: String): String = {
    def applyCommand(prevState: RoverState, cmd: Command): RoverState = {
      cmd match {
        case Command.Backwards => prevState.moveBackwards
        case Command.Forward => prevState.moveForward
        case Command.Left => prevState.rotateLeft
        case Command.Right => prevState.rotateRight
      }
    }

    commandStr.foreach { symbol =>
      Command.fromSymbol(symbol) match {
        case Right(cmd) => this.state = applyCommand(this.state, cmd)
        case Left(err) => throw err
      }
    }

    reportPosition
  }

  def reportPosition: String =
    s"(${this.state.coordinates.x}, ${this.state.coordinates.y}) ${this.state.heading}"

}

object Rover {
  def touchDown(coordinates: Coordinates, heading: Direction): Rover =
    new Rover(coordinates, heading)
}