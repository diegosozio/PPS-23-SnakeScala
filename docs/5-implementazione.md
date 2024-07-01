# Implementazione

In questo capitolo vengono descritte le scelte implementative adottate per la realizzazione del progetto. In particolare, si analizzano le tecnologie impiegate, la suddivisione del lavoro e le decisioni progettuali prese.

## Tecnologie

Il progetto è stato sviluppato utilizzando tecnologie moderne e potenti, selezionate per garantire un'esperienza utente fluida e una gestione efficiente dei dati. Le principali tecnologie impiegate sono descritte nei paragrafi seguenti.

### Scala

Scala è stato scelto come linguaggio principale di sviluppo per il progetto, rivelandosi fondamentale per il successo e l'efficienza del sistema. Unendo il paradigma di programmazione orientata agli oggetti con quello funzionale, Scala offre una sintassi flessibile ed espressiva che rende il codice conciso e altamente leggibile. Questa combinazione di caratteristiche rende Scala particolarmente adatto per lo sviluppo di applicazioni complesse e scalabili.

### ScalaTest
ScalaTest è stato scelto come libreria di testing per il progetto, rivelandosi fondamentale per garantire l'affidabilità e la qualità del sistema. Grazie alla sua sintassi chiara e intuitiva, ScalaTest permette di scrivere test in modo semplice e veloce, facilitando l'adozione della pratica del Test-Driven Development (TDD). Questa caratteristica, insieme alla flessibilità di supportare diversi stili di testing come spec-based, behavior-driven e object-oriented, rende ScalaTest una scelta ideale per progetti complessi. Inoltre, l'integrazione con strumenti di build come sbt, Maven e Gradle semplifica l'automazione dei test e l'integrazione continua, mantenendo alta la qualità del software. La ricca libreria di matcher di ScalaTest consente di esprimere aspettative sui risultati dei test in modo chiaro e preciso, migliorando la leggibilità e la manutenzione del codice di test. L'estensibilità di ScalaTest permette di creare nuovi matcher, fixture e stili di test personalizzati, adattandosi alle esigenze specifiche del progetto. Infine, il supporto per il testing asincrono rende ScalaTest particolarmente utile per applicazioni moderne che fanno largo uso di operazioni asincrone. Queste combinazioni di caratteristiche rendono ScalaTest uno strumento indispensabile per garantire un processo di testing robusto ed efficace, migliorando la qualità complessiva del software.

#### Code Coverage e Testing:
Durante lo sviluppo del progetto SnakeScala, abbiamo adottato il Test Driven Development (TDD) come pratica principale. Attraverso questo approccio, abbiamo sviluppato test automatizzati che stimiamo coprano più del 90% del codice relativo ai modelli Model e ai Controller. Questi test ci hanno fornito una sicurezza maggiore nella stabilità e nel comportamento delle componenti fondamentali del gioco.

È importante notare che non abbiamo esteso la copertura dei test alla parte di GUI del progetto. Questo perché il testing della GUI richiederebbe l'uso di framework specifici come Cypress o Playwright, i quali sono più adatti per testare l'interazione utente e la presentazione grafica dell'applicazione. Tuttavia, ci siamo concentrati con dedizione sulla copertura dei test delle parti core del gioco Snake, inclusi il movimento del serpente, la gestione della collisione, la logica di gioco e altre funzionalità essenziali.

Questo approccio ci ha permesso di mantenere un alto standard di qualità nel codice sviluppato, garantendo che le funzionalità principali del gioco siano robuste e affidabili. Guardando al futuro, consideriamo l'eventuale integrazione di framework specifici per il testing della GUI per migliorare ulteriormente la qualità complessiva dell'applicazione, mentre continuamo a espandere e migliorare SnakeScala con nuove funzionalità e ottimizzazioni.


## Suddivisione del Lavoro

Durante l'intero progetto, abbiamo sempre cercato di suddividere il lavoro in modo equo, sfruttando al meglio le competenze di ciascun membro del team ed evitando che uno dovesse assumere un carico di lavoro maggiore rispetto all'altro. Essendo un gruppo composto da soli due membri, è stato difficile assegnare aree dell'applicazione esclusivamente a un singolo individuo, poiché abbiamo collaborato intensamente su quasi tutti i componenti.

Nonostante la forte collaborazione, è possibile identificare alcune aree in cui un membro ha avuto un ruolo più preminente rispetto all'altro. Tuttavia, l'approccio collaborativo ha assicurato che entrambi contribuissero in modo significativo a tutte le parti del progetto. In Particolare Matteo Venturi essendo uno sviluppatore con decennale esperienza si è occupato principalmente della fase di sviluppo con la forma del pair programming mentre Sozio Diego, coprendo quotidianamente le attività di PO, analista funzionale e QA su differenti ambiti applicativi si è occupato di orchestrare le attività di sviluppo e redigere la relazione sotto la legida supervisione di Matteo. 

Possiamo comunque identificare aree di impatto del singolo componente del team: 

Sozio Diego [qui](contributions/Sozio.md)
Venturi Matteo [qui](contributions/Venturi.md)




