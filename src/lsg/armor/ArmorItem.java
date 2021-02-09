package lsg.armor;

/**
 * Class ArmorItem
 */
public class ArmorItem {
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


}
