# Design di dettaglio

Questo capitolo illustra nel dettaglio il design del sistema SnakeScala. Il sistema si compone di 3 package i quali vengono discussi nei paragrafi che
seguono: `model`, `controller` e `view`.


## Model

Questo package contiene le classi che rappresentano le entità del gioco SnakeScala, le quali rispecchiano il modello di
dominio definito in fase di raccolta dei requisiti.

## Controller

In questo package sono presenti le classi che si occupano di gestire le interazioni tra l'utente e il sistema, in modo
da garantire la corretta esecuzione delle operazioni richieste.

Nel rispetto del pattern architetturale MVC, i controller sono stati progettati per reagire alle interazioni dell'utente
con l'interfaccia grafica, per poi richiamare le opportune funzioni della logica di business.

## View

In questo package sono presenti le classi che si occupano di costruire e gestire l'interfaccia utente, in modo da
garantire una corretta visualizzazione delle pagine e delle informazioni. In particolare, tali classi sono state
progettate per reagire alle interazioni dell'utente con la GUI, per poi richiamare le opportune funzioni dei controller.
