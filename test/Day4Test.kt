import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.File

class Day4Test {

    @Test
    fun provided(){
        Assert.assertEquals(2, Day4.solve(("aa bb cc dd ee\n" +
                "aa bb cc dd aa\n" +
                "aa bb cc dd aaa").split("\n")))
    }

    @Test
    fun provided2(){
        Assert.assertTrue(Day4.isValid2("abcde fghij"))
        Assert.assertFalse(Day4.isValid2("abcde xyz ecdab"))
        Assert.assertTrue(Day4.isValid2("a ab abc abd abf abj"))
        Assert.assertTrue(Day4.isValid2("iiii oiii ooii oooi oooo"))
        Assert.assertFalse(Day4.isValid2("oiii ioii iioi iiio"))
    }

    @Test
    fun task(){
        Assert.assertEquals(451, Day4.solve((File("input/day4.txt").readLines())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(223, Day4.solve2((File("input/day4.txt").readLines())))
    }
}