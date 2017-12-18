import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day18Test {

    @Test
    fun provided(){
        Assert.assertEquals(4, Day18.solve(("set a 1\n" +
                "add a 2\n" +
                "mul a a\n" +
                "mod a 5\n" +
                "snd a\n" +
                "set a 0\n" +
                "rcv a\n" +
                "jgz a -1\n" +
                "set a 1\n" +
                "jgz a -2").split("\n")))
    }



    @Test
    fun task(){
        Assert.assertEquals(3188, Day18.solve((File("input/day18.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(7112, Day18.solve2((File("input/day18.txt").readLines())))
    }
}