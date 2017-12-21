
object Day21 {

    fun solve(rounds: Int, list: List<String>): Int {
        var img = (".#.\n" + "..#\n" + "###").split("\n").parseToArray()
        val rules = parseRules(list)
        repeat(rounds, { img = process(img, rules) })
        return img.sumBy { it.sumBy { if (it) 1 else 0 } }
    }

    private fun process(img: Array<Array<Boolean>>, rules: Map<String, String>): Array<Array<Boolean>> {
        var arr: Array<Array<Boolean>>
        var blockSize: Int
        var newBlockSize: Int

        if (img.size % 2 == 0) {
            newBlockSize = 3
            blockSize = 2
        } else {
            blockSize = 3
            newBlockSize =4
        }
        var newSize=  img.size / blockSize * newBlockSize
        arr = Array(newSize, { Array(newSize, { false }) })

        for (i in 0 until img.size / blockSize) {
            for (j in 0 until img.size / blockSize) {
                val key =
                        (i * blockSize until i * blockSize + blockSize).map { k ->
                            img[k].sliceArray(j * blockSize until j * blockSize + blockSize)
                        }.toTypedArray()

                val keyString = join(key)
                val value = rules.getValue(keyString).split("/").parseToArray()

                value.forEachIndexed { m, it ->
                    it.forEachIndexed { n, it ->
                        arr[i * newBlockSize + m][j * newBlockSize + n] = it
                    }
                }

            }
        }
        return arr
    }

    private fun parseRules(list: List<String>): Map<String, String> =
            list.map { val (k, v) = it.split(" => "); k.split("/").parseToArray() to v }
                    .flatMap { rotateAndFlip(it) }.toMap()


    private fun rotateAndFlip(inp: Pair<Array<Array<Boolean>>, String>): List<Pair<String, String>> {
        val res = mutableListOf<String>()
        var arr = inp.first

        (0..3).forEach {
            res.add(join(arr))
            res.add(arr.joinToString("/") { it.joinToString("") { if (it) "#" else "." }.reversed() }) //vflip
            res.add(arr.reversed().joinToString("/") { it.joinToString("") { if (it) "#" else "." } }) //hflip

            arr = Array(arr.size, { i -> Array(arr.size, { j -> arr[arr.size - 1 - j][i] }) })
        }

        return res.distinct().map { it to inp.second }
    }


    private fun join(inp: Array<Array<Boolean>>): String =
            inp.asList().joinToString("/") { it.joinToString("") { if (it) "#" else "." } }

    private fun List<String>.parseToArray(): Array<Array<Boolean>> =
            this.map { it.map { it == '#' }.toTypedArray() }.toTypedArray()


}

