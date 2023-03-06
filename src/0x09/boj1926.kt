package `0x09`

import java.util.LinkedList
fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val n = input[0]
    val m = input[1]

    val painting = Array<IntArray?>(n) { null }
    for (i in 0 until n) {
        painting[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val queue = LinkedList<Pair<Int, Int>>()
    val visit = Array(n) { BooleanArray(m) { false } }

    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(-1, 0, 1, 0)

    var cnt = 0
    var maxSize = 0

    for (x in 0 until n) {
        for (y in 0 until m) {
            if (painting[x]!![y] == 0 || visit[x][y]) continue
            visit[x][y] = true
            queue.add(Pair(x, y))
            cnt++

            var size = 0
            while (queue.isNotEmpty()) {
                size++
                val cen = queue.removeFirst()
                val cenX = cen.first
                val cenY = cen.second
                for (i in 0 until 4) {
                    val curX = cenX + dx[i]
                    val curY = cenY + dy[i]
                    if (curX < 0 || curX >= n ||
                        curY < 0 || curY >= m) continue
                    if(painting[curX]!![curY] == 1
                        && !visit[curX][curY]){
                        visit[curX][curY] = true
                        queue.add(Pair(curX, curY))
                    }
                }
            }
            if(size > maxSize) maxSize = size
        }
    }
    println(cnt)
    println(maxSize)
}
