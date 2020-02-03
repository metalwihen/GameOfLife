package ui

import model.Board

interface IInputParser {
    fun requestInfoToGenerateBoard(): Board
}

class InputParser(
    private val terminalReader: ITerminalReader,
    private val outputPrinter: IOutputPrinter
) : IInputParser {


    override fun requestInfoToGenerateBoard(): Board {
        outputPrinter.showMessage("Please enter the size of the board (generated as size x size):")
        val size = Integer.parseInt(terminalReader.readLine())
        val board = Board(size)

        outputPrinter.showMessage("\nYou've created a board but the cells are all dead!")
        outputPrinter.showBoardWithCoordinates(board)

        outputPrinter.showMessage("\n\nPlease enter the total number of cells you want alive:")
        var liveCellCount = Integer.parseInt(terminalReader.readLine()) ?: 0
        var count = 0
        while (liveCellCount > 0) {
            outputPrinter.showMessage("\nPlease enter the coordinates of the live cell ${++count} as X,Y (Eg: 2,3 ):")
            val coordinate = terminalReader.readLine()
            try {
                val split = coordinate!!.split(",")
                val x = Integer.parseInt(split[1])
                val y = Integer.parseInt(split[0])

                if (x >= size || y >= size || x < 0 || y < 0) {
                    throw IllegalStateException()
                }

                board.setAliveAt(x, y)
            } catch (exception: Exception) {
                outputPrinter.showMessage("\nInvalid Input. Try again.")
                continue
            }

            liveCellCount--
        }

        return board
    }
}

interface ITerminalReader {
    fun readLine(): String?
}

class TerminalReader() : ITerminalReader {
    override fun readLine(): String? = kotlin.io.readLine()
}