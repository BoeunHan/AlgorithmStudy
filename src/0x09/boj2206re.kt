package `0x09`

import java.util.LinkedList

data class Point2(val x: Int, val y: Int, val broken: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { Array(m) { false } }

    for (i1 in 0 until n) {
        readLine().toCharArray().forEachIndexed { i2, c ->
            map[i1][i2] = (c == '0')
        }
    }

    val dx = arrayOf(-1, 0, 0, 1)
    val dy = arrayOf(0, -1, 1, 0)

    val queue = LinkedList<Point2>()
    val visited = Array(2) { Array(n) { Array(m) { 0 } } }

    visited[0][0][0] = 1
    visited[1][0][0] = 1
    queue.add(Point2(0, 0, 0))

    while (queue.isNotEmpty()) {
        val cen = queue.removeFirst()
        println("cenx = ${cen.x} ceny = ${cen.y} broken = ${cen.broken}")

        if (cen.x == n - 1 && cen.y == m - 1) {
            println(visited[cen.broken][cen.x][cen.y])
            return
        }
        for (i in 0 until 4) {
            val curX = cen.x + dx[i]
            val curY = cen.y + dy[i]
            if (curX < 0 || curX >= n || curY < 0 || curY >= m) continue
            if (map[curX][curY]) {    //갈수 있는 길일때
                if (visited[cen.broken][curX][curY] == 0) {
                    visited[cen.broken][curX][curY] = visited[cen.broken][cen.x][cen.y] + 1
                    queue.add(Point2(curX, curY, cen.broken))
                }
            } else {   //벽일때
                if (cen.broken == 0 && visited[1][curX][curY] == 0) {
                    visited[1][curX][curY] = visited[cen.broken][cen.x][cen.y] + 1
                    queue.add(Point2(curX, curY, 1))
                }
            }
        }
        printVisited(visited)
    }

    println("-1")
}

fun printVisited(visit: Array<Array<Array<Int>>>) {

    for (i in 0 until 2) {
        for (j in visit[0].indices) {
            for (k in visit[0][0].indices) {
                print("${visit[i][j][k]} ")
            }
            println()
        }
        println()
    }
    println("--------------")
}