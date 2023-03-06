package `0x09`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val maze = Array(n) { BooleanArray(m) { false } }

    for (i in maze.indices) {
        val input = readLine()
        for (j in input.indices) maze[i][j] = (input[j] == '1')
    }

    val distArr = Array(n) { IntArray(m) { -1 } }
    val queue = LinkedList<Pair<Int, Int>>()

    val dx = arrayOf(0, -1, 0, 1)
    val dy = arrayOf(1, 0, -1, 0)

    distArr[0][0] = 1
    queue.add(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val cen = queue.removeFirst()
        val cenX = cen.first
        val cenY = cen.second
        for (i in 0 until 4) {
            val curX = cenX + dx[i]
            val curY = cenY + dy[i]
            if (curX < 0 || curX >= n ||
                curY < 0 || curY >= m) continue
            if (maze[curX][curY] && distArr[curX][curY] == -1) {
                queue.add(Pair(curX, curY))
                distArr[curX][curY] = distArr[cenX][cenY] + 1
            }
        }
    }
    println(distArr[n - 1][m - 1])

}

