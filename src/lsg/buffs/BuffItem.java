package lsg.buffs;

import lsg.bags.Collectible;

import java.util.Locale;

public abstract class BuffItem implements Collectible {
	
	private String name ; 
	
	public BuffItem(String name) {
		this.name = name ;
	}
	
	public abstract float computeBuffValue() ;
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format(Locale.US, "[%s, %.2f]", getName(), computeBuffValue()) ;
	}


	private final int coll=1;

	/**
	 * implementation de la methode l'interface Collectible retourne
	 * un entier correspondant	 au	 nombre	 de	 kilos du
	 * collectable.
	 * @return collect (constant 3kg)
	 */
	@Override
	public int getWeigth() {
		return coll;
	}
}
