import org.junit.Assert
import org.junit.Test
import java.io.File

class Day7Test {

    @Test
    fun provided(){
        Assert.assertEquals("tknk", Day7.solve(("pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "fwft (72) -> ktlj, cntj, xhth\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga, havc, qoyq\n" +
                "tknk (41) -> ugml, padx, fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo, ebii, jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)").split("\n")))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(8, Day7.solve2(("pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "fwft (72) -> ktlj, cntj, xhth\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga, havc, qoyq\n" +
                "tknk (41) -> ugml, padx, fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo, ebii, jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)").split("\n")))
    }

    @Test
    fun test(){
        Assert.assertEquals(42, Day7.solve(("a\nb").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals("cqmvs", Day7.solve((File("input/day7.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals("cqmvs", Day7.solve2((File("input/day7.txt").readLines())))
    }
}