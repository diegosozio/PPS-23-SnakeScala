package snake

import org.scalatest.funspec.AnyFunSpec

class EnvironmentSuite extends AnyFunSpec  {
  var env:Environment = _

  describe("An Environment"){
    describe("when empty"){
      it("should has not any food"){
        env = new Environment(20, 20)
        assert(env.getPlacedFood.isEmpty)
      }
    }

    describe("when add food"){
      it("should place food"){
        env = new Environment(20, 20)
        env.addFood()
        assert(env.getPlacedFood.isDefined)
      }
    }

    describe("when add an other food") {
      it("should not replace the food") {
        env = new Environment(20, 20)
        env.addFood()
        val prevFood = env.getPlacedFood
        env.addFood()
        assert(env.getPlacedFood == prevFood)
      }
    }

    describe("with some food"){
      describe("when the food is eaten"){
        it("should remove the food"){
          env = new Environment(20, 20)
          env.addFood()
          env.tryEatFood(env.getPlacedFood.get)
          assert(env.getPlacedFood.isEmpty)
        }
      }
    }
  }
}
