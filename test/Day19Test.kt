import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day19Test {

    @Test
    fun provided(){
        Assert.assertEquals("ABCDEF", Day19.solve(("     |          \n" +
                "     |  +--+    \n" +
                "     A  |  C    \n" +
                " F---|----E|--+ \n" +
                "     |  |  |  D \n" +
                "     +B-+  +--+").split("\n")))
    }



    @Test
    fun task(){
        Assert.assertEquals("PVBSCMEQHY", Day19.solve((File("input/day19.txt").readLines())))
    }

}