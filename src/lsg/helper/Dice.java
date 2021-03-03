package lsg.helper;
import java.util.Random;

/**
 * Classe Dice
 */
public class Dice {
	private int faces; //entier qui contiendra le bombre de face du dé
	private Random random;//servira à générer les séries de nombres aléatoires.
	//private int random=r.nextInt(50);

	/**
	 * 2.2. Création d'un constructeur à 1 paramètre permettant fixer le nombre de faces du dé.
	 */


	public Dice(int faces) {

		this.faces = faces;
		random= new Random();
	}

	/**
	 * 2.3. Création de la méthode d’instance roll() qui retourne un entier correspondant au
	 * résultat du lancer de dé
	 */

	public int roll(){
		return random.nextInt(faces);
		//return this.random.nextInt(50);
	}

	/**
	 * 2.4. Création d'une méthode main qui servira simplement à tester le dé
	 */

	public static void main(String[] args) {
		int face=50;
		Dice dice= new Dice(face);

		int val=dice.roll();
		int Min=val; int Max=val;

		for(int i=0; i<500;i++) {

			System.out.print(val +" ");
			val=dice.roll();

			if (val>Max )Max=val;

			if(val<Min)Min=val;



		}
		System.out.println("\n") ;
		System.out.println("Min: "+Min);
		System.out.println("Max: "+Max);

	}
}
