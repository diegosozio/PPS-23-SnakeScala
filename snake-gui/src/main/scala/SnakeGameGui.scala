import java.awt.Color
import scala.swing.*
import scala.swing.event.*
import snake.*;

object SnakeGameGui extends SimpleSwingApplication {
  private val l:Int = 16
  private val gridSize:Int = 20
  private val environment = Environment(gridSize, gridSize)
  private var canMove: Boolean = false
  private var timeSnakeMove:Int = 300
  private var timeSnakeMoveChanged:Boolean = false

  def top: MainFrame = new MainFrame {
    title = "Snake Game"
    val gamePanel: GridPanel = new GridPanel(gridSize, gridSize) {
      preferredSize = new Dimension(gridSize * l, gridSize * l)

      // Metodo per aggiornare la posizione del serpente
      def moveSnake(): Unit = {
        val isGameOver: Boolean = !environment.snake.move()
        repaint()

        if(isGameOver){
          gameOver()
        }else{
          canMove = true

          if(!timeSnakeMoveChanged && environment.snake.totalEatenFoods % 5 == 0){
            timeSnakeMove = timeSnakeMove - environment.snake.totalEatenFoods * 5
            moveTime.setDelay(timeSnakeMove)
            timeSnakeMoveChanged = true
          } else if(environment.snake.totalEatenFoods % 5 == 1){
            timeSnakeMoveChanged = false
          }
        }
      }

      def createFood(): Unit = environment.addFood()

      def placeSquare(g: Graphics2D, pos: (Int,Int)): Unit = g.fillRect(pos._1 * l, pos._2 * l, l, l)

      def gameOver(): Unit = {
        foodTimer.stop()
        moveTime.stop()
        canMove = false
      }

      // Metodo per disegnare il serpente
      override def paintComponent(g: Graphics2D): Unit = {
        super.paintComponent(g)

        if(environment.placedFood.isDefined) {
          g.setColor(Color.orange)
          placeSquare(g, environment.placedFood.get)
        }

        g.setColor(Color.black)
        for (pos <- environment.snake.body) {
          placeSquare(g,pos)
        }
      }

      // Timer per muovere il serpente
      val moveTime = new javax.swing.Timer(timeSnakeMove, Swing.ActionListener(e => moveSnake()))
      val foodTimer = new javax.swing.Timer(5000, Swing.ActionListener(e => createFood()))

      // Avvia il timer
      moveTime.start()
      foodTimer.start()

      // Gestione degli eventi della tastiera
      listenTo(keys)
      reactions += {
        case e: KeyPressed =>
          if (canMove) {
            if (e.key == Key.Up) environment.snake.goUp()
            else if (e.key == Key.Down) environment.snake.goDown()
            else if (e.key == Key.Left) environment.snake.goLeft()
            else if (e.key == Key.Right) environment.snake.goRight()
            canMove = false
          }
      }

      canMove = true

      // Imposta il pannello per ricevere eventi della tastiera
      focusable = true
      resizable = false
      requestFocus()
    }

    contents = gamePanel
  }
}
