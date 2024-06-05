package snake

class Snake {
  private val _totalEatenFoods: Int = 0
  private val _body: List[(Int, Int)] = List((3, 5), (3, 4), (3, 3))
  private val _direction: (Int, Int) = (0, 1)

  def body: List[(Int, Int)] = _body
  def direction: (Int, Int) = _direction
  def totalEatenFoods:Int = _totalEatenFoods

  def changeDirection(newDir: (Int, Int)): Unit = {}
  def move(): Boolean = false
  def eatFood(): Unit = {}
}
