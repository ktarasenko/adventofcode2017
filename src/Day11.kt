import java.lang.Math.*

object Day11 {

    fun solve(list: Iterable<String>): Int {
        var max = 0
       val r = list.fold(Triple(0, 0, 0), { acc, it ->
            when (it) {
                "ne" -> acc.ne()
                "sw" -> acc.sw()
                "nw" -> acc.nw()
                "se" -> acc.se()
                "n" -> acc.n()
                else -> acc.s()
            }.also { max =  max(max, it.toList().map { abs(it) }.max()!!)}
        })
        println(max)
        return r.toList().map { abs(it) }.max()!!
    }

    fun solve2(list: Iterable<String>): Int {
        return 42
    }


    fun Triple<Int, Int, Int>.ne() = Triple(first, second + 1, third - 1)
    fun Triple<Int, Int, Int>.sw() = Triple(first, second - 1, third + 1)
    fun Triple<Int, Int, Int>.n() = Triple(first + 1, second, third - 1)
    fun Triple<Int, Int, Int>.s() = Triple(first - 1, second, third + 1)
    fun Triple<Int, Int, Int>.nw() = Triple(first + 1, second - 1, third)
    fun Triple<Int, Int, Int>.se() = Triple(first - 1, second + 1, third)

}
