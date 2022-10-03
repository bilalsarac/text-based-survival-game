
public class Monster extends Character implements Printable {
	public Monster() {
		super("Monster", 0, 10, 4, 4, new Sword(), new LightArmor());
		init();

	}

	public void init() {
		setWeapon(super.getWeapon().weaponcreator());
		setArmor(super.getArmor().armorcreator());
	}

	@Override
	public void stats() {
		System.out.println("\n" + getName() + "Features\n------------");
		System.out.println("Health:" + getHealth());
		System.out.println("Damage:" + (getDamage() + getWeapon().getDamage()));

		System.out.println("Weapon:" + getWeapon().getName());
		System.out.println("Armor:" + getArmor().getName());
		System.out.println("Armor Value:" + getArmor().getArmorValue());
		System.out.println("Item Weapon Value:" + getWeapon().getValuePoint());
		System.out.println("Item Armor Value:" + getArmor().getValuePoint());

	}

	@Override
	public void afterHit() {

		System.out.println(getName() + "Health:" + getHealth());
		System.out.println();
	}
}
