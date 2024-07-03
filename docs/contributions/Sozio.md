# Sozio Diego

Entrando nel dettaglio del lavoro svolto dal singolo membro del team, tratteremo in questo momento le parti prevalentemente svolte da Diego tenendo comunque a mente che il software in virtù dell'esiguo nucleo di progetto è stato svolto in parte con la tecnica del pair programming 

## View 
Personalmente per declinazione personale a causa della mia esperienza lavorativa come sviluppatore frontendista mi sono occupato principalmente dell'interfaccia grafica dove in particolare ho implementato i comportamenti di: 
### 1. Calcolo di Score crescente a seguito della consumazione di un cibo da parte del serpente

Nella prima implementazione, ho gestito l'incremento dello score direttamente nel flusso di gioco, senza separare chiaramente le responsabilità tra MODEL, VIEW e CONTROLLER. Questo approccio ha reso il codice meno modulare e più complesso da mantenere nel tempo.

Dopo aver riconosciuto la necessità di adottare una struttura più chiara e conforme al pattern MVC, ho estratto la logica del calcolo dello score in una classe o oggetto separato che rappresenta il MODEL. Questo cambiamento ha migliorato la separazione delle responsabilità nel codice, facilitando la manutenzione e consentendo una migliore gestione dell'applicazione nel complesso.

Questo approccio ha anche favorito la riutilizzabilità del codice, poiché ora lo score può essere facilmente manipolato e testato in modo isolato dal resto dell'applicazione di gioco.

### 2. Implementazione della visualizzazione dello stato del gioco

La visualizzazione dello stato del gioco è gestita principalmente dall'etichetta `statusLabel`. Ecco i dettagli rilevanti:

```
val statusLabel: Label = new Label("Game paused") {
  preferredSize = new Dimension(_gridSize * _l, 30)
  horizontalAlignment = Alignment.Center
  verticalAlignment = Alignment.Center
  background = Color.white
  opaque = true
}

// Aggiornamento dello stato del gioco
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
```
### 3. Implementazione del bottone Start
Il bottone Start è gestito da playPauseButton. Ecco i dettagli rilevanti:
```
val playPauseButton: Button = new Button("Play") {
  preferredSize = buttonSize
  reactions += {
    case ButtonClicked(_) =>
      if(_isGameOver) {
        restartGame()
      } else {
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
```

### 4. Implementazione del Bottone Restart
Il bottone Restart è gestito da restartButton. Ecco i dettagli rilevanti:
```
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
```

### 5. Implementazione delle logiche di MaxScore
La gestione del MaxScore è incorporata nella classe Environment e viene visualizzata da maxScoreLabel. Ecco i dettagli rilevanti:
```
val maxScoreLabel: Label = new Label(s"Max Score: ${_environment.maxScore}") {
  preferredSize = new Dimension(_gridSize * _l, 30)
  horizontalAlignment = Alignment.Center
  verticalAlignment = Alignment.Center
  background = Color.white
  opaque = true
}

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
```

### 6. Implementazione dei Test per il componente core Score

Ho implementato una suite di test per il componente core Score utilizzando ScalaTest. La suite di test include diverse specifiche per garantire il corretto funzionamento del punteggio nel gioco Snake.

Esempi di Test Implementati:

- Verifica che il punteggio inizi a 0.
- Verifica che il punteggio massimo inizi a 0 se non esiste alcun file.
- Verifica che il punteggio si incrementi correttamente.
- Verifica che il punteggio si resetti correttamente.
- Verifica che il punteggio massimo venga aggiornato correttamente se il nuovo punteggio è maggiore.
- Verifica che il punteggio massimo non venga aggiornato se il nuovo punteggio non è maggiore.
- Verifica che il punteggio massimo venga caricato correttamente dal file se esiste.
- Verifica che il punteggio massimo venga salvato correttamente nel file.

```
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.BeforeAndAfter
import java.io.File

class ScoreSuite extends AnyFunSpec with BeforeAndAfter {
  private val _scoreFilename: String = "maxScore.txt"

  before {
    // Ensure the score file does not exist before each test
    new Score().deleteMaxScore()
  }

  describe("Score") {
    it("should start with a score of 0") {
      val score = new Score()
      assert(score.score == 0)
    }

    it("should start with a max score of 0 if no file exists") {
      val score = new Score()
      assert(score.maxScore == 0)
    }

    it("should increment the score correctly") {
      val score = new Score()
      score.Inc(10)
      assert(score.score == 10)
    }

    it("should reset the score correctly") {
      val score = new Score()
      score.Inc(10)
      score.resetScore()
      assert(score.score == 0)
    }

    it("should update the max score correctly if the new score is higher") {
      val score = new Score()
      score.Inc(10)
      score.updateMaxScore()
      assert(score.maxScore == 10)
    }

    it("should not update the max score if the new score is not higher") {
      val score = new Score()
      score
```
## Testing 
Personalmente mi sono occupato della scrittura della Test Suite del componente core denominato Socre 

## Build Automation 
Entrambi i membri del team hanno concordato sulla scelta di utilizzare SBT come strumento di build automation. 
Io mi sono occupato di scrivere il file di configurazione build.sbt di SnakeGameGui, definendo le dipendenze del progetto e le regole per determinare la corretta versione delle librerie utilizzate.

## Documentazione e Github Action 
Mi sono assunto il compito di redigere e gestire la documentazione del progetto in modo efficace ed efficiente. Per rendere questo processo più fluido e automatizzato, ho configurato GitHub Actions, uno strumento che esegue automatizzazioni e flussi di lavoro, garantendo coerenza e precisione nella documentazione.

Ho implementato procedure automatizzate per il build e deploy della documentazione. Ogni volta che vengono apportate modifiche alla documentazione nel repository, questi flussi di lavoro generano automaticamente la documentazione, assicurando che sia sempre aggiornata.

L'uso di GitHub Actions ha migliorato significativamente l'efficienza del nostro team nello sviluppo e nella manutenzione della documentazione del progetto. Ha ridotto il carico manuale, migliorato la coerenza e ha permesso al team di concentrarsi maggiormente sullo sviluppo del software senza compromettere la qualità della documentazione.



[Torna all'implementazione](../5-implementazione.md)
