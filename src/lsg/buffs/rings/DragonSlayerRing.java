package lsg.buffs.rings;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;


public class DragonSlayerRing extends Ring {
	
	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14) ;
	}
	
	@Override
	public float computeBuffValue() {
		if(hero != null && hasDragonsSlayerItem()){
			return power ;
		}else return 0 ;
	}
	
	private boolean hasDragonsSlayerItem(){
		ArmorItem[] items = hero.getArmorItems() ;
		for(ArmorItem item: items){
			if(item instanceof DragonSlayerLeggings) return true ;
		}
		return false ;
	}
	private final int collect = 3;

	/**
	 * implementation de la methode l'interface Collectible retourne
	 * un entier correspondant	 au	 nombre	 de	 kilos du
	 * collectable.
	 * @return collect (constant 3kg)
	 */
	@Override
	public int getWeigth() {
		return collect;
	}
}
