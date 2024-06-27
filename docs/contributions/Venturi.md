# Venturi Matteo


Entrando nel dettaglio del lavoro svolto dal singolo membro del team, tratteremo in questo momento le parti prevalentemente svolte da Matteo tenendo comunque a mente che il software in virtù dell'esiguo nucleo di progetto è stato svolto in parte con la tecnica del pair programming

## Struttura di progetto
Ho creato la struttura base del progetto, organizzato il codice sorgente in due moduli (snake e snake-gui) così da marcare la separazione tra UI e parti di controller e dominio e incluso le librerie necessarie allo sviluppo e al testing.

## View
Ho implementanto il primo prototipo di view durante la prima sprint, in modo da avere a disposizione una prima versione embrionale della UI. La UI in questa prima versione mostrava semplicemente il serpente e l'ambiente in cui si muoveva.

## Controller
Con diverse iterazioni, ho implementato la parte di controller Environment, con relativi unit test, che si occupa di gestire l'ambiente del gioco, incorporando le necessarie strutture dati, pilotare il serpente e incapsulare la logica di punteggio e di aggiunta del cibo.

## Dominio
Ho implementato l'entità Snake, con relativi unit test, che incapsula le logiche di movimento del serpente, accrescimento del corpo successivamente alla cattura del cibo, logica di gameover e le strutture dati relative.
Ho partecipato come reviewer allo sviluppo dell'entità Score che incapsula la storicizzazione e il reperimento del punteggio.

## Test
Ho partecipato alle fasi di test dell'applicativo durante tutte le sprint di sviluppo.