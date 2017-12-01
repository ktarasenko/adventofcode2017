import org.junit.Assert
import org.junit.Test
import java.io.File

class Day1Test {

    @Test
    fun provided(){
        Assert.assertEquals(3, Day1.solve("1122"))
        Assert.assertEquals(4, Day1.solve("1111"))
        Assert.assertEquals(0, Day1.solve("1234"))
        Assert.assertEquals(9, Day1.solve("91212129"))
    }

    @Test
    fun provided2(){
        Assert.assertEquals(6, Day1.solve2("1212"))
        Assert.assertEquals(0, Day1.solve2("1221"))
        Assert.assertEquals(12, Day1.solve2("123123"))
        Assert.assertEquals(4, Day1.solve2("12131415"))
    }


    @Test
    fun task(){
        Assert.assertEquals(1144, Day1.solve((File("input/day1.txt").readText())))
    }

    @Test
    fun task2(){
        Assert.assertEquals(42, Day1.solve2((File("input/day1.txt").readText())))
    }
}