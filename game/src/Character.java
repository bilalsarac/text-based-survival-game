import java.util.Random;

public abstract class Character implements Printable {
	private String name;
	private int damage, award, health, maxNumber;
	private Weapon weapon;
	private Armor armor;

	public Character(String name, int damage, int health, int award, int maxNumber, Weapon weapon, Armor armor) {
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.health = health;
		this.maxNumber = maxNumber;
		this.weapon = weapon;
		this.armor = armor;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int count() {
		Random r = new Random();
		return r.nextInt(this.maxNumber);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public void stats() {

	}

	public void afterHit() {

	}

}
