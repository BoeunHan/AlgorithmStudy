package `0x09`

import java.util.LinkedList

//1: 익은토마토 0: 안익은토마토 -1: 토마토없음
fun main() = with(System.`in`.bufferedReader()) {
    val (m, n, h) = readLine().split(" ").map { it.toInt() }
    val ripe = List(h) { List(n) { MutableList(m) { -1 } } }
    val queue = LinkedList<Triple<Int, Int, Int>>()
    var allRipe = true
    val tomato = List(h) { i1 ->
        List(n) { i2 ->
            readLine().split(" ").mapIndexed { i3, s ->
                if (s == "0") allRipe = false
                else if (s == "1") {
                    ripe[i1][i2][i3] = 0
                    queue.add(Triple(i1, i2, i3))
                }
                s.toInt()
            }
        }
    }
    if (allRipe) {
        println("0")
        return
    }

    val dh = arrayOf(0, 0, 0, 0, 1, -1)
    val dn = arrayOf(1, -1, 0, 0, 0, 0)
    val dm = arrayOf(0, 0, 1, -1, 0, 0)
    lateinit var cen: Triple<Int, Int, Int>
    var cenH = 0
    var cenN = 0
    var cenM = 0
    var curH: Int
    var curN: Int
    var curM: Int

    while (queue.isNotEmpty()) {
        cen = queue.removeFirst()
        cenH = cen.first
        cenN = cen.second
        cenM = cen.third
        for (i in 0 until 6) {
            curH = cenH + dh[i]
            curN = cenN + dn[i]
            curM = cenM + dm[i]
            if (curH < 0 || curH >= h ||
                curN < 0 || curN >= n ||
                curM < 0 || curM >= m
            ) continue
            if (tomato[curH][curN][curM] == 0 &&
                ripe[curH][curN][curM] == -1
            ) {
                queue.add(Triple(curH, curN, curM))
                ripe[curH][curN][curM] = ripe[cenH][cenN][cenM] + 1
            }
        }
    }

    var notAllRipe = false
    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (tomato[i][j][k] == 0 && ripe[i][j][k] == -1) {
                    notAllRipe = true
                    break
                }
            }
        }
    }
    if (notAllRipe) {
        println("-1")
        return
    }

    println(ripe[cenH][cenN][cenM])

}

fun printRipe(ripe: List<List<List<Int>>>){
    println("------------------")
    for(i in ripe.indices){
        for(j in ripe[0].indices){
            println(ripe[i][j])
        }
        println()
    }
}

