package compute

import model.Board
import org.junit.Test
import kotlin.test.assertEquals

class GodTest {
    @Test
    fun `should evolve board`() {
        /* BEFORE EVOLUTION:
            ░░ ░░ ░░ ░░ ░░
            ░░ ▓▓ ▓▓ ░░ ░░
            ░░ ▓▓ ░░ ░░ ░░
            ░░ ░░ ░░ ░░ ░░
            ░░ ░░ ░░ ░░ ░░
        */
        val oldBoard = Board(5)
        oldBoard.setAliveAt(1, 1)
        oldBoard.setAliveAt(1, 2)
        oldBoard.setAliveAt(2, 1)

        val god = God()
        val newBoard = god.evolve(oldBoard)

        /* AFTER EVOLUTION
            ░░ ░░ ░░ ░░ ░░
            ░░ ▓▓ ▓▓ ░░ ░░
            ░░ ▓▓ ▓▓ ░░ ░░
            ░░ ░░ ░░ ░░ ░░
            ░░ ░░ ░░ ░░ ░░
        */
        assertEquals(false, newBoard.isAliveAt(0, 0))
        assertEquals(true, newBoard.isAliveAt(1, 1))
        assertEquals(true, newBoard.isAliveAt(1, 2))
        assertEquals(true, newBoard.isAliveAt(2, 1))
        assertEquals(true, newBoard.isAliveAt(2, 2))
        assertEquals(false, newBoard.isAliveAt(3, 3))
    }
}