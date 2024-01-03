import java.util.Random;

public class HarnessedTrotRun {

	public static final int startLine = 0;
	public static final int finishLine = 2400;
	
	public static void main(String[] args) {
		
		System.out.println(dice());
		
	}
	
	public static int dice() {
		
		int dice = new Random().nextInt(6);
		
		return dice;
	}
	
	public static int horseSpeed(int dice) {
		int speed = 0;
		
		return speed;
	}

}
