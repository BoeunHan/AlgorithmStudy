package `0x09`

import java.util.LinkedList

private data class Point(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sgVisit = HashMap<Point, Int>()
    val fireVisit = HashMap<Point, Int>()
    val fireQueue = LinkedList<Point>()
    val sgQueue = LinkedList<Point>()
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)

    loop@ for (ti in 0 until t) {
        val (w, h) = readLine().split(" ").map { it.toInt() }
        sgVisit.clear()
        fireVisit.clear()
        fireQueue.clear()
        sgQueue.clear()
        val maze = List(h) { i1 ->
            readLine().toList().mapIndexed { i2, c ->
                if (c == '*') {
                    fireVisit[Point(i1, i2)] = 0
                    fireQueue.add(Point(i1, i2))
                } else if (c == '@') {
                    sgVisit[Point(i1, i2)] = 0
                    sgQueue.add(Point(i1, i2))
                }
                c
            }
        }

        var cen: Point
        var cenX: Int
        var cenY: Int
        var curX: Int
        var curY: Int

        while (fireQueue.isNotEmpty()) {
            cen = fireQueue.removeFirst()
            cenX = cen.x
            cenY = cen.y
            for (i in 0 until 4) {
                curX = cenX + dx[i]
                curY = cenY + dy[i]
                if (curX < 0 || curX >= h || curY < 0 || curY >= w) continue
                if (maze[curX][curY] != '#' && fireVisit[Point(curX, curY)] == null) {
                    fireVisit[Point(curX, curY)] = fireVisit[Point(cenX, cenY)]!!.plus(1)
                    fireQueue.add(Point(curX, curY))
                }
            }
        }

        while (sgQueue.isNotEmpty()) {
            cen = sgQueue.removeFirst()
            cenX = cen.x
            cenY = cen.y
            for (i in 0 until 4) {
                curX = cenX + dx[i]
                curY = cenY + dy[i]
                if (curX < 0 || curX >= h || curY < 0 || curY >= w) {
                    println(sgVisit[Point(cenX, cenY)]!!.plus(1))
                    continue@loop
                }
                if (maze[curX][curY] != '#' &&
                    (fireVisit[Point(curX, curY)] == null ||
                            fireVisit[Point(curX, curY)]!! > sgVisit[Point(cenX, cenY)]!!.plus(1))
                ) {
                    sgVisit[Point(curX, curY)] = sgVisit[Point(cenX, cenY)]!!.plus(1)
                    sgQueue.add(Point(curX, curY))
                }
            }
        }
        println("IMPOSSIBLE")
    }
}
