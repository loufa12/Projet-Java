import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Partie {
	private Royaume[][] table;
	private Joueur[] players;
	private Joueur currentPlayer;

	public void play() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel est le nombre de joueurs ?");
		int nbPlayers = scanner.nextInt();
		scanner.nextLine();

		// On vérifie que le nb de joueurs est compris entre 2 et 4
		while (nbPlayers != 2 && nbPlayers != 3 && nbPlayers != 4) {
			System.out.println("Saisissez un nombre de joueurs compris entre 2 et 4.");
			nbPlayers = scanner.nextInt();
			scanner.nextLine();
		}

		// On crée la liste des couleurs possibles
		ArrayList<String> colors_list = new ArrayList<String>();
		colors_list.add("Rose");
		colors_list.add("Jaune");
		colors_list.add("Vert");
		colors_list.add("Bleu");

		// On crée la liste des joueurs
		String[] playersTable = new String[nbPlayers];
		for (int i=0; i < nbPlayers; i++) {
			System.out.println("Indiquez le nom du joueur " + (i + 1) + " :");
			String name_player = scanner.nextLine();
			playersTable[i] = name_player;

			System.out.println("Parmi les couleurs " + colors_list + " laquelle choisissez-vous ?");
			String chosen_color = scanner.nextLine();

			// On vérifie que la couleurs choisie appartient à la liste
			if (!(colors_list.contains(chosen_color))) {
				System.out.println("Vous devez choisir une couleur parmi : " + colors_list);
				chosen_color = scanner.nextLine();
			}

			// On crée les différents joueurs à chaque tour de boucle
			Joueur player = new Joueur(i+1, name_player, chosen_color);

			// On crée les différents rois avec leur couleur
			Roi king = new Roi(i+1, chosen_color);

			if (playersTable.length == 2) {
				Roi kingbis = new Roi(i+2, chosen_color);
			}

			colors_list.remove(chosen_color);
		}

		// On affiche les noms des différents joueurs
		System.out.println(Arrays.toString(playersTable));
		for (int j=0; j < playersTable.length; j++) {
			System.out.println("Bienvenue " + playersTable[j] + ", vous êtes le joueur n°" + (j+1) + " !");
		}

	}
}
