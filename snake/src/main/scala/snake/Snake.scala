package snake

private class Snake(_env: Environment) {
  private val directionRight: (Int, Int) = (1,0)
  private val directionLeft: (Int, Int) = (-1,0)
  private val directionDown: (Int, Int) = (0,1)
  private val directionUp: (Int, Int) = (0,-1)

  private var _isAlive: Boolean = true
  private var _totalEatenFoods: Int = 0
  private var _body: List[(Int, Int)] = List((3, 5), (3, 4), (3, 3))
  private var _direction: (Int, Int) = directionDown

  def body: List[(Int, Int)] = _body
  def direction: (Int, Int) = _direction
  def totalEatenFoods:Int = _totalEatenFoods

  private def changeDirection(newDir: (Int, Int)): Unit = {
    if(newDir == directionUp && _direction != directionDown
      ||
      newDir == directionDown && _direction != directionUp
      ||
      newDir == directionLeft && _direction != directionRight
      ||
      newDir == directionRight && _direction != directionLeft) {
      _direction = newDir
    }
  }

  def goUp(): Unit = changeDirection(directionUp)

  def goDown(): Unit  = changeDirection(directionDown)

  def goLeft(): Unit  = changeDirection(directionLeft)

  def goRight(): Unit  = changeDirection(directionRight)

  def move(): Boolean = {
    if !_isAlive then return false

    var gameOver: Boolean = false

    // Calcola la nuova testa in base alla direzione corrente
    val newHead = (
      (_body.head._1 + direction._1),
      (_body.head._2 + direction._2)
    )

    if (_env.tryEatFood(newHead)) {
      // Aggiunge la nuova testa e non rimuove la coda perché ha mangiato
      _body = newHead +: _body
      _totalEatenFoods = _totalEatenFoods + 1
    } else {
      // Aggiunge la nuova testa e rimuove la coda
      _body = newHead +: _body.init
    }

    if (_body.distinct.length != _body.length || // hit body
      (newHead._1 == _env.rows || newHead._2 == _env.columns || newHead._1 == -1 || newHead._2 == -1)) { // hit wall
      gameOver = true
      _isAlive = false
    }

    !gameOver
  }
}
