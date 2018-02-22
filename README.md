## Konkurentné programovanie: 2. projekt
## SOAP webservice (od WSDL ku kódu)

Ako zadanie druhého projektu som si vybrala implementáciu operácie
```
Vytvorenie nového cvičenia. Vstupom je názov predmetu. Návratovou hodnotu je jednoznačný identifikátor UUID.
```

### Inštrukcie

* Softvérové požiadavky: Java JDK version 1.8.0_121, Google Chrome verzia 64.0, projekt bol vytvorený v Eclipse Java Neon 4.6.2
* V projekte sa používa MySQL databáza, ktorú je nutné vytvoriť pomocou súboru KOPR_AJS/db.sql (skript do databázy vloží aj testovacie dáta)
* Prístup k databáze (= vlastného používateľa) je nutné nastaviť v triede KOPR_AJS/src/ajs/x/ObjectFactory.java (MysqlDataSource)
* WSDL súbor pomocou ktorého bol generovaný kód sa nachádza v KOPR_AJS/src/AJS.wsdl, klient a server boli generované pomocou príkazov v KOPR_AJS/cmd.txt
* Testovacia trieda sa nachádza v KOPR_AJS/src/test/MysqlCvicenieDaoTest.java
* Server - všetky triedy sa nachádzajú v KOPR_AJS/src/ajs/x
* Klient - všetky triedy sa nachádzajú v KOPR_AJS/src/ajs/y
* Klienta je možné otestovať spustením servera (KOPR_AJS/src/ajs/x/Server.java) a následne klienta (KOPR_AJS/src/ajs/y/Client.java) - ak požiadavku spustíme dvakrát, je vyhodená výnimka
