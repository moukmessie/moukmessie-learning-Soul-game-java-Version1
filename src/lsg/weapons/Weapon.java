package lsg.weapons;

import lsg.bags.Collectible;
import lsg.consumables.repair.RepairKit;

public class Weapon implements Collectible {
	
	protected String name ;
	
	private int minDamage ;
	private int maxDamage ;
	private int stamCost ;
	private int durability ;

	public static final String DURABILITY_STAT_STRING = "durability";
	
	public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		this.name = name ;
		this.minDamage = minDamage ;
		this.maxDamage = maxDamage ;
		this.stamCost = stamCost ;
		this.durability = durability ;
	}
	
	public void use(){
		setDurability(durability-1) ; ;
	}

	/**
	 * la methode isBroken  qui renvoi un boléen indiquant si l'arme est cassée
	 * (durabibility inférieure ou égale à 0)
	 * @return
	 */
	public boolean isBroken(){
		return durability <=0 ;
	}

	/**
	 * les getters correspondants aux attributs
	 * @return
	 */
	public String getName() {
		return name;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public int getStamCost() {
		return stamCost;
	}

	public int getDurability() {
		return durability;
	}

	/**
	 * setter privé pour durabillity
	 * @param durability
	 */
	private void setDurability(int durability) {
		this.durability = durability;
	}

	/**
	 * méthode toString() surchargée pour une donner une répresentation de l'arme dans la console
	 * @return
	 */
	@Override
	public String toString() {
		return getName() + " (min:" + getMinDamage() + " max:" + getMaxDamage() + " stam:" + getStamCost() +" " +DURABILITY_STAT_STRING +":" + getDurability() + ")" ;
	}

	/**
	 *
	 * @param kit remonte la durabilité de l'arma en utilisant le use()
	 */
	public void repairWith(RepairKit kit){
		setDurability(durability + kit.use());
	}

private final int colect=2;
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
