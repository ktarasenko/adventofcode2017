import org.junit.Assert
import org.junit.Test
import java.io.File

class Day16Test {

    @Test
    fun provided(){
        Assert.assertEquals("baedc", Day16.solve(('a'..'e').joinToString(""), ("s1,x3/4,pe/b").split(",")))
    }


    @Test
    fun provided2(){
        Assert.assertEquals("ceadb",
                Day16.solve2(('a'..'e').joinToString(""), 2,
                        ("s1,x3/4,pe/b").split(",")))
    }




    @Test
    fun task(){
        Assert.assertEquals("glnacbhedpfjkiom",
                Day16.solve(('a'..'p').joinToString(""),
                        (File("input/day16.txt").readText().split(","))))
    }


    @Test
    fun task2(){
        Assert.assertEquals("fmpanloehgkdcbji", Day16.solve2(('a'..'p').joinToString(separator = ""),
                1000 * 1000 * 1000,  (File("input/day16.txt").readText().split(","))))


    }
}