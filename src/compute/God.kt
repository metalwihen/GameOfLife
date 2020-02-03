package compute

import model.Board

interface IGod {
    fun evolve(oldBoard: Board): Board
}

class God : IGod {
    override fun evolve(oldBoard: Board): Board {
        val newBoard = Board(oldBoard.size)

        for (i in 0..oldBoard.size) {
            for (j in 0..oldBoard.size) {
                val willBeAlive = when (oldBoard.countNeighboursAt(i, j)) {
                    0, 1 -> false
                    2 -> oldBoard.isAliveAt(i, j)
                    3 -> true
                    else -> false
                }

                newBoard.setAliveAt(i, j, willBeAlive)
            }
        }

        return newBoard
    }
}