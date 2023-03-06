package `0x03`

fun main() = with(System.`in`.bufferedReader()){
    val arr = IntArray(10){0}

    var result = 1
    result *= readLine().toInt()
    result *= readLine().toInt()
    result *= readLine().toInt()

    while(result > 0){
        arr[result % 10]++
        result /= 10
    }
    for(cnt in arr){
        println(cnt)
    }
}