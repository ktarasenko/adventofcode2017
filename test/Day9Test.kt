import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day9Test {

    @Test
    fun provided(){
        Assert.assertEquals(1, Day9.solve("{}"))
        Assert.assertEquals(6, Day9.solve("{{{}}}"))
        Assert.assertEquals(5, Day9.solve("{{},{}}"))
        Assert.assertEquals(16, Day9.solve("{{{},{},{{}}}}"))
        Assert.assertEquals(1, Day9.solve("{<a>,<a>,<a>,<a>}"))
        Assert.assertEquals(9, Day9.solve("{{<ab>},{<ab>},{<ab>},{<ab>}}"))
        Assert.assertEquals(9, Day9.solve("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
        Assert.assertEquals(1, Day9.solve("{<{<<}<<{{}}}}<a>}"))
        Assert.assertEquals(3, Day9.solve("{{<a!>},{<a!>},{<a!>},{<ab>}}"))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(0, Day9.solve2("<>"))
        Assert.assertEquals(17, Day9.solve2("<random characters>"))
        Assert.assertEquals(3, Day9.solve2("<<<<>"))
        Assert.assertEquals(2, Day9.solve2("<{!>}>"))
        Assert.assertEquals(0, Day9.solve2("<!!>"))
        Assert.assertEquals(0, Day9.solve2("<!!!>>"))
        Assert.assertEquals(10, Day9.solve2("<{o\"i!a,<{i<a>"))
    }


    @Test
    fun task(){
        Assert.assertEquals(16827, Day9.solve((File("input/day9.txt").readText())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(7298, Day9.solve2((File("input/day9.txt").readText())))
    }
}