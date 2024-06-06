package snake

import org.scalatest.funspec.AnyFunSpec

class SnakeSuite extends AnyFunSpec {
  val changeDirectionTest: (Int, Int) = (1,0)
  val env: Environment = new Environment(20, 20)
  var snake:Snake = new Snake(env)
  var initialHeadPosition: (Int, Int) = snake.body.head
  var initialTotalBodyLength:Int = snake.body.length
  var initialTotalEatenFood:Int = snake.totalEatenFoods
  var originalDirection: (Int, Int) = snake.direction

  describe("The Snake"){

    describe("at the beginning"){
      it("should be long 3 and fasting"){
        snake = new Snake(env)

        assert(snake.body.length == 3)
        assert(snake.totalEatenFoods == 0)
      }
    }

    describe("when move"){
      it("should change it position"){
        snake.move()
        assert(initialHeadPosition != snake.body.head)
      }

      it("should die if it hit own body"){
        var moveDone: Boolean = false
        var i = 0
        while (i<2){
          val head = snake.body.head
          val food = (head._1, head._2 + 1)
          env.addFood(food)
          moveDone = snake.move()
          i = i + 1
        }
        snake.changeDirection(snake.directionRight)
        moveDone = snake.move()
        snake.changeDirection(snake.directionUp)
        moveDone = snake.move()
        snake.changeDirection(snake.directionLeft)
        moveDone = snake.move()
        assert(!moveDone)
      }

      it("should die if it hit the front wall") {
        var moveDone: Boolean = true
        var i = 0
        while (moveDone && i < env.rows && i < env.columns) {
          moveDone = snake.move()
          i = i + 1
        }
        assert(!moveDone)
      }

      it("should die if it hit the right wall") {
        var moveDone: Boolean = true
        var i = 0
        snake.changeDirection(snake.directionLeft)

        while (moveDone && i < env.rows && i < env.columns) {
          moveDone = snake.move()
          i = i + 1
        }
        assert(!moveDone)
      }

      it("should die if it hit the left wall") {
        var moveDone: Boolean = true
        var i = 0
        snake.changeDirection(snake.directionRight)

        while (moveDone && i < env.rows && i < env.columns) {
          moveDone = snake.move()
          i = i + 1
        }
        assert(!moveDone)
      }

      it("should die if it hit the back wall") {
        var moveDone: Boolean = true
        var i = 0
        snake.changeDirection(snake.directionRight)
        moveDone = snake.move()
        snake.changeDirection(snake.directionUp)

        while (moveDone && i < env.rows && i < env.columns) {
          moveDone = snake.move()
          i = i + 1
        }
        assert(!moveDone)
      }
    }

    describe("when eat") {
      it("should increase by 1 unit the body and the total food counter") {
        snake = new Snake(env)
        val foodPlace = (3, 6)
        env.addFood(foodPlace)
        snake.move()

        assert(initialTotalBodyLength + 1 == snake.body.length)
        assert(initialTotalEatenFood + 1 == snake.totalEatenFoods)
      }
    }

    describe("when it is requested to change direction"){
      it("should change direction"){
        snake.changeDirection(changeDirectionTest)

        assert(snake.direction == changeDirectionTest)
      }
    }
  }
}
