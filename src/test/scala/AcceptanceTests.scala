package com.jm2dev

import org.scalatest.{GivenWhenThen, FeatureSpec}
import org.scalatest.matchers.ShouldMatchers

class AcceptanceTests extends FeatureSpec
  with GivenWhenThen
  with ShouldMatchers {

  feature("Serialized data is processed to extract desired results") {
    info("As an engineer")
    info("I want to process serialized data from sensor")
    info("and extract as many results as specified by first value")

    scenario("One top scoring point.")
    {
      given("data set 1")
      val data = List(1, 5, 5, 3, 1, 2, 0, 4, 1, 1, 3, 2, 2, 3, 2, 4, 3, 0, 2, 3, 3, 2, 1, 0, 2, 4, 3)
      val sensor = Sensor(data)

      when("I process data")
      val actuals = sensor.results

      then("I get one top scoring point with its cardinal coordinates.")
      val expected = "(3, 3 score: 26)"
      actuals should be(expected)
    }

    scenario("Multiple top scoring points")
    {
      given("data set 2")
      val data = List(3, 4, 2, 3, 2, 1, 4, 4, 2, 0, 3, 4, 1, 1, 2, 3, 4, 4)
      val sensor = Sensor(data)

      when("I process data")
      val actuals = sensor.results

      then("I get three top scoring points with their cardinal coordinates.")
      val expected = "(1, 2 score: 27)(1, 1 score: 25)(2, 2 score: 23)"
      actuals should be(expected)
    }
  }
}
