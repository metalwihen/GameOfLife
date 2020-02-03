package model

import org.junit.Assert.*
import org.junit.Test

class BoardTest {
    @Test
    fun `should have a cell alive at coordinate if previously set`() {
        val board = Board(4)

        board.setAliveAt(3, 3)

        assertEquals(true, board.isAliveAt(3, 3))
    }

    @Test
    fun `should have all cells dead if cell alive status not previously set`() {
        val board = Board(2)

        assertEquals(false, board.isAliveAt(0, 0))
        assertEquals(false, board.isAliveAt(1, 0))
        assertEquals(false, board.isAliveAt(0, 1))
        assertEquals(false, board.isAliveAt(1, 1))
    }

    @Test
    fun `should count all neighbours of a cell`() {
        val board = Board(5)
        board.setAliveAt(1, 1)
        board.setAliveAt(1, 2)
        board.setAliveAt(1, 3)
        board.setAliveAt(2, 1)
        board.setAliveAt(2, 3)
        board.setAliveAt(3, 1)
        board.setAliveAt(3, 2)
        board.setAliveAt(3, 3)
        /*
            ░░ ░░ ░░ ░░ ░░
            ░░ ▓▓ ▓▓ ▓▓ ░░
            ░░ ▓▓ ░░ ▓▓ ░░
            ░░ ▓▓ ▓▓ ▓▓ ░░
            ░░ ░░ ░░ ░░ ░░
        */

        val actual = board.countNeighboursAt(2, 2)

        assertEquals(8, actual)
    }

    @Test
    fun `should return zero if no neighbours of a cell`() {
        val board = Board(5)
        /*
            ░░ ░░ ░░ ░░ ░░
            ░░ ░░ ░░ ░░ ░░
            ░░ ░░ ░░ ░░ ░░
            ░░ ░░ ░░ ░░ ░░
            ░░ ░░ ░░ ░░ ░░
        */

        val actual = board.countNeighboursAt(2, 2)

        assertEquals(0, actual)
    }
}