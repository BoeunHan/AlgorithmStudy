package `0x03`

//시간복잡도 O(N)으로 풀기
fun func2(arr: Array<Int>, n: Int): Int{
    val numArr = BooleanArray(101){false}

    for(i in arr){
        if(numArr[100-i]) return 1
        numArr[i] = true
    }
    return 0
}

fun main(){
    println(func2(arrayOf(1, 52, 48), 3))
    println(func2(arrayOf(50, 42), 2))
    println(func2(arrayOf(4, 13, 63, 87), 4))
}