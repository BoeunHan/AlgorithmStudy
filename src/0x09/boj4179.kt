package `0x09`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (x, y) = readLine().split(" ").map { it.toInt() }
    val maze = List(x) { readLine().toList() }

    lateinit var jh: Pair<Int, Int>
    val fireQueue = LinkedList<Pair<Int, Int>>()
    val fireVisit = Array(x) { Array(y) { -1 } }

    for (i in maze.indices) {
        for (j in maze[0].indices) {
            if (maze[i][j] == 'J') jh = Pair(i, j)
            if (maze[i][j] == 'F') {
                fireVisit[i][j] = 0
                fireQueue.add(Pair(i, j))
            }
        }
    }

    if (jh.first == 0 || jh.first == x - 1 ||
        jh.second == 0 || jh.second == y - 1
    ) {
        println("1")
        return
    }
    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(-1, 0, 1, 0)

    while (fireQueue.isNotEmpty()) {
        val fireCen = fireQueue.removeFirst()
        val fireCenX = fireCen.first
        val fireCenY = fireCen.second
        for (i in 0 until 4) {
            val curX = fireCenX + dx[i]
            val curY = fireCenY + dy[i]
            if (curX < 0 || curX >= x ||
                curY < 0 || curY >= y
            ) continue
            if (fireVisit[curX][curY] == -1 &&
                maze[curX][curY] != '#'
            ) {
                fireVisit[curX][curY] = fireVisit[fireCenX][fireCenY] + 1
                fireQueue.add(Pair(curX, curY))
            }
        }
    }

    val jhQueue = LinkedList<Pair<Int, Int>>()
    val jhVisit = Array(x) { Array(y) { -1 } }

    jhVisit[jh.first][jh.second] = 0
    jhQueue.add(jh)

    var possible = false

    loop@ while (jhQueue.isNotEmpty()) {
        val jhCen = jhQueue.removeFirst()
        val jhCenX = jhCen.first
        val jhCenY = jhCen.second

        for (i in 0 until 4) {
            val curX = jhCenX + dx[i]
            val curY = jhCenY + dy[i]
            if (curX < 0 || curX >= x ||
                curY < 0 || curY >= y
            ) {
                possible = true
                println(jhVisit[jhCenX][jhCenY] + 1)
                break@loop
            }
            if (jhVisit[curX][curY] == -1 &&
                maze[curX][curY] != '#' &&
                (fireVisit[curX][curY] == -1 ||
                        fireVisit[curX][curY] > jhVisit[jhCenX][jhCenY] + 1)
            ) {
                jhVisit[curX][curY] = jhVisit[jhCenX][jhCenY] + 1
                jhQueue.add(Pair(curX, curY))
            }
        }
    }
    if (!possible) println("IMPOSSIBLE")
}

fun printMaze(jh: Array<Array<Int>>, fire: Array<Array<Int>>) {
    val print = Array(jh.size) { Array(jh[0].size) { "__ " } }
/*    for (i in jh.indices) {
        for (j in jh[0].indices) {
            if (jh[i][j] != -1) print[i][j] = "J${jh[i][j]} "
        }
    }*/
    for (i in fire.indices) {
        for (j in fire[0].indices) {
            if (fire[i][j] != -1) print[i][j] = "${fire[i][j]} "
        }
    }
    for (i in jh.indices) {
        for (j in jh[0].indices) {
            print("${print[i][j]} ")
        }
        println()
    }
    println("----------")
}