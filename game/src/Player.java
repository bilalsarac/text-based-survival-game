import java.util.Scanner;

public class Player extends Character implements Printable {
	private int damage, health, rHealth;
	private String name, cName;
	private Inventory inv;
	private Weapon weapon;
	private Armor armor;

	Scanner sc = new Scanner(System.in);

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	Scanner scan = new Scanner(System.in);

	public Player(String name, int damage, int health, int award, int maxNumber, Weapon weapon, Armor armor) {
		super(name, damage, health, award, maxNumber, weapon, armor);
		this.name = name;
		this.inv = new Inventory();
		this.damage = damage;
		this.health = health;
		this.weapon = weapon;
		this.armor = armor;
	}

	public int getTotalDamage() {
		return this.getDamage() + getWeapon().getDamage();
	}

	public void init(String cName, int dmg, int hlth, int mny, Weapon weapon, Armor armor) {
		setcName(cName);
		setDamage(dmg);
		setHealth(hlth);
		setrHealth(hlth);
		setWeapon(new Sword());
		setArmor(new LightArmor());
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getrHealth() {
		return rHealth;
	}

	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public void lookInventory() {

		System.out.println("You have these items");
		System.out.println("Weapons:");
		for (int i = 0; i < getInv().getWeapons().size(); i++) {
			System.out.println(getInv().getWeapons().get(i).getName());

		}
		System.out.println("Armors:");
		for (int i = 0; i < getInv().getArmors().size(); i++) {
			System.out.println(getInv().getArmors().get(i).getName());

		}

	}

	public void equipWeapon() {
		System.out.println("Which item do you want to equip?");
		String choice = sc.nextLine();

		for (int i = 0; i < getInv().getWeapons().size(); i++) {
			if (/* choice.contains(getInv().getWeapons().get(i).getName()) */ choice
					.compareTo(getInv().getWeapons().get(i).getName()) == 0) {
				Weapon temporaryweapon = getWeapon();
				setWeapon(getInv().getWeapons().get(i));
				getInv().getWeapons().remove(i);
				getInv().getWeapons().add(temporaryweapon);
			} else
				System.out.println("There is no such an item.");

		}

		System.out.println("Your new weapon: " + getWeapon().getName());
	}

	public void equipArmor() {
		System.out.println("Which item do you want to equip?");
		String choice = sc.nextLine();

		for (int i = 0; i < getInv().getArmors().size(); i++) {
			if (/* choice.contains(getInv().getArmors().get(i).getName()) */ choice
					.compareTo(getInv().getArmors().get(i).getName()) == 0) {
				Armor temporaryarmor = getArmor();
				setArmor(getInv().getArmors().get(i));
				getInv().getArmors().remove(i);
				getInv().getArmors().add(temporaryarmor);
			}

		}

		System.out.println("Your New Armor: " + getArmor().getName());
	}

	@Override
	public void stats() {
		System.out.println("Player Features \n--------------");
		System.out.println("Health:" + getHealth());
		System.out.println("Damage:" + getWeapon().getDamage());
		System.out.println("Weapon:" + getWeapon().getName());
		System.out.println("Armor:" + getArmor().getName());
		System.out.println("Armor Value:" + getArmor().getArmorValue());
		System.out.println("Item Weapon ValuePoints:" + getWeapon().getValuePoint());
		System.out.println("Item Armor ValuePoints:" + getArmor().getValuePoint());

		if (getInv().getDamage() > 0) {
			System.out.println("Weapon:" + getInv().getwName());

		}
		if (getInv().getArmor() > 0) {
			System.out.println("Armor:" + getInv().getaName());
		}
	}

	@Override
	public void afterHit() {
		System.out.println("Player Health:" + getHealth());

	}

	public void totalPoint() {
		int totalPointWeapon = 0;
		int totalPointArmor = 0;
		for (int i = 0; i < getInv().getWeapons().size(); i++) {

			totalPointWeapon = totalPointWeapon + getInv().getWeapons().get(i).getValuePoint();
		}
		for (int i = 0; i < getInv().getWeapons().size(); i++) {

			totalPointArmor = totalPointArmor + getInv().getArmors().get(i).getValuePoint();
		}
		int totalPoint = totalPointArmor + totalPointWeapon + getArmor().getValuePoint() + getWeapon().getValuePoint();

		System.out.println("Every item has their own value. The more items you collect, the more points you get. ");
		System.out.println();
		System.out.println(
				"You start with 0 point.The more items you collect, game add item's value points to your score ");
		System.out.println(
				"Moreover, If you be hero and save people, you will get 5 points more for each people you saved.");
		System.out.println();
		System.out.println("Your Score:" + (totalPoint + BattleLoc.numberOfRescuedPeople * 5));
		System.out.println();

	}

	public int totalPointValue() {
		int totalPointWeapon = 0;
		int totalPointArmor = 0;
		for (int i = 0; i < getInv().getWeapons().size(); i++) {

			totalPointWeapon = totalPointWeapon + getInv().getWeapons().get(i).getValuePoint();
		}
		for (int i = 0; i < getInv().getWeapons().size(); i++) {

			totalPointArmor = totalPointArmor + getInv().getArmors().get(i).getValuePoint();
		}
		int totalPoint = totalPointArmor + totalPointWeapon + getArmor().getValuePoint() + getWeapon().getValuePoint();

		return totalPoint;

	}

}
