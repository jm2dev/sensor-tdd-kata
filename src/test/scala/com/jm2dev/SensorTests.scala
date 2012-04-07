package com.jm2dev

import org.scalatest.{GivenWhenThen, Spec}
import org.scalatest.matchers.ShouldMatchers

class SensorTests extends Spec
  with GivenWhenThen
  with ShouldMatchers
{
  private val sensorData = List(4, 2, 3, 2, 2, 1, 3, 2, 1)
  private val numberOfRequestedResults = 1
  private val sizeOfGrid = 3
  private val data = List(numberOfRequestedResults, sizeOfGrid) ::: sensorData

  describe("A solar temperature sensor")
  {
    it("should provide grid size")
    {
      given("a working solar sensor with temperature data")
      val sensor = Sensor(data)

      when("when grid size data is retrieved")
      val gridSize = sensor.gridSize

      then("the second number stands for grid size")
      gridSize should be(sizeOfGrid)
    }

    it("should provide actual data by grid position")
    {
      given("a working solar sensor with temperature data")
      val sensor = Sensor(data)

      when("raw data point is retrieved by its grid coordinates")
      val rawData = List(sensor.dataAt(0, 0),
        sensor.dataAt(0, 1),
        sensor.dataAt(0, 2),
        sensor.dataAt(1, 0),
        sensor.dataAt(1, 1),
        sensor.dataAt(1, 2),
        sensor.dataAt(2, 0),
        sensor.dataAt(2, 1),
        sensor.dataAt(2, 2)
      )

      then("right value inside the list is obtained")
      rawData should be(sensorData)
    }

    it("should provide score for given coordinate and existing neighbours")
    {
      given("a working solar sensor with temperature data")
      val sensor = Sensor(data)
      val expected = 20

      when("score data is retrieved for given coordinates")
      val score = sensor.scoreAt(1, 1)

      then("score is calculated based on position for given coordinates and neighbours")
      score should be(expected)
    }

    it("should provide score for given coordinate and non existing neighbours")
    {
      given("a working solar sensor with temperature data")
      val sensor = Sensor(data)
      val expected = 10

      when("score data is retrieved for given coordinates")
      val score = sensor.scoreAt(0, 0)

      then("score is calculated based on position for given coordinates and neighbours")
      score should be(expected)
    }

    it("should return all scoring points")
    {
      given("a working sensor with temperature data")
      val sensor = Sensor(data)

      when("I want to know all scoring points")
      val actuals = sensor.scoringPoints

      then("I get the following list")
      val expected = List(10, 15, 9, 14, 20, 11, 8, 11, 6)
      actuals should be(expected)
    }

    it("should return distinct scoring points")
    {
      given("a working sensor with temperature data")
      val sensor = Sensor(data)

      when("I want to know scoring points")
      val actuals = sensor.uniqueScoringPoints

      then("I get the following values")
      val expected = List(20, 15, 14, 11, 10, 9, 8, 6)
      actuals should be(expected)
    }

    it("should return specified results")
    {
      given("a working sensor with temperature data")
      val sensor = Sensor(data)

      when("I want to know scoring points")
      val actuals = sensor.results

      then("I get the following values")
      val expected = "(1, 1 score: 20)"
      actuals should be(expected)
    }

    it("should return specified results for data set 1")
    {
      given("a working sensor with temperature data")
      val data = List(1, 5, 5, 3, 1, 2, 0, 4, 1, 1, 3, 2, 2, 3, 2, 4, 3, 0, 2, 3, 3, 2, 1, 0, 2, 4, 3)
      val sensor = Sensor(data)

      when("I want to know especified results")
      val actuals = sensor.results

      then("I get the following values")
      val expected = "(3, 3 score: 26)"
      actuals should be(expected)
    }

    it("should return specified results for data set 2")
    {
      given("a working sensor with temperature data")
      val data = List(3, 4, 2, 3, 2, 1, 4, 4, 2, 0, 3, 4, 1, 1, 2, 3, 4, 4)
      val sensor = Sensor(data)

      when("I want to know especified results")
      val actuals = sensor.results

      then("I get the following values")
      val expected = "(1, 2 score: 27)(1, 1 score: 25)(2, 2 score: 23)"
      actuals should be(expected)
    }
  }
}

