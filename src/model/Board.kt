package model

class Board(val size: Int) {
    private val cellLifeStatus = mutableMapOf<String, Boolean>()

    fun isAliveAt(x: Int, y: Int): Boolean {
        return cellLifeStatus[generateBoardKey(x, y)] ?: false
    }

    fun setAliveAt(x: Int, y: Int, isAlive: Boolean = true) {
        cellLifeStatus[generateBoardKey(x, y)] = isAlive
    }

    fun countNeighboursAt(x: Int, y: Int): Int {
        val left = if (x != 0 && isAliveAt(x - 1, y)) 1 else 0
        val right = if (x != size - 1 && isAliveAt(x + 1, y)) 1 else 0
        val top = if (y != 0 && isAliveAt(x, y - 1)) 1 else 0
        val bottom = if (y != size - 1 && isAliveAt(x, y + 1)) 1 else 0
        val leftTop = if (x != 0 && y != 0 && isAliveAt(x - 1, y - 1)) 1 else 0
        val rightTop = if (x != size - 1 && y != 0 && isAliveAt(x + 1, y - 1)) 1 else 0
        val leftBottom = if (x != 0 && y != size - 1 && isAliveAt(x - 1, y + 1)) 1 else 0
        val rightBottom = if (x != size - 1 && y != size - 1 && isAliveAt(x + 1, y + 1)) 1 else 0

        return left + right + top + bottom + leftBottom + leftTop + rightTop + rightBottom
    }

    private fun generateBoardKey(x: Int, y: Int): String {
        return "[$x,$y]"
    }
}
