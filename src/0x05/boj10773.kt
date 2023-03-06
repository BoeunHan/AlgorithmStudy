package `0x05`

fun main() = with(System.`in`.bufferedReader()){
    val k = readLine().toInt()
    val arr = Array(k){0}
    var pos = 0
    repeat(k){
        val n = readLine().toInt()
        if(n == 0) pos--
        else arr[pos++] = n
    }
    var sum = 0
    for(i in 0 until pos) sum += arr[i]

    println(sum)
}

