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

## Algorithm:
check_availablity(newEvent, eventsList){
    # eventsList already filtered by the start day of new event/vehicule/driver
    for(event : eventsList){
        if(newEvent.start < event.start 
        && newEvent.end)
    }
    return true;
}