import compute.God
import ui.*

val printer: IOutputPrinter = OutputPrinter(TerminalWriter())
val parser: IInputParser = InputParser(TerminalReader(), printer)
val god = God()

fun main(args: Array<String>) {
    var board = parser.requestInfoToGenerateBoard()

    printer.showMessage("\n\nThe cells of the board will evolve every 2 seconds...")
    printer.showMessage("\nExit program with Ctrl+C to stop!\n\n")

    var counter = 0
    while (true) {
        printer.showMessage("\n\nEvolution ${++counter}:\n")
        printer.showBoard(board)
        Thread.sleep(2000)
        board = god.evolve(board)
    }
}
