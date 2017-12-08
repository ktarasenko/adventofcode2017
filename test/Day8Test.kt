import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day8Test {

    @Test
    fun provided(){
        Assert.assertEquals(1, Day8.solve(("b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10").split("\n")))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(10, Day8.solve2(("b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals(5946, Day8.solve((File("input/day8.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(6026, Day8.solve2((File("input/day8.txt").readLines())))
    }
}