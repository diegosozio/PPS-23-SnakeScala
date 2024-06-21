package snake

import java.io.PrintWriter
import scala.io.Source

class Score {
  private val _scoreFilename: String = "maxScore.txt"
  private var _score: Int = 0
  private var _maxScore: Int = 0
  loadMaxScore()

  def score: Int = _score
  def maxScore: Int = _maxScore
  def resetScore(): Unit = _score = 0

  private def loadMaxScore(): Unit = {
    try {
      val source = Source.fromFile(_scoreFilename)
      _maxScore = source.getLines().next().toInt
      source.close()
    } catch {
      case _: Exception => _maxScore = 0 // Default to 0 if file doesn't exist or there's an error
    }
  }

  private def saveMaxScore(): Unit = {
    val writer = new PrintWriter(_scoreFilename)
    writer.println(_maxScore)
    writer.close()
  }

  def Inc(unit: Int): Unit = {
    _score += unit
  }

  def updateMaxScore(): Unit = {
    if (score > maxScore) {
      _maxScore = _score
      saveMaxScore()
    }
  }
}
