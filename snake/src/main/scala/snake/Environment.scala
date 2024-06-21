package snake

class Environment(_rows: Int, _columns: Int) {
  private val scorePerFoodUnit: Int = 10
  private var _food: Option[(Int, Int)] = None
  private val _rand = new scala.util.Random
  private val _snake = new Snake(this)
  private val _score: Score = new Score()

  def rows: Int = _rows
  def columns: Int = _columns
  def placedFood: Option[(Int, Int)] = _food
  def score: Int = _score.score
  def maxScore: Int = _score.maxScore
  def totalEatenFoods: Int = _snake.totalEatenFoods
  def snakeBody: List[(Int, Int)] = _snake.body

  def addFood(): Unit = {
    val place = (_rand.nextInt(Integer.MAX_VALUE) % rows, _rand.nextInt(Integer.MAX_VALUE) % columns)
    addFood(place)
  }

  def addFood(place: (Int, Int)): Unit = {
    if (_food.isEmpty) {
      _food = Some(place)
    }
  }

  def tryEatFood(place: (Int, Int)): Boolean = {
    var eaten: Boolean = false
    if (_food.isDefined && place == _food.get) {
      _food = None
      _score.Inc(scorePerFoodUnit)
      eaten = true
    }
    eaten
  }

  /**
   * Move the snake
   * @return true if the snake moved (it's alive), false otherwise
   */
  def moveSnake(): Boolean = {
    val isAlive = _snake.move()
    if(!isAlive){
      _score.updateMaxScore()
    }
    isAlive
  }

  def moveSnakeUp(): Unit = _snake.goUp()

  def moveSnakeDown(): Unit = _snake.goDown()

  def moveSnakeLeft(): Unit = _snake.goLeft()

  def moveSnakeRight(): Unit = _snake.goRight()
}