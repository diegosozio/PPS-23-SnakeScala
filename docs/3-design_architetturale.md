## Design Architetturale

Per il gioco Snake, l'architettura scelta si basa sul pattern MVC (Model-View-Controller), che separa la logica di business dalla logica di presentazione, consentendo la modularità e la manutenibilità del codice.

![Pattern Model-View-Controller](img/mvc.png)

### Architettura MVC per Snake

L'architettura prevede tre componenti principali:

1. **Model**: Contiene la logica di business del gioco Snake, inclusi i meccanismi per gestire il movimento del serpente, la generazione del cibo e il rilevamento delle collisioni. Lo stato attuale del gioco è incapsulato all'interno del Model. Esso è progettato per essere immutabile, e può essere accessibile all'esterno solo tramite funzioni specifiche. Le modifiche allo stato avvengono tramite la funzione `update`, che prende in input un'azione e aggiorna lo stato di conseguenza.

2. **Controller**: Gestisce le interazioni dell'utente con il gioco, implementando la logica di input e di accesso al Model. I Controller ricevono input dall'utente e agiscono di conseguenza sul Model. Sono gli unici in grado di modificare lo stato del gioco. Una volta effettuata una modifica, i Controller notificano la View per aggiornare l'interfaccia grafica.

3. **View**: Si occupa di visualizzare lo stato attuale del gioco Snake e di consentire all'utente di interagire con esso tramite un'interfaccia grafica. Ogni View mantiene una copia dello stato attuale del gioco, che viene aggiornato dai Controller. Quando lo stato viene modificato, la View aggiorna l'interfaccia grafica di conseguenza per riflettere i cambiamenti.

L'architettura MVC per Snake garantisce una chiara separazione delle responsabilità e facilita la manutenzione e l'aggiornamento del codice, consentendo la modifica indipendente di ciascun componente senza influenzare gli altri.
