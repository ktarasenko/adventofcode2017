import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day13Test {

    @Test
    fun provided(){
        Assert.assertEquals(42, Day13.solve(("a\nb").split("\n")))
    }

    @Test
    @Ignore
    fun provided2(){
        Assert.assertEquals(42, Day13.solve2(("a\nb").split("\n")))
    }

    @Test
    @Ignore
    fun test(){
        Assert.assertEquals(42, Day13.solve(("a\nb").split("\n")))
    }

    @Test
    @Ignore
    fun task(){
        Assert.assertEquals(42, Day13.solve((File("input/day13.txt").readLines())))
    }

    @Test
    @Ignore
    fun task2(){
        Assert.assertEquals(42, Day13.solve2((File("input/day13.txt").readLines())))
    }
}