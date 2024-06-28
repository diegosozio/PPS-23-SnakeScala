import java.awt.Color
import scala.swing._
import scala.swing.event._

object SnakeGameGui extends SimpleSwingApplication {
  private val _l: Int = 16
  private val _gridSize: Int = 30
  private var _environment = Environment(_gridSize, _gridSize)
  private var _canMove: Boolean = false
  private var _timeSnakeMove: Int = 300
  private var _timeSnakeMoveChanged: Boolean = false
  private var _isGameOver: Boolean = false
  private var _isPaused: Boolean = true // Start with the game paused

  def top: MainFrame = new MainFrame {
    title = "Snake Game"
    object gamePanel extends GridPanel(_gridSize, _gridSize) {
      preferredSize = new Dimension(_gridSize * _l, _gridSize * _l)

      val moveTimer = new javax.swing.Timer(_timeSnakeMove, Swing.ActionListener(e => moveSnake()))
      val foodTimer = new javax.swing.Timer(5000, Swing.ActionListener(e => createFood()))

      def startTimers(): Unit = {
        moveTimer.start()
        foodTimer.start()
      }

      def stopTimers(): Unit = {
        moveTimer.stop()
        foodTimer.stop()
      }

      def moveSnake(): Unit = {
        if (!_isGameOver) {
          _isGameOver = !_environment.moveSnake()

          if (_isGameOver) {
            gameOver()
          } else {
            repaint()
            _canMove = true
            header.text = s"Score: ${_environment.score}"
            header.repaint() // Update the label with the new score

            if (!_timeSnakeMoveChanged && _environment.totalEatenFoods % 5 == 0) {
              _timeSnakeMove = _timeSnakeMove - _environment.totalEatenFoods * 5
              moveTimer.setDelay(_timeSnakeMove)
              _timeSnakeMoveChanged = true
            } else if (_environment.totalEatenFoods % 5 == 1) {
              _timeSnakeMoveChanged = false
            }
          }
        }
      }

      def createFood(): Unit = {
        _environment.addFood()
        repaint()
      }

      def placeSquare(g: Graphics2D, pos: (Int, Int)): Unit = g.fillRect(pos._1 * _l, pos._2 * _l, _l, _l)

      def gameOver(): Unit = {
        stopTimers()
        _canMove = false

        statusLabel.text = "Game Over"
        statusLabel.repaint()

        playPauseButton.text = "Play"
        playPauseButton.repaint()

        maxScoreLabel.text = s"Max Score: ${_environment.maxScore}"
        maxScoreLabel.repaint()
      }

      override def paintComponent(g: Graphics2D): Unit = {
        super.paintComponent(g)

        if (_environment.placedFood.isDefined) {
          g.setColor(Color.orange)
          placeSquare(g, _environment.placedFood.get)
        }

        g.setColor(Color.black)
        for (pos <- _environment.snakeBody) {
          placeSquare(g, pos)
        }
      }

      listenTo(keys)
      reactions += {
        case e: KeyPressed =>
          if (_canMove) {
            if (e.key == Key.Up) _environment.moveSnakeUp()
            else if (e.key == Key.Down) _environment.moveSnakeDown()
            else if (e.key == Key.Left) _environment.moveSnakeLeft()
            else if (e.key == Key.Right) _environment.moveSnakeRight()
            _canMove = false
          }
      }

      _canMove = true

      focusable = true
      resizable = false
      requestFocus()
    }

    val header: Label = new Label(s"Score: ${_environment.score}") {
      preferredSize = new Dimension(_gridSize * _l, 30)
      horizontalAlignment = Alignment.Center
      verticalAlignment = Alignment.Center
      background = Color.white
      opaque = true
    }

    val statusLabel: Label = new Label("Game paused") {
      preferredSize = new Dimension(_gridSize * _l, 30)
      horizontalAlignment = Alignment.Center
      verticalAlignment = Alignment.Center
      background = Color.white
      opaque = true
    }

    val maxScoreLabel: Label = new Label(s"Max Score: ${_environment.maxScore}") {
      preferredSize = new Dimension(_gridSize * _l, 30)
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

          if(_isGameOver) {
            restartGame()
          }else {
            if (_isPaused) {
              gamePanel.startTimers()
              text = "Pause"
              statusLabel.text = "Game in progress"
            } else {
              gamePanel.stopTimers()
              text = "Play"
              statusLabel.text = "Game paused"
            }

            statusLabel.repaint()
            _isPaused = !_isPaused
            gamePanel.requestFocus() // Ensure gamePanel retains focus to capture key events
          }
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

      _environment = Environment(_gridSize, _gridSize) // Recreate the environment

      header.text = s"Score: ${_environment.score}"
      header.repaint()
      statusLabel.text = "Game in progress"
      statusLabel.repaint()
      _isGameOver = false
      _isPaused = false
      playPauseButton.text = "Pause"

      _canMove = true // Allow movement after restart
      gamePanel.requestFocus() // Ensure gamePanel retains focus to capture key events
      gamePanel.startTimers()
      gamePanel.repaint() // Ensure the gamePanel is repainted to reflect the new state
    }

    val buttonPanel: BoxPanel = new BoxPanel(Orientation.Vertical) {
      background = Color.white
      opaque = true
      preferredSize = new Dimension(200, 300) // Set your desired width and height here
      minimumSize = new Dimension(200, 300)
      maximumSize = new Dimension(200, 300)

      contents += new BoxPanel(Orientation.Horizontal) {
        contents += statusLabel
        background = Color.white

      }
      contents += Swing.Glue

      contents += new BoxPanel(Orientation.Horizontal) {
        contents += playPauseButton
        background = Color.white

      }
      contents += Swing.Glue

      contents += new BoxPanel(Orientation.Horizontal) {
        contents += restartButton
        background = Color.white

      }
      contents += Swing.Glue

      contents += new BoxPanel(Orientation.Horizontal) {
        contents += maxScoreLabel
        background = Color.white

      }
      contents += Swing.Glue
    }

    contents = new BorderPanel {
      layout(header) = BorderPanel.Position.North
      layout(gamePanel) = BorderPanel.Position.Center
      layout(buttonPanel) = BorderPanel.Position.East
    }

  }
}
