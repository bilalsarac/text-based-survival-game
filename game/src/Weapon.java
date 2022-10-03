import java.util.Random;

public abstract class Weapon {
	private String name;
	private int damage;
	private int weight;
	private int valuePoint;

	public int getValuePoint() {
		return valuePoint;
	}

	public void setValuePoint(int valuePoint) {
		this.valuePoint = valuePoint;
	}

	public Weapon(String name, int damage, int weight, int valuePoint) {

		this.name = name;
		this.damage = damage;
		this.weight = weight;
		this.valuePoint = valuePoint;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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

	public Weapon weaponcreator() {
		Random r = new Random();
		int randomnumber = r.nextInt(3);
		if (randomnumber == 0) {

			return new Bow();
		} else if (randomnumber == 1) {
			return new Axe();
		} else
			return new Sword();

	}
}
