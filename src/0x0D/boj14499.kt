package `0x0D`

private var n = 0
private var m = 0
private var x = 0
private var y = 0
private lateinit var map: Array<IntArray>
private lateinit var move: List<String>
private var dice = MutableList(6) { 0 }

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]; m = input[1]
    x = input[2]; y = input[3]

    map = Array(n) { IntArray(m) }
    repeat(n) { idx ->
        map[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    move = readLine().split(" ").toList()

    repeat(input[4]) { idx ->
        roll(move[idx])
    }

}
/*
*  0   (맨위)
*  1
*  2   (바닥)
*4 3 5
*/
//1:동 2:서 3:북 4:남

private fun moveDice(dir: String): Boolean {
    var newX = x
    var newY = y
    when (dir) {
        "1" -> {
            newY++
        }
        "2" -> {
            newY--
        }
        "3" -> {
            newX--
        }
        "4" -> {
            newX++
        }
    }
    if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
        return false
    }
    x = newX
    y = newY
    return true
}

private fun roll(dir: String) {
    if (!moveDice(dir)) return

    lateinit var newDice: List<Int>
    when (dir) {
        "1" -> {
            newDice = listOf(dice[4], dice[1], dice[5], dice[3], dice[2], dice[0])
        }
        "2" -> {
            newDice = listOf(dice[5], dice[1], dice[4], dice[3], dice[0], dice[2])
        }
        "3" -> {
            newDice = listOf(dice[1], dice[2], dice[3], dice[0], dice[4], dice[5])
        }
        "4" -> {
            newDice = listOf(dice[3], dice[0], dice[1], dice[2], dice[4], dice[5])
        }
    }
    dice = newDice.toMutableList()

    copyNum()

    println(dice[0])
}

private fun copyNum() {
    if (map[x][y] == 0) {
        map[x][y] = dice[2]
    } else {
        dice[2] = map[x][y]
        map[x][y] = 0
    }
}