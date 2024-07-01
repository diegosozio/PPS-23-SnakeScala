# Design di dettaglio

Questo capitolo illustra nel dettaglio il design del sistema SnakeScala. Il sistema si compone di 3 package i quali vengono discussi nei paragrafi che
seguono: `model`, `controller` e `view`.


# Model

Questo package contiene le classi che rappresentano le entità del gioco Snake, rispecchiando il modello di dominio definito in fase di raccolta dei requisiti.

Ogni entità è definita attraverso classi regolari, con attributi e operazioni che gestiscono lo stato e il comportamento del gioco. Di seguito, la descrizione dettagliata delle classi presenti nel package `model`, visionabili anche nel diagramma sottostante:

### Environment
Rappresenta l'ambiente di gioco in cui il serpente si muove e interagisce con il cibo. È caratterizzato da:
- **rows** - numero di righe della griglia.
- **columns** - numero di colonne della griglia.
- **scorePerFoodUnit** - punteggio assegnato per ogni unità di cibo consumata.
- **_food** - posizione attuale del cibo nella griglia, se presente.
- **_rand** - generatore di numeri casuali per posizionare il cibo.
- **_snake** - istanza della classe Snake che rappresenta il serpente.
- **_score** - istanza della classe Score che gestisce il punteggio.
  
#### Metodi Principali:
- `addFood()`: aggiunge cibo in una posizione casuale della griglia.
- `addFood(place: (Int, Int))`: aggiunge cibo nella posizione specificata.
- `tryEatFood(place: (Int, Int))`: verifica se il serpente ha mangiato il cibo.
- `moveSnake()`: muove il serpente e ritorna `true` se il serpente è vivo, `false` altrimenti.
- Metodi per muovere il serpente nelle quattro direzioni (su, giù, sinistra, destra).

### Snake
Rappresenta il serpente che si muove all'interno dell'ambiente di gioco.

#### Attributi Principali:
- **body** - lista delle coordinate che costituiscono il corpo del serpente.
- **direction** - direzione corrente del movimento del serpente.
- **environment** - riferimento all'ambiente di gioco.

#### Metodi Principali:
- `move()`: aggiorna la posizione del serpente.
- Metodi per cambiare la direzione del serpente (goUp, goDown, goLeft, goRight).

### Score
Gestisce il punteggio del gioco.

#### Attributi Principali:
- **score** - punteggio corrente.
- **maxScore** - punteggio massimo raggiunto.

#### Metodi Principali:
- `Inc(points: Int)`: incrementa il punteggio corrente di un certo numero di punti.
- `updateMaxScore()`: aggiorna il punteggio massimo se il punteggio corrente è superiore.

### Diagramma delle Classi

Ecco il diagramma delle classi del package `model`:

|  Environment    |
|-----------------|
| - scorePerFoodUnit: Int      |
| - _food: Option[(Int, Int)]  |
| - _rand: Random              |
| - _snake: Snake              |
| - _score: Score              |
|-------------------------------|
| + rows: Int                  |
| + columns: Int               |
| + placedFood: Option[(Int, Int)] |
| + score: Int                 |
| + maxScore: Int              |
| + totalEatenFoods: Int       |
| + snakeBody: List[(Int, Int)]|
|-------------------------------|
| + addFood(): Unit            |
| + addFood(place: (Int, Int)): Unit |
| + tryEatFood(place: (Int, Int)): Boolean |
| + moveSnake(): Boolean       |
| + moveSnakeUp(): Unit        |
| + moveSnakeDown(): Unit      |
| + moveSnakeLeft(): Unit      |
| + moveSnakeRight(): Unit     |


|     Snake       |
|-----------------|
| - body: List[(Int, Int)]     |
| - direction: (Int, Int)      |
| - environment: Environment   |
| + totalEatenFoods: Int       |
| + move(): Boolean            |
| + goUp(): Unit               |
| + goDown(): Unit             |
| + goLeft(): Unit             |
| + goRight(): Unit            |

|     Score       |
|-----------------|
| - score: Int              |
| - maxScore: Int           |
| + score: Int              |
| + maxScore: Int           |
| + Inc(points: Int): Unit  |
| + updateMaxScore(): Unit  |






# View

In questo package sono presenti le classi che si occupano di costruire e gestire l'interfaccia utente del gioco Snake, in modo da garantire una corretta visualizzazione del gioco e delle informazioni. Queste classi sono progettate per reagire alle interazioni dell'utente con la GUI, richiamando le opportune funzioni dei controller per aggiornare lo stato del gioco.

Sono stati previsti diversi componenti principali per organizzare in maniera più ordinata i vari elementi che compongono la View:

### MainFrame

La classe principale `SnakeGameGui` estende `SimpleSwingApplication` e rappresenta il frame principale dell'applicazione. Al suo interno sono definiti vari componenti grafici e logiche di gestione del gioco:

- **Header**: Un'etichetta che visualizza il punteggio corrente del gioco.
- **Status Label**: Un'etichetta che mostra lo stato attuale del gioco, come "Game paused" o "Game Over".
- **Max Score Label**: Un'etichetta che visualizza il punteggio massimo raggiunto.
- **Play/Pause Button**: Un pulsante per avviare o mettere in pausa il gioco. Aggiorna lo stato del gioco e l'etichetta di stato.
- **Restart Button**: Un pulsante per riavviare il gioco. Resetta l'ambiente di gioco e riavvia i timer.

### Components

#### GamePanel

Il `GamePanel` è un componente chiave che estende `GridPanel`. Gestisce la logica di disegno e aggiornamento della griglia di gioco:

- **Movimento del Serpente**: Utilizza un `Timer` per gestire il movimento del serpente. Il serpente si muove automaticamente a intervalli regolari, e il movimento viene aggiornato basato sugli input dell'utente.
- **Generazione del Cibo**: Un altro `Timer` gestisce la generazione periodica del cibo nella griglia.
- **Disegno del Gioco**: Il metodo `paintComponent` è sovrascritto per disegnare il serpente e il cibo sulla griglia di gioco.
- **Gestione Input**: Il pannello ascolta gli eventi della tastiera per muovere il serpente in diverse direzioni (su, giù, sinistra, destra).

#### ButtonPanel

Il `ButtonPanel` è un componente verticale che contiene i pulsanti e le etichette di stato del gioco:

- **Status Label**: Visualizza lo stato attuale del gioco (in pausa, in corso, finito).
- **Play/Pause Button**: Permette di avviare e mettere in pausa il gioco. Aggiorna lo stato del gioco e l'etichetta di stato.
- **Restart Button**: Riavvia il gioco resettando l'ambiente e riavviando i timer.
- **Max Score Label**: Visualizza il punteggio massimo raggiunto durante il gioco.

### Logiche di Gioco

- **Gestione Stato del Gioco**: Il gioco inizia in stato di pausa. I pulsanti di play/pausa e riavvio permettono di gestire lo stato del gioco e i timer associati.
- **Movimento del Serpente e Collisioni**: La logica del movimento del serpente è gestita dal timer `moveTimer`. Se il serpente si muove senza collisioni, il gioco continua; altrimenti, lo stato viene aggiornato a "Game Over".
- **Aggiornamento del Punteggio**: Il punteggio viene aggiornato ogni volta che il serpente mangia il cibo. L'etichetta del punteggio viene aggiornata di conseguenza.

Questo design permette di realizzare un'interfaccia utente chiara e reattiva per il gioco Snake, garantendo una buona esperienza utente e facilitando la gestione dello stato del gioco tramite l'interazione con i componenti grafici.

# Controller
In questo package sono presenti le classi che si occupano di gestire le interazioni tra l'utente e il sistema, in modo da garantire la corretta esecuzione delle operazioni richieste.

Nel rispetto del pattern architetturale MVC, i controller sono stati progettati per reagire alle interazioni dell'utente con l'interfaccia grafica, per poi richiamare le opportune funzioni della logica di business.

I controllers relativi al gioco del serpente presentano una struttura ben precisa. Queste classi sono rappresentate da oggetti o classi che gestiscono specifiche operazioni del gioco, come il punteggio e il movimento del serpente.

Di seguito, vengono descritti i controllers presenti in questo package:

Il controller `Environment` gestisce la logica del gioco Snake, includendo la gestione del serpente, del cibo e del punteggio. Qui di seguito approfondiamo i dettagli del design implementativo per ciascuna componente del controller:

#### Struttura del Controller

Il controller `Environment` è progettato per mantenere lo stato e la logica del gioco Snake. Ecco una panoramica dei componenti principali:

- **Variabili di Stato**:
  - `_rows` e `_columns`: Rappresentano il numero di righe e colonne della griglia di gioco.
  - `_food`: Opzionale, rappresenta la posizione corrente del cibo sulla griglia.
  - `_rand`: Oggetto `Random` utilizzato per generare posizioni casuali.
  - `_snake`: Istanzia l'oggetto `Snake`, che rappresenta il serpente controllato dal giocatore.
  - `_score`: Gestisce il punteggio del giocatore e il punteggio massimo raggiunto.

#### Metodi Pubblici del Controller

- **Metodi Getter**:
  - `rows` e `columns`: Restituiscono rispettivamente il numero di righe e colonne della griglia di gioco.
  - `placedFood`: Restituisce la posizione del cibo, se presente.
  - `score` e `maxScore`: Restituiscono il punteggio corrente e il punteggio massimo raggiunto.
  - `totalEatenFoods`: Restituisce il numero totale di cibi mangiati dal serpente.
  - `snakeBody`: Restituisce la lista delle posizioni del corpo del serpente da disegnare sulla griglia.

- **Metodi per la Gestione del Cibo**:
  - `addFood()`: Aggiunge un cibo in una posizione casuale sulla griglia.
  - `addFood(place: (Int, Int))`: Aggiunge un cibo in una posizione specificata sulla griglia.
  - `tryEatFood(place: (Int, Int))`: Verifica se la posizione specificata contiene del cibo. Se sì, lo rimuove e aumenta il punteggio del giocatore.

- **Metodi per il Movimento del Serpente**:
  - `moveSnake()`: Muove il serpente sulla griglia. Restituisce `true` se il serpente è vivo dopo il movimento, altrimenti `false`.
  - Metodi separati (`moveSnakeUp()`, `moveSnakeDown()`, `moveSnakeLeft()`, `moveSnakeRight()`): Muovono il serpente in direzioni specifiche.

Questo design permette al controller di gestire efficacemente gli aspetti fondamentali del gioco Snake, garantendo una struttura modulare e ben organizzata per una facile manutenzione e espansione.




