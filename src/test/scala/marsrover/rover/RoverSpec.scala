package marsrover.rover

import marsrover.model._

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

final class RoverSpec extends AnyFlatSpec with Matchers {

  "Rover" should "perform movements according to the given command list" in {
    val rover = new Rover(
      Coordinates(0, 0), Direction.North
    )

    val positionReport = rover.executeCommands("FLFFFRFLB")
    positionReport shouldBe "(-2, 2) West"
  }

  it should "throw an exception if any of the commands is not a valid one" in {
    val rover = new Rover(
      Coordinates(0, 0), Direction.North
    )

    assertThrows[UnrecognizedCommandSymbol] {
      rover.executeCommands("FFLBRALLFFBB")
    }

    val positionReport = rover.reportPosition
    positionReport shouldBe "(1, 2) North"
  }

}
