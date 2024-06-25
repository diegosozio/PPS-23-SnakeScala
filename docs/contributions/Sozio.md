# Sozio Diego

Entrando nel dettaglio del lavoro svolto dal singolo membro del team, tratteremo in questo momento le parti prevalentemente svolte da Diego tenendo comunque a mente che il software in virtù dell'esiguo nucleo di progetto è stato svolto in parte con la tecnica del pair programming 

## View 
Personalmente per declinazione personale a causa della mia esperienza lavorativa come sviluppatore frontendista mi sono occupato principalmente dell'interfaccia grafica dove in particolare ho implementato i comportamenti di: 
- Calcolo di Score crescente a seguito della consumazione di un cibo da parte del serpente 
- Implementazione della visualizzazione dello stato del gioco 
- Implementazione del bottone Start 
- Implementazione del Bottone Restart
- Implementazione delle logiche di MaxScore 
- Implementazione dei Test per il componente core Score 

## Testing 
Personalmente mi sono occupato della scrittura della Test Suite del componente core denominato Socre 

## Build Automation 
Entrambi i membri del team hanno concordato sulla scelta di utilizzare SBT come strumento di build automation. 
Io mi sono occupato di scrivere il file di configurazione build.sbt di SnakeGameGui, definendo le dipendenze del progetto e le regole per determinare la corretta versione delle librerie utilizzate.

## Documentazione e Github Action 
Mi sono assunto il compito di redigere e gestire la documentazione del progetto in modo efficace e efficiente. Per rendere questo processo più fluido e automatizzato, ho configurato GitHub Actions. Questo strumento è stato utilizzato per eseguire automatizzazioni e flussi di lavoro che garantiscono la coerenza e la precisione della documentazione.

Con GitHub Actions, ho implementato procedure automatizzate per:

1. **Build e Deploy della Documentazione**: Ho configurato flussi di lavoro che si attivano ogni volta che vengono apportate modifiche alla documentazione nel repository. Questi flussi di lavoro eseguono la generazione automatica della documentazione, garantendo che sia sempre aggiornata rispetto all'ultima versione del codice.

2. **Gestione delle Versioni della Documentazione**: Utilizzando GitHub Actions, ho implementato meccanismi per gestire le versioni della documentazione. Questo include la generazione di documentazione per versioni specifiche del software e la corretta archiviazione delle versioni precedenti.

L'uso di GitHub Actions ha migliorato significativamente l'efficienza del nostro team nello sviluppo e nella manutenzione della documentazione del progetto. Ha ridotto il carico manuale, migliorato la coerenza e ha permesso al team di concentrarsi maggiormente sullo sviluppo del software senza compromettere la qualità della documentazione.



[Torna all'implementazione](../5-implementazione.md)