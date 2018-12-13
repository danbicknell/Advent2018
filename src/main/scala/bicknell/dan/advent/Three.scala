package bicknell.dan.advent

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Three {

  val Values = readDataFile
  val fabricOverlapCount = Array.ofDim[Int](2000, 2000)

  def readDataFile: mutable.Map[String, (String, String)] = {
    import scala.io.Source

    var mapedResult = mutable.Map[String, (String, String)]()
    println("opening file")
    val filename = "C:\\TempWork\\Advent\\Advent3.txt"
    for (line <- Source.fromFile(filename).getLines) {
      val splitLine: Array[String] = line.split("@")
      val key = splitLine(0).trim
      val splitCoordinates = splitLine(1).split(":")
      // println("Adding Key: " + key + " with values: ('" + splitCoordinates(0).trim + "','" + splitCoordinates(1).trim + "')")
      mapedResult(key) = (splitCoordinates(0).trim, splitCoordinates(1).trim)
    }

    mapedResult

  }

  def findValidClaim: String = {
    var result = ""
    var valid = false

    for ((k, v) <- Values) {

      val beginningCoordinates = v._1.split(",")
      val cutDimensions = v._2.split("x")

      val StartX = beginningCoordinates(0).toInt + 1
      val StartY = beginningCoordinates(1).toInt + 1
      val Width = cutDimensions(0).toInt - 1
      val Height = cutDimensions(1).toInt - 1

      valid = true

      for (a <- StartX to (StartX + Width)) {

        for (b <- StartY to (StartY + Height)) {
          if (fabricOverlapCount(a)(b) > 1) {
            valid = false
            print(fabricOverlapCount(a)(b))
          }
          println()
        }


      }
      if (valid) return k

    }
    result
  }


  def findOverlappingFabric: Int = {
    var result = 0
    var cellCount = 0


    for ((k, v) <- Values) {

      val beginningCoordinates = v._1.split(",")
      val cutDimensions = v._2.split("x")

      val StartX = beginningCoordinates(0).toInt + 1
      val StartY = beginningCoordinates(1).toInt + 1
      val Width = cutDimensions(0).toInt - 1
      val Height = cutDimensions(1).toInt - 1

      // println("Starting and dimensions:" + StartX + ", " + StartY +  ", "  + Width +  ", "  + Height)

      for (a <- StartX to (StartX + Width); b <- StartY to (StartY + Height)) {
        fabricOverlapCount(a)(b) += 1
        // println("Fabric Overlap count: " + a +  ", " + b +  ", " +  fabricOverlapCount(a)(b))
      }

    }

    for (c <- 0 to 1999) {
      for (d <- 0 to 1999) {

        if (fabricOverlapCount(c)(d) > 1) {
          result += 1
          // println("Fabric Overlap result: " + a + ", " + b + " = " + fabricOverlapCount(a)(b) + " - result tally: " + result)
          cellCount += 1
          // println("Coordinates: " + c + ", " + d)
        }
      }
    }

    println("Result: " + result + "   Cell Count: " + cellCount)
    result
  }

}
