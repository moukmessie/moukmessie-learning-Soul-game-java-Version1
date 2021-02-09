package lsg.consumables.drinks;


import lsg.consumables.Consumable;
import lsg.characters.Character;

public class Drink extends Consumable {

    public Drink(String name, int capacity) {
        super(name, capacity, Character.STAM_STAT_STRING);
    }

}





