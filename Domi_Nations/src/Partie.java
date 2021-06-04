
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Partie {
	private Joueur[] listeJoueurs;
	private int nb_joueurs;
	private ArrayList<Roi> listeRois;
	private ArrayList<Domino> plateau;


	public void creationJoueurs() {
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
		ArrayList<String> colors_list = new ArrayList<>();
		colors_list.add("rose");
		colors_list.add("jaune");
		colors_list.add("vert");
		colors_list.add("bleu");

		// On crée la liste des joueurs
		String[] players_color_list = new String[nb_joueurs];
		listeJoueurs = new Joueur[nb_joueurs];

		// On crée la liste des dés, ie. des rois
		listeRois = new ArrayList<>();

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
			Joueur player = new Joueur(i + 1, name_player, chosen_color, null);

			listeJoueurs[i] = player;
			//System.out.println(listeJoueurs[i].getName() + " : " + listeJoueurs[i].getColor() + ", " + listeJoueurs[i].getId_joueur());

			if (nb_joueurs == 2) {
				Roi roi = new Roi(player, chosen_color, null);
				Roi roibis = new Roi(player, chosen_color, null);

				// On ajoute roi et roisbis à la liste des rois et on met à jour roi dans joueur
				listeRois.add(roi);
				listeRois.add(roibis);
				player.setRoi(roi);
				player.setRoi(roibis);

			} else {
				// On crée les différents rois avec leur couleur
				Roi roi = new Roi(player, chosen_color, null);
				listeRois.add(roi);
				player.setRoi(roi);
			}
			colors_list.remove(chosen_color);

			//System.out.println(player.getRoi());
		}

		for (int i = 0; i < nb_joueurs; i++) {
			Joueur joueur = listeJoueurs[i];
			System.out.println("Bienvenue " + joueur.getName() + ", vous êtes le joueur n°" + joueur.getId_joueur() + " avec la couleur " + joueur.getColor() + " !");
		}
	}


	// ------------------------------------------------------------------------//


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
		ArrayList<Domino> playedDominos = new ArrayList<>();

		// Pour chaque domino, on récupère les caractéristiques
		for (int i = 0; i < infosdominos.length; i++) {
			String[] param = infosdominos[i].split(",");

			int id_domino = Integer.valueOf(param[4]);
			int nbcouronnes1 = Integer.valueOf(param[0]);
			int nbcouronnes2 = Integer.valueOf(param[2]);
			String domaine1 = param[1];
			String domaine2 = param[3];

			// On crée les 48 dominos du jeu
			Domino domino = new Domino(id_domino, domaine1, domaine2, nbcouronnes1, nbcouronnes2, null, null);

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
		plateau = new ArrayList<Domino>();

		// On prend aléatoirement autant de dominos que de rois pour le plateau
		for (int i = 0; i < listeRois.size(); i++) {
			Domino domino = pioche.get(random.nextInt(pioche.size()));
			plateau.add(domino);
			pioche.remove(domino);
		}

		// On crée la liste des dominos contenus dans le plateau trié
		ArrayList<Domino> plateau_tri = new ArrayList<Domino>();

		// On trie le plateau dans l'ordre croissant
		// Tant que le plateau n'est pas vide, on séléctionne le plus petit domino pour le mettre dans un plateau trié
		while (plateau.size() != 0) {
			int plus_petit_id = plateau.get(0).getId_domino();
			int place_plus_petit_domino = 0;
			for (int j = 0; j < (plateau.size()); j++) {
				if (plateau.get(j).getId_domino() < plus_petit_id) {
					plus_petit_id = plateau.get(j).getId_domino();
					place_plus_petit_domino = j;
				}
			}
			plateau_tri.add(plateau.get(place_plus_petit_domino));
			plateau.remove(plateau.get(place_plus_petit_domino));
		}
		plateau = plateau_tri;

		// Test affichage des dominos restants dans la pioche
		//for (Domino x : pioche) {
		//	System.out.println("pioche : " + x.getId_domino());
		//}

		// Test d'affichage des numéros des dominos tirés au hasard pour le plateau
		//for (Domino x : plateau) {
		//	System.out.println("plateau : " + x.getId_domino());
		//}
	}


	// ------------------------------------------------------------------------//


	public void premierTour() throws FileNotFoundException {

		// On crée la liste des joueurs dans l'ordre de passage
		ArrayList<Joueur> ordre_passage = new ArrayList<Joueur>();

		// On mélange les rois dans la liste pour les choisir dans un ordre aléatoire
		Collections.shuffle(listeRois);

		// On définit l'ordre de passage des joueurs à partir du tirage des rois
		for (Roi roi : listeRois) {
			String id_color = roi.getColor();
			for (Joueur joueur : listeJoueurs) {
				if (joueur.getColor() == id_color) {
					ordre_passage.add(joueur);
				}
			}
		}

		// Test d'affichage des joueurs dans l'ordre
		//for (Joueur x : ordre_passage) {
		//	System.out.println(x.getId_joueur() + ", " + x.getName() + ", " + x.getColor());
		//}

		// On crée la liste des id des dominos présents sur le plateau
		List<String> plateau_id = new ArrayList<>();
		for (Domino x : plateau) {
			plateau_id.add(String.valueOf(x.getId_domino()));
		}

		// On récupère les informations de chaque domino du plateau
		for (Domino x : plateau) {
			String domaine1 = x.getDomaine1();
			String domaine2 = x.getDomaine2();
			int nb_couronnes1 = x.getNb_couronnes1();
			int nb_couronnes2 = x.getNb_couronnes2();
		}

		Scanner scanner3 = new Scanner(System.in);

		// On crée le tableau des scores en fonction des joueurs
		int[][] tableau_scores = new int[nb_joueurs][2];

		// Pour chaque joueur dans l'ordre de passage,
		for (int i = 0; i < ordre_passage.size(); i++) {

			// On ajoute en première colonne les id des joueurs dans l'ordre de passage
			tableau_scores[i][0] = ordre_passage.get(i).getId_joueur();

			// Pour chaque joueur, l'id devient son ordre de passage dans le jeu
			ordre_passage.get(i).setId_joueur(i + 1);

			// On demande au joueur quel domino il/elle choisit
			System.out.println(ordre_passage.get(i).getName() + ", choisissez sur quel domino vous voulez placer votre roi : " + plateau_id);
			String domino_choisi = scanner3.nextLine();

			// On vérifie que le numéro de domino choisi appartient bien à la liste
			while (!(plateau_id.contains(domino_choisi))) {
				System.out.println("Vous devez choisir un domino parmi : " + plateau_id);
				domino_choisi = scanner3.nextLine();
			}

			// Pour chaque domino choisi pour un roi, on met à jour domino_roi dans Roi
			for (Domino x : plateau) {
				if (x.getId_domino() == Integer.valueOf(domino_choisi)) {
					ordre_passage.get(i).getRoi().setDomino_roi(x);
				}
			}

			// Une fois le domino choisi par un joueur, on le retire du plateau
			plateau_id.remove(domino_choisi);

		}

		for (int i = 0; i < ordre_passage.size(); i++) {
			//int[][] taille_max = new int[13][13];
			int[][] taille_initiale = new int[5][5];

			int colum_chateau = 3;
			int row_chateau = 3;

			Royaume royaume = new Royaume(ordre_passage.get(i).getId_joueur(), taille_initiale);
			Position position_chateau = new Position(colum_chateau, row_chateau);
			Chateau chateau = new Chateau(royaume, position_chateau);

			Position[] liste_positions_autour_chateau = new Position[4];
			// On parcourt dans l'ordre haut/bas/gauche/droite les cases autour du chateau :
			liste_positions_autour_chateau[0] = new Position(colum_chateau, row_chateau - 1);
			liste_positions_autour_chateau[1] = new Position(colum_chateau, row_chateau + 1);
			liste_positions_autour_chateau[2] = new Position(colum_chateau - 1, row_chateau);
			liste_positions_autour_chateau[3] = new Position(colum_chateau + 1, row_chateau);

			Position[] liste_positions = new Position[2];

			Scanner scanner4 = new Scanner(System.in);
			System.out.println(ordre_passage.get(i).getName() + ", placez votre premier domino dans votre royaume :");

			boolean incorrect_input = true;
			while (incorrect_input) {
				System.out.println("Indiquez la position du domaine 1 du domino (ligne) :");
				int position_ligne1 = Integer.parseInt(scanner4.nextLine());

				System.out.println("Indiquez la position du domaine 1 du domino (colonne) :");
				int position_colonne1 = Integer.parseInt(scanner4.nextLine());

				liste_positions[0] = new Position(position_colonne1, position_ligne1);

				System.out.println("Indiquez la position du domaine 2 du domino (ligne) :");
				int position_ligne2 = Integer.parseInt(scanner4.nextLine());

				System.out.println("Indiquez la position du domaine 2 du domino (colonne) :");
				int position_colonne2 = Integer.parseInt(scanner4.nextLine());

				liste_positions[1] = new Position(position_colonne2, position_ligne2);
				// On vérifie que le premier domino est à côté du chateau
				for (int j = 0; j < 4; j++) {
					Position position_case = liste_positions_autour_chateau[j];
					if (position_case.equals(liste_positions[0]) || position_case.equals(liste_positions[1])) {
						incorrect_input = false;
						break;
					}
				}

				Position position_domaine1 = new Position(position_colonne1, position_ligne1);
				ordre_passage.get(i).getRoi().getDomino_roi().setPosition_domino1(position_domaine1);

				Position position_domaine2 = new Position(position_colonne2, position_ligne2);
				ordre_passage.get(i).getRoi().getDomino_roi().setPosition_domino2(position_domaine2);

			}
			if (ordre_passage.get(i).getRoi().getDomino_roi().getNb_couronnes1() == 0 && ordre_passage.get(i).getRoi().getDomino_roi().getNb_couronnes2() == 0) {
				tableau_scores[i][1] = 0;
			}
			else {
				tableau_scores[i][1] = ordre_passage.get(i).getRoi().getDomino_roi().getNb_couronnes1() + ordre_passage.get(i).getRoi().getDomino_roi().getNb_couronnes2();
			}
		}

		for (int i=0; i<nb_joueurs; i++){
			System.out.println("Le score actuel du joueur " + tableau_scores[i][0] + " est :");
			for(int j=0; j<2; j++){
				System.out.println(tableau_scores[1][j]);
			}
		}
	}
}