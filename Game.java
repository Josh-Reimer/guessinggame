import java.util.Random;
import java.util.Scanner;

public class Game{
	public boolean keepPlaying = true;
	public boolean exitGame = false;
	static String guessString;
	public void play(Scanner sc) {
		System.out.println("guess a number");
		Random r = new Random();
		int n = r.nextInt(100);
		String guessString = "";
		int guess = -1;
		int count = 0;
		while (keepPlaying) {
			sc = new Scanner(System.in);
			count = count + 1;
			//beginning of input validation
			if (sc.hasNext("[A-Za-z]*")) {
				if(sc.hasNext("exit")) {
					System.out.println("alright, the number is "+n);
					
					keepPlaying = false;
					break;
				} else {
					System.out.println("invalid input");
					continue;
				}
			} else {
				guessString = sc.next();
				guess = Integer.parseInt(guessString);
			}
			//end of input validation
			if (guess > 100) {
				System.out.println("here's a tip - the secret number is between 0 and 100");
			}
			if (guess > n) {
				System.out.println("Lower!");
			}
			if (guess < n) {
				System.out.println("Higher!");
			}
			if (guess == n) {
				System.out.println("You guessed it in " + count + " tries!");
				
				keepPlaying = false;
				break;
			}
			
		}	//end of game loop
		if(exitGame) {
			sc.close();
		}
	}	//end of play method

	public void ask(Scanner confirm) {
		System.out.println(" 1. play again\n 2. close game\nenter choice:");
			confirm = new Scanner(System.in);
			int yesNo;
		if(confirm.hasNextInt()) {
			yesNo = confirm.nextInt();
			if(yesNo == 1) {
				exitGame = false;
			}else if(yesNo == 2) {
				exitGame = true;
				
			} else {
				exitGame = true;
				System.out.println("invalid input- the program will now exit");
			}
		} else {
			System.out.println("invalid input- the program will now exit");
			exitGame = true;
		}
		if(exitGame) {
			confirm.close();
		}
	}
}