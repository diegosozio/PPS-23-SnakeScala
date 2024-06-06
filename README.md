## SnakeScala

SnakeScala è un'implementazione del classico gioco del serpente scritta in Scala. Il gioco è stato sviluppato per essere eseguito sulla JVM e utilizza la libreria grafica Swing per l'interfaccia utente.

## Funzionalità

- Interfaccia utente semplice e intuitiva.
- Controllo del serpente tramite tastiera.
- Meccanismo di punti per tenere traccia del punteggio.
- Incremento della velocità del serpente man mano che mangia cibo.
- Gestione del game over quando il serpente colpisce i bordi del campo di gioco o si morde da solo.

## Installazione

1. Assicurati di avere Java Development Kit (JDK) installato sul tuo sistema.
2. Clona il repository SnakeScala sul tuo computer:

    ```bash
    git clone https://github.com/diegosozio/PPS-23-SnakeScala.git
    ```

3. Entra nella directory SnakeScala:

    ```bash
    cd SnakeScala
    ```

4. Compila il codice sorgente utilizzando sbt (Scala Build Tool):

    ```bash
    sbt compile
    ```

5. Esegui il gioco:

    ```bash
    sbt run
    ```

## Utilizzo

- Avvia il gioco eseguendo il file JAR o utilizzando sbt come indicato sopra.
- Usa le frecce direzionali per controllare il movimento del serpente.
- Mangia il cibo per ottenere punti e aumentare la lunghezza del serpente.
- Evita di colpire i bordi del campo di gioco o di morderti da solo, altrimenti perderai.
