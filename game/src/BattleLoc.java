import java.io.IOException;
import java.util.Random;

public abstract class BattleLoc extends Location {
	protected Character character;

	protected People people;
	public static int numberOfRescuedPeople = 0;
	Random r = new Random();

	public BattleLoc(Player player, String name, Character character, People people) {
		super(player);
		this.character = character;
		this.name = name;

		this.people = people;
	}

	public boolean getLocation() {

		int obsCount = character.count();
		int peopleCount = people.count();
		System.out.println("You are here now:" + this.getName());
		System.out.println("There is/are " + obsCount + character.getName() + "here");
		System.out.println("There is/are " + peopleCount + people.getName() + "here");
		System.out.println("<F>ight or <R>un:");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("F")) {
			if (combat(obsCount, peopleCount)) {

				System.out.println("You clear all the monsters in " + this.getName());

				System.out.println(
						"Do you want to take the monster's weapon <Y>es or <N>o " + character.getWeapon().getName());
				String c = scan.nextLine();
				c = c.toUpperCase();
				if (c.equals("Y") && player.getInv().getMaxWeight() > character.getWeapon().getWeight()
						+ player.getInv().getCurrentWeight()) {
					player.getInv().addWeapon(character.getWeapon());
					player.getInv()
							.setCurrentWeight(character.getWeapon().getWeight() + player.getInv().getCurrentWeight());
					System.out.println("You've got the " + character.getWeapon().getName() + " in the inventory.");
					System.out.println("Inventory weight is :" + player.getInv().getCurrentWeight());
				}
				System.out.println(
						"Do you want to take the monster's armor <Y>es or <N>o " + character.getArmor().getName());
				c = scan.nextLine();
				c = c.toUpperCase();

				if (c.equals("Y") && player.getInv().getMaxWeight() > character.getArmor().getWeight()
						+ player.getInv().getCurrentWeight()) {
					player.getInv().addArmor(character.getArmor());
					player.getInv()
							.setCurrentWeight(character.getArmor().getWeight() + player.getInv().getCurrentWeight());
					System.out.println("You've got the " + character.getArmor().getName() + " in the inventory.");
					System.out.println("Inventory weight is :" + player.getInv().getCurrentWeight());
				}

				System.out.println("You saved " + peopleCount + "number of town people. They are grateful now.");
				numberOfRescuedPeople = numberOfRescuedPeople + peopleCount;
				System.out.println("Now people are going to heal you");
				System.out.println("Heal point will be between 0 and 5 points for each town people");
				int randomNumber = r.nextInt(6);

				player.setHealth((player.getHealth() + peopleCount * randomNumber));
				System.out.println("Your heal :" + player.getHealth());

				return true;

			}
			if (player.getHealth() <= 0) {
				System.out.println("Game Over... You are dead...");
				try {
					Game.creator();
					Game.writingToFile(player.totalPointValue());
					Game.reader();
				} catch (IOException e) {

					e.printStackTrace();
				}

				return false;
			}
		}
		return true;

	}

	public boolean combat(int obsCount, int peopleCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = character.getHealth();
			player.stats();
			character.stats();
			while (player.getHealth() > 0 && character.getHealth() > 0) {
				System.out.println("<A>ttack or <F>lee:");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("A")) {
					System.out.println("You hit the monster!");
					character.setHealth(
							character.getHealth() - (player.getTotalDamage() - character.getArmor().getArmorValue()));
					player.afterHit();
					character.afterHit();
					if (character.getHealth() > 0) {
						System.out.println();
						System.out.println("The monster hit you!");
						player.setHealth(player.getHealth()
								- (character.getWeapon().getDamage() - player.getArmor().getArmorValue()));
						player.afterHit();
						character.afterHit();
					}
				} else {
					return false;

				}

			}
			if (character.getHealth() < player.getHealth()) {
				System.out.println("You killed the monster!");

				character.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("-----------------");
		}
		return true;

	}

}

