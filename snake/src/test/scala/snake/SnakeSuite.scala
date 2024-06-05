package snake

import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec

class SnakeSuite extends AnyFunSpec {
  val changeDirectionTest: (Int, Int) = (1,0)
  var snake:Snake = new Snake()
  var initialHeadPosition: (Int, Int) = snake.body.head
  var initialTotalBodyLength:Int = snake.body.length
  var initialTotalEatenFood:Int = snake.totalEatenFoods
  var originalDirection: (Int, Int) = snake.direction

  describe("The Snake"){

    describe("at the beginning"){
      it("should be long 3"){
        assert(snake.body.length == 3)
      }
      it("should be fasting"){
        assert(snake.totalEatenFoods == 0)
      }
    }

    describe("when move"){
      snake.move()

      it("should change it position"){
        assert(initialHeadPosition != snake.body.head)
      }
    }

    describe("when eat") {
      snake.eatFood()

      it("should increase by 1 unit the body") {
        assert(initialTotalBodyLength + 1 == snake.body.length)
      }

      it("should increase by 1 unit the total food eaten"){
        assert(initialTotalEatenFood + 1 == snake.totalEatenFoods)
      }
    }

    describe("when it is requested to change direction"){
      snake.changeDirection(changeDirectionTest)

      it("should change direction"){
        assert(snake.direction == changeDirectionTest)
      }
    }
  }
}
