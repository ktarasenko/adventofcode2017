import kotlin.coroutines.experimental.buildSequence

object Day15 {


    fun solve(a: Int, b: Int): Int {
        val ga = generatorSeq(16807, a,1)
        val gb = generatorSeq(48271, b,1)
        val amount= 40*1000*1000
        return ga.zip(gb).take(amount).count { it.first == it.second }
    }
    fun solve2(a: Int, b: Int): Int {
        val ga = generatorSeq(16807, a,4)
        val gb = generatorSeq(48271, b,8)
        val amount= 5*1000*1000
        return ga.zip(gb).take(amount).count { it.first == it.second }
    }

    private fun generatorSeq(factor: Int, startValue: Int, divides: Int) = buildSequence {
        var v = startValue.toLong()
        while (true){
            v = v*factor % 2147483647
            if (v % divides == 0L) yield(v.toString(2).takeLast(16))
        }
    }

}
