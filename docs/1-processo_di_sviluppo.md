## Processo di Sviluppo Adottato

Il processo di sviluppo adottato è ispirato a SCRUM, scelto in conformità alle linee guida del corso per gestire il progetto in maniera agile secondo le best practice del Project Management.

### Ruoli

Nella fase iniziale del processo, sono stati definiti i seguenti ruoli:

1. **Sozio Diego**: Product Owner, responsabile di supervisionare l'andamento del progetto nonché del coordinamento del team di sviluppo.
2. **Venturi Matteo**: Scrum Master, figura cruciale per garantire che il team Scrum lavori in modo efficace, seguendo i principi e le pratiche di Scrum.

### Cerimonie

Le tipologie di cerimonie utilizzate nel progetto sono le seguenti:

1. **Initial Planning**
    - **Descrizione:** Questo meeting viene svolto all'inizio del progetto e coinvolge tutti i membri del team.
    - **Obiettivo:** Definire il Product Backlog, che include tutti i requisiti del progetto, e stabilire gli obiettivi per lo sprint iniziale.

2. **Sprint Planning**
    - **Descrizione:** Meeting di pianificazione della durata di circa un'ora, svolto all'inizio di ogni sprint (ogni Lunedì) e coinvolge tutti i membri del team.
    - **Obiettivo:** Selezionare gli item dal Product Backlog che verranno sviluppati durante lo sprint e definire le attività necessarie per raggiungere gli obiettivi dello sprint, decomponendo gli items selezionati in task.

3. **Daily Scrum**
    - **Descrizione:** Meeting giornaliero della durata di circa 15-30 minuti, svolto dal Martedì al Venerdì e coinvolge tutti i membri del team.
    - **Obiettivo:** Tenere aggiornato il team sullo stato di avanzamento del progetto e individuare eventuali difficoltà incontrate dai membri del team.

4. **Sprint Review**
    - **Descrizione:** Meeting di revisione della durata di circa un'ora, svolto alla fine di ogni sprint e coinvolge tutti i membri del team.
    - **Obiettivo:** Valutare il lavoro svolto durante lo sprint e individuare eventuali miglioramenti da apportare al processo di sviluppo.

### Principali tecnologie e metodi di sviluppo

#### Trello

Per la realizzazione del Product Backlog e per la gestione delle attività da svolgere, è stato deciso di utilizzare Trello, uno strumento basato su Kanban che agevola la gestione del progetto.

#### Gestione operativa dei tasks

Ad ogni Sprint Planning, vengono selezionati gli item dal Product Backlog che verranno sviluppati, e vengono creati i task necessari per lo sviluppo di ogni item tramite decomposizione. Per i task più importanti vengono assegnati dei membri del team responsabili dello sviluppo fin da subito, mentre quelli meno importanti vengono lasciati senza assegnatario e possono essere auto-assegnati dai membri del team che hanno già completato i propri task.

#### Label di Trello

Sono state utilizzate le label di Trello per identificare le macro-aree ricoperte dai vari task. In particolare, sono state identificate le seguenti:

- **C.I.:** Continuous Integration
- **Docs:** Documentazione
- **Scrum:** Processo di sviluppo
- **Code:** Implementazione di codice
- **Test:** Testing

#### Stima della Durata dei Task

Per la gestione della stima della durata dei task sono state sfruttate le label di Trello. In particolare, sono state identificate le seguenti label:

- **1h:** Task che richiede 1 ora di lavoro
- **2h:** Task che richiede 2 ore di lavoro
- **4h:** Task che richiede 4 ore di lavoro
- **8h:** Task che richiede 8 ore di lavoro
- **12h:** Task che richiede 12 ore di lavoro

Nel caso in cui un task non rientri in nessuna delle stime sopra indicate, la durata viene arrotondata per eccesso alla stima più vicina. Inoltre, qualora un task richieda più di 12 ore di lavoro, viene suddiviso in più parti, in modo da avere task il più semplici possibili.

### Utilizzo di GitHub

Per quanto riguarda l'utilizzo di GitHub, è stato deciso di adottare il modello GitFlow, che prevede l'utilizzo di diversi branch per la gestione del codice sorgente.

In particolare, sono stati definiti i seguenti branch stabili:

- **main:** Branch principale, contiene il codice stabile.
- **develop:** Branch di sviluppo, contiene il codice in fase di sviluppo.

Successivamente, è stato deciso di utilizzare la convenzione di denominazione dei branch proposta da GitFlow, che prevede l'utilizzo dei seguenti prefissi:

- **feature-\<featureName\>:** Branch per lo sviluppo di una feature.
- **release-\<releaseName\>:** Branch per la produzione di una release.
- **hotfix-\<hotfixName\>:** Branch per la correzione di un bug qualora si verifichi in produzione.

### Testing

Per garantire la correttezza delle funzionalità sviluppate, è stato adottato l'approccio del Test Driven Development (TDD) che prevede tre passaggi principali:

1. **Scrittura di un Test:** inizialmente si scrive un test che descrive il comportamento desiderato del componente o della funzionalità che si sta sviluppando. Questo test deve fallire dato che il componente o la funzionalità non è stata ancora implementata.
2. **Implementazione:** successivamente, si procede con l'implementazione del componente o della funzionalità in modo da far superare il test precedentemente scritto.
3. **Refactoring:** dopo aver fatto passare il test, sarà possibile apportare eventuali miglioramenti al codice, refattorizzandolo per renderlo più pulito e meglio comprensibile. È importante che il test continui a passare anche dopo il refactoring.

### Building

Ho scelto SBT perché è uno strumento versatile e potente per la gestione dei progetti Scala. Offre una serie di vantaggi, tra cui:

- Gestione delle dipendenze semplificata.
- Compilazione e test integrati.
- Generazione automatica della documentazione.
- Build automatizzate per la distribuzione.
- Integrazione continua con altri strumenti.
- Estensibilità attraverso una vasta gamma di plugin.

In sintesi, SBT offre una solida infrastruttura per lo sviluppo di progetti Scala, rendendo la gestione delle dipendenze, la compilazione del codice e la generazione della documentazione più efficienti e intuitive.

### Code Quality

#### ScalaTest

ScalaTest è un framework di testing per Scala che offre un'ampia gamma di stili di test, dai classici test unitari ai test di integrazione più complessi. Con ScalaTest, puoi scrivere test espressivi e ben strutturati utilizzando una varietà di stili come FunSuite, FlatSpec, WordSpec e molti altri. Grazie alla sua sintassi intuitiva e flessibile, ScalaTest semplifica il processo di scrittura e esecuzione dei test, consentendoti di verificare facilmente il comportamento del tuo codice e garantire la sua correttezza. Troviamo tra gli aspetti positivi:

- **Sintassi Intuitiva:** ScalaTest offre una sintassi intuitiva e flessibile che rende la scrittura dei test un'attività piacevole e accessibile.
- **Diversi Stili di Test:** Con ScalaTest, puoi scegliere tra una varietà di stili di test, ognuno progettato per adattarsi alle esigenze specifiche del tuo progetto.
- **Espressività:** I test scritti con ScalaTest sono espressivi e leggibili, consentendo di comunicare facilmente l'intento del test.
- **Facilità d'Uso:** ScalaTest semplifica il processo di scrittura, esecuzione e manutenzione dei test, riducendo al minimo lo sforzo richiesto per verificare il comportamento del codice.

### CI/CD

GitHub Actions è una piattaforma di automazione integrata direttamente in GitHub, progettata per semplificare e automatizzare il processo di sviluppo del software. Consente di eseguire una serie di attività, come build e test, direttamente dal tuo repository GitHub.

#### Caratteristiche Principali

- **Integrazione con GitHub:** GitHub Actions è completamente integrato in GitHub, il che significa che puoi gestire facilmente i tuoi workflow di automazione direttamente dal tuo repository GitHub.
- **Flussi di Lavoro Configurabili:** Puoi definire flussi di lavoro personalizzati utilizzando file YAML, che specificano le azioni da eseguire e i trigger che attivano tali azioni.
- **Ampia Libreria di Azioni:** GitHub Actions offre una vasta libreria di azioni predefinite che puoi utilizzare per eseguire una varietà di compiti.
- **Integrazione con l'Ecosistema GitHub:** GitHub Actions si integra perfettamente con altre funzionalità di GitHub, come le notifiche, le issue e i commenti nelle pull request.
- **Scalabilità e Flessibilità:** Puoi configurare flussi di lavoro complessi e scalabili con GitHub Actions, adattandoli alle esigenze del tuo progetto.

### Documentazione

Per quanto riguarda la documentazione del progetto è stata costruita una pagina web navigabile

Lo sprint backlog di questo progetto è visionabile [qui](sprint-backlog.md).
