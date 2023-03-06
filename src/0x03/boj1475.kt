package `0x03`

fun main() = with(System.`in`.bufferedReader()){
    val arr = IntArray(10){0}
    val n = readLine()

    for(i in n){
        arr[i - '0']++
    }

    if(arr[6] > arr[9]){
        val share = (arr[6] - arr[9])/2
        arr[6] -= share
        arr[9] += share
    }
    else if(arr[9] > arr[6]){
        val share = (arr[9] - arr[6])/2
        arr[9] -= share
        arr[6] += share
    }
    print(arr.maxOrNull())
}