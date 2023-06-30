package `0x0D`

import java.lang.Integer.min

private lateinit var map: Array<IntArray>

private var n = 0
private var m = 0

private lateinit var cctv: ArrayList<CCTV>

private var minCnt = Integer.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {

    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    n = _n; m = _m;

    map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    cctv = getCCTVs()

    findSight(0, map)
    println(minCnt)
}

data class CCTV(val posX: Int, val posY: Int, val mode: Int)

private fun getCCTVs(): ArrayList<CCTV> =
    ArrayList<CCTV>().apply {
        for (i in map.indices) {
            for (j in map[0].indices) {
                if (map[i][j] in 1..5) add(CCTV(i, j, map[i][j]))
            }
        }
    }

private fun findSight(idx: Int, map: Array<IntArray>) {
    lateinit var map2: Array<IntArray>

    if (idx == cctv.size) {
        val cnt = getBlindSpotCnt(map)
        minCnt = min(cnt, minCnt)
        //printMap(map)
       //println("----------")
        return
    }

    val cctv = cctv[idx]
    //println("idx: $idx , cctv mode: ${cctv.mode}")
    when (cctv.mode) {
        1 -> {
            for (i in 1..4) {
                map2 = copyMap(map)
                straight(map2, cctv.posX, cctv.posY, i)
                findSight(idx + 1, map2)
            }
        }
        2 -> {
            for ((i, j) in setOf(Pair(1, 2), Pair(3, 4))) {
                map2 = copyMap(map)
                straight(map2, cctv.posX, cctv.posY, i)
                straight(map2, cctv.posX, cctv.posY, j)
                findSight(idx + 1, map2)
            }
        }
        3 -> {
            for ((i, j) in setOf(Pair(1, 3), Pair(1, 4), Pair(2, 3), Pair(2, 4))) {
                map2 = copyMap(map)
                straight(map2, cctv.posX, cctv.posY, i)
                straight(map2, cctv.posX, cctv.posY, j)
                findSight(idx + 1, map2)
            }
        }
        4 -> {
            for ((i, j, k) in setOf(Triple(1, 2, 4), Triple(1, 3, 4), Triple(2, 3, 4), Triple(1, 2, 3))) {
                map2 = copyMap(map)
                straight(map2, cctv.posX, cctv.posY, i)
                straight(map2, cctv.posX, cctv.posY, j)
                straight(map2, cctv.posX, cctv.posY, k)
                findSight(idx + 1, map2)
            }
        }
        5 -> {
            map2 = copyMap(map)
            for (i in 1..4) {
                straight(map2, cctv.posX, cctv.posY, i)
            }
            findSight(idx + 1, map2)
        }
    }
}
private fun copyMap(map: Array<IntArray>): Array<IntArray>{
    val new = Array(n){IntArray(m) { 0 } }
    for(i in new.indices){
        for(j in new[0].indices){
            new[i][j] = map[i][j]
        }
    }
    return new
}

private fun straight(map: Array<IntArray>, posX: Int, posY: Int, direction: Int) {
    //println("posX: $posX, posY: $posY, direction: $direction")
    when (direction) {
        //오른쪽 직진
        1 -> for (i in posY + 1 until m) {
            if (map[posX][i] == 6) break
            if (map[posX][i] in 1..5) continue
            map[posX][i] = -1
        }
        //왼쪽 직진
        2 -> for (i in posY - 1 downTo 0) {
            if (map[posX][i] == 6) break
            if (map[posX][i] in 1..5) continue
            map[posX][i] = -1
        }
        //위쪽 직진
        3 -> for (i in posX - 1 downTo 0) {
            if (map[i][posY] == 6) break
            if (map[i][posY] in 1..5) continue
            map[i][posY] = -1
        }
        //아래쪽 직진
        4 -> for (i in posX + 1 until n) {
            if (map[i][posY] == 6) break
            if (map[i][posY] in 1..5) continue
            map[i][posY] = -1
        }
    }
}

private fun getBlindSpotCnt(map: Array<IntArray>): Int {
    var cnt = 0
    for (i in map.indices) {
        for (j in map[0].indices) {
            if (map[i][j] == 0) cnt++
        }
    }
    return cnt
}

private fun printMap(map: Array<IntArray>) {
    for (i in map.indices) {
        for (j in map[0].indices) {
            print("${map[i][j]} ")
        }
        println()
    }
}