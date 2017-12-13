import java.lang.Math.*

object Day11 {

    fun solve(list: Iterable<String>): Int {
        var max = 0
       val r = list.fold(Triple(0, 0, 0), { acc, it ->
            funcs.getValue(it)(acc).also { max =  max(max, it.toList().map { abs(it) }.max()!!)}
        })
        println(max)
        return r.toList().map { abs(it) }.max()!!
    }


    val funcs = mapOf<String, (Triple<Int,Int,Int>) -> Triple<Int,Int,Int>>(
            "ne" to {t-> Triple(t.first, t.second + 1, t.third - 1)},
            "sw" to {t -> Triple(t.first, t.second - 1, t.third + 1)},
            "n" to {t -> Triple(t.first + 1, t.second, t.third - 1)},
            "s" to {t -> Triple(t.first - 1, t.second, t.third + 1)},
            "nw" to {t -> Triple(t.first + 1, t.second - 1, t.third)},
            "se" to {t -> Triple(t.first - 1, t.second + 1, t.third)})

}
