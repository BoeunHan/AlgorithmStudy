package `0x01`

fun myFunc2(arr: Array<Int>, n: Int): Int{
    for(i in 0 until n){
        for(j in i+1 until n){
            if(arr[i]+arr[j]==100) return 1
        }
    }
    return 0
}

fun main(){
    println(myFunc2(arrayOf(1,52,48),3))
    println(myFunc2(arrayOf(50,42),2))
    println(myFunc2(arrayOf(4,13,63,87),4))
}