# INF-dbp
## Aufgabe 4:
### Aufgabenstellung:
Ganz im Sinne des Undo-Redo Frameworks von SWP, sollt ihr ein Konzept ausarbeiten, welches es ermöglicht Datenbank-Operationen rückgängig zu machen. (Redo können wir derzeit vernachlässigen).

Ein einfaches Commit-Rollback reicht nicht, da das Undo nicht unbedingt in der aktuellen Session passieren muss.

Nehmt euer Repertoire an Funktionen, Trigger und was ihr sonst noch braucht um ein Konzept zu erarbeiten.

Als ersten Schritt reicht das Konzept, kann zb. als Markdown oder als pdf in euer git gepusht werden.

(Ziel ist es bei einer Webanwendung die undo-redo Funktionalität zu verwenden.)


### Konzept:
Ich würde allgemeinen mit den Grundsätzlichen Aufbei eines CommandPattern arbeiten. Ich würde einzelne Klassen erstellen, welche für die einzelnen Datenbank-Operationen was ich ausführen will steht. Diese Klassen implementieren alle das Interface ICommand mit den Mehtoden execute und undo. Über die Parameterliste werden die nötigen Daten übergeben z.B. Namen usw. für ein Create. Und wenn ich nun z.B. bei einer Klasse CreateKunde die Undo Methode Aufrufe wird ein Delete-Statement aufgerufen. Dies alles würde ich mit einem JPA kombinieren wie z.B. der Bestellung_jpa. Dadurch müsste ich in der Parameterliste nur noch einen Kunden übergeben und könnte dann execute oder undo ausführen. Sprich create Kunde bzw. delete Kunde.
