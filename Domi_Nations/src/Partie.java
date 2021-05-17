
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;


public class Partie {
	private Royaume[][] table;
	private Joueur currentPlayer;

	public void play() throws FileNotFoundException {
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

		// On calcule le nombre de dominos
		int nbDominosMax = 48;
		int nbDomino = 48 - 12 * (4 - nbPlayers);
		System.out.println("Nombre de dominos : " + nbDomino);

		// On crée la liste des couleurs possibles
		ArrayList<String> colors_list = new ArrayList<String>();
		colors_list.add("rose");
		colors_list.add("jaune");
		colors_list.add("vert");
		colors_list.add("bleu");

		// On crée la liste des joueurs
		String[] playersTable = new String[nbPlayers];
		String[] players_color_list = new String[nbPlayers];
		//ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();

		for (int i = 0; i < nbPlayers; i++) {
			System.out.println("Indiquez le nom du joueur " + (i + 1) + " :");
			String name_player = scanner.nextLine();
			playersTable[i] = name_player;

			System.out.println("Parmi les couleurs " + colors_list + " laquelle choisissez-vous ?");
			String chosen_color = scanner.nextLine();

			// On vérifie que la couleurs choisie appartient à la liste
			while (!(colors_list.contains(chosen_color))) {
				System.out.println("Vous devez choisir une couleur parmi : " + colors_list);
				chosen_color = scanner.nextLine();
			}

			players_color_list[i] = chosen_color;

			// On crée les différents joueurs à chaque tour de boucle
			Joueur player = new Joueur(i + 1, name_player, chosen_color);
			//System.out.println(player.getName() + " : " + player.getColor());
			//listeJoueurs.add(player);

			// On crée les différents rois avec leur couleur
			Roi king = new Roi(i + 1, chosen_color, null);

			if (playersTable.length == 2) {
				Roi kingbis = new Roi(i + 2, chosen_color, null);
			}
			colors_list.remove(chosen_color);
		}

		// On affiche les noms des différents joueurs
		for (int j = 0; j < playersTable.length; j++) {
			System.out.println("Bienvenue " + playersTable[j] + ", vous êtes le joueur n°" + (j + 1) + " avec la couleur " + players_color_list[j] + " !");
		}

		// On récupère les dominos à partir du fichier CSV
		Scanner scanner2 = new Scanner(new File("dominos.csv"));
		StringBuilder stringBuilder = new StringBuilder();

		scanner2.nextLine();
		while (scanner2.hasNextLine()) {
			stringBuilder.append(scanner2.nextLine()).append("\n");
		}
		scanner2.close();

		String filetostr = stringBuilder.toString();
		String[] dominos = filetostr.split("\n");

		// On crée la liste des objets dominos
		ArrayList<Domino> playedDominos = new ArrayList<Domino>();

		// Pour chaque ligne, on récupère les caractéristiques
		for (int i = 0; i < dominos.length; i++) {
			String[] param = dominos[i].split(",");

			int id_domino = Integer.valueOf(param[4]);
			int nbcouronnes1 = Integer.valueOf(param[0]);
			int nbcouronnes2 = Integer.valueOf(param[2]);
			String domaine1 = param[1];
			String domaine2 = param[3];

			// On crée les 48 dominos
			Domino domino = new Domino(id_domino, domaine1, domaine2, nbcouronnes1, nbcouronnes2);

			// On ajoute chaque domino créé à la liste
			playedDominos.add(domino);
		}

		// On génère un nombre aléatoire de dominos à retirer du nombre total
		int nb;
		Random random = new Random();
		while (playedDominos.size() != nbDomino) {
			nb = random.nextInt(playedDominos.size() + 1);
			playedDominos.remove(playedDominos.get(nb));
		}

		// On crée la pioche avec les dominos choisis aléatoirement
		ArrayList<Domino> pioche = new ArrayList<Domino>();

		for (Domino x : playedDominos) {
			//System.out.println(x.getId_domino());
			pioche.add(x);
		}

		Random random1 = new Random();
		int i = 0;
//		for (String player : playersTable) {
//			nb = random1.nextInt(pioche.size() + 1);
//			pioche.remove(pioche.get(nb));
//			//System.out.println(x.getId_domino());
//			i += 1;
//		}
		System.out.println(i);
	}
}
