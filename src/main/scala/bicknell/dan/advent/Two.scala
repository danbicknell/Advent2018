package bicknell.dan.advent

import scala.collection.immutable.NumericRange
import scala.collection.mutable.ArrayBuffer

class Two {

  val BoxIds = readBoxIdFile
  val Letters: NumericRange.Inclusive[Char] = 'a' to 'z'

  println("Two initialized - there are " + BoxIds.length + " Box IDs")


  def calculateChecksum: Int = {
    var doubleLetters = 0
    var trippleLetters = 0

    for (box <- BoxIds) {
      doubleLetters += checkForDoubles(box)
      trippleLetters += checkForTriples(box)
    }

    (doubleLetters * trippleLetters)
  }

  def detectSimilarBoxes: String = {
    val testOne = "abcde"
    val testTwo = "abcdf"
    var matchNumber = 0

    for (box1 <- BoxIds) {
      for (box2 <- BoxIds) {

        matchNumber = computeStringCharacterMatches(box1, box2)
        if (matchNumber == 1) return box2 intersect box1

      }

    }


    println("The number of non-matching characters is: " + matchNumber)

    "No matches found"

  }


  def readBoxIdFile: ArrayBuffer[String] = {
    import scala.io.Source
    val result = ArrayBuffer[String]()
    println("opening file")
    val filename = "C:\\TempWork\\Advent\\Advent2.txt"
    for (line <- Source.fromFile(filename).getLines) {
      result += line
    }

    result

  }

  def checkForDoubles(box: String): Int = {

    for (letter <- Letters) {
      val count = box.count(_ == letter)
      if (count == 2) return 1
    }

    0
  }

  def checkForTriples(box: String): Int = {
    for (letter <- Letters) {
      val count = box.count(_ == letter)
      if (count == 3) return 1
    }
    0
  }

  def computeStringCharacterMatches(str1: String, str2: String): Int = {
    if (str1.length != str2.length)
      throw new IllegalArgumentException("Strings have different length")

    println(" String 1: " + str1 + " String2: " + str2 + " equals: " + (0 to str1.length - 1).filter(i => str1(i) != str2(i)).size )
    (0 to str1.length - 1).filter(i => str1(i) != str2(i)).size
  }

}
