package marsrover.rover

final case class UnrecognizedCommandSymbol(symbol: Char) extends Exception(
  s"The symbol `$symbol` has not been recognised as a valid command. Valid values are: ${Command.values.map(_.symbol).mkString(", ")}"
)

sealed abstract class Command(val symbol: Char)
object Command {
  case object Forward extends Command('F')
  case object Backwards extends Command('B')
  case object Left extends Command('L')
  case object Right extends Command('R')

  private[rover] val values: Vector[Command] = Vector(Forward, Backwards, Left, Right)

  def fromSymbol(char: Char): Either[UnrecognizedCommandSymbol, Command] =
    values.find(_.symbol == char).toRight(UnrecognizedCommandSymbol(char))
}
