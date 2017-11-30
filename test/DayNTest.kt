import org.junit.Assert
import org.junit.Test
import java.io.File

class DayNTest{

    @Test
    fun provided(){
        Assert.assertEquals(42, DayN.solve(("a\nb").split("\n")))
    }

    @Test
    fun test(){
        Assert.assertEquals(42, DayN.solve(("a\nb").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals(42, DayN.solve((File("input/dayN.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(42, DayN.solve((File("input/dayN.txt").readLines())))
    }
}