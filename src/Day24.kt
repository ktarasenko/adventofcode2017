object Day24 {

    fun solve(list: Iterable<String>): Int {
        val e = list.map {val (a, b) = it.split("/"); a.toInt() to b.toInt() }
        return bridge(0, 0, e).maxBy{it.first}!!.first
    }

    private fun bridge(sum: Int, next: Int, e: List<Pair<Int, Int>>, length: Int = 0): List<Pair<Int, Int>> =
         e.filter { it.first == next || it.second == next }.flatMap {
            bridge(sum+ it.first + it.second, if (it.first == next)it.second else it.first, e-it, length+1)
        } + (sum to length)

    fun solve2(list: Iterable<String>): Int {
        val e = list.map {val (a, b) = it.split("/"); a.toInt() to b.toInt() }
        return bridge(0, 0, e).sortedWith(compareBy({it.second}, {it.first})).last().first
    }

}
