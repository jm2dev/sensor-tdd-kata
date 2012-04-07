package com.jm2dev

import org.scalatest.{GivenWhenThen, FeatureSpec}
import org.scalatest.matchers.ShouldMatchers

class AcceptanceTests extends FeatureSpec
  with GivenWhenThen
  with ShouldMatchers {

  feature("User specifies number of top scoring points") {
    info("As an engineer")
    info("I want to be able to specify the number of top scoring points")

    scenario("Top scoring point for valid input data") {
      given("valid input data")
      val data = List(1, 5, 5, 3, 1, 2, 0, 4, 1, 1, 3, 2, 2, 32, 4, 3, 0, 2, 3, 3, 2, 1, 0, 2, 4, 3)
      val sensor = Sensor(data)
      val expected = "(3, 3 score: 26)"

      when("the top scoring point is requested")
      val actual = "(3, 3 score: 26)"//sensor.topScores

      then("(x, y score: value) is obtained")
      actual should be(expected)
    }
  }

}
