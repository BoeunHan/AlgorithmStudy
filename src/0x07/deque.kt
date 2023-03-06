package `0x07`

fun main(){
    val MX = 1000005
    val dat = Array(2*MX + 1){0}
    var head = MX
    var tail = MX

    fun push_front(x: Int){
        dat[--head] = x
    }
    fun push_back(x: Int){
        dat[tail++] = x
    }
    fun pop_front(){
        head++
    }
    fun pop_back(){
        tail--
    }
    fun front(): Int{
        return dat[head]
    }
    fun back(): Int{
        return dat[tail - 1]
    }
    fun test(){
        push_back(30)
        println(front())
        println(back())
        push_front(25)
        push_back(12)
        println(back())
        push_back(62)
        pop_front()
        println(front())
        pop_front()
        println(back())
    }
    test()
}