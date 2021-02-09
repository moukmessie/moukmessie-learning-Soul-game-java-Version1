package lsg.consumables;

public class Consumable {

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

}
