package `0x09`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val visited = List(n) { MutableList(n) { 0 } }
    val color = List(n) { readLine().toList() }

    val dxdy = arrayOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))
    var colorCnt = 0
    var blindCnt = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j] == 0 && color[i][j] == 'B') {
                blindCnt++
                colorCnt++
                val queue = LinkedList<Pair<Int, Int>>()
                visited[i][j] = 1
                queue.add(Pair(i, j))
                while (queue.isNotEmpty()) {
                    val cen = queue.removeFirst()
                    val cenX = cen.first
                    val cenY = cen.second
                    for ((dx, dy) in dxdy) {
                        val curX = cenX + dx
                        val curY = cenY + dy
                        if (curX < 0 || curX >= n || curY < 0 || curY >= n) continue
                        if (visited[curX][curY] == 0 && color[curX][curY] == 'B') {
                            visited[curX][curY] = 1
                            queue.add(Pair(curX, curY))
                        }
                    }
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j] == 0 && color[i][j] == 'R') {
                colorCnt++
                val queue = LinkedList<Pair<Int, Int>>()
                visited[i][j] = 2
                queue.add(Pair(i, j))
                while (queue.isNotEmpty()) {
                    val cen = queue.removeFirst()
                    val cenX = cen.first
                    val cenY = cen.second
                    for ((dx, dy) in dxdy) {
                        val curX = cenX + dx
                        val curY = cenY + dy
                        if (curX < 0 || curX >= n || curY < 0 || curY >= n) continue
                        if (visited[curX][curY] == 0 && color[curX][curY] == 'R') {
                            visited[curX][curY] = 2
                            queue.add(Pair(curX, curY))
                        }
                    }
                }
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j] == 0 && color[i][j] == 'G') {
                colorCnt++
                val queue = LinkedList<Pair<Int, Int>>()
                visited[i][j] = 2
                queue.add(Pair(i, j))
                while (queue.isNotEmpty()) {
                    val cen = queue.removeFirst()
                    val cenX = cen.first
                    val cenY = cen.second
                    for ((dx, dy) in dxdy) {
                        val curX = cenX + dx
                        val curY = cenY + dy
                        if (curX < 0 || curX >= n || curY < 0 || curY >= n) continue
                        if (visited[curX][curY] == 0 && color[curX][curY] == 'G') {
                            visited[curX][curY] = 2
                            queue.add(Pair(curX, curY))
                        }
                    }
                }
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j] == 2) {
                blindCnt++
                val queue = LinkedList<Pair<Int, Int>>()
                visited[i][j] = 3
                queue.add(Pair(i, j))
                while (queue.isNotEmpty()) {
                    val cen = queue.removeFirst()
                    val cenX = cen.first
                    val cenY = cen.second
                    for ((dx, dy) in dxdy) {
                        val curX = cenX + dx
                        val curY = cenY + dy
                        if (curX < 0 || curX >= n || curY < 0 || curY >= n) continue
                        if (visited[curX][curY] == 2) {
                            visited[curX][curY] = 3
                            queue.add(Pair(curX, curY))
                        }
                    }
                }
            }
        }
    }
    println("$colorCnt $blindCnt")
}

