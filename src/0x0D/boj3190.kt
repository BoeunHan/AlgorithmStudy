package `0x0D`


private var n = 0
private lateinit var board: Array<IntArray>
private lateinit var board2: Array<Array<Position2>>

//0: 빈칸 1: 뱀 몸통 2: 사과

private data class Position2(var x: Int, var y: Int)

private val move = HashMap<Int, String>()
private var time = 0
private var headPos = Position2(0, 0)
private var tailPos = Position2(0, 0)
private var direction = Position2(0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    board = Array(n) { IntArray(n) }
    board2 = Array(n) { Array(n) { Position2(0, 0) } }

    board[0][0] = 1

    repeat(readLine().toInt()) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        board[x - 1][y - 1] = 2
    }
    repeat(readLine().toInt()) {
        val (idx, dir) = readLine().split(" ")
        move[idx.toInt()] = dir
    }

    play()
}

private fun play() {
    while (proceed()) {
        move[time]?.let {
            rotate(it)
        }
    }

    println(time)
}

private fun rotate(dir: String) {
    when (direction) {
        Position2(0, 1) -> {
            if (dir == "L") {
                direction.x = -1; direction.y = 0
            }
            if (dir == "D") {
                direction.x = 1; direction.y = 0
            }
        }
        Position2(0, -1) -> {
            if (dir == "L") {
                direction.x = 1; direction.y = 0
            }
            if (dir == "D") {
                direction.x = -1; direction.y = 0
            }
        }
        Position2(1, 0) -> {
            if (dir == "L") {
                direction.x = 0; direction.y = 1
            }
            if (dir == "D") {
                direction.x = 0; direction.y = -1
            }
        }
        Position2(-1, 0) -> {
            if (dir == "L") {
                direction.x = 0; direction.y = -1
            }
            if (dir == "D") {
                direction.x = 0; direction.y = 1
            }
        }
    }
}

private fun proceed(): Boolean {
    time++

    board2[headPos.x][headPos.y]?.let {
        it.x = direction.x
        it.y = direction.y
    }

    headPos.x = headPos.x + direction.x
    headPos.y = headPos.y + direction.y

    if (OOB(headPos)) return false

    if (board[headPos.x][headPos.y] == 1) return false

    if (board[headPos.x][headPos.y] == 0) {
        board[tailPos.x][tailPos.y] = 0

        board2[tailPos.x][tailPos.y]?.let {
            tailPos.x = tailPos.x + it.x
            tailPos.y = tailPos.y + it.y
        }
    }
    board[headPos.x][headPos.y] = 1

    return true
}

private fun OOB(pos: Position2): Boolean {
    if (pos.x < 0 || pos.x >= n || pos.y < 0 || pos.y >= n) return true
    return false
}

