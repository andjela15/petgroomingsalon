Pet Grooming Salon

Ovo je ispitni projekat iz predmeta koji obuhvata rad sa relacionom bazom podataka, backendom i frontendom.
Tema projekta je aplikacija za pet grooming salon. Aplikacija omogućava evidenciju vlasnika, njihovih ljubimaca i termina za grooming usluge.

Korišćene tehnologije
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- HTML
- CSS
- Vanilla JavaScript

Opis projekta
Aplikacija služi za upravljanje osnovnim podacima u pet grooming salonu.
Korisnik može da:
- dodaje vlasnike
- pregleda listu vlasnika
- menja podatke o vlasnicima
- briše vlasnike
- dodaje ljubimce
- pregleda listu ljubimaca
- menja podatke o ljubimcima
- briše ljubimce
- dodaje termine
- pregleda listu termina
- menja termine
- briše termine

Baza podataka
U projektu se koristi relaciona MySQL baza podataka.
Baza sadrži tri tabele:
vlasnik
Tabela vlasnik čuva podatke o vlasnicima ljubimaca.
Kolone:
- vlasnik_id
- ime
- prezime
- telefon
- email
ljubimci
Tabela ljubimci čuva podatke o ljubimcima.
Kolone:
- ljubimac_id
- ime
- vrsta
- rasa
- starost
- vlasnik_id

termini
Tabela termini čuva podatke o zakazanim terminima.
Kolone:
- termin_id
- datum_vreme
- usluga
- status
- napomena
- ljubimac_id

Relacije u bazi
U bazi postoje relacije između tabela:

- jedan vlasnik može imati više ljubimaca
- jedan ljubimac može imati više termina

Relacije su ostvarene pomoću stranih ključeva:

- `ljubimci.vlasnik_id` povezuje tabelu `ljubimci` sa tabelom `vlasnik`
- `termini.ljubimac_id` povezuje tabelu `termini` sa tabelom `ljubimci`

Backend
Backend je urađen u Spring Boot-u.

Za svaku tabelu postoje:
- model klasa
- repository
- service
- controller

Implementirane su CRUD operacije za:
- vlasnike
- ljubimce
- termine

Primer ruta:

```text
GET    /api/vlasnici
POST   /api/vlasnici
PUT    /api/vlasnici/{id}
DELETE /api/vlasnici/{id}

GET    /api/ljubimci
POST   /api/ljubimci
PUT    /api/ljubimci/{id}
DELETE /api/ljubimci/{id}

GET    /api/termini
POST   /api/termini
PUT    /api/termini/{id}
DELETE /api/termini/{id}
