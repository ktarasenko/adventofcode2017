import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day25Test {

    @Test
    fun provided(){
        Assert.assertEquals(3, Day25.solve(6, ("A|1 1 B|0 -1 B\n" +
                "B|1 -1 A|1 1 A").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals(3362, Day25.solve(12481997, (File("input/day25_mod.txt").readLines())))
    }

}