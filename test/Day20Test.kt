import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day20Test {

    @Test
    fun provided(){
        Assert.assertEquals(0, Day20.solve(("p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>\n" +
                "p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0> ").split("\n")))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(1, Day20.solve2(("p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>\n" +
                "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>\n" +
                "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0> \n" +
                "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>").split("\n")))
    }

    @Test
    fun task(){
        Assert.assertEquals(300, Day20.solve((File("input/day20.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(502, Day20.solve2((File("input/day20.txt").readLines())))
    }
}