package ui

import model.Board

interface IOutputPrinter {
    fun showMessage(string: String)
    fun showBoard(board: Board)
    fun showBoardWithCoordinates(board: Board)
}

class OutputPrinter(private val tp: ITerminalWriter) : IOutputPrinter {

    private val alive = "▓▓"
    private val dead = "░░"

    override fun showMessage(message: String) {
        tp.println(message)
    }

    override fun showBoard(board: Board) {
        for (i in 0 until board.size) {
            for (j in 0 until board.size) {
                if (board.isAliveAt(i, j)) {
                    tp.print("$alive ")
                } else {
                    tp.print("$dead ")
                }
            }
            tp.print("\n")
        }
    }

    override fun showBoardWithCoordinates(board: Board) {
        for (i in -1 until board.size + 1) {
            for (j in -1 until board.size + 1) {
                if (i == -1 && j == -1) {
                    tp.print("## ")
                    continue
                } else if (i == board.size && j == -1) {
                    tp.print(" Y")
                    break
                } else if (i == -1 && j == board.size) {
                    tp.print("X")
                } else if (i == -1 && j >= 0) {
                    printFormattedNumber(j)
                } else if (j == -1 && i >= 0) {
                    printFormattedNumber(i)
                } else if (i == board.size || j == board.size) {
                    continue
                } else if (i >= 0 && j >= 0) {
                    if (board.isAliveAt(i, j)) {
                        tp.print("$alive ")
                    } else {
                        tp.print("$dead ")
                    }
                }
            }
            tp.print("\n")
        }
    }

    private fun getCountOfDigits(number: Int): Int {
        var countDigits = 0
        var tempNumber = number
        while (tempNumber > 0) {
            tempNumber /= 10
            countDigits++
        }
        return countDigits
    }

    private fun printFormattedNumber(numberToFormat: Int) {
        var formattedNumber = numberToFormat % 100
        var difference = getCountOfDigits(formattedNumber)
        if (difference == 1 || formattedNumber == 0) {
            tp.print("0")
        }
        tp.print("$formattedNumber ")
    }
}

interface ITerminalWriter {
    fun print(string: String)
    fun println(string: String)
}

class TerminalWriter : ITerminalWriter {
    override fun print(string: String) {
        kotlin.io.print(string)
    }

    override fun println(string: String) {
        kotlin.io.println(string)
    }
}