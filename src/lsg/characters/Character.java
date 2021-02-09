package lsg.characters;

import java.util.Locale;

import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
import lsg.helper.Dice;
import lsg.weapons.Weapon;

public abstract class Character {



	private static String MSG_ALIVE = "(ALIVE)" ;
	private static String MSG_DEAD = "(DEAD)" ;

	public   static final String LIFE_STAT_STRING = "life";
	public   static final String STAM_STAT_STRING = "stamina";
	public   static final String PRO_STAT_STRING	 = "protection";
	public   static final String BUF_STAT_STRING  = "buff";
	
	private String name ; // Nom du personnage
	
	private int maxLife, life ; 		// Nombre de points de vie restants
	private int maxStamina, stamina ;	// Nombre de points d'action restants
	
	private Weapon weapon ;
	private Consumable consumable;
	
	private Dice dice101 = new Dice(101) ;
	
	public Character(String name) {
		this.name = name ;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMaxLife() {
		return maxLife;
	}
	
	protected void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	
	public int getLife() {
		return life;
	}
	
	protected void setLife(int life) {
		this.life = life;
	}
	
	public int getMaxStamina() {
		return maxStamina;
	}
	
	protected void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}
	
	public int getStamina() {
		return stamina;
	}

	public Consumable getConsumable() {
		return consumable;
	}

	public void setConsumable(Consumable consumable) {
		this.consumable = consumable;
	}

	protected void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public boolean isAlive(){
		return life > 0 ;
	}
	
	public void printStats(){
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		
		String classe = getClass().getSimpleName() ;
		String life = String.format("%5d", getLife()) ; 
		String stam = String.format("%5d", getStamina()) ; 
		String protection = String.format(Locale.US, "%6.2f", computeProtection() );
		String buff = String.format(Locale.US, "%6.2f", computeBuff());

		//String msg = String.format("%-20s %-20s LIFE:%-10s STAMINA:%-10s PROTECTION:%-10s BUFF:%-10s",
		// "[ " + classe + " ]", getName(), life, stam, protection,buff) ;

		//String msg = String.format("%-20s %-20s"+ LIFE_STAT_STRING +":%-10s"+
		// STAM_STAT_STRING +":%-10s"+PRO_STAT_STRING +":%-10s"+BUF_STAT_STRING+":%-10s",
		// "[ " + classe + " ]", getName(), life, stam, protection,buff) ;
		String msg = String.format("%-20s %-20s %s:%-10s %s:%-10s %s:%-10s %s:%-10s", "[ " + classe + " ]",
				getName(),
				LIFE_STAT_STRING.toUpperCase() ,
				life,
				STAM_STAT_STRING.toUpperCase(),
				stam,
				PRO_STAT_STRING.toUpperCase(),
				protection,
				BUF_STAT_STRING.toUpperCase(),
				buff) ;

		String status ;
		if(isAlive()){
			status = MSG_ALIVE ;
		}else{
			status = MSG_DEAD ;
		}

		
		return msg + status ;

	}
	
	public int attack(){
		return attackWith(this.getWeapon()) ;
	}
	
	/**
	 * Calcule une attaque en fonction d'une arme.
	 * Le calcul dépend des statistiques de l'arme et de la stamina (restante) du personnage
	 * 
	 * @param weapon : l'arme utilisée.
	 * @return la valeur de l'attaque ; 0 si l'arme est cassée.
	 */
	private int attackWith(Weapon weapon){
		int min = weapon.getMinDamage() ;
		int max = weapon.getMaxDamage() ;
		int cost = weapon.getStamCost() ;
		
		int attack = 0 ;
		
		if(!weapon.isBroken()){
			attack = min + Math.round((max-min) * dice101.roll() / 100.f) ;
			int stam = getStamina() ;
			if(cost <= stam){ // il y a assez de stam pour lancer l'attaque
				setStamina(getStamina()-cost);
			}else{
				attack = Math.round(attack * ((float)stam / cost)) ;
				setStamina(0);
			}
			
			weapon.use();
		}
		
		return attack + Math.round(attack * computeBuff() / 100);

	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	/**
	 * méthode abstraite computeProtection qui renvoie un
	 * float représentant la protection du personnage.
	 *
	 * @return le nombre de points de protection du personnage
	 */
	protected abstract float computeProtection();

	/**
	 * méthode abstraite computeBuff qui renvoie un float représentant un buff qui
	 * correspond à un pourcentage qui amplifie une attaque
	 * @return
	 */
	protected abstract float computeBuff();



	/**
	 * Calcule le nombre de PV retires 
	 * @param value : le montant des degats reçus
	 * @return le nombre de PV effectivement retires (value si assez de vie ; le reste de la vie sinon)
	 */
	public int getHitWith(int value){
		int life = getLife() ;
		int dmg ;
		//Ajout de computeProtection qui calcul le pourcentage de degat subit par rapport a la protection
		float protection = computeProtection();
		if (protection > 100) protection = 100; // si la protection depasse 100, elle absorbera 100% de l'attaque
		value = Math.round(value - (value * protection / 100));

		dmg = (life > value) ? value : life ; // le if en opérateur ternaire
		setLife(life-dmg);
		return dmg ;
	}

	/**
	 * Methode qui utilise le consommable equipé par le personnage
	 */
	public void consume(){
		use(consumable);
	}

	private void drink(Drink drink){
		if(drink == null) return; ;
		System.out.println(getName() + " drinks " + drink);
		int newStam = getStamina() + drink.use() ;
		newStam = (newStam < maxStamina) ? newStam : maxStamina ;
		setStamina(newStam);
	}

	private void eat (Food food){
		if(food == null) return;
		System.out.println(getName() + " eat " + food);
		int newLife = getLife() + food.use();
		//newLife = (newLife < maxLife)? newLife : maxLife;
		if(newLife < maxLife){
			newLife = newLife;
		}else {
			newLife = maxLife;
		}
		setLife(newLife);
	}
	private void repairWeaponWith(RepairKit kit){
		if(weapon == null) return;
		System.out.println(getName() + " repairs " + weapon + " with " + kit);
		weapon.repairWith(kit);
	}

	/**
	 * L' opérateur java instanceof est utilisé pour tester si l'objet est une instance
	 * du type spécifié (classe ou sous-classe ou interface).
	 *
	 * L'instance de java est également connue sous le nom d' opérateur de comparaison
	 * de type car elle compare l'instance avec le type. Il renvoie vrai ou faux.
	 * Si nous appliquons l'opérateur instanceof à une variable qui a une valeur nulle,
	 * il retourne false.
	 *
	 * @param consumable
	 */

	public void use(Consumable consumable){
		if(consumable instanceof Drink){
			drink((Drink)consumable);
		}else if(consumable instanceof  Food){
			eat((Food)consumable);

		}else if(consumable instanceof RepairKit){
			repairWeaponWith((RepairKit)consumable);
		}
	}

	
}
