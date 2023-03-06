package `0x03`

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val numArr = readLine().split(" ").map { it.toInt() }
    val x = readLine().toInt()

    val arr = IntArray(1000000){ 0 }
    var cnt = 0

    for(i in numArr){
        if(x - i <= 0 || x - i >= 1000000) continue
        if(arr[x - i] > 0) cnt += arr[x - i]
        arr[i]++
    }
    println(cnt)
}