package `0x06`

fun main() {
    val MX = 1000005
    val dat = IntArray(MX) { 0 }
    var head = 0
    var tail = 0

    fun push(x: Int) {
        dat[tail++] = x
    }
    fun pop() {
        head++
    }
    fun front(): Int {
        return dat[head]
    }
    fun back(): Int {
        return dat[tail - 1]
    }
    fun test() {
        push(10); push(20); push(30)
        println(front())
        println(back())
        pop(); pop()
        push(15); push(25)
        println(front())
        println(back())
    }
    test()
}