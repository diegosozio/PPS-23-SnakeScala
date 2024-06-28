private class Snake(_env: Environment) {
  private val _directionRight: (Int, Int) = (1,0)
  private val _directionLeft: (Int, Int) = (-1,0)
  private val _directionDown: (Int, Int) = (0,1)
  private val _directionUp: (Int, Int) = (0,-1)

  private var _isAlive: Boolean = true
  private var _totalEatenFoods: Int = 0
  private var _body: List[(Int, Int)] = List((3, 5), (3, 4), (3, 3))
  private var _direction: (Int, Int) = _directionDown

  /**
   * @return the snake body to draw
   */
  def body: List[(Int, Int)] = _body

  /**
   * @return The last snake direction
   */
  def direction: (Int, Int) = _direction

  /**
   * @return how many foods the snaked ate
   */
  def totalEatenFoods:Int = _totalEatenFoods

  /**
   * Change the snake direction if the new direction is correct
   * @param newDir to set
   */
  private def changeDirection(newDir: (Int, Int)): Unit = {
    if(newDir == _directionUp && _direction != _directionDown
      ||
      newDir == _directionDown && _direction != _directionUp
      ||
      newDir == _directionLeft && _direction != _directionRight
      ||
      newDir == _directionRight && _direction != _directionLeft) {
      _direction = newDir
    }
  }

  /**
   * Set teh snake direction to up
   */
  def goUp(): Unit = changeDirection(_directionUp)

  /**
   * Set teh snake direction to down
   */
  def goDown(): Unit  = changeDirection(_directionDown)

  /**
   * Set teh snake direction to left
   */
  def goLeft(): Unit  = changeDirection(_directionLeft)

  /**
   * Set teh snake direction to right
   */
  def goRight(): Unit  = changeDirection(_directionRight)

  /**
   * Let progress the snake modifying the body
   * @return true if the snake is alive after the progressing
   */
  def move(): Boolean = {
    if (_isAlive) {

      // Calculate new head position with direction
      val newHead = (
        _body.head._1 + direction._1,
        _body.head._2 + direction._2
      )

      if (_env.tryEatFood(newHead)) {
        // Add the head but doesn't remove the tail cause it ate
        _body = newHead +: _body
        _totalEatenFoods = _totalEatenFoods + 1
      } else {
        // Add the head and remove the tail
        _body = newHead +: _body.init
      }

      if (_body.distinct.length != _body.length || // hit body
        (newHead._1 == _env.rows || newHead._2 == _env.columns || newHead._1 == -1 || newHead._2 == -1)) { // hit wall
        _isAlive = false
      }
    }
    _isAlive
  }
}
