package `0x09`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val move = arrayOf(
        Pair(2, 1), Pair(1, 2), Pair(-1, 2), Pair(-2, 1),
        Pair(-2, -1), Pair(-1, -2), Pair(1, -2), Pair(2, -1)
    )
    repeat(readLine().toInt()) {
        val l = readLine().toInt()
        val board = List(l) { MutableList(l) { -1 } }

        val from = readLine().split(" ").map { it.toInt() }
        val to = readLine().split(" ").map { it.toInt() }

        val queue = LinkedList<Pair<Int, Int>>()
        board[from[0]][from[1]] = 0
        queue.add(Pair(from[0], from[1]))

        while (board[to[0]][to[1]] == -1) {
            val cen = queue.removeFirst()
            val cenX = cen.first
            val cenY = cen.second
            for ((dx, dy) in move) {
                val curX = cenX + dx
                val curY = cenY + dy
                if (curX < 0 || curX >= l || curY < 0 || curY >= l) continue
                if (board[curX][curY] == -1) {
                    board[curX][curY] = board[cenX][cenY] + 1
                    queue.add(Pair(curX, curY))
                }
            }
        }
        println(board[to[0]][to[1]])
    }
}