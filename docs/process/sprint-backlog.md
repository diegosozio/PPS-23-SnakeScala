# Sprint Backlog

Il presente documento rappresenta il registro delle attività pianificate e completate durante lo sviluppo del progetto SnakeScala. Ogni sprint, della durata di due settimane, ha visto il team concentrarsi su obiettivi specifici per avanzare nel ciclo di sviluppo software. Ogni attività è stata stimata in ore di lavoro effettivo, considerando un'unità di 8 ore al giorno, escludendo pause e attività non direttamente correlate allo sprint in corso. Il file è strutturato per fornire una visione chiara delle attività svolte, delle date di esecuzione e delle retrospettive sull'andamento del lavoro, consentendo una valutazione continua e il miglioramento continuo del processo di sviluppo.

| ID  | Descrizione                                                                 | Stima Oraria |
|-----|-----------------------------------------------------------------------------|--------------|
| 1   | Creazione del repository su GitHub e configurazione del modello GitFlow      | 2h           |
| 2   | Definizione del dominio del problema e requisiti                            | 4h           |
| 3   | Pianificazione delle cerimonie Scrum (Initial Planning, Sprint Planning)    | 3h           |
| 4   | Implementazione del Test Driven Development (TDD)                           | 6h           |
| 5   | Implementazione della classe `Score`                                        | 1h           |
| 6   | Implementazione della classe `Snake`                                        | 4h           |
| 7   | Implementazione del movimento del serpente                                  | 3h           |
| 8   | Gestione della collisione del serpente con i bordi e se stesso              | 4h           |
| 9   | Implementazione della crescita del serpente quando mangia il cibo           | 3h           |
| 10  | Generazione casuale della posizione del cibo                                | 2h           |
| 11  | Implementazione del controller del gioco                                    | 4h           |
| 12  | Gestione degli input dell'utente per il controllo del serpente              | 3h           |
| 13  | Implementazione della vista del gioco (`SnakeGameGui`)                      | 4h           |
| 14  | Rendering del campo di gioco e visualizzazione del serpente e del cibo      | 4h           |
| 15  | Gestione dello stato del gioco (in corso, pausa, finito)                    | 3h           |
| 16  | Implementazione del salvataggio automatico del punteggio più alto           | 2h           |
| 17  | Testing unitario delle classi `Score`, `Snake`, `Enviroment`                | 6h           |
| 18  | Scrittura della documentazione del codice                                   | 4h           |
| 19  | Revisione del codice e refactoring finale                                   | 5h           |
| 20  | Configurazione di Continuous Integration (CI) con GitHub Actions            | 4h           |
| 21  | Verifica e validazione del sistema completo                                 | 5h           |
| 22  | Preparazione della relazione finale                      | 6h           |
| **Totale** |                                                                       | **78h**      |


Qui di seguito sono elencati gli sprint con le relative date di inizio e fine, insieme alle attività svolte, alle stime di durata in ore e alle ore realmente spese nello sviluppo del singolo task.

### Sprint 1 (15 maggio 2024 - 28 maggio 2024)

| ID  | Descrizione                                                                  | Stima Oraria | Orario Effettivo |
|-----|------------------------------------------------------------------------------|--------------|-----------------|
| 1   | Creazione del repository su GitHub e configurazione del modello GitFlow       | 2h           | 2h              |
| 2   | Definizione del dominio del problema e requisiti                             | 4h           | 4h              |
| 3   | Pianificazione delle cerimonie Scrum (Initial Planning, Sprint Planning)     | 3h           | 3h              |
| 4   | Implementazione del Test Driven Development (TDD)                            | 6h           | 6h              |
| 6   | Implementazione della classe `Snake`                                         | 4h           | 4h              |
| 7   | Implementazione del movimento del serpente                                   | 3h           | 4h              |
| **Totale** |                                                                        | **22h**      | **23h**         |

**Retrospettiva di Sprint:**

#### Cosa ha funzionato bene:
- **Creazione del repository su GitHub e configurazione di GitFlow:** Completata in modo efficiente e conforme alle aspettative in meno tempo del previsto.
- **Implementazione della classe `Snake`:** Completata con successo e senza ritardi significativi.

#### Cosa potremmo migliorare:
- **Gestione del tempo:** Alcune attività, come l'implementazione del movimento del serpente, hanno richiesto più tempo del previsto a causa di sfide tecniche impreviste.
- **Pianificazione delle attività:** Alcuni task, come la gestione degli input dell'utente, potrebbero essere stati sottovalutati in termini di complessità.

#### Azioni correttive:
- Migliorare la stima delle attività future considerando le complessità tecniche.
- Incrementare la collaborazione durante la risoluzione di problemi per ridurre i tempi di blocco.

#### Dettagli aggiuntivi:
- Nel primo sprint è stato implementato un prototipo dell'interfaccia grafica (GUI) che include solo il serpente, senza la generazione della mela e la gestione delle collisioni complete, e solo una parte dell'ambiente è stata sviluppata. La classe `Score` non è stata ancora implementata.

### Sprint 2 (29 maggio 2024 - 11 giugno 2024)

| ID  | Descrizione                                                                  | Stima Oraria | Orario Effettivo |
|-----|------------------------------------------------------------------------------|--------------|-----------------|
| 5   | Implementazione della classe `Score`                                         | 1h           | 0h              |
| 8   | Gestione della collisione del serpente con i bordi e se stesso               | 4h           | 2h              |
| 9   | Implementazione della crescita del serpente quando mangia il cibo            | 3h           | 1h              |
| 10  | Generazione casuale della posizione del cibo                                 | 2h           | 1h              |
| 11  | Implementazione della vista del gioco (`SnakeGameGui`)                       | 4h           | 4h              |
| 12  | Rendering del campo di gioco e visualizzazione del serpente e del cibo       | 4h           | 4h              |
| 13  | Gestione dello stato del gioco (in corso, pausa, finito)                     | 3h           | 3h              |
| 15  | Testing unitario delle classi `Score`, `Snake`, `Enviroment`                 | 6h           | 6h              |
| 16  | Scrittura della documentazione del codice                                    | 4h           | 4h              |
| **Totale** |                                                                        | **31h**      | **25h**         |

**Retrospettiva di Sprint:**

#### Cosa ha funzionato bene:
- **Implementazione della vista del gioco (SnakeGameGui):** Completata in tempo e soddisfacente per quanto riguarda le specifiche richieste.
- **Testing unitario delle classi core:** Ha rivelato pochi bug significativi, il che denota una buona qualità del codice base.

#### Cosa potremmo migliorare:
- **Gestione dello stato del gioco e salvataggio del punteggio:** Queste funzionalità potrebbero essere state più integrate e testate prima.

#### Azioni correttive:
- Pianificare sessioni di revisione del codice più frequenti per identificare e risolvere le problematiche prima delle fasi finali.
- Incrementare il coinvolgimento del team durante il processo di integrazione per ridurre il rischio di bug dell'ultimo minuto.

#### Dettagli aggiuntivi:
- Nel secondo sprint, le classi `Snake` e `Environment` vengono potenziate con l'introduzione della logica per la gestione del cibo e delle collisioni.

### Sprint 3 (12 giugno 2024 - 25 giugno 2024)

| ID  | Descrizione                                              | Stima Oraria | Orario Effettivo |
|-----|----------------------------------------------------------|--------------|-----------------|
| 5   | Implementazione della classe `Score`                     | 1h           | 1h              |
| 14  | Implementazione del salvataggio automatico del punteggio più alto | 2h           | 2h              |
| 17  | Preparazione della relazione finale                      | 6h           | 6h              |
| 18  | Revisione del codice e refactoring finale                | 5h           | 5h              |
| 19  | Configurazione di Continuous Integration (CI) con GitHub Actions | 4h           | 4h              |
| 20  | Verifica e validazione del sistema completo              | 5h           | 5h              |
| **Totale** |                                                    | **23h**      | **23h**         |

**Retrospettiva di Sprint:**

#### Cosa ha funzionato bene:
- **Implementazione del Test Driven Development (TDD):** Ha contribuito a migliorare la qualità del codice e a ridurre i bug.
- **Configurazione di Continuous Integration (CI) con GitHub Actions:** Ha semplificato l'integrazione continua mediante il testing automatico ad ogni push del codice, la generazione automatica del file eseguibile JAR e la compilazione di una relazione di progetto esaustiva e ben strutturata.

#### Cosa potremmo migliorare:
- **Preparazione della relazione finale e della documentazione:** Richiedeva più tempo del previsto per essere completata in modo esaustivo.

#### Azioni correttive:
- Pianificare attività di documentazione e preparazione della relazione più realisticamente nei prossimi sprint.
- Assicurarsi di rispettare i tempi stabiliti per le cerimonie Scrum per migliorare la comunicazione e la pianificazione.

#### Dettagli aggiuntivi:
- Nel terzo sprint, il progetto si arricchisce con l'implementazione della classe `Score` per la gestione del punteggio. La classe `GUI` viene migliorata con l'aggiunta dei pulsanti per start, pausa e restart. Il controller gestisce anche il game over, portando così alla conclusione dei lavori di sviluppo con questo sprint.


