import java.util.HashMap;
import java.util.Scanner;


public class HarnessedTrotRun {

	public static final int startLine = 0;
	public static final int finishLine = 2400;
	public static final int actualSpeed = 0;
	public static final int[] zeroSpeed = {0, 1, 1, 1, 2, 2};
	public static final int[] firstSpeed = {0, 0, 1, 1, 1, 2};
	public static final int[] secondSpeed = {0, 0, 1, 1, 1, 2};
	public static final int[] thirdSpeed = {-1, 0, 0, 1, 1, 1};
	public static final int[] fourthSpeed = {-1, 0, 0, 0, 1, 1};
	public static final int[] fifthSpeed = {-2, -1, 0, 0, 0, 1};
	public static final int[] sixthSpeed = {-2, -1, 0, 0, 0, 0};
	
	public static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		
		
	}
	
	public static int validInput(Scanner scan, String errorMessage) {
		int input = 0;
		boolean validInput = false;

		while (!validInput) {
			if (scan.hasNextInt()) {
				input = scan.nextInt();
				validInput = true;
			} else {
				System.out.println(errorMessage);
				scan.next();
			}
		}

		return input;
	}
	
	public static String runChoice() {
		String choice = "";
		HashMap<Integer, String> choiceList = new HashMap<Integer, String>();
		choiceList.put(1, "tierce");
		choiceList.put(2, "quarte");
		choiceList.put(3, "quinte");
		
		for(int i : choiceList.keySet()) {
			System.out.print("[" + i + " - " + choiceList.get(i) + "]");
		}
		System.out.println();
		
		System.out.println("Quel type de course souhaitez-vous?(entrez un numéro)");
		boolean ok = false;
		
		while(!ok) {
			int userChoice = validInput(scan, "Veuillez entrer un numéro valide !!");
			if(choiceList.containsKey(userChoice)) {
				choice = choiceList.get(userChoice);
				ok = true;
			}else System.out.println("Veuillez entrer un numéro de la liste !");
				
		}
		
		return choice;
	}
	
	public static int dice() {
		int minDice = 1;
		int maxDice = 6;
		int dice = minDice + (int) (Math.random()*(maxDice-minDice));
		
		return dice;
	}
	
	public static int horseSpeed(int dice, int actualSpeed) {
		int speed = 0;
		switch(actualSpeed) {
		case 1 :
			speed += firstSpeed[dice - 1];
			break;
		case 2 :
			speed += secondSpeed[dice - 1];
			break;
		case 3 :
			speed += thirdSpeed[dice - 1];
			break;
		case 4 :
			speed += fourthSpeed[dice - 1];
			break;
		case 5 :
			speed += fifthSpeed[dice - 1];
			break;
		case 6 :
			speed += sixthSpeed[dice - 1];
			break;
		default :
			speed += zeroSpeed[dice - 1];
		}
		
		actualSpeed += speed;
		return actualSpeed;
	}
	
	public static int distance(int actualSpeed) {
		int actualDistance = 0;
		HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();
		distance.put(0, 0);
		distance.put(1, 23);
		distance.put(2, 46);
		distance.put(3, 69);
		distance.put(4, 92);
		distance.put(5, 115);
		distance.put(6, 138);
		
		actualDistance += distance.get(actualSpeed);
		
		return actualDistance;
		
	}
	
	

}
