import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	Scanner sc = new Scanner(System.in);

	private String wName, aName;
	private int damage, armor;
	private final int maxWeight = 100;
	private int currentWeight;

	public int getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private ArrayList<Armor> armors = new ArrayList<Armor>();

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(ArrayList<Weapon> weapons) {
		this.weapons = weapons;
	}

	public ArrayList<Armor> getArmors() {
		return armors;
	}

	public void setArmors(ArrayList<Armor> armors) {
		this.armors = armors;
	}

	Inventory() {

		this.damage = 0;
		this.armor = 0;
		this.wName = null;
		this.aName = null;

	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public void addWeapon(Weapon weapon) {
		weapons.add(weapon);
	}

	public void addArmor(Armor armor) {
		armors.add(armor);
	}
}
