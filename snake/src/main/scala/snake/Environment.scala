package snake

class Environment(_rows: Int, _columns: Int) {
  private val _totalFoodOnThePlate:Int = 0
  private val _maxFoodOnThePlate:Int = 1
  private val _rand = new scala.util.Random
  private val _foods: List[(Int, Int)] = List()
  private val _snake: Snake = null

  def foods: List[(Int, Int)] = _foods
  def rows: Int = _rows
  def columns: Int = _columns
  def snake: Snake = _snake
  def totalFoodOnThePlate: Int = _totalFoodOnThePlate

  def createFood(): Unit = {}
  def isFood(place: (Int, Int)): Boolean = false
  def addSnake(): Unit = {}
}