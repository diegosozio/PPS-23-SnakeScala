# Sprint Backlog

Il presente documento rappresenta il registro delle attività pianificate e completate durante lo sviluppo del progetto SnakeScala. Ogni sprint, della durata di due settimana, ha visto il team concentrarsi su obiettivi specifici per avanzare nel ciclo di sviluppo software. Ogni attività è stata stimata in ore di lavoro effettivo, considerando un'unità di 8 ore al giorno, escludendo pause e attività non direttamente correlate allo sprint in corso. Il file è strutturato per fornire una visione chiara delle attività svolte, delle date di esecuzione e delle retrospettive sull'andamento del lavoro, consentendo una valutazione continua e il miglioramento continuo del processo di sviluppo.


| ID | Descrizione | Stima Oraria |
|----|-------------|--------------|
| 1  | Creazione del repository su GitHub e configurazione del modello GitFlow | 2h |
| 2  | Definizione del dominio del problema e requisiti | 4h |
| 3  | Implementazione della classe `Score` | 1h |
| 4  | Implementazione della classe `Snake` | 4h |
| 5  | Implementazione del movimento del serpente | 3h |
| 6  | Gestione della collisione del serpente con i bordi e se stesso | 4h |
| 7  | Implementazione della crescita del serpente quando mangia il cibo | 3h |
| 8  | Generazione casuale della posizione del cibo | 2h |
| 9  | Implementazione del controller del gioco | 4h |
| 10 | Gestione degli input dell'utente per il controllo del serpente | 3h |
| 11 | Implementazione della vista del gioco (`SnakeGameGui`) | 4h |
| 12 | Rendering del campo di gioco e visualizzazione del serpente e del cibo | 4h |
| 13 | Gestione dello stato del gioco (in corso, pausa, finito) | 3h |
| 14 | Implementazione del salvataggio automatico del punteggio più alto | 2h |
| 15 | Testing unitario delle classi `Score`, `Snake`, `Enviroment` | 6h |
| 16 | Scrittura della documentazione del codice | 4h |
| 17 | Preparazione della relazione finale e del documento PDF | 6h |
| 18 | Revisione del codice e refactoring finale | 5h |
| 19 | Pianificazione delle cerimonie Scrum (Initial Planning, Sprint Planning, Daily Scrum, Sprint Review) | 3h |
| 20 | Configurazione di Continuous Integration (CI) con GitHub Actions | 4h |
| 21 | Implementazione del Test Driven Development (TDD) | 6h |
| 22 | Verifica e validazione del sistema completo | 5h |
| **Totale** | | **78h** |


Per ogni sprint l team deve stimare con precisione il tempo necessario per completare ogni attività in ore di lavoro effettivo. Un'ora di lavoro effettivo non include pause, interruzioni o attività non pertinenti allo sprint. Una giornata lavorativa è considerata pari a 8 ore. Pertanto, per esprimere la durata di un'attività in giorni lavorativi, occorre convertirla in ore (ad esempio, 2 giorni equivalgono a 16 ore).

Qui di seguito sono elencate le iterazioni con le relative date di inizio e fine, insieme alle attività svolte e alle stime di durata in ore o giorni lavorativi. 

### Sprint 1 (15 maggio 2024 - 28 maggio 2024)

| ID | Descrizione | Stima Oraria |
|----|-------------|--------------|
| 1  | Creazione del repository su GitHub e configurazione del modello GitFlow | 2h |
| 2  | Definizione del dominio del problema e requisiti | 4h |
| 3  | Implementazione della classe `Score` | 1h |
| 4  | Implementazione della classe `Snake` | 4h |
| 5  | Implementazione del movimento del serpente | 3h |
| 6  | Gestione della collisione del serpente con i bordi e se stesso | 4h |
| 7  | Implementazione della crescita del serpente quando mangia il cibo | 3h |
| 8  | Generazione casuale della posizione del cibo | 2h |
| 9  | Implementazione del controller del gioco | 4h |
| 10 | Gestione degli input dell'utente per il controllo del serpente | 3h |
| **Totale** | | **30h** |

**Retrospettiva del Progetto:**

#### Cosa ha funzionato bene:
- **Creazione del repository su GitHub e configurazione di GitFlow:** Completata in modo efficiente e conforme alle aspettative in meno tempo del previsto.
- **Implementazione delle classi base (Score, Snake):** Sono state completate con successo e senza ritardi significativi.

#### Cosa potremmo migliorare:
- **Gestione del tempo:** Alcune attività, come l'implementazione del movimento del serpente, hanno richiesto più tempo del previsto a causa di sfide tecniche impreviste.
- **Pianificazione delle attività:** Alcuni task, come la gestione degli input dell'utente, potrebbero essere stati sottovalutati in termini di complessità.

#### Azioni correttive:
- Migliorare la stima delle attività future considerando le complessità tecniche.
- Incrementare la collaborazione durante la risoluzione di problemi per ridurre i tempi di blocco.


### Sprint 2 (29 maggio 2024 - 11 giugno 2024)

| ID | Descrizione | Stima Oraria |
|----|-------------|--------------|
| 11 | Implementazione della vista del gioco (`SnakeGameGui`) | 4h |
| 12 | Rendering del campo di gioco e visualizzazione del serpente e del cibo | 4h |
| 13 | Gestione dello stato del gioco (in corso, pausa, finito) | 3h |
| 14 | Implementazione del salvataggio automatico del punteggio più alto | 2h |
| 15 | Testing unitario delle classi `Score`, `Snake`, `Enviroment` | 6h |
| 16 | Scrittura della documentazione del codice | 4h |
| **Totale** | | **23h** |

**Retrospettiva del Progetto:**

#### Cosa ha funzionato bene:
- **Implementazione della vista del gioco (SnakeGameGui):** Completata in tempo e soddisfacente per quanto riguarda le specifiche richieste.
- **Testing unitario delle classi core:** Ha rivelato pochi bug significativi, il che denota una buona qualità del codice base.

#### Cosa potremmo migliorare:
- **Gestione dello stato del gioco e salvataggio del punteggio:** Queste funzionalità potrebbero essere state più integrate e testate prima.

#### Azioni correttive:
- Pianificare sessioni di revisione del codice più frequenti per identificare e risolvere le problematiche prima delle fasi finali.
- Incrementare il coinvolgimento del team durante il processo di integrazione per ridurre il rischio di bug dell'ultimo minuto.


### Sprint 3 (12 giugno 2024 - 25 giugno 2024)

| ID | Descrizione | Stima Oraria |
|----|-------------|--------------|
| 17 | Preparazione della relazione finale e del documento PDF | 6h |
| 18 | Revisione del codice e refactoring finale | 5h |
| 19 | Pianificazione delle cerimonie Scrum | 3h |
| 20 | Configurazione di Continuous Integration (CI) con GitHub Actions | 4h |
| 21 | Implementazione del Test Driven Development (TDD) | 6h |
| 22 | Verifica e validazione del sistema completo | 5h |
| **Totale** | | **29h** |

**Retrospettiva del Progetto:**

#### Cosa ha funzionato bene:
- **Implementazione del Test Driven Development (TDD):** Ha contribuito a migliorare la qualità del codice e a ridurre i bug.
- **Configurazione di Continuous Integration (CI) con GitHub Actions:** Ha facilitato l'integrazione continua e il rilevamento tempestivo di errori.

#### Cosa potremmo migliorare:
- **Preparazione della relazione finale e della documentazione:** Richiedeva più tempo del previsto per essere completata in modo esaustivo.

#### Azioni correttive:
- Pianificare attività di documentazione e preparazione della relazione più realisticamente nei prossimi sprint.
- Assicurarsi di rispettare i tempi stabiliti per le cerimonie Scrum per migliorare la comunicazione e la pianificazione.

