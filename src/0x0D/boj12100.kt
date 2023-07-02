package `0x0D`

import java.lang.Integer.max

private lateinit var board: Array<IntArray>
private var n = 0
private var sum = 0

var max = 0
fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray().onEach { sum += it } }

    calculate(0, board)
    println(max)
}

private fun calculate(count: Int, b: Array<IntArray>) {

    if (max == sum) return
    if (count == 5) {
        max = max(max, getMaxValue(b))
        return
    }

    lateinit var board: Array<IntArray>

    for (i in 1..4) {
        board = copyBoard(b)
        swipe(i, board)
        calculate(count + 1, board)
    }
}

private fun swipe(direction: Int, board: Array<IntArray>) {
    var line = IntArray(n)
    lateinit var merge: IntArray
    when (direction) {
        //오른쪽 스와이프
        1 -> {
            for (i in 0 until n) {
                line = board[i].reversedArray()
                merge = merge(line)
                board[i] = merge.reversedArray()
            }
        }
        //왼쪽 스와이프
        2 -> {
            for (i in 0 until n) {
                line = board[i]
                merge = merge(line)
                board[i] = merge
            }
        }
        //아래쪽 스와이프
        3 -> {
            for (j in 0 until n) {
                for (i in 0 until n) line[i] = board[n - 1 - i][j]
                merge = merge(line)
                for (i in 0 until n) board[i][j] = merge[n - 1 - i]
            }
        }
        //위쪽 스와이프
        4 -> {
            for (j in 0 until n) {
                for (i in 0 until n) line[i] = board[i][j]
                merge = merge(line)
                for (i in 0 until n) board[i][j] = merge[i]
            }
        }
    }
}

private fun merge(_line: IntArray): IntArray {
    val line = IntArray(n)
    var idx = 0

    for (i in 0 until n) {
        if (_line[i] != 0) {
            line[idx] = _line[i]
            idx++
        }
    }

    for (i in idx until n) {
        line[i] = 0
    }

    var prev = 0

    for (i in 1 until n) {
        if (line[i] == line[prev]) {
            line[prev] += line[i]
            line[i] = 0
        }
        prev = i
    }

    val merge = IntArray(n)
    idx = 0

    for (i in 0 until n) {
        if (line[i] != 0) {
            merge[idx] = line[i]
            idx++
        }
    }

    for (i in idx until n) {
        merge[i] = 0
    }

    return merge
}

private fun copyBoard(board: Array<IntArray>): Array<IntArray> {
    val new = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        for (j in 0 until n) {
            new[i][j] = board[i][j]
        }
    }

    return new
}


private fun getMaxValue(board: Array<IntArray>): Int {
    var max = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            max = max(max, board[i][j])
        }
    }

    return max
}