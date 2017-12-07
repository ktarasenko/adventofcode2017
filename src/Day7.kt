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
        val children = c.split(",").map { it.trim() }.filter { it.isNotBlank() }
        return Disk(name, wS.drop(1).dropLast(1).toInt(), children)
    }


    data class Disk(val name: String, val weight: Int, val children: List<String>) {
        fun toNode(disksMap: Map<String, Disk>): Node = Node(name, weight, children.map { disksMap.getValue(it).toNode(disksMap) })
    }

    data class Node(val name: String, val weight: Int, val children: List<Node>) {
        val subtreeSum: Int by lazy { weight + children.sumBy { it.subtreeSum } }

        val sumsList : List<List<Day7.Node>> by lazy {
            children.map { it.subtreeSum to it }.groupBy { it.first }.map { it.value.map { it.second } }.sortedBy { it.size }
        }

        val unbalancedChild: Node by lazy {
            sumsList.first().first()
        }

        val weightToBalance: Int by lazy {
            if (sumsList.size > 1) {
                val expectedSubtreeSize = sumsList[1].first().subtreeSum
                expectedSubtreeSize - unbalancedChild.subtreeSum + unbalancedChild.weight
            } else {
                0
            }
        }
    }

    fun solve2(list: List<String>): Int {
        val disks = list.map { parse(it) }
        val disksMap = disks.map { it.name to it }.toMap()
        val rootNode = disksMap.getValue(findRoot(disks)).toNode(disksMap)
        return findLastBalance(rootNode)
    }

    private fun findLastBalance(node: Node): Int =
            node.weightToBalance.let {
                if (it > 0) {
                    if (node.children.none { it.weightToBalance > 0 }) it else findLastBalance(node.unbalancedChild)
                } else {
                    node.children.map { findLastBalance(it) }.max() ?: 0
                }
            }


}
