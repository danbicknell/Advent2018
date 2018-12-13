package bicknell.dan.advent

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Four {

  val timeLog = readDataFile
  val gaurdTally = new mutable.Map[String,  Array[Int](60)]




  def readDataFile:  ArrayBuffer[String]  = {
    import scala.io.Source

    var results = ArrayBuffer[String]()


    println("opening file")
    val filename = "C:\\TempWork\\Advent\\Advent4.txt"
    for (line <- Source.fromFile(filename).getLines) {
      results += line
    }


    for (result <- results.sorted) {
      println(result)
      processLine(result)
    }

    results

  }


  def processLine(line: String) = {
    val dateMatchRegex = "(\\d{4})-(\\d{2})-(\\d{2})".r
    val match1 = dateMatchRegex.findFirstIn(line)
    val currentGuard = ""


    val guardMatchRegex = "(#\\d*)".r
    val guardMatch = guardMatchRegex.findFirstIn(line)

    match1 match {
      case Some(s) => println(s"Date: $s")
      case None =>
    }

    guardMatch match {
      case Some(s) => println(s"Guard: $s")
      case None =>
    }







  }

}
