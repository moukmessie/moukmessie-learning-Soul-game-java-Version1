package lsg.consumables;

import lsg.bags.Collectible;

public class Consumable implements Collectible {

    private  String name;
    private int capacity;
    private String stat;

    /**
     *
     * @param name
     * @param capacity
     * @param stat
     */
    public Consumable(String name, int capacity, String stat) {
        this.name = name;
        this.capacity = capacity;
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStat() {
        return stat;
    }

    @Override
    public String toString() {
        return    getName() +  "[" + getCapacity() + " " + getStat() +" "+"point(s)]"  ;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *
     * @return la valeur totale de la capacity puis met capacity a zéro
     */

    public int use(){
        int totalCapacity=0;
       if(capacity>0){
        totalCapacity = capacity;
       }
       capacity = 0;
        return totalCapacity;

    }
private final int collect = 1;
    /**
     * implementation de la methode l'interface Collectible retourne
     * un entier correspondant	 au	 nombre	 de	 kilos du
     * collectable.
     * @return collect (constant 3kg)
     */
    @Override
    public int getWeigth() {
        return collect;
    }
}
