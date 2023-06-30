package `0x0C`

import java.util.*

private lateinit var student: Array<CharArray>
private val student2 = Array(25) { it }
private val myArr = Array(7) { -1 }
private var cnt = 0
fun main() = with(System.`in`.bufferedReader()) {
    student = Array(5) { readLine().toCharArray() }
    func(0, 0)
    //25개 중 7개 뽑는 조합
    //그 7개가 다 인접해 있는지 계산
    //인접해 있다면 그중 S가 4개 이상인지
    println(cnt)
}

private fun func(k: Int, prev: Int) {
    if (k == 7) {
        if(bfs()) cnt++
        return
    }
    for (i in prev until student2.size) {
        myArr[k] = student2[i]
        func(k + 1, i + 1)
    }
}

private fun bfs(): Boolean {
    var cntS = 0
    var cnt = 0
    val dx = listOf(-1, 0, 1, 0)
    val dy = listOf(0, -1, 0, 1)
    val x = myArr[0] / 5
    val y = myArr[0] % 5
    val visited = Array(7) { false }
    val queue = LinkedList<Pair<Int, Int>>()
    if(student[x][y] == 'S') cntS++
    queue.add(Pair(x, y))
    visited[0] = true
    cnt++
    while (queue.isNotEmpty()) {
        val cen = queue.removeFirst()
        for (i in 0 until 4) {
            val curX = cen.first + dx[i]
            val curY = cen.second + dy[i]
            for (j in 1 until 7) {
                if (!visited[j] && curX == student2[j] / 5 && curY == student2[j] % 5){
                    if(student[curX][curY] == 'S') cntS++
                    queue.add(Pair(curX, curY))
                    visited[j] = true
                    cnt++
                }
            }
        }
    }
    return cnt == 7 && cntS >=4
}

