package bicknell.dan.advent

import scala.collection.mutable.ArrayBuffer

class One {

  var foundDuplicate = false
  var duplicate = -100000
  var currentFrequency = 0

  def sumSequence: Int = {

    var result : Int = 0

    import scala.io.Source
  println("opening file")
    val filename = "C:\\TempWork\\Advent\\Advent1.txt"
    for (line <- Source.fromFile(filename).getLines) {

      if(line != null && !line.isEmpty()) result += (line.replace("+","")).toInt

    }

  result

  }


  def repeatingFrequency : Int = {
    val frequencyList = readFrequencyFile

    val calculatedFrequencies = ArrayBuffer[Int]()

    val

    while (!foundDuplicate){
      checkDups()
    }



     -100000
  }

def readFrequencyFile : Array[Int] = {
  import scala.io.Source
  val frequencies = ArrayBuffer[Int]()
  println("opening file")
  val filename = "C:\\TempWork\\Advent\\Advent1.txt"
  for (line <- Source.fromFile(filename).getLines) {
    if(line != null && !line.isEmpty()) frequencies += (line.replace("+","")).toInt
  }
  frequencies
}

def checkDups(frequencies : Array[Int], foundFrequencies : ArrayBuffer[Int]) : ArrayBuffer[Int] = {
 var result = currentFrequency



  for(frequency <- frequencies) {
    if (frequencies contains frequency) {
      foundDuplicate = true
      duplicate = frequency
      return foundFrequencies
    }
    foundFrequencies += frequency
  }

  currentFrequency =
  foundFrequencies
  }


}
