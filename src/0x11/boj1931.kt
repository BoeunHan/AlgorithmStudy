package `0x11`

private data class Meeting(
    val start: Int,
    val end: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val meetings = ArrayList<Meeting>()
    repeat(n) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        meetings.add(Meeting(s, e))
    }

    meetings.sortWith(compareBy({ it.end }, { it.start }))
    var time = 0
    var cnt = 0

    for (i in meetings) {
        if (i.start >= time) {
            time = i.end
            cnt++
        }
    }
    println(cnt)

}
