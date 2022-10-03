import java.util.Random;

public abstract class Armor {
	private String name;
	private int armorValue;
	private int weight;
	private int valuePoint;

	public int getWeight() {
		return weight;
	}

	public int getValuePoint() {
		return valuePoint;
	}

	public void setValuePoint(int valuePoint) {
		this.valuePoint = valuePoint;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Armor(String name, int armorValue, int weight, int valuePoint) {

		this.name = name;
		this.armorValue = armorValue;
		this.weight = weight;
		this.valuePoint = valuePoint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArmorValue() {
		return armorValue;
	}

	public void setArmorValue(int armorValue) {
		this.armorValue = armorValue;
	}

	public Armor armorcreator() {

		Random r = new Random();
		int randomnumber = r.nextInt(3);
		if (randomnumber == 0) {

			return new HeavyArmor();
		} else if (randomnumber == 1) {
			return new LeatherArmor();
		} else
			return new LightArmor();

	}
}
