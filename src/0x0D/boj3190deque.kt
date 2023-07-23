package `0x0D`

import java.util.*
import kotlin.collections.HashMap

private var n = 0
private lateinit var board: List<MutableList<Int>>
private var move = HashMap<Int, String>()

private var snake = LinkedList<Pair<Int, Int>>()
private var time = 0
private var direction = Pair(0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    board = List(n) { MutableList(n) { 0 } }

    repeat(readLine().toInt()) {
        val input = readLine().split(" ")
        board[input[0].toInt() - 1][input[1].toInt() - 1] = 2
    }
    repeat(readLine().toInt()) {
        val input = readLine().split(" ")
        move[input[0].toInt()] = input[1]
    }

    play()
}

private fun play() {
    snake.addLast(Pair(0, 0))

    while (move()) {
        time++
        println("time = $time")
        move[time]?.let {
            changeDirection(it)
        }
        printBoard()
    }
    println(++time)
}

private fun printBoard() {
    for (i in board.indices) {
        for (j in board[i]) {
            print("$j ")
        }
        println()
    }
    println("==========================")
}

//L: 왼 D: 오
private fun changeDirection(dir: String) {
    when (direction) {
        Pair(0, 1) -> {
            direction = if (dir == "L") Pair(-1, 0)
            else Pair(1, 0)
        }
        Pair(0, -1) -> {
            direction = if (dir == "L") Pair(1, 0)
            else Pair(-1, 0)
        }
        Pair(1, 0) -> {
            direction = if (dir == "L") Pair(0, 1)
            else Pair(0, -1)
        }
        Pair(-1, 0) -> {
            direction = if (dir == "L") Pair(0, -1)
            else Pair(0, 1)
        }
    }
}

private fun move(): Boolean {
    println(snake)
    val newX = snake.peekLast().first + direction.first
    val newY = snake.peekLast().second + direction.second

    println(direction)
    println("newX = $newX / newY = $newY")
    if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
        println("out of bound")
        return false
    }
    if (board[newX][newY] == 1) {
        println("crash body")
        return false
    }

    snake.addLast(Pair(newX, newY))

    if (board[newX][newY] != 2) {
        val tail = snake.removeFirst()
        board[tail.first][tail.second] = 0
    }

    board[newX][newY] = 1

    return true
}



