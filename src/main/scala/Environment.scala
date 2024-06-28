/**
 * This class acts as controller, containing the snake, the food and the score logic.
 * @param _rows count of rows
 * @param _columns count of columns
 */
class Environment(_rows: Int, _columns: Int) {
  private val scorePerFoodUnit: Int = 10
  private var _food: Option[(Int, Int)] = None
  private val _rand = new scala.util.Random
  private val _snake = new Snake(this)
  private val _score: Score = new Score()

  /**
   * @return count of rows
   */
  def rows: Int = _rows

  /**
   * @return count of columns
   */
  def columns: Int = _columns

  /**
   * @return the food in the environment, if exists
   */
  def placedFood: Option[(Int, Int)] = _food

  /**
   * @return the score reached from the player in this play
   */
  def score: Int = _score.score

  /**
   * @return the max score reached from the player
   */
  def maxScore: Int = _score.maxScore

  /**
   * @return how many foods the snaked ate
   */
  def totalEatenFoods: Int = _snake.totalEatenFoods

  /**
   * @return the snake body to be draw
   */
  def snakeBody: List[(Int, Int)] = _snake.body

  /**
   * Add one food to the environment in a random place
   */
  def addFood(): Unit = {
    val place = (_rand.nextInt(Integer.MAX_VALUE) % rows, _rand.nextInt(Integer.MAX_VALUE) % columns)
    addFood(place)
  }

  /**
   * Add one food to the environment in a fixed place
   */
  def addFood(place: (Int, Int)): Unit = {
    if (_food.isEmpty) {
      _food = Some(place)
    }
  }

  /**
   * Check if the place contains food and if true remove the food and increase the score
   * @param place to test if containing food
   * @return true if the place contained food
   */
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

  /**
   * Move up the snake
   */
  def moveSnakeUp(): Unit = _snake.goUp()

  /**
   * Move down the snake
   */
  def moveSnakeDown(): Unit = _snake.goDown()

  /**
   * Move left the snake
   */
  def moveSnakeLeft(): Unit = _snake.goLeft()

  /**
   * Move right the snake
   */
  def moveSnakeRight(): Unit = _snake.goRight()
}