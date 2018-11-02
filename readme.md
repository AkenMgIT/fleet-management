# Fleet management

## Features/User Stories
- User can add Car [ok]
    - with selected Brand [ok]
- User can add User [ok]
    - with selected User Type : {Driver,Customer} [ok]
- User can add Activity [ok]
    - with selected car [ok]
    - with selected driver [ok]
    - calculate disponibility from car and driver
- User can see car: activities
- User can see user(Owner): activities
- User can see user(Driver): activities
- User can see Calendar of activities by week
    - send JSON to javascript 
    - http://docs.dhtmlx.com/scheduler/

## Bugs:
- rename object to "item" / object list to "list" in following views:
    - cars 
    - brands 
- rename object to "entity" in following classes:
    - cars service
    - brands service

## Algorithme:
<pre>
case 01:
    schedule target:
        - start: 08:00
        - end: 08:30
    schedule existant:
        - start: 09:00
        - end: 10:00
    resultat:
        - [valid] 
case 02:
    schedule target:
        - start: 08:00
        - end: 09:00
    schedule existant:
        - start: 09:00
        - end: 10:00
    resultat:
        - [valid] car la fin de (A) est egale au debut de (B)
case 03:
    schedule target:
        - start: 09:00
        - end: 09:30
    schedule existant:
        - start: 09:00
        - end: 10:00
    resultat:
        - [invalid] car la fin de (A) se trouve dans (B)
case 04:
    schedule target:
        - start: 09:30
        - end: 11:00
    schedule existant:
        - start: 09:00
        - end: 10:00
    resultat:
        - [invalid] car le debut de (A) est se trouve dans (B)
case 05:
    schedule target:
        - start: 10:30
        - end: 11:00
    schedule existant:
        - start: 09:00
        - end: 10:00
    resultat:
        - [valid]
</pre>