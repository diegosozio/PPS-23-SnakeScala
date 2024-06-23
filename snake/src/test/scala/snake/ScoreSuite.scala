package snake

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.BeforeAndAfter
import java.io.File

class ScoreSuite extends AnyFunSpec with BeforeAndAfter {

  val scoreFileName = "maxScore.txt"

  before {
    // Ensure the score file does not exist before each test
    val file = new File(scoreFileName)
    if (file.exists()) {
      file.delete()
    }
  }

  describe("Score") {
    it("should start with a score of 0") {
      val score = new Score()
      assert(score.score == 0)
    }

    it("should start with a max score of 0 if no file exists") {
      val score = new Score()
      assert(score.maxScore == 0)
    }

    it("should increment the score correctly") {
      val score = new Score()
      score.Inc(10)
      assert(score.score == 10)
    }

    it("should reset the score correctly") {
      val score = new Score()
      score.Inc(10)
      score.resetScore()
      assert(score.score == 0)
    }

    it("should update the max score correctly if the new score is higher") {
      val score = new Score()
      score.Inc(10)
      score.updateMaxScore()
      assert(score.maxScore == 10)
    }

    it("should not update the max score if the new score is not higher") {
      val score = new Score()
      score.Inc(5)
      score.updateMaxScore()
      assert(score.maxScore == 5)

      score.resetScore()
      score.Inc(3)
      score.updateMaxScore()
      assert(score.maxScore == 5)
    }

    it("should load the max score from the file if it exists") {
      val score = new Score()
      score.Inc(20)
      score.updateMaxScore()

      val newScore = new Score()
      assert(newScore.maxScore == 20)
    }

    it("should save the max score to the file correctly") {
      val score = new Score()
      score.Inc(15)
      score.updateMaxScore()

      val file = new File(scoreFileName)
      assert(file.exists())

      val source = scala.io.Source.fromFile(scoreFileName)
      val maxScoreFromFile = source.getLines().next().toInt
      source.close()

      assert(maxScoreFromFile == 15)
    }
  }

  after {
    // Clean up: Delete the score file after each test
    val file = new File(scoreFileName)
    if (file.exists()) {
      file.delete()
    }
  }
}
