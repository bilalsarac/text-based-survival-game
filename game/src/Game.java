import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	static String playerName;

	Scanner scan = new Scanner(System.in);

	public void Login() {

		System.out.println("Welcome to the hero of the Dungeon");

		player = new Player(playerName, 0, 40, 0, 1, new Sword(), new LightArmor());
		// System.out.println("Welcome to the game " + playerName);

		start();

	}

	public void start() {
		int selLoc = 0;
		System.out.println("Please enter your name");
		playerName = scan.nextLine();
		player.setName(playerName);
		System.out.println("Welcome to the game " + playerName);
		while (true) {
			printMenu();
			boolean loopCondition = true;
			do {

				System.out.println("You can use the menu above.");

				try {

					selLoc = Integer.parseInt(scan.nextLine());

					loopCondition = false;

				} catch (Exception e) {
					System.err.println("Sorry! Invalid Choice. Please check above!" + e.getMessage());
					System.err.println("Enter a number... Press 1,2,3,4,5,6 ...");
				}

			} while (loopCondition && selLoc < 0 || selLoc > 6);

			switch (selLoc) {

			case 1:

				location = new Room(player);

				break;

			case 2:
				player.lookInventory();
				continue;
			case 3:
				player.equipWeapon();
				;
				continue;
			case 4:
				player.equipArmor();
				continue;
			case 5:
				System.out.println("Number of Rescued People: " + BattleLoc.numberOfRescuedPeople);
				continue;
			case 6:
				player.totalPoint();

				continue;
			default:
				location = new Room(player);
				break;

			}

			if (!location.getLocation()) {
				System.out.println("Game Over!");
				break;
			}

		}
	}

	public static void printMenu() {
		System.out.println();
		System.out.println("=====================================");
		System.out.println();
		System.out.println("Choose that you want");

		System.out.println("To fight with monster enter the room (1)");
		System.out.println("Check Inventory(2)");
		System.out.println("Equip weapon from inventory (3)");
		System.out.println("Equip armor from inventory (4)");
		System.out.println("Check how many town people you saved (5)");
		System.out.println("Check Your Score(Game Point) (6)");
		System.out.println("Choose Option:");
	}

	public static void creator() {

		File file = new File("Scores.txt");
		try {
			if (file.createNewFile()) {
				System.out.println();
			} else {
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writingToFile(int score) throws IOException {

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("Scores.txt", true));

			bw.write("Name: " + playerName + " Score:" + score + " \n");

			bw.close();

		}

		catch (IOException e) {
			System.out.println("Something went wrong.");
			e.printStackTrace();
		}

	}

	public static void reader() {

		File file = new File("Scores.txt");

		try {
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				System.out.println(data);

			}
			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	/*
	 * import java.io.BufferedWriter; import java.io.File; import
	 * java.io.FileNotFoundException; import java.io.FileWriter; import
	 * java.io.IOException; import java.util.ArrayList; import
	 * java.util.Collections; import java.util.Iterator; import java.util.Scanner;
	 * 
	 * import java.util.Comparator; public class Scores {
	 * 
	 * String name; int highscores;
	 * 
	 * Scores(String name,int highscores) { this.name=name;
	 * this.highscores=highscores;
	 * 
	 * }
	 * 
	 * } public class compare implements Comparator<Object>{
	 * 
	 * @Override public int compare(Object a1,Object a2)
	 * 
	 * { Scores player1 = (Scores)a1; Scores player2 =(Scores)a2;
	 * 
	 * if(player1.highscores==player2.highscores) { return 0;
	 * 
	 * } if(player1.highscores>player2.highscores) { return -1; } else return 1;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * } public class FileMaker{
	 * 
	 * ArrayList<Scores> dataScores = new ArrayList<Scores>(); public void create()
	 * {
	 * 
	 * 
	 * File file = new File("Scores.txt");
	 * 
	 * try { if(file.createNewFile()) { System.out.println(); } else {
	 * System.out.println(); } }catch(IOException e) { e.printStackTrace(); }
	 * 
	 * 
	 * } public void writingToFile(int score) throws IOException{
	 * 
	 * 
	 * try {
	 * 
	 * 
	 * BufferedWriter bw = new BufferedWriter(new FileWriter("Scores.txt",true));
	 * bw.newLine();
	 * 
	 * bw.write( Game.playerName +": " + score );
	 * 
	 * 
	 * 
	 * bw.close();
	 * 
	 * }
	 * 
	 * catch(IOException e) { System.err.println("Something went wrong.");
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * } public void reader(){
	 * 
	 * File file = new File("Scores.txt");
	 * 
	 * try { Scanner sc= new Scanner(file);
	 * 
	 * while(sc.hasNextLine()) { while(sc.hasNextLine()) { dataScores.add(new
	 * Scores(sc.next(),sc.nextInt()));
	 * 
	 * } Collections.sort(dataScores,new compare()); Iterator<Scores> iterator
	 * =dataScores.iterator(); int i =0; while(iterator.hasNext() & i<5) { i++;
	 * Scores i1 =(Scores)iterator.next();
	 * 
	 * System.out.println(i1.name + " " + i1.highscores);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * String data = sc.nextLine(); System.out.println(data);
	 * 
	 * 
	 * } sc.close();
	 * 
	 * }catch(FileNotFoundException e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */

}