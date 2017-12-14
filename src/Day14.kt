object Day14 {

    fun solve(input: String): Int =
        grid(input)
                .sumBy { it.count { it == '1' } }

    private fun grid(input: String) =
            (0..127).map { "$input-$it" }
                    .map { knotHash(it) }
                    .map { hexToBinary(it) }

    private fun hexToBinary(hex: String): String =
            (0..3).map { hex.take(8 * (it + 1)).drop(it*8) } .map {
                it.toLong(16).toString(2).padStart(32, '0')
            }.joinToString(separator = "")

    fun solve2(input: String): Int {
        val grid = grid(input)
                .map { it
                        .map {
                            when(it) {
                                '1' -> 1
                                else -> 0
                            }
                        }.toMutableList() }
        var g = -1

        for (i in 0 until grid.size){
            for (j in 0 until grid.size){
                markGroup(grid, i to j,  g--)
            }
        }
        return grid.flatMap { it.distinct() }.distinct().size - 1
    }

    private fun markGroup(grid: List<MutableList<Int>>, c: Pair<Int, Int>, g: Int) {
        if (grid.getOrNull(c.first)?.getOrNull(c.second)?: 0 > 0){
            grid[c.first][c.second] = g
            markGroup(grid, c.first +1 to c.second, g)
            markGroup(grid, c.first -1 to c.second, g)
            markGroup(grid, c.first to c.second-1, g)
            markGroup(grid, c.first to c.second +1, g)
        }
    }

}
