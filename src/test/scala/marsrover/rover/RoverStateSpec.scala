package marsrover.rover

import marsrover.model._

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

import scala.util.Random

final class RoverStateSpec extends AnyFlatSpec with Matchers with TableDrivenPropertyChecks {
  
  val forwardMovements = Table(
    ("initialCoords", "heading", "expectedCoords"),
    (Coordinates(0, 0), Direction.North, Coordinates(0, 1)),
    (Coordinates(0, 0), Direction.East, Coordinates(1, 0)),
    (Coordinates(0, 0), Direction.South, Coordinates(0, -1)),
    (Coordinates(0, 0), Direction.West, Coordinates(-1, 0)),
  )

  "Rover state" should "move in the same heading direction" in {
    forAll(forwardMovements) { (initialCoords: Coordinates, heading: Direction, expectedCoords: Coordinates) =>
      val initialState = RoverState(initialCoords, heading)
      val finalState = initialState.moveForward

      finalState.coordinates shouldBe expectedCoords
      finalState.heading shouldBe initialState.heading
    }
  }

  val backwardMovements = Table(
    ("initialCoords", "heading", "expectedCoords"),
    (Coordinates(0, 0), Direction.North, Coordinates(0, -1)),
    (Coordinates(0, 0), Direction.East, Coordinates(-1, 0)),
    (Coordinates(0, 0), Direction.South, Coordinates(0, 1)),
    (Coordinates(0, 0), Direction.West, Coordinates(1, 0)),
  )

  it should "move in the oposite heading direction" in {
    forAll(backwardMovements) { (initialCoords: Coordinates, heading: Direction, expectedCoords: Coordinates) =>
      val initialState = RoverState(initialCoords, heading)
      val finalState = initialState.moveBackwards

      finalState.coordinates shouldBe expectedCoords
      finalState.heading shouldBe initialState.heading
    }
  }

  val leftRotations = Table(
    ("initial", "expected"),
    (Direction.North, Direction.West),
    (Direction.West, Direction.South),
    (Direction.South, Direction.East),
    (Direction.East, Direction.North),
  )

  it should "rotate left without changing coordinates" in {
    forAll(leftRotations) { (initial: Direction, expected: Direction) =>
      val initialState = RoverState(Coordinates(Random.nextInt(), Random.nextInt()), initial)
      val finalState = initialState.rotateLeft

      finalState.heading shouldBe expected
      finalState.coordinates shouldBe initialState.coordinates
    }
  }

  val rightRotations = Table(
    ("initial", "expected"),
    (Direction.North, Direction.East),
    (Direction.East, Direction.South),
    (Direction.South, Direction.West),
    (Direction.West, Direction.North),
  )

  it should "rotate right without changing coordinates" in {
    forAll(rightRotations) { (initial: Direction, expected: Direction) =>
      val initialState = RoverState(Coordinates(Random.nextInt(), Random.nextInt()), initial)
      val finalState = initialState.rotateRight

      finalState.heading shouldBe expected
      finalState.coordinates shouldBe initialState.coordinates
    }
  }

}
