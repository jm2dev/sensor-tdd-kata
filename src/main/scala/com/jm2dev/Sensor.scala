package com.jm2dev

case class Sensor(rawdata: List[Int])
{
  def gridSize = rawdata.tail.head

  def numberOfResults = rawdata.head

  def dataAt(x: Int, y: Int): Int = {
    if ( x >= 0 && y >= 0 && x < gridSize & y < gridSize )
      raw( transform(x, y) )
    else
      0
  }

  def scoreAt(x: Int, y: Int): Int = {
    dataAt(x - 1, y - 1) +
      dataAt(x - 1, y)     +
      dataAt(x - 1, y + 1) +
      dataAt(x, y - 1)     +
      dataAt(x, y)         +
      dataAt(x, y + 1)     +
      dataAt(x + 1, y - 1) +
      dataAt(x + 1, y)     +
      dataAt(x + 1, y + 1)
  }

  def scoringPoints: List[Int] = {
    (0 to gridSize - 1).map( (i: Int) =>
      (0 to gridSize -1).map(
        (j: Int) => scoreAt(j, i)
      ).toList
    ).toList.flatten
  }

  def uniqueScoringPoints: List[Int] = scoringPoints.toSet.toList.sorted.reverse

  def results: String = {
    (1 to numberOfResults).map( (i:Int) =>
      {
        extractScore(uniqueScoringPoints.drop(i - 1))
      }
    ).toSet.mkString("")
  }

  private def extractScore(lista: List[Int]): String = {
    val score = lista.head
    val candidate = scoringPoints.indexOf(score)
    val coordinates = antitransform(candidate)
    "(%s, %s score: %s)".format(coordinates._1, coordinates._2, score)

  }

  private val raw = rawdata.tail.tail

  private def transform(x: Int, y: Int): Int = {
    x * gridSize + y
  }

  private def antitransform(i: Int): (Int, Int) = {
    (i / gridSize, i % gridSize)
  }
}