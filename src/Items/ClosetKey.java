package Items;

import People.Person;

public class ClosetKey implements Item {
    @Override
    public void pickup(Person x){
        x.pickupItem();
    }

    @Override
    public void use(Person x){

    }
}
