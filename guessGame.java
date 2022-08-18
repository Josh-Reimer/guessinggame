import java.util.Scanner;

public class guessGame extends Game{
	public static void main(String args[ ]) {
		System.out.println("Welcome to my guessing game!");
		Game guessGame = new Game();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			if (guessGame.keepPlaying) {
				guessGame.play(scanner);
			}
			if (!guessGame.keepPlaying) {
				guessGame.ask(scanner);
				if (guessGame.exitGame) {
					scanner.close();
					System.exit(0);
				}
				if (!guessGame.exitGame) {
					guessGame = new Game();
				}
			}
		}
	}
}