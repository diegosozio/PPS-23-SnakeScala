package snake

import org.scalatest.funspec.AnyFunSpec

class EnvironmentSuite extends AnyFunSpec  {
  val env: Environment = new Environment(20, 20)

  describe("An Environment"){

    describe("when empty"){
      it("should has not any food"){
        assert(env.foods.isEmpty)
      }
      it("should has not any snake"){
        assert(env.snake == null)
      }
      it("should has not any food in place"){
        assert(env.totalFoodOnThePlate == 0)
      }
    }

    describe("when game start"){
      env.addSnake()

      it("should has the snake") {
        assert(env.snake != null)
      }
    }

    describe("when add food"){
      env.createFood()

      it("should place 1 food"){
        assert(env.foods.length == 1)
        assert(env.totalFoodOnThePlate == 1)
      }
    }

    describe("when add an other food") {
      env.createFood()

      it("should not place any food") {
        assert(env.foods.length == 1)
        assert(env.totalFoodOnThePlate == 1)
      }
    }
  }
}
