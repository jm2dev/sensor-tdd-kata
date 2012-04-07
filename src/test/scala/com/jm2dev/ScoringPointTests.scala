package com.jm2dev

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{Spec, GivenWhenThen}

class ScoringPointTests extends Spec
  with GivenWhenThen
  with ShouldMatchers
{
  describe("Scoring Point")
  {
    it("should sort scoring points by higher score values")
    {
      given("two scoring points with different scores")
      val greater = new ScoringPoint(0, 0, 1)
      val smaller = new ScoringPoint(1, 1, 0)

      when("I sort them")
      val isGreaterBiggerThanSmaller = false //greater > smaller

      then("Score point with highest score comes first")
      isGreaterBiggerThanSmaller should be(true)
    }

    it("should format output as (x, y score: score")
    {
      given("a valid scoring point")
      val point = new ScoringPoint

      when("I print its value")

      then("I see (x, y score: score)")
      point.toString should include("(0, 0 score: 0)")
    }
  }

}