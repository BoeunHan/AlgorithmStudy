package `0x09`

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val visit = Array(100001) { -1 }
    val queue = LinkedList<Int>()

    visit[n] = 0
    queue.add(n)

    while (visit[k] == -1) {
        val cen = queue.removeFirst()
        for (i in setOf(cen - 1, cen + 1, cen * 2)) {
            if (i < 0 || i >= 100001) continue
            if (visit[i] != -1) continue
            visit[i] = visit[cen] + 1
            queue.add(i)
        }
    }
    println(visit[k])
}