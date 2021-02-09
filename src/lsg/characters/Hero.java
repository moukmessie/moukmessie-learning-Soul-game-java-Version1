package lsg.characters;


import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.buffs.rings.Ring;

import java.util.Arrays;

public class Hero extends Character {

    private static final String DEFAULT_NAME = "Gregooninator"; // Nom par défaut
    private static final int DEFAULT_MAX_LIFE = 100; // Nombre de points de vie par défaut
    private static final int DEFAULT_MAX_STAMINA = 50; // Nombre de points d'action par défaut

    private  ArmorItem[] armor;// un tableau destiné à recevoir des pièces d'armure
    private Ring[] rings;

    private static final int MAX_ARMOR_PIECES = 3; //la taille max de pièce d'armures fixée à trois
    private static final  int MAX_RINGS = 2;
    /**
     * construteur Hero
     * @param name
     */

    public Hero(String name) {
        super(name);
        setMaxLife(DEFAULT_MAX_LIFE);
        setLife(DEFAULT_MAX_LIFE);
        setMaxStamina(DEFAULT_MAX_STAMINA);
        setStamina(DEFAULT_MAX_STAMINA);

        armor = new ArmorItem[MAX_ARMOR_PIECES];
        rings = new Ring[MAX_RINGS];

    }

    /**
     * constructeur Hero par defaut
     */
    public Hero() {
        this(DEFAULT_NAME);
    }

    /**
     * Place d' armure
     * @param item : la pièce d'armure
     * @param slot : slot à utiliser (si une pièce est utilisée, elle sera remplacée
     */
     public void SetArmorItem(ArmorItem item, int slot) {

       if (slot-1 >= 0 &&  slot-1 < MAX_ARMOR_PIECES) {
           armor[slot-1] = item;

        }

    }

    /**
     *
     * @return un tableau contenant les pièces d'armure effectivement portées
     */
        public ArmorItem[] getArmorItems(){

            //comptage du nombre de pieces portées
            int count = 0;
            for(ArmorItem item : armor){
                if(item != null) count++;
            }

            //Création et remplissage du tableau résultat
            ArmorItem[] items = new ArmorItem[count];
            int  i =  0;
            for(ArmorItem item : armor){
                if(item != null){
                    items[i]=item ;
                    i++;
                }
            }
            return items;
        }


    /**
     *
     * @return retourne un float correspondant à la somme des valeurs
     * d’armure des pièces.
     */
    public float getTotalArmor(){
         float Total=0;
         for(ArmorItem i : armor){

             /* avec condition ternaire
             Total = (i != null)? Total +i.getArmorValue() : Total;
              */

            if(i != null){
                Total += i.getArmorValue();
            }else {
                Total=Total;
            }
         }
         return Total;
    }

    /**
     * placé un anneau
     * @param ring
     * @param slot : slot a utiliser (NB: si un anneau était en place, il est remplacee)
     */
    public void setRing(Ring ring, int slot){
        if(slot-1 >= 0 && slot-1 < MAX_RINGS){
            rings[slot-1]=ring;
            ring.setHero(this);
        }
    }

    /**
     *
     * @return retourne un tableau des anneaux portées
     */
    public Ring[] getRings(){
        //comptage du nombre d'anneaux
        int count = 0;
        for(Ring ring : rings){
            if(ring != null) count++;
        }

        //création de tableau et  remplissage de celui-ci
        Ring[] result= new Ring[count];
        int i = 0 ;
        for(Ring r : rings ){
            if(r != null){
                result[i]=r;
                i++;
            }
        }
        return result;
    }



    /**
     *renvoie une chaine contenant une description formatée de
     * l’armure totale portée par le héro
     * @return la représentation de l'armure portee par le hero
     */

    /*@Override
    public String ArmorToString() {
        return "Hero{" +
                "armor=" + Arrays.toString(armor) + '}'; }*/
    public String ArmorToString() {
        String msg = "ARMOR";
        String item;

        for(int i = 0; i<MAX_ARMOR_PIECES; i++){
            /*avec condition ternaire
            item=(armor[i] != null)? armor[i].toString():"empty";

             */
            if(armor[i] != null){
                item= armor[i].toString();
            }else {
                item="empty";
            }
            msg = String.format("%s %2d:%-30s", msg, i+1, item);
        }
        return msg + "TOTAL: " + getTotalArmor();
    }

    /**
     * methode abstraite
     * @return la valeur totale des pièces d'armure
     */

   @Override
    protected float computeProtection() {
        return getTotalArmor();
    }
    /**
     *  methode abstraite
     * @return la valeur total d'anneau
     */
    @Override
    protected float computeBuff() {
       float total = 0;
       for(Ring r : rings){
           total = (r != null)? total + r.computeBuffValue() : total; //calcul la somme des valeurs d’anneaux.
       }
        return total;
    }


    /**
     * un main dans Hero (pour tester) :  instanciation  d'un héro, avec équipement, et
     * affichage des statistiques de son armure
     * @param args
     */

    public static void main(String[] args){
        Hero hero= new Hero();

        hero.SetArmorItem( new BlackWitchVeil(),1);
        hero.SetArmorItem(new RingedKnightArmor(),3);
        //hero.SetArmorItem(new DragonSlayerLeggings(),2);

        System.out.println(hero.ArmorToString());
    }


}