package `0x05`

fun main(){
    val MX = 1000005
    val dat = IntArray(MX){0}
    var pos = 0

    fun push(x: Int){
        dat[pos++] = x
    }
    fun pop() {
        pos--
    }
    fun top(): Int{
        return dat[pos - 1]
    }
    fun test(){
        push(5); push(4); push(3)
        println(top())
        pop(); pop()
        println(top())
        push(10); push(12)
        println(top())
        pop()
        println(top())
    }

    test()

}