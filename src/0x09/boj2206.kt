package `0x09`

lateinit var map: Array<Array<Boolean>>
var n = 0
var m = 0
val dx = arrayOf(-1, 0, 0, 1)
val dy = arrayOf(0, -1, 1, 0)
fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    n = _n; m = _m

    map = Array(n) { Array(m) { false } }
    val visit = Array(n) { Array(m) { 0 } }

    for (i1 in 0 until n) {
        readLine().toCharArray().forEachIndexed { i2, c ->
            map[i1][i2] = (c == '0')
        }
    }

    visit[0][0] = 1
    bfs(0, 0, 0, visit, 0)
    println(if (visit[n - 1][m - 1] == 0) -1 else visit[n - 1][m - 1])
}

fun bfs(x: Int, y: Int, cnt: Int, visit: Array<Array<Int>>, idx: Int) {
    printVisit(x, y, idx, visit)
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
        /*
        벽인 경우 - 한번도 뚫은적 없으면 뚫고가기 가능
        벽이아닌 경우 - 한번도 간적없으면 가기
                      이미 갔으면 숫자가 현재+1보다 크면 글로 가기 가능
        */
        if (map[nx][ny]) {
            if (visit[nx][ny] == 0 || (visit[nx][ny] > visit[x][y] + 1)) {
                visit[nx][ny] = visit[x][y] + 1
                bfs(nx, ny, cnt, visit, idx + 1)
            }
        } else {
            if (cnt == 0) {
                visit[nx][ny] = visit[x][y] + 1
                bfs(nx, ny, 1, visit, idx + 1)
            }
        }
    }
}

fun printVisit(x: Int, y: Int, idx: Int, visit: Array<Array<Int>>) {
    println("$idx 번째 재귀 ($x, $y)------")
    for (i in visit.indices) {
        for (j in visit[0].indices) {
            print("${visit[i][j]} ")
        }
        println()
    }
}