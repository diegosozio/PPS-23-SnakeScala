package snake

import org.scalatest.funspec.AnyFunSpec

class EnvironmentSuite extends AnyFunSpec  {
  describe("An Environment"){
    describe("when empty"){
      it("should has not any food"){
        val env = new Environment(20, 20)
        assert(env.placedFood.isEmpty)
      }
    }

    describe("when add food"){
      it("should place food"){
        val env = new Environment(20, 20)
        env.addFood()
        assert(env.placedFood.isDefined)
      }
    }

    describe("when add an other food") {
      it("should not replace the food") {
        val env = new Environment(20, 20)
        env.addFood()
        val prevFood = env.placedFood
        env.addFood()
        assert(env.placedFood == prevFood)
      }
    }

    describe("with some food"){
      describe("when the food is eaten"){
        it("should remove the food"){
          val env = new Environment(20, 20)
          env.addFood()
          env.tryEatFood(env.placedFood.get)
          assert(env.placedFood.isEmpty)
        }
      }
    }

    describe("when asked to move the snake"){
      it("should move the snake"){
        val env = new Environment(20, 20)
        val initialSnakeBody = env.snakeBody
        val isAlive = env.moveSnake()
        assert(isAlive)
        assert(initialSnakeBody != env.snakeBody)
      }

      it("should inc score when the snake eat and save score when the snake die"){
        var score = new Score()
        score.deleteMaxScore()

        val env = new Environment(4, 7)
        val initialSnakeLen = env.snakeBody.length
        var isAlive: Boolean = false
        env.addFood((3,6))
        isAlive = env.moveSnake()
        assert(isAlive)
        assert(initialSnakeLen == env.snakeBody.length - 1)
        isAlive = env.moveSnake()
        assert(!isAlive)

        score = new Score()
        assert(score.maxScore == 10)
      }
    }
  }
}
