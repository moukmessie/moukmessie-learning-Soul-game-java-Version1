package lsg.weapons;

public class Sword extends Weapon {
	
	private static String NAME = "Basic Sword" ;
	
	public Sword() {
		super(NAME, 5, 10, 20, 100) ;
	}
	
	public static void main(String[] args) {
		System.out.println(new Sword());
	}

}
