import org.junit.Assert
import org.junit.Test
import java.io.File

class Day7Test {

    @Test
    fun provided(){
        Assert.assertEquals(42, Day7.solve(("a\nb").split("\n")))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(42, Day7.solve(("a\nb").split("\n")))
    }

    @Test
    fun test(){
        Assert.assertEquals(42, Day7.solve(("a\nb").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals(42, Day7.solve((File("input/day7.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(42, Day7.solve((File("input/day7.txt").readLines())))
    }
}