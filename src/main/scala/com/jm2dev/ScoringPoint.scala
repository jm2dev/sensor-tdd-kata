package com.jm2dev

class ScoringPoint(x: Int = 0, y: Int = 0, score: Int = 0)
{
  override def toString = "(%s, %s score: %s)".format(x, y, score)
}
