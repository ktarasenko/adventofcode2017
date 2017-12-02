object Day2 {

    private val SPACE_REGEX = """\s""".toRegex()

    fun solve(list: Iterable<String>): Int = sumRowsBy(list, ::minmax)


    fun solve2(list: Iterable<String>): Int = sumRowsBy(list, ::dividers)

    private fun sumRowsBy(list: Iterable<String>, op: (List<Int>) -> Int): Int =
            list.sumBy {
                it.split(SPACE_REGEX)
                        .map { it.toInt() }
                        .sortedDescending()
                        .let {
                            op(it)
                        }

            }

    private fun minmax(it: List<Int>): Int = it.first() - it.last()

    private fun dividers(it: List<Int>): Int {
        it.forEachIndexed { index, i ->
            it.subList(index + 1, it.size).firstOrNull {
                i % it == 0
            }?.let {
                return i / it
            }
        }
        return 0
    }


}
