package boj.bruteforce

val t = TA()

class TA {
    init {
        val list = mutableListOf<Int>(1,2,3,4)
        val list2 = listOf<Int>(1,2,3)

        val list3 = list + list2
        println(list3)
    }
}