import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Partie {
	private Royaume[][] table;
	private Joueur[] player;
	private Joueur currentPlayer;

	public void play() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel est le nombre de joueurs ?");
		int nbPlayers = scanner.nextInt();
		scanner.nextLine();
		while (nbPlayers != 2 && nbPlayers != 3 && nbPlayers != 4) {
			System.out.println("Saisissez un nombre de joueurs compris entre 2 et 4.");
			nbPlayers = scanner.nextInt();
			scanner.nextLine();
		}

		ArrayList<String> colors_list = new ArrayList<String>();
		colors_list.add("Rose");
		colors_list.add("Jaune");
		colors_list.add("Vert");
		colors_list.add("Bleu");

		String[] playersTable = new String[nbPlayers];
		for (int i=0; i < nbPlayers; i++) {
			System.out.println("Indiquez le nom du joueur " + (i + 1) + " :");
			String iPlayer = scanner.nextLine();
			playersTable[i] = iPlayer;

			System.out.println("Parmi les couleurs " + colors_list + " laquelle choisissez-vous ?");
			String chosen_color = scanner.nextLine();
			if (!(colors_list.contains(chosen_color))) {
				System.out.println("Vous devez choisir une couleur parmi : " + colors_list);
				chosen_color = scanner.nextLine();
			}
			colors_list.remove(chosen_color);
		}

		System.out.println(Arrays.toString(playersTable));
		for (int j=0; j < playersTable.length; j++) {
			System.out.println("Bienvenue " + playersTable[j] + ", vous êtes le joueur n°" + (j+1) + " !");
		}
	}
}
