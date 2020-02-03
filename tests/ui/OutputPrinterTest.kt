package ui

import model.Board
import org.junit.Test
import kotlin.test.assertEquals

class OutputPrinterTest {

    @Test
    fun `should display message`() {
        val terminalPrinter = FakeTerminalWriter()
        val outputPrinter = OutputPrinter(terminalPrinter)
        val message = "Hello, World!"

        outputPrinter.showMessage(message)

        assertEquals("$message\n", terminalPrinter.getPrintedText())
    }

    @Test
    fun `should display 5x5 board`() {
        val terminalPrinter = FakeTerminalWriter()
        val board = Board(5)
        board.setAliveAt(1, 1)
        board.setAliveAt(1, 2)
        board.setAliveAt(2, 1)
        val outputPrinter = OutputPrinter(terminalPrinter)

        outputPrinter.showBoard(board)

        val actual = terminalPrinter.getPrintedText()
        val expected =
                    "░░ ░░ ░░ ░░ ░░ \n" +
                    "░░ ▓▓ ▓▓ ░░ ░░ \n" +
                    "░░ ▓▓ ░░ ░░ ░░ \n" +
                    "░░ ░░ ░░ ░░ ░░ \n" +
                    "░░ ░░ ░░ ░░ ░░ \n"
        assertEquals(expected, actual)
    }

    @Test
    fun `should display 5x5 board with coordinates`() {
        val terminalPrinter = FakeTerminalWriter()
        val board = Board(10)
        board.setAliveAt(1, 1)
        board.setAliveAt(1, 2)
        board.setAliveAt(2, 1)
        val outputPrinter = OutputPrinter(terminalPrinter)

        outputPrinter.showBoardWithCoordinates(board)

        val actual = terminalPrinter.getPrintedText()
        val expected =
                "## 00 01 02 03 04 05 06 07 08 09 X\n" +
                "00 ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                "01 ░░ ▓▓ ▓▓ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                "02 ░░ ▓▓ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                "03 ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                "04 ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                "05 ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                "06 ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                "07 ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                "08 ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                "09 ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ ░░ \n" +
                " Y\n"

        assertEquals(expected, actual)
    }
}