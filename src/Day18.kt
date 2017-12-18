import kotlin.coroutines.experimental.buildIterator

object Day18 {

    fun solve(list: List<String>): Long {
        val reg = mutableMapOf<String, Long>()
        var i = 0
        var lp = 0L
        while (i < list.size) {
            val cmd = list[i].split(" ")
            when (cmd[0]) {
                "snd" -> {
                    lp = reg.getOrElse(cmd[1], { cmd[1].toLong() }); i++
                }
                "rcv" -> {
                    if (reg.getOrElse(cmd[1], { cmd[1].toLong() }) > 0) return lp else i++
                }
                "set" -> {
                    reg.put(cmd[1], reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
                }
                "add" -> {
                    reg.put(cmd[1], reg.getOrDefault(cmd[1], 0) + reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
                }
                "mul" -> {
                    reg.put(cmd[1], reg.getOrDefault(cmd[1], 0) * reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
                }
                "mod" -> {
                    reg.put(cmd[1], reg.getOrDefault(cmd[1], 0) % reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
                }
                "jgz" -> if (reg.getOrElse(cmd[1], { cmd[1].toLong() }) > 0) i += cmd[2].toInt() else i++
            }
        }
        return -1
    }

    var c = 0
    var p1 = false

    fun solve2(list: List<String>): Int {

        val q1 = mutableListOf<Long>()
        val q2 = mutableListOf<Long>()
        val seq1 = buildIterator {
            val reg = mutableMapOf("p" to 0L)
            var i = 0
            var steps = 0
            while (true) {
                if (ex(reg, q2, q1, list, i).let {
                    if (i == it) {
                        true
                    } else {
                        steps++; i = it; false
                    }
                }) {
                    steps = 0
                    break
                }
            }
            yield(steps)
        }
        val seq2 = buildIterator {
            val reg = mutableMapOf("p" to 1L)
            var i = 0
            var steps = 0
            while (true) {
                if (ex(reg, q2, q1, list, i).let {
                    if (i == it) {
                        true
                    } else {
                        steps++; i = it; false
                    }
                }) {
                    steps = 0
                    break
                }
            }
            yield(steps)
        }
        var s1 = -1
        var s2 = -1
        while (s1 != 0 || s2 != 0) {
            p1 = false
            s1 = seq1.next()
            p1 = true
            s2 = seq2.next()

        } //TODO: rewrite to pub/sub
        return c
    }

    private fun ex(reg: MutableMap<String, Long>, q1: MutableList<Long>, q2: MutableList<Long>, list: List<String>, p: Int): Int {
        val cmd = list[p].split(" ")
        var i = p
        when (cmd[0]) {
            "snd" -> {
                q2.add(reg.getOrElse(cmd[1], { cmd[1].toLong() })); i++
                if (p1) c++
            }
            "rcv" -> {
                if (q1.isNotEmpty()) {
                    reg.put(cmd[1], q1.removeAt(0))
                    i++
                }
            }
            "set" -> {
                reg.put(cmd[1], reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
            }
            "add" -> {
                reg.put(cmd[1], reg.getOrDefault(cmd[1], 0) + reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
            }
            "mul" -> {
                reg.put(cmd[1], reg.getOrDefault(cmd[1], 0) * reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
            }
            "mod" -> {
                reg.put(cmd[1], reg.getOrDefault(cmd[1], 0) % reg.getOrElse(cmd[2], { cmd[2].toLong() })); i++
            }
            "jgz" -> if (reg.getOrElse(cmd[1], { cmd[1].toLong() }) > 0) i += reg.getOrElse(cmd[2], { cmd[2].toLong() }).toInt() else i++
        }
        return i
    }


}