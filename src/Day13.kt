object Day13 {

    fun solve(list: Iterable<String>): Int =
        severity(0, parse(list))

    private fun parse(list: Iterable<String>): List<Pair<Int, Int>> =
        list.map {
            val (layer, length) = it.split(": ")
            layer.toInt() to length.toInt()
        }


    private fun severity(delay: Int, list: List<Pair<Int, Int>>): Int =
        list.fold(0, {acc, (layer, length) ->
            if ((delay+layer)% (2*length-2) == 0){
                acc + layer*length
            } else {
                acc
            }
        })


    fun solve2(list: Iterable<String>): Int {
        val firewall = parse(list)
        return (0..Int.MAX_VALUE).first { delay ->
            firewall.none { (layer, length) -> (delay + layer) % (2 * length - 2) == 0 }
        }
    }

}
