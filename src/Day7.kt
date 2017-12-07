import javafx.scene.text.FontWeight

object Day7 {

    fun solve(list: List<String>): String =
            findRoot(list.map { parse(it) })

    private fun findRoot(list: List<Disk>): String =
            list.fold(emptySet<String>() to emptySet<String>(), { acc, it ->
                acc.first.plus(it.name) to acc.second.plus(it.children)
            }).run { first.minus(second).first() }


    private fun parse(l: String): Disk {
        // fwft (72) -> ktlj, cntj, xhth
        val ls = l.split("->")
        val nw = ls.first()
        val c = ls.getOrElse(1, { "" })
        val (name, wS) = nw.split(" ")
        val children = c.split(",").filter { it.isNotBlank() }
        return Disk(name, wS.drop(1).dropLast(1).toInt(), children)
    }


    data class Disk(val name: String, val weight: Int, val children: List<String>)

    fun solve2(list: List<String>): Long {
        val disks = list.map { parse(it) }
        val disksMap = disks.map { it.name to it }.toMap()
        val rootNode = disksMap.getValue(solve(list))
        rootNode.children.map { subtreeSum(it, disksMap)}
        return 42
    }

    private fun subtreeSum(node: String, disksMap: Map<String, Day7.Disk>): Int {
        return disksMap.getValue(node).run{
            weight + children.sumBy { subtreeSum(it, disksMap) }
        }.also { println("$it, $node") }
    }

}
