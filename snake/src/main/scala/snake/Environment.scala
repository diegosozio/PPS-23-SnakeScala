package snake

class Environment(_rows: Int, _columns: Int) {
  private var _food: Option[(Int, Int)] = None
  private val _rand = new scala.util.Random
  private var _snake = new Snake(this)

  def rows: Int = _rows
  def columns: Int = _columns
  def snake: Snake = _snake
  def placedFood: Option[(Int, Int)] = _food

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
    if (_food.isDefined && place == _food.get) {
      _food = None
      return true
    }
    false
  }
}