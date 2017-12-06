import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class DayNTest{

    @Test
    fun provided(){
        Assert.assertEquals(42, DayN.solve(("a\nb").split("\n")))
    }

    @Test
    @Ignore
    fun provided2(){
        Assert.assertEquals(42, DayN.solve2(("a\nb").split("\n")))
    }

    @Test
    @Ignore
    fun test(){
        Assert.assertEquals(42, DayN.solve(("a\nb").split("\n")))
    }

    @Test
    @Ignore
    fun task(){
        Assert.assertEquals(42, DayN.solve((File("input/dayN.txt").readLines())))
    }

    @Test
    @Ignore
    fun task2(){
        Assert.assertEquals(42, DayN.solve2((File("input/dayN.txt").readLines())))
    }
}