import java.awt.Color
import scala.swing._
import scala.swing.event._
import snake._

object SnakeGameGui extends SimpleSwingApplication {
  private val l: Int = 16
  private val gridSize: Int = 20
  private var environment = Environment(gridSize, gridSize)
  private var canMove: Boolean = false
  private var timeSnakeMove: Int = 300
  private var timeSnakeMoveChanged: Boolean = false
  private var score: Int = 0
  private var isGameOver: Boolean = false
  private var isPaused: Boolean = true // Start with the game paused

  def top: MainFrame = new MainFrame {
    title = "Snake Game"
    object gamePanel extends GridPanel(gridSize, gridSize) {
      preferredSize = new Dimension(gridSize * l, gridSize * l)

      val moveTime = new javax.swing.Timer(timeSnakeMove, Swing.ActionListener(e => moveSnake()))
      val foodTimer = new javax.swing.Timer(5000, Swing.ActionListener(e => createFood()))

      def startTimers(): Unit = {
        moveTime.start()
        foodTimer.start()
      }

      def stopTimers(): Unit = {
        moveTime.stop()
        foodTimer.stop()
      }

      def moveSnake(): Unit = {
        if (!isGameOver) {
          isGameOver = !environment.snake.move()
          repaint()

          if (isGameOver) {
            gameOver()
          } else {
            canMove = true

            if (environment.snake.body.head == environment.placedFood.getOrElse((-1, -1))) {
              score += 10
              header.text = s"Score: $score"
              header.repaint() // Update the label with the new score
              environment.addFood()
            }

            if (!timeSnakeMoveChanged && environment.snake.totalEatenFoods % 5 == 0) {
              timeSnakeMove = timeSnakeMove - environment.snake.totalEatenFoods * 5
              moveTime.setDelay(timeSnakeMove)
              timeSnakeMoveChanged = true
            } else if (environment.snake.totalEatenFoods % 5 == 1) {
              timeSnakeMoveChanged = false
            }
          }
        }
      }

      def createFood(): Unit = environment.addFood()

      def placeSquare(g: Graphics2D, pos: (Int, Int)): Unit = g.fillRect(pos._1 * l, pos._2 * l, l, l)

      def gameOver(): Unit = {
        stopTimers()
        canMove = false

        statusLabel.text = "Game Over"
        statusLabel.repaint()
      }

      override def paintComponent(g: Graphics2D): Unit = {
        super.paintComponent(g)

        if (environment.placedFood.isDefined) {
          g.setColor(Color.orange)
          placeSquare(g, environment.placedFood.get)
        }

        g.setColor(Color.black)
        for (pos <- environment.snake.body) {
          placeSquare(g, pos)
        }
      }

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

      focusable = true
      resizable = false
      requestFocus()
    }

    val header: Label = new Label(s"Score: $score") {
      preferredSize = new Dimension(gridSize * l, 30)
      horizontalAlignment = Alignment.Center
      verticalAlignment = Alignment.Center
      background = Color.white
      opaque = true
    }

    val statusLabel: Label = new Label("Game paused") {
      preferredSize = new Dimension(gridSize * l, 30)
      horizontalAlignment = Alignment.Center
      verticalAlignment = Alignment.Center
      background = Color.white
      opaque = true
    }

    val buttonSize = new Dimension(100, 30) // Define a common size for the buttons

    val playPauseButton: Button = new Button("Play") {
      preferredSize = buttonSize
      reactions += {
        case ButtonClicked(_) =>
          if (isPaused) {
            gamePanel.startTimers()
            text = "Pause"
            statusLabel.text = "Game in progress"
            statusLabel.repaint()
          } else {
            gamePanel.stopTimers()
            text = "Play"
            statusLabel.text = "Game paused"
            statusLabel.repaint()
          }
          isPaused = !isPaused
          gamePanel.requestFocus() // Ensure gamePanel retains focus to capture key events
      }
    }

    val restartButton: Button = new Button("Restart") {
      preferredSize = buttonSize
      reactions += {
        case ButtonClicked(_) =>
          restartGame()
      }
    }

    def restartGame(): Unit = {
      gamePanel.stopTimers()
      score = 0
      header.text = s"Score: $score"
      header.repaint()
      statusLabel.text = "Game in progress"
      statusLabel.repaint()
      isGameOver = false
      isPaused = false
      playPauseButton.text = "Pause"

      environment = Environment(gridSize, gridSize) // Recreate the environment
      canMove = true // Allow movement after restart
      gamePanel.requestFocus() // Ensure gamePanel retains focus to capture key events
      gamePanel.startTimers()
      gamePanel.repaint() // Ensure the gamePanel is repainted to reflect the new state
    }

    val buttonPanel = new BoxPanel(Orientation.Vertical) {
      background = Color.lightGray
      opaque = true
      contents += playPauseButton
      contents += restartButton
    }

    contents = new BorderPanel {
      layout(header) = BorderPanel.Position.North
      layout(statusLabel) = BorderPanel.Position.South
      layout(gamePanel) = BorderPanel.Position.Center
      layout(buttonPanel) = BorderPanel.Position.East
    }

    listenTo(gamePanel.keys)
    reactions += {
      case KeyPressed(_, Key.Up, _, _) => if (canMove) { environment.snake.goUp(); canMove = false }
      case KeyPressed(_, Key.Down, _, _) => if (canMove) { environment.snake.goDown(); canMove = false }
      case KeyPressed(_, Key.Left, _, _) => if (canMove) { environment.snake.goLeft(); canMove = false }
      case KeyPressed(_, Key.Right, _, _) => if (canMove) { environment.snake.goRight(); canMove = false }
    }

    gamePanel.requestFocus() // Ensure gamePanel retains focus to capture key events
  }
}
