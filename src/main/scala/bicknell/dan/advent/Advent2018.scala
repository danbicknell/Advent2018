package bicknell.dan.advent

object Advent2018 extends App {


  override def main(args: Array[String]): Unit = {
    println("Hello Advent")
    /*
    val one = new One
    val result = one.sumSequence
    println("The answer to Puzzle 1-A is: " + result)
    val result2 = one.repeatingFrequency
    println("The answer to Puzzle 1-B is: " + result2)
*/
    val two = new Two
    //val result2a = two.calculateChecksum
    //println("The answer to Puzzle 2-A is: " + result2a)

    val result2b = two.detectSimilarBoxes
    println("The answer to Puzzle 2-B is: " + result2b)


  }

}
