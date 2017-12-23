import kotlin.math.sqrt

object Day23 {

    fun solve(list: List<String>, v: Long = 0): Int {
        val reg = mutableMapOf<String, Long>("a" to v, "b" to 0, "c" to 0, "d" to 0, "e" to 0, "g" to 0, "h" to 0)
        var i = 0
        var mc = 0
        var s = 0
        while (i < list.size) {
            val cmd = list[i].split(" ")
            when (cmd[0]) {
                "sub" -> {
                    reg.put(cmd[1], reg.getOrDefault(cmd[1], 0) - reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
                }
                "set" -> {
                    reg.put(cmd[1], reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
                }
                "mul" -> {
                    mc++; reg.put(cmd[1], reg.getOrDefault(cmd[1], 0) * reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
                }
                "jnz" -> if (reg.getOrElse(cmd[1], { cmd[1].toLong() }) != 0L) i += cmd[2].toInt() else i++
            }


        }
        return mc
    }


    fun solve2(): Int {
        var b = 57 * 100 + 100000
        var c = b + 17000
        var h = 0

        b -= 17
        while (b != c) {
            b += 17
            (2 until sqrt(b.toDouble()).toInt())
                    .firstOrNull{b % it == 0}
                    ?.let { h++ }

        }
        return h
    }

}
