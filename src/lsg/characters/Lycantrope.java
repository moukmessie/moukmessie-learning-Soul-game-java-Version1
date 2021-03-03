package lsg.characters;

import lsg.weapons.Claw;

public class Lycantrope extends Monster {
    private static  String NAME = "Lycantrope";

    /**
     * constructeur initialiser
     */
    public Lycantrope() {
        super(NAME); //nom Lycantrope
        setWeapon(new Claw());// arrme
        setSkinThickness(30);//Epaisseur de la peau
    }
}
