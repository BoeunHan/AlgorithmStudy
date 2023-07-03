package `0x0D`

import java.lang.Integer.*
import kotlin.math.abs

private data class Position (
    val posX: Int,
    val posY: Int
)

private var n = 0
private var m = 0
private var minChickenDist = MAX_VALUE

private val chickens = ArrayList<Position>()
private val houses = ArrayList<Position>()

private val selected = ArrayList<Position>()

fun main() = with(System.`in`.bufferedReader()) {
    val (n1, m1) = readLine().split(" ").map { it.toInt() }
    n = n1; m = m1

    for (i in 0 until n) {
        readLine().split(" ").forEachIndexed { idx, s ->
            when (s) {
                "1" -> houses.add(Position(i, idx))
                "2" -> chickens.add(Position(i, idx))
            }
        }
    }

    select(0, 0)

    println(minChickenDist)
}

private fun select(index: Int, depth: Int) {
    if (depth == m) {
        minChickenDist = min(minChickenDist, getChickenDistance())
        return
    }

    for (i in index until chickens.size) {
        selected.add(chickens[i])
        select(i + 1, depth + 1)
        selected.removeLast()
    }
}

private fun getChickenDistance(): Int {
    var sum = 0
    for (house in houses) {
        var min = MAX_VALUE
        for (chicken in selected) {
            min = min(min, abs(chicken.posX - house.posX) + abs(chicken.posY - house.posY))
        }
        sum += min
    }
    return sum
}

/*
최대계산횟수 13Cm * 치킨거리구하기 100*m
*/

