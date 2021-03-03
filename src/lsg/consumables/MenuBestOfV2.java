package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.HashSet;

public class MenuBestOfV2 {
    /**
     * Qu’est-il précisé à propos de l’itération ?
     * Il ne donne aucune garantie quant à l'ordre
     * d'itération de l'ensemble; en particulier,
     * il ne garantit pas que l'ordre restera constant dans le temps.
     * Cette classe autorise l' élément nul .
     */
    java.util.HashSet<Consumable>menu;

    public MenuBestOfV2() {

        menu = new HashSet<>();

        menu.add(new Hamburger());
        menu.add(new Wine());
        menu.add(new Americain());
        menu.add(new Coffee());
        menu.add(new Whisky());

    }

    @Override
    public String toString() {
        String Menu= getClass().getSimpleName()+" : \n";
        int i=1;
        for(Consumable c : menu){
            Menu+= i + " : " + c.toString() +"\n";
            i++;
        }
        return Menu;
    }

    public static void main(String[] args){System.out.println(new MenuBestOfV2());}
}
