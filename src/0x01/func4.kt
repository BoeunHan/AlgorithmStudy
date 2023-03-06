package `0x01`

fun myFunc4(n: Int): Int{
    var num = 1
    var tmp = num

    while(true){
        tmp *= 2
        if(tmp <= n) num = tmp
        else return num
    }
}


fun main(){
    println(myFunc4(5))
    println(myFunc4(97615282))
    println(myFunc4(1024))
 }