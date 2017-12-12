object Day12 {

    fun solve(list: Iterable<String>): Int {
        val map = parseMap(list)

        val seen = mutableSetOf<Int>()
        findGroup(0, map, seen)
        return seen.size
    }

    private fun parseMap(list: Iterable<String>): Map<Int, List<Int>> {
        return list.map {
            val (from, to) = it.split("<->")
            from.trim().toInt() to to.split(",").map { it.trim().toInt() }
        }.toMap()
    }

    private fun findGroup(n: Int, map: Map<Int, List<Int>>, seen: MutableSet<Int>) {
        if (seen.add(n)){
            map.getValue(n).forEach { findGroup(it, map, seen) }
        }
    }

    fun solve2(list: Iterable<String>): Int {
        val map = parseMap(list)
        val seen = mutableSetOf<Int>()
        var groups = 0
        map.keys.forEach {
            if (!seen.contains(it)) {
                groups++
                findGroup(it, map, seen)
            }
        }
        return groups
    }

}
