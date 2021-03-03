package lsg.armor;

import lsg.bags.Collectible;

/**
 * Class ArmorItem
 */
public class ArmorItem implements Collectible {
    public String name;//attribut qui  contiendra le nom de la pièce(fixé lors de l’instanciation)
    public  float armorValue;//contenant la valeur d’armure de l’item

    /**
     * accesseur	public en	lecture de l'attribut name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * accesseur	public en	lecture de l'attribut armorValue
     * @return
     */
    public float getArmorValue() {
        return armorValue;
    }

    /**
     * Un constructeur à 2 paramètres permettant de nommer et fixer la valeur
     * d’armure d’une pièce lors de son instanciation
     * @param name
     * @param armorValue
     */
    public ArmorItem(String name,float armorValue) {
        this.name = name;
        this.armorValue=armorValue;
    }


    /**
     * Une surcharge de la méthode toString qui renvoie une chaine
     * @return
     */

    @Override
    public String toString() {
        return getName() + "(" + getArmorValue() + ")";
    }

 private final int colect = 4;

    /**
     * implementation de la methode l'interface Collectible retourne
     * un entier correspondant	 au	 nombre	 de	 kilos du
     * collectable.
     * @return collect (constant 3kg)
     */
    @Override
    public int getWeigth() {
        return colect;
    }

}
