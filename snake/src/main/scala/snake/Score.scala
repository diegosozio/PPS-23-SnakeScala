package snake

import java.io.{File, PrintWriter}
import scala.io.Source

class Score {
  private val _scoreFilename: String = "maxScore.txt"
  private var _score: Int = 0
  private var _maxScore: Int = 0

  loadMaxScore()

  /**
   * @return the score reached from the player in this play
   */
  def score: Int = _score

  /**
   * @return the max score reached from the player
   */
  def maxScore: Int = _maxScore

  /**
   * Reset the play score
   */
  def resetScore(): Unit = _score = 0

  /**
   * Load the max score from the file where it is stored
   */
  private def loadMaxScore(): Unit = {
    try {
      val source = Source.fromFile(_scoreFilename)
      _maxScore = source.getLines().next().toInt
      source.close()
    } catch {
      case _: Exception => _maxScore = 0 // Default to 0 if file doesn't exist or there's an error
    }
  }

  /**
   * Save the max score into the file
   * @param value to save
   */
  private def saveMaxScore(value: Int): Unit = {
    val writer = new PrintWriter(_scoreFilename)
    writer.println(value)
    writer.close()
  }

  /**
   * Increase the play score
   * @param unit how much increase the score
   */
  def Inc(unit: Int): Unit = {
    _score += unit
  }

  /**
   * Update the max score when the score is greater then previous max score
   */
  def updateMaxScore(): Unit = {
    if (score > maxScore) {
      _maxScore = _score
      saveMaxScore(_maxScore)
    }
  }

  /**
   * Delete the file where the score is stored
   */
  def deleteMaxScore(): Unit = {
    val file = new File(_scoreFilename)
    if (file.exists()) {
      file.delete()
    }
  }
}
