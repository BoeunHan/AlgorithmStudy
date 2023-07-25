package `0x0F`

import java.util.*

data class Creature(
    var size: Int,
    var group: Int
)

private val creatures = LinkedList<Creature>()

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        creatures.clear()
        creatures.addAll(readLine().split(" ")
            .map { Creature(it.toInt(), 1) })

        creatures.addAll(readLine().split(" ")
            .map { Creature(it.toInt(), 2) })


        creatures.sortWith(compareBy({ it.size }, { it.group }))

        var cnt = 0
        var bCnt = 0

        for (c in creatures) {
            if (c.group == 1) cnt += bCnt
            else if(c.group == 2) bCnt++
        }

        println(cnt)
    }
}