# Venturi Matteo


Entrando nel dettaglio del lavoro svolto dal singolo membro del team, tratteremo in questo momento le parti prevalentemente svolte da Matteo tenendo comunque a mente che il software in virtù dell'esiguo nucleo di progetto è stato svolto in parte con la tecnica del pair programming

## Struttura di progetto
Ho creato la struttura base del progetto e incluso le librerie necessarie allo sviluppo e al testing. Infine ho implementato la parte di CI/CD del codice di progetto usando Github Actions.
Di seguito il file yml di CI/CD:
```
name: Scala CI

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

permissions:
  contents: read

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v4
    
    - name: Set up JDK 21
      uses: actions/setup-java@v3
      with:
        java-version: '21'
        distribution: 'temurin'
        cache: 'sbt'
        
    - name: Run tests
      run: sbt test

    - name: Package application
      run: |
        sbt assembly
        mkdir -p artifact
        cp target/scala-3.3.3/*.jar artifact/

    - name: Upload artifacts
      uses: actions/upload-artifact@v4.3.3
      with:
        name: pps-23-snakescala
        path: artifact/
```
## View
Ho implementanto il primo prototipo di view durante la prima sprint, in modo da avere a disposizione una prima versione embrionale della UI. La UI in questa prima versione mostrava semplicemente il serpente e l'ambiente in cui si muoveva.

## Controller
Con diverse iterazioni, ho implementato la parte di controller Environment, con relativi unit test, che si occupa di gestire l'ambiente del gioco, incorporando le necessarie strutture dati, pilotare il serpente e incapsulare la logica di punteggio e di aggiunta del cibo.
Di seguito il codice che gestisce il movimento del serpente e il salvataggio del punteggio:
```
  def moveSnake(): Boolean = {
    val isAlive = _snake.move()
    if(!isAlive){
      _score.updateMaxScore()
    }
    isAlive
  }
```

## Dominio
Ho implementato l'entità Snake, con relativi unit test, che incapsula le logiche di movimento del serpente, accrescimento del corpo successivamente alla cattura del cibo, logica di gameover e le strutture dati relative.
Ho partecipato come reviewer allo sviluppo dell'entità Score che incapsula la storicizzazione e il reperimento del punteggio.
Di seguito la logica di movimento del serpente:
```
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
```

## Test
Ho partecipato alle fasi di test dell'applicativo durante tutte le sprint di sviluppo.

[Torna all'implementazione](../5-implementazione.md)
