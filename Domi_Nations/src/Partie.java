import java.util.Scanner;
import java.util.Arrays;

public class Partie {
	private Royaume[][] table;
	private Joueur[] player;
	private Joueur currentPlayer;

	public void createPlayers() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel est le nombre de joueurs ?");
		int nbPlayers = scanner.nextInt();
		scanner.nextLine();

		String[] playersTable = new String[nbPlayers];
		for (int i=0; i < nbPlayers; i++) {
			System.out.println("Indiquez le nom du joueur " + (i+1) + " :");
			String iPlayer = scanner.nextLine();
			playersTable[i] = iPlayer;
		}
		System.out.println(Arrays.toString(playersTable));
		for (int j=0; j < playersTable.length; j++) {
			System.out.println("Bienvenue " + playersTable[j] + ", vous êtes le joueur n°" + (j+1) + " !");
		}
	}
}
