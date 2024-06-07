package snake

import org.scalatest.funspec.AnyFunSpec

class SnakeSuite extends AnyFunSpec {
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
        snake.goRight()
        moveDone = snake.move()
        snake.goUp()
        moveDone = snake.move()
        snake.goLeft()
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
        snake.goLeft()

        while (moveDone && i < env.rows && i < env.columns) {
          moveDone = snake.move()
          i = i + 1
        }
        assert(!moveDone)
      }

      it("should die if it hit the left wall") {
        var moveDone: Boolean = true
        var i = 0
        snake.goRight()

        while (moveDone && i < env.rows && i < env.columns) {
          moveDone = snake.move()
          i = i + 1
        }
        assert(!moveDone)
      }

      it("should die if it hit the back wall") {
        var moveDone: Boolean = true
        var i = 0
        snake.goRight()
        moveDone = snake.move()
        snake.goUp()

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
        //setup the snakes
        snake.goDown()
        snake.move()

        val snake2 = new Snake(env)
        snake2.goDown()
        snake2.move()

        // change direction to the first snake
        snake.goLeft()
        snake.move()

        // don't change direction to the second one
        snake2.move()

        assert(snake2.body.head != snake.body.head)
      }

      it("should not change direction if new direction is the opposite"){
        snake = new Snake(env)
        // TEST from DOWN to UP

        //setup the snakes
        snake.goDown()
        snake.move()

        val snake2 = new Snake(env)
        snake2.goDown()
        snake2.move()

        // change direction to the first snake
        snake.goUp()
        snake.move()

        // don't change direction to the second one
        snake2.move()

        assert(snake2.body.head == snake.body.head)

        // TEST from LEFT to RIGHT

        //setup the snakes
        snake.goLeft()
        snake.move()

        snake2.goLeft()
        snake2.move()

        // change direction to the first snake
        snake.goRight()
        snake.move()

        // don't change direction to the second one
        snake2.move()

        assert(snake2.body.head == snake.body.head)
      }
    }
  }
}
