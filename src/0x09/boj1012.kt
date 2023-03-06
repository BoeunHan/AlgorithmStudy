package `0x09`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (x, y, k) = readLine().split(" ").map { it.toInt() }

        val cabbage = Array(x) { Array(y) { false } }
        val visit = Array(x) { Array(y) { false } }

        repeat(k) {
            val (posX, posY) = readLine().split(" ").map { it.toInt() }
            cabbage[posX][posY] = true
        }

        val dxdy = arrayOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))

        var cnt = 0

        for (i in 0 until x) {
            for (j in 0 until y) {
                if (cabbage[i][j] && !visit[i][j]) {
                    val stack = LinkedList<Pair<Int, Int>>()
                    cnt++
                    visit[i][j] = true
                    stack.add(Pair(i, j))

                    while (stack.isNotEmpty()) {
                        val cen = stack.pop()
                        val cenX = cen.first
                        val cenY = cen.second
                        for ((dx, dy) in dxdy) {
                            val curX = cenX + dx
                            val curY = cenY + dy
                            if (curX < 0 || curX >= x ||
                                curY < 0 || curY >= y
                            ) continue
                            if (cabbage[curX][curY] && !visit[curX][curY]) {
                                visit[curX][curY] = true
                                stack.add(Pair(curX, curY))
                            }
                        }
                    }
                }
            }
        }
        println(cnt)
    }
}