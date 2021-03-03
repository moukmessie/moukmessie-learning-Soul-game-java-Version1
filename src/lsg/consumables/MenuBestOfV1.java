package lsg.consumables;


import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.Arrays;


public class MenuBestOfV1  {


    private static int MAX_TAILLE = 5;
    private Consumable[] menu ;

    public MenuBestOfV1() {

        menu = new Consumable[MAX_TAILLE];

        menu[0] = new Hamburger();
        menu[1] = new Wine();
        menu[2] = new Americain();
        menu[3] = new Coffee();
        menu[4] = new Whisky();
    }

    @Override
    public String toString() {
       String Menu= "MenuBestOfV1 : \n";
    int i=1;
       for(Consumable c : menu){
          Menu+= i + " : " + c.toString() +"\n";
          i++;
       }
       return Menu;
    }

    public static void main(String[] args){System.out.println(new MenuBestOfV1());}

}
