package bicknell.dan.advent

import scala.collection.mutable.ArrayBuffer

class One {

  var foundDuplicate = false
  var duplicate = -100000
  var currentFrequency = 0
  val foundFrequencies = ArrayBuffer[Int]()
  var loopCount = 0

  def sumSequence: Int = {

    var result: Int = 0

    import scala.io.Source
    println("opening file")
    val filename = "C:\\TempWork\\Advent\\Advent1.txt"
    for (line <- Source.fromFile(filename).getLines) {

      if (line != null && !line.isEmpty()) result += (line.replace("+", "")).toInt

    }

    result

  }


  def repeatingFrequency: Int = {
    val frequencyList = readFrequencyFile


    while (!foundDuplicate) {
      foundDuplicate = checkDups(frequencyList)
    }

    for ( x <- foundFrequencies ) {
      println( x )
    }

    duplicate
  }

  def readFrequencyFile: ArrayBuffer[Int] = {
    import scala.io.Source
    val frequencies = ArrayBuffer[Int]()
    println("opening file")
    val filename = "C:\\TempWork\\Advent\\Advent1.txt"
    for (line <- Source.fromFile(filename).getLines) {
      if (line != null && !line.isEmpty()) frequencies += (line.replace("+", "")).toInt
    }

    frequencies
  }

  def checkDups(frequencies: ArrayBuffer[Int]): Boolean = {
    var result = currentFrequency


    for (frequencyAdjustment <- frequencies) {
      currentFrequency += frequencyAdjustment
      if (foundFrequencies contains currentFrequency) {
        foundDuplicate = true
        duplicate = currentFrequency
        return true
      }
      foundFrequencies += currentFrequency
    }

    false

  }


}
