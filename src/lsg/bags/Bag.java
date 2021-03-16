package lsg.bags;

import java.util.Arrays;
import java.util.HashSet;

public class Bag {
    private final int capacity;//capacity of bag
    private int weight; //	entier	correspondant	au	nombre	de	kilos « utilisés »
    private HashSet<Collectible>items; //

    /**
     *
     * @param capacity
     */
    public Bag( final int capacity) {

        this.capacity = capacity;
       // items=new HashSet<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Permet d'ajouter un item dans le sac
     * @param item
     */
    public void push(Collectible item){
        while ((getCapacity() > (weight+item.getWeigth()))) {
          items.add(item);
          weight=weight+item.getWeigth();
        }

    }

    /***
     * 	retire	un	item	du	sac
     * @param item
     * @return l'item retiré sinon return null
     */
    public Collectible pop(Collectible item){
       while (getCapacity() > (weight+item.getWeigth())) {
           if (items.contains(item)) {
               items.remove(item);
               return item;
           }
           weight=weight+item.getWeigth();
       }
       return null;
    }

    /**
     * indique	 si	l’item
     * passé	en	paramètre	se	trouve	bien	dans	le	sac
     * @param item
     * @return true or false
     */
    public boolean contains(Collectible item){
        return items.contains(item);
    }

    /**
     * 	retourne	un	tableau	contenant	les	items	du
     * sac
     * @return the array
     */
    public Collectible[] getItems(){
        Collectible arr[]= new Collectible[items.size()];
        //toArray method convert the items to array
        items.toArray(arr);

       /** //2 method
        int i=0;
        for(Collectible item : items){
            arr[i++]=item;
        }*/

        return arr;
    }

    /***
     *
     * @return le contenu du sac on	affichera	« ∙ empty »	si	le	sac	est	vide
     */

    @Override
    public String toString() {
        int size = items.size();
        String msg = getClass()+" [ "+ size + " | "+ getWeight() + "/"+getCapacity()+"\n";

          if(size != 0){
                msg+= " "+ Arrays.toString(this.getItems()) +"["+getWeight()+"kg]" + "\n";
              /* for(Collectible item : items){
                msg+= " "+item.toString() + "["+getWeight()+"kg]" + "\n";
            }*/
          }else {
              msg+="(empty)";
          }
        return msg;
    }

    /**
     * 	transfère	le	contenu	du	sac	source	dans	le	sac	de	destination	dans
     * la	limite	de	la	capacité de	ce	dernier.
     * Les	items	qui	n’ont	pas	pu	être	 transféré
     * restent	dans	le	sac	source
     * @param from
     * @param into
     */
    public static void transfer(Bag from, Bag into){
       while (from.getCapacity()< into.getCapacity()){
           into.items= from.items;
       }

    }

}
