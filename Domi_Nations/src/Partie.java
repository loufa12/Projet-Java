
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.io.FileReader;


public class Partie {
	private Royaume[][] table;
	private Joueur[] listeJoueurs;
	private int nb_joueurs;
	private ArrayList<Roi> listeRois;


	public void creationJoueurs() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel est le nombre de joueurs ?");
		nb_joueurs = scanner.nextInt();

		scanner.nextLine();

		// On vérifie que le nb de joueurs est compris entre 2 et 4
		while (nb_joueurs != 2 && nb_joueurs != 3 && nb_joueurs != 4) {
			System.out.println("Saisissez un nombre de joueurs compris entre 2 et 4.");
			nb_joueurs = scanner.nextInt();
			scanner.nextLine();
		}

		// On crée la liste des couleurs possibles
		ArrayList<String> colors_list = new ArrayList<String>();
		colors_list.add("rose");
		colors_list.add("jaune");
		colors_list.add("vert");
		colors_list.add("bleu");

		// On crée la liste des joueurs
		String[] players_color_list = new String[nb_joueurs];
		listeJoueurs = new Joueur[nb_joueurs];

		// On crée la liste des dés, ie. des rois
		listeRois = new ArrayList<Roi>();

		for (int i = 0; i < nb_joueurs; i++) {
			System.out.println("Indiquez le nom du joueur " + (i + 1) + " :");
			String name_player = scanner.nextLine();

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

			listeJoueurs[i] = player;
			//System.out.println(listeJoueurs[i].getName() + " : " + listeJoueurs[i].getColor() + ", " + listeJoueurs[i].getId_joueur());

			if (nb_joueurs == 2) {
				Roi roi = new Roi(player, chosen_color, null);
				Roi roibis = new Roi(player, chosen_color, null);
				listeRois.add(roi);
				listeRois.add(roibis);
			} else {
				// On crée les différents rois avec leur couleur
				Roi roi = new Roi(player, chosen_color, null);
				listeRois.add(roi);
			}
			colors_list.remove(chosen_color);

		}

		for (int i = 0; i < nb_joueurs; i++) {
			Joueur joueur = listeJoueurs[i];
			System.out.println("Bienvenue " + joueur.getName() + ", vous êtes le joueur n°" + joueur.getId_joueur() + " avec la couleur " + joueur.getColor() + " !");
		}
	}

	public void creationDominos() throws FileNotFoundException {

		// On calcule le nombre de dominos nécessaires pour la partie en fonction du nombre de joueurs
		int nbDomino = 48 - 12 * (4 - nb_joueurs);

		// On récupère les dominos à partir du fichier CSV
		Scanner scanner2 = new Scanner(new File("dominos.csv"));
		StringBuilder stringBuilder = new StringBuilder();

		scanner2.nextLine();
		while (scanner2.hasNextLine()) {
			stringBuilder.append(scanner2.nextLine()).append("\n");
		}
		scanner2.close();

		String filetostr = stringBuilder.toString();
		String[] infosdominos = filetostr.split("\n");

		// On crée la liste des objets dominos
		ArrayList<Domino> playedDominos = new ArrayList<Domino>();

		// Pour chaque domino, on récupère les caractéristiques
		for (int i = 0; i < infosdominos.length; i++) {
			String[] param = infosdominos[i].split(",");

			int id_domino = Integer.valueOf(param[4]);
			int nbcouronnes1 = Integer.valueOf(param[0]);
			int nbcouronnes2 = Integer.valueOf(param[2]);
			String domaine1 = param[1];
			String domaine2 = param[3];

			// On crée les 48 dominos du jeu
			Domino domino = new Domino(id_domino, domaine1, domaine2, nbcouronnes1, nbcouronnes2);

			// On ajoute chaque domino créé à la liste
			playedDominos.add(domino);
		}

		// On génère un nombre aléatoire de dominos à retirer du nombre total
		int nb;
		Random random = new Random();
		while (playedDominos.size() != nbDomino) {
			nb = random.nextInt(playedDominos.size());
			playedDominos.remove(playedDominos.get(nb));
		}

		// On crée la pioche avec les dominos choisis aléatoirement
		ArrayList<Domino> pioche = new ArrayList(playedDominos);

		// On crée la liste des dominos du plateau
		ArrayList<Domino> plateau = new ArrayList<Domino>();

		// On prend aléatoirement autant de dominos que de rois pour le plateau
		for (int i=0; i < listeRois.size(); i++) {
			Domino domino = pioche.get(random.nextInt(pioche.size()));
			plateau.add(domino);
			pioche.remove(domino);
		}

		ArrayList<Domino> plateau_tri = new ArrayList<Domino>();

		// On trie le plateau dans l'ordre croissant
		// Tant que le plateau n'est pas vide, on séléctionne le plus petit domino pour le mettre dans un plateau trié
		while (plateau.size() != 0){
			int plus_petit_id = plateau.get(0).getId_domino();
			int place_plus_petit_domino = 0;
			for (int j=0; j < (plateau.size()); j++){
				if (plateau.get(j).getId_domino() < plus_petit_id){
					plus_petit_id = plateau.get(j).getId_domino();
					place_plus_petit_domino = j;
				}
			}
			plateau_tri.add(plateau.get(place_plus_petit_domino));
			plateau.remove(plateau.get(place_plus_petit_domino));
		}
		plateau = plateau_tri;


		// Test affichage des dominos restants dans la pioche
		for (Domino x : pioche) {
			System.out.println("pioche : " + x.getId_domino());
		}

		// On affiche les numéros des dominos tirés au hasard pour le plateau
		for (Domino x : plateau) {
			System.out.println("plateau : " + x.getId_domino());
		}

		// On crée la liste des joueurs dans l'ordre de passage
		ArrayList<Joueur> ordre_passage = new ArrayList<Joueur>();

		// On mélange les rois dans la liste pour les choisir dans un ordre aléatoire
		Collections.shuffle(listeRois);

		for (Roi roi : listeRois) {
			String id_color = roi.getColor();
			for (Joueur joueur : listeJoueurs) {
				if (joueur.getColor() == id_color) {
					ordre_passage.add(joueur);
				}
			}
		}

		// Test d'affichage des joueurs dans leur ordre
		for (Joueur x : ordre_passage) {
			System.out.println(x.getId_joueur() + ", " + x.getName() + ", " + x.getColor());
		}

		Scanner scanner3 = new Scanner(System.in);

		for (int i = 0; i < ordre_passage.size(); i++) {
			System.out.println("Joueur " + ordre_passage.get(i).getName() + " : choisissez sur quel domino placer votre roi : " + plateau);
			String domino_recouvert = scanner3.nextLine();

			// On vérifie que la couleurs choisie appartient à la liste
			while (!(plateau.contains(domino_recouvert))) {
				System.out.println("Vous devez choisir un domino parmi : " + plateau);
				domino_recouvert = scanner3.nextLine();
			}

			plateau.remove(domino_recouvert);
		}
	}
}