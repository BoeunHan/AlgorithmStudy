package `0x09`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }

    val tomato = List(n) { readLine().split(" ") }
    val ripe = Array(n) { IntArray(m) { -1 } }
    val queue = LinkedList<Pair<Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (tomato[i][j] == "1") {
                queue.add(Pair(i, j))
                ripe[i][j] = 0
            } else if (tomato[i][j] == "-1") {
                ripe[i][j] = -2
            }
        }
    }
    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    var dist = 0

    while (queue.isNotEmpty()) {
        val cen = queue.removeFirst()
        val cenX = cen.first
        val cenY = cen.second
        for (i in 0 until 4) {
            val curX = cenX + dx[i]
            val curY = cenY + dy[i]
            if (curX < 0 || curX >= n ||
                curY < 0 || curY >= m) continue
            if (ripe[curX][curY] == -1) {
                dist = ripe[cenX][cenY] + 1
                ripe[curX][curY] = dist
                queue.add(Pair(curX, curY))
            }
        }
    }
    for(i in 0 until n){
        if(ripe[i].contains(-1)) {println("-1"); return}
    }
    println(dist)
}