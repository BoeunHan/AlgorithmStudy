package `0x0D`

import kotlin.math.abs

private var n = 0
private var l = 0

private lateinit var map: Array<IntArray>


fun main() = with(System.`in`.bufferedReader()) {
    val (n1, l1) = readLine().split(" ").map { it.toInt() }
    n = n1; l = l1

    map = Array(n) { IntArray(n) }


    repeat(n) { idx ->
        map[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    println(count())
}

private fun count(): Int {
    //slide()에 한줄씩 떼서 보내고 반환값이 true인 개수 구하기
    var cnt = 0

    //행 확인
    for (i in map) {
        if (slide(i)) cnt++
    }

    val line = IntArray(n)
    //열 확인
    for (j in 0 until n) {
        for (i in 0 until n) {
            line[i] = map[i][j]
        }
        if (slide(line)) cnt++
    }
    return cnt
}

private fun slide(map: IntArray): Boolean {
    var idx = 0
    var cnt = 1

    while (idx < n - 1) {
        if (abs(map[idx] - map[idx + 1]) >= 2) return false
        if (map[idx] == map[idx + 1]) {
            cnt++
            idx++
        } else if (map[idx] < map[idx + 1]) {
            if (cnt < l) return false
            cnt = 1
            idx++
        } else {
            if (idx + l >= n) return false
            for (i in idx + 1 until idx + l) {
                if (map[i] != map[i + 1]) return false
            }
            idx += l
            cnt = 0
        }
    }
    return true
}