package lsg.characters;

import lsg.buffs.talismans.Talisman;
public class Monster extends Character{
	
	private static int INSTANCES_COUNT = 0 ;

	private static String DEFAULT_NAME = "Monster" ; // Nom par défaut
	private static int DEFAULT_MAX_LIFE = 10 ; // Nombre de points de vie par défaut
	private static int DEFAULT_MAX_STAMINA = 10 ; // Nombre de points d'action par défaut

	private static float skinThickness =20f;// attribut initialisé à 20

		private Talisman talisman;
	/**
	 * constructeur monster
	 * @param name
	 */
	public Monster(String name) {
		super(name) ;
		setMaxLife(DEFAULT_MAX_LIFE);
		setLife(DEFAULT_MAX_LIFE) ;
		setMaxStamina(DEFAULT_MAX_STAMINA);
		setStamina(DEFAULT_MAX_STAMINA) ;
		INSTANCES_COUNT++ ;
	}

	/**
	 * constructeur monster par defaut
	 */
	public Monster(){
		this(DEFAULT_NAME) ;
		setName(getName() + "_" + INSTANCES_COUNT);
	}

	public static float getSkinThickness() {
		return skinThickness;
	}

	public static void setSkinThickness(float skinThickness) {
		Monster.skinThickness = skinThickness;
	}

	/**
	 * methode abstraite qui retourne la valeur de l'épaisseur de la peau
	 * @return
	 */

	@Override
	protected float computeProtection() {
		return getSkinThickness();
	}

	/**
	 * getter et setter de talisman
	 * @return
	 */
	public Talisman getTalisman() {
		return talisman;
	}

	public void setTalisman(Talisman talisman) {
		this.talisman = talisman;
	}

	/**
	 * methode abstraite
	 * @return
	 */
	@Override
	protected float computeBuff() {
		float buff = (talisman != null) ? talisman.computeBuffValue() : 0 ;
		return buff;

	}
}
