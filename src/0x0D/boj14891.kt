package `0x0D`

import java.util.*

private val gear = Array(4) { LinkedList<Int>() }
private lateinit var rotated: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    repeat(4) { idx ->
        gear[idx].addAll(readLine().map { it - '0' })
    }

    repeat(readLine().toInt()) {
        val (gearNo, dir) = readLine().split(" ").map { it.toInt() }
        rotated = BooleanArray(4) { false }
        rotate(gearNo - 1, dir)
    }
    println(countScore())
}

//1: 시계방향 / -1: 반시계방향
private fun rotate(gearNo: Int, dir: Int) {
    if(rotated[gearNo]) return

    rotated[gearNo] = true

    if (gearNo - 1 >= 0 && gear[gearNo][6] != gear[gearNo - 1][2]) rotate(gearNo - 1, dir * (-1))
    if (gearNo + 1 < 4 && gear[gearNo][2] != gear[gearNo + 1][6]) rotate(gearNo + 1, dir * (-1))

    if (dir == 1) {
        gear[gearNo].addFirst(gear[gearNo].removeLast())
    } else {
        gear[gearNo].addLast(gear[gearNo].removeFirst())
    }

    //극이 다르면 반대방향 회전
    //극이 같으면 회전 x

}

//0: N극 / 1: S극
private fun countScore(): Int {
    var score = 0
    if (gear[0][0] == 1) score += 1
    if (gear[1][0] == 1) score += 2
    if (gear[2][0] == 1) score += 4
    if (gear[3][0] == 1) score += 8
    return score
}