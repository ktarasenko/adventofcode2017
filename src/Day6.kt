object Day6 {

    fun solve(list: List<String>): Int {
        val seenBefore = mutableSetOf<String>()
        var blocks = list.map { it.toInt() }
        var n = 0
        while (seenBefore.add(blocks.toString())) {
            blocks = redistribute(blocks)
            n++
        }
        return n
    }

    fun solve2(list: List<String>): Int {
        val seenBefore = mutableSetOf<String>()
        var blocks = list.map { it.toInt() }
        var n = 0
        var stateToRepeat: String? = null
        do {
            val currState = blocks.toString()
            if (stateToRepeat == null && !seenBefore.add(currState)) {
                stateToRepeat = currState
                n = 0
            }
            blocks = redistribute(blocks)
            n++
        } while (stateToRepeat == null || stateToRepeat != blocks.toString())
        return n
    }

    private fun redistribute(blocks: List<Int>): List<Int> {
        val (pos,amount) = blocks.mapIndexed { i, e -> i to e }.maxBy { it.second }!!
        val count = blocks.size
        return blocks.mapIndexed { i, e ->
            val fullRounds = amount / count
            val lastRound = (( i- pos + count) % count in 1..(amount % count))
            val base = (pos != i) * e
            lastRound + base + fullRounds
        }
    }

    private operator fun Boolean.times(b : Int): Int = b * if (this) 1 else 0
    private operator fun Boolean.plus(b : Int): Int = b + if (this) 1 else 0

}

