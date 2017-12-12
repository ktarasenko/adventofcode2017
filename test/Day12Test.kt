import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day12Test {

    @Test
    fun provided(){
        Assert.assertEquals(6, Day12.solve(("0 <-> 2\n" +
                "1 <-> 1\n" +
                "2 <-> 0, 3, 4\n" +
                "3 <-> 2, 4\n" +
                "4 <-> 2, 3, 6\n" +
                "5 <-> 6\n" +
                "6 <-> 4, 5").split("\n")))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(2, Day12.solve2(("0 <-> 2\n" +
                "1 <-> 1\n" +
                "2 <-> 0, 3, 4\n" +
                "3 <-> 2, 4\n" +
                "4 <-> 2, 3, 6\n" +
                "5 <-> 6\n" +
                "6 <-> 4, 5").split("\n")))
    }


    @Test
    fun task(){
        Assert.assertEquals(134, Day12.solve((File("input/day12.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(193, Day12.solve2((File("input/day12.txt").readLines())))
    }
}