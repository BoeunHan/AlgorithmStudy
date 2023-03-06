package `0x04`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()

    for (i in 1..n) {
        val password = LinkedList<Char>()
        var pos = 0

        val str = readLine()
        for (j in str) {
            when (j) {
                '<' -> if (pos > 0) pos--
                '>' -> if (pos < password.size) pos++
                '-' -> if (pos > 0) password.removeAt(--pos)
                else -> password.add(pos++, j)
            }
        }

        for(j in password) bw.write(j.toString())
        bw.write("\n")
        bw.flush()
    }
    bw.close()
}