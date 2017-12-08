import kotlin.math.abs
import kotlin.math.max

object Day8 {

    fun solve(list: Iterable<String>): Int {
        val regs = mutableMapOf<String, Int>().withDefault { 0 }
        list.forEach {
            doInsturction(it, regs)
        }
        return regs.maxBy { it.value }!!.value
    }

    fun solve2(list: Iterable<String>): Int {
        val regs = mutableMapOf<String, Int>().withDefault { 0 }
        var max = 0
        list.forEach {
            doInsturction(it, regs)
            max = max(regs.maxBy { it.value }?.value?: 0, max)

        }
        return max
    }


    private fun doInsturction(it: String, regs: MutableMap<String, Int>) {
        val (act, cond) = it.split("if")
        val (reg, op, v) = cond.trim().split(" ")
        val cnd = regs.getValue(reg).compareTo(v.toInt())
        if (when (op) {
            ">" -> cnd > 0
            ">=" -> cnd >= 0
            "<" -> cnd < 0
            "<=" -> cnd <= 0
            "!=" -> cnd != 0
            "==" -> cnd == 0
            else -> {
                println("shoun't happen");true
            }
        }) {
            val (reg, op, v) = act.trim().split(" ")
            regs[reg] = regs.getValue(reg) + v.toInt() * if (op == "dec") -1 else 1
        }
    }

}
