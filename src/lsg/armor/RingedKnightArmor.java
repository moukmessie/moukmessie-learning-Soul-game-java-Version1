package lsg.armor;

public class RingedKnightArmor extends ArmorItem {
    public static String name="Ringed Knight Armor";

    public RingedKnightArmor(){super(name, (float) 14.99);}

    public static void main(String[] args){
        System.out.println(new RingedKnightArmor());
    }
}
