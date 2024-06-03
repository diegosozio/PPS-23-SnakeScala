# Introduzione

### Snake in Scala

Il gioco Snake implementato in Scala è un'interpretazione del classico gioco arcade in cui il giocatore controlla un serpente che si muove all'interno di una griglia, cercando di mangiare il cibo per crescere. Il gioco termina se il serpente colpisce se stesso o i bordi della griglia. Utilizzando Scala, il movimento del serpente e la gestione del cibo sono implementati in modo funzionale, offrendo un'esperienza coinvolgente e semplice.

(img/logo.png)

### Obiettivo del Gioco

Nel gioco, il giocatore controlla un serpente che si muove all'interno di una griglia. L'obiettivo primario è far crescere il serpente mangiando il cibo che appare casualmente sulla griglia. Ogni volta che il serpente mangia il cibo, diventa più lungo. Il gioco termina se il serpente colpisce se stesso o i bordi della griglia.

### Meccaniche di Gioco

#### Movimento del Serpente

Il serpente si muove continuamente in una direzione e il giocatore può controllare la direzione del movimento usando le frecce direzionali. Il serpente può muoversi su, giù, sinistra e destra. Il giocatore deve evitare che il serpente colpisca i bordi della griglia o il proprio corpo.

##### Crescita del Serpente

Ogni volta che il serpente mangia il cibo, cresce di una unità. Il cibo appare un'unità alla volta in posizioni casuali sulla griglia e scompare una volta mangiato. Il punteggio del giocatore aumenta, nasce inizializzato a 0 e ad ogni pezzo di cibo mangiato aumenta di 1 unità.

##### Collisione

Il gioco termina se il serpente collide con se stesso o con i bordi della griglia. In tal caso, il punteggio finale del giocatore viene mostrato e il giocatore può scegliere di ricominciare il gioco.

### Obiettivo del Gioco

L'obiettivo finale di Snake è ottenere il punteggio più alto possibile facendo crescere il serpente il più lungo possibile. Man mano che il serpente cresce, il gioco diventa progressivamente più difficile aumentando la velocità ogni 5 mele mangiate. Questo richiede maggiore abilità e attenzione da parte del giocatore.

### Scambio di Risorse

Nella versione di Snake, non c'è una componente di scambio di risorse, ma il concetto di gestione delle risorse è rappresentato dal cibo che il serpente deve consumare per crescere. Il giocatore deve strategicamente muovere il serpente per raccogliere il cibo senza andare a sbattere contro se stesso o i bordi della griglia. Questo aggiunge un elemento di pianificazione e gestione spaziale al gioco.
