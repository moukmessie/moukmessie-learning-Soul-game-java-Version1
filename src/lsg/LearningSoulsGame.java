
package lsg;

import java.util.Scanner;

import lsg.armor.DragonSlayerLeggings;

import lsg.armor.RingedKnightArmor;
import lsg.buffs.rings.DragonSlayerRing;
import lsg.buffs.rings.RingOfDeath;
import lsg.buffs.talismans.MoonStone;
import lsg.characters.Character;
import lsg.characters.Hero;
import lsg.characters.Lycantrope;
import lsg.characters.Monster;
import lsg.consumables.Consumable;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.food.Hamburger;
import lsg.weapons.Claw;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

public class LearningSoulsGame {

	public static final String BULLET_POINT = "\u2219 " ;
	Scanner scanner = new Scanner(System.in) ;
	
	Hero hero ;
	Monster monster ;

	/**
	 * Methode dont le but est de créer un héro
	 * totalement épuisé
	 */
	private void createExhaustedHero(){
		hero = new Hero(); //Instanciation de l'hero

		hero.getHitWith(99);//pour vider la vie

		//pour depenser la stam
		hero.setWeapon(new Weapon("Grosse Arme",0,0,1000,100));
		hero.attack();
//		hero.setWeapon(null);

		System.out.println(hero);
//		System.out.println(hero.getWeapon());

	}


	/**
	 * Methode d'éxécution de la consomation
	 */
	private void aTable(){
		MenuBestOfV4 menu = new MenuBestOfV4();

		for(Consumable c : menu){
			System.out.println();
			hero.use(c);
			System.out.println(hero);
			System.out.println("Après utilisation : " + c);
		}
		System.out.println(hero.getWeapon());
	}


	//public LearningSoulsGame(){play() ;}

	private void init(){
		hero = new Hero() ;
		hero.setWeapon(new Sword());
		hero.SetArmorItem(new DragonSlayerLeggings(), 1);
		hero.setRing(new RingOfDeath(), 1);
		hero.setRing(new DragonSlayerRing(),2);

		hero.setConsumable(new Hamburger());

		monster = new Lycantrope();
		monster.setTalisman(new MoonStone());

	}



	private void play(){
		init() ;
		fight1v1() ;

	}

	/*private void  play_v2(){
		hero = new Hero();
		hero.setWeapon(new Sword());
		hero.SetArmorItem(new DragonSlayerLeggings(),1);

		monster = new Monster() ;
		monster.setWeapon(new Claw());
		fight1v1();
	}


	private void play_v3(){
		hero = new Hero();
		hero.setWeapon(new Sword());
		hero.SetArmorItem(new DragonSlayerLeggings(),1);

		lycantrope = new Lycantrope() ;
		lycantrope.setWeapon(new Claw());
		fight1v1();

	}*/

	private void fight1v1(){

		
		refresh();
		
		Character agressor = hero ;
		Character target = monster ;
		int action; // TODO sera effectivement utilise dans une autre version
		int attack, hit ;
		Character tmp ;
		while(hero.isAlive() && monster.isAlive()){ // ATTENTION : boucle infinie si 0 stamina...

			action = 1 ;
			System.out.println();

			if(agressor == hero){
				do{
					System.out.println("Hit enter key for next move > ");
					action = scanner.nextInt(); // GENERERA UNE ERREUR L'UTILISATEUR ENTRE AUTRE CHOSE QU'UN ENTIER (ON TRAITERA PLUS TARD)

				}while(action < 1 || action > 2);
				System.out.println();
			}

			if(action == 2){
				hero.consume();
				System.out.println();
			}else{
				attack = agressor.attack() ;
				hit = target.getHitWith(attack);
				System.out.printf("%s attacks %s with %s (ATTACK:%d | DMG : %d)", agressor.getName(), target.getName(), agressor.getWeapon().getName(), attack, hit);
				System.out.println();
				System.out.println();
			}

			refresh();
			
			tmp = agressor ;
			agressor = target ;
			target = tmp ;
			
		}
		
		Character winner = (hero.isAlive()) ? hero : monster ;
		System.out.println();
		System.out.println("--- " + winner.getName() + " WINS !!! ---");
		
	}
	
	private void refresh(){
		hero.printStats();
		System.out.println(BULLET_POINT + hero.getWeapon()) ;
		System.out.println(BULLET_POINT + hero.getConsumable());
		System.out.println();
		monster.printStats();
	}

	private void title(){
		System.out.println();
		System.out.println("###############################");
		System.out.println("#   THE LEARNING SOULS GAME   #");
		System.out.println("###############################");
		System.out.println();
	}

	public static void main(String[] args) {

		LearningSoulsGame lsg = new LearningSoulsGame() ;
		lsg.title();
//		lsg.createExhaustedHero();
//		lsg.aTable();
		lsg.init();
		lsg.fight1v1();
	}

}
