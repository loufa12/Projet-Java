
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import static java.lang.System.*;
import java.util.InputMismatchException;

public class Partie {
	private Joueur[] listeJoueurs;
	private int nb_joueurs;
	private ArrayList<Roi> listeRois;
	private ArrayList<Domino> plateau;
	private ArrayList<Joueur> ordre_passage_suite;
	private ArrayList<Domino> pioche;
	private ArrayList<Domino> plateau_trie;
	private String domaine1;
	private String domaine2;
	private int nb_couronnes_domaine1;
	private int nb_couronnes_domaine2;
	private int indice_temp;
	private List<String> plateau_id;
	private ArrayList<Joueur> ordre_passage_1 = new ArrayList<Joueur>();
	private int[][] tableau_scores;
	private int min_ligne_temp;
	private int min_col_temp;
	private int max_ligne_temp;
	private int max_col_temp;
	private int colum_chateau = 4;
	private int row_chateau = 4;
	private Position[]liste_positions_autour_chateau = new Position[4];
	private ArrayList<String[][]> table = new ArrayList<>();
	String[][] Roy1 = {
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Châto", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
	};

	String[][] Roy2 = {
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Châto", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
	};

	String[][] Roy3 = {
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Châto", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
	};

	String[][] Roy4 = {
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Châto", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
			{"Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide", "Vide",},
	};


	public void creationJoueurs() {
		table.add(Roy1);
		table.add(Roy2);
		table.add(Roy3);
		table.add(Roy4);







		class IntervalException extends Exception {
			public IntervalException() {
			}

			public IntervalException(String msg) {
			}
		}

		// On demande le nombre de joueurs tant que la réponse n'est pas un entier entre 2 et 4
		Scanner scanner = new Scanner(System.in);
		String s;
		while (nb_joueurs != 2 && nb_joueurs != 3 && nb_joueurs != 4) {
			try {
				System.out.println("Saisissez un nombre de joueurs compris entre 2 et 4.");
				;
				nb_joueurs = scanner.nextInt();
				if (nb_joueurs != 2 && nb_joueurs != 3 && nb_joueurs != 4) throw new IntervalException();
				break;
			} catch (InputMismatchException e) {
				s = scanner.next();
				out.println("Veuillez entrer un entier");
			} catch (IntervalException e) {
				out.println("Il faut que l'entier soit compris entre 2 et 4 !");
				scanner.nextLine();
			}
		}

		scanner.nextLine();


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

		if (nb_joueurs == 2) {
			// On demande le nom des joueurs
			// Le nom d'un joueur doit être composé de lettres (il ne doit pas être vide ni ne comporter uniquement des chiffres)
			for (int i = 0; i < nb_joueurs; i++) {
				String name_player;
				boolean isInteger;
				do {
					System.out.println("Indiquez le nom du joueur " + (i + 1) + " :");
					name_player = scanner.nextLine();
					try {
						int name_player_integer = Integer.parseInt(name_player);
						isInteger = true;
					} catch (NumberFormatException nfe) {
						isInteger = false;
					}
					if (name_player == "") {
						out.println("Veuillez entrer un nom non vide");
					}
					if (isInteger == true) {
						out.println("Veuillez entrer un nom non uniquement de type int");
					}
				} while (name_player == "" || isInteger == true);


				// On demande la couleur des joueurs parmi celles restantes
				System.out.println("Parmi les couleurs " + colors_list + " laquelle choisissez-vous ?");
				String chosen_color = scanner.nextLine();

				// On vérifie que la couleurs choisie appartient à la liste
				while (!(colors_list.contains(chosen_color))) {
					System.out.println("Vous devez choisir une couleur parmi : " + colors_list);
					chosen_color = scanner.nextLine();
				}
				players_color_list[i] = chosen_color;

				// On retire de la liste la couleur choisie
				colors_list.remove(chosen_color);

				// On crée les différents joueurs à chaque tour de boucle
				Joueur nouveau_joueur = new Joueur(i + 1, name_player, chosen_color, null, null);

				listeJoueurs[i] = nouveau_joueur;

				//System.out.println(listeJoueurs[i].getName() + " : " + listeJoueurs[i].getColor() + ", " + listeJoueurs[i].getId_joueur());
				String nom_roi = "roi";
				String nom_roi_bis = "roi_bis";
				Roi roi = new Roi("roi", nouveau_joueur, chosen_color, null);
				Roi roi_bis = new Roi("roibis", nouveau_joueur, chosen_color, null);

				// On ajoute roi et roisbis à la liste des rois et on met à jour roi dans joueur
				listeRois.add(roi);
				listeRois.add(roi_bis);

				nouveau_joueur.setRoi(roi);
				nouveau_joueur.setRoi_bis(roi_bis);

				//System.out.println(player.getRoi());
			}

		} else {
			for (int i = 0; i < nb_joueurs; i++) {
				String name_player;
				boolean isInteger;
				do {
					System.out.println("Indiquez le nom du joueur " + (i + 1) + " :");
					name_player = scanner.nextLine();
					try {
						int name_player_integer = Integer.parseInt(name_player);
						isInteger = true;
					} catch (NumberFormatException nfe) {
						isInteger = false;
					}
					if (name_player == "") {
						out.println("Veuillez entrer un nom non vide");
					}
					if (isInteger == true) {
						out.println("Veuillez entrer un nom non uniquement de type int");
					}
				} while (name_player == "" || isInteger == true);

				// On demande la couleur des joueurs parmi celles restantes
				System.out.println("Parmi les couleurs " + colors_list + " laquelle choisissez-vous ?");
				String chosen_color = scanner.nextLine();

				// On vérifie que la couleurs choisie appartient à la liste
				while (!(colors_list.contains(chosen_color))) {
					System.out.println("Vous devez choisir une couleur parmi : " + colors_list);
					chosen_color = scanner.nextLine();
				}
				players_color_list[i] = chosen_color;

				colors_list.remove(chosen_color);

				// On crée les différents joueurs à chaque tour de boucle
				Joueur player = new Joueur(i + 1, name_player, chosen_color, null, null);

				listeJoueurs[i] = player;
				//System.out.println(listeJoueurs[i].getName() + " : " + listeJoueurs[i].getColor() + ", " + listeJoueurs[i].getId_joueur());

				// On crée les différents rois avec leur couleur
				String nom_roi1 = "roi1";
				Roi roi = new Roi("roi1", player, chosen_color, null);
				listeRois.add(roi);
				player.setRoi(roi);

				//System.out.println(player.getRoi());
			}
		}
		// Message de bienvenue
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
			Domino domino = new Domino(id_domino, domaine1, domaine2, nbcouronnes1, nbcouronnes2, null, null, null, null);

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
		pioche = new ArrayList(playedDominos);

		// On crée la liste des dominos du plateau
		plateau = new ArrayList<Domino>();

		// On prend aléatoirement autant de dominos que de rois pour le plateau
		for (int i = 0; i < listeRois.size(); i++) {
			Domino domino = pioche.get(random.nextInt(pioche.size()));
			plateau.add(domino);
			pioche.remove(domino);
		}

		// On crée la liste des dominos contenus dans le plateau trié
		plateau_trie = new ArrayList<Domino>();

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
			plateau_trie.add(plateau.get(place_plus_petit_domino));
			plateau.remove(plateau.get(place_plus_petit_domino));
		}

		// Affichage du plateau et de la pioche
		String[][] board = new String[49][2];
		for (Domino x : plateau_trie) {
			board[x.getId_domino()][0] = String.valueOf(x.getId_domino());
			board[x.getId_domino()][1] = "Plateau";
		}
		for (Domino y : pioche) {
			board[y.getId_domino()][0] = String.valueOf(y.getId_domino());
			board[y.getId_domino()][1] = "Pioche";
		}

		for (String[] tab : board) {
			for (String s : tab) {
				System.out.print(s + "\t");
			}
			System.out.println("\n");
		}
	}


	public void premierTour() throws FileNotFoundException {

		// On crée la liste des id des dominos présents sur le plateau
		plateau_id = new ArrayList<>();
		for (Domino x : plateau_trie) {
			plateau_id.add(String.valueOf(x.getId_domino()));
		}

		// On récupère les informations de chaque domino du plateau
		for (Domino x : plateau_trie) {
			String domaine1 = x.getDomaine1();
			String domaine2 = x.getDomaine2();
			int nb_couronnes1 = x.getNb_couronnes1();
			int nb_couronnes2 = x.getNb_couronnes2();
		}

		Scanner scanner3 = new Scanner(System.in);

		// On crée l'odre de passage du tour suivant en fonction des dominos pris par les joueurs
		ordre_passage_suite = new ArrayList<Joueur>();

		// On mélange les rois dans la liste pour les choisir dans un ordre aléatoire
		Collections.shuffle(listeRois);

		// On crée la liste des joueurs dans l'ordre de passage
		ArrayList<Joueur> ordre_passage_1 = new ArrayList<Joueur>();

		// On définit l'ordre de passage des joueurs à partir du tirage des rois
		for (Roi roi : listeRois) {
			String id_color = roi.getColor();
			for (Joueur joueur : listeJoueurs) {
				if (joueur.getColor() == id_color) {
					ordre_passage_1.add(joueur);
				}
			}
		}

		// On crée le tableau des scores en fonction des joueurs
		// avec 2 colonnes et autant de lignes que de joueurs

		int[][] tableau_scores;
		if (nb_joueurs == 2) {
			tableau_scores = new int[nb_joueurs * 2][2];
		} else {
			tableau_scores = new int[nb_joueurs][2];
		}

		if (nb_joueurs == 2) {
			// Pour chaque joueur dans l'ordre de passage, on choisit un domino
			for (int i = 0; i < listeRois.size(); i++) {

				// Pour chaque joueur, l'id devient son ordre de passage dans le jeu
				//ordre_passage_1.get(i).setId_joueur(i + 1);

				// On demande au joueur quel domino il/elle choisit
				System.out.println(listeRois.get(i).getJoueur().getName() + ", choisissez sur quel domino vous voulez placer votre roi : " + plateau_id);
				String domino_choisi = scanner3.nextLine();

				//dominos_choisis.add(domino_choisi);

				// On vérifie que le numéro de domino choisi appartient bien à la liste
				while (!(plateau_id.contains(domino_choisi))) {
					System.out.println("Vous devez choisir un domino parmi : " + plateau_id);
					domino_choisi = scanner3.nextLine();
				}

				// Pour chaque domino choisi par un roi, on met à jour domino_roi dans Roi
				for (Domino domino_plateau : plateau_trie) {
					if (domino_plateau.getId_domino() == Integer.valueOf(domino_choisi)) {

						listeRois.get(i).setDomino_roi(domino_plateau);
						//out.println("id du domino du roi joué : " + listeRois.get(i).getDomino_roi().getId_domino());

						if (listeRois.get(i).getName() == "roi") {
							listeRois.get(i).getDomino_roi().setRoi_domino(listeRois.get(i));
							//out.println("nom du roi sur le domino choisi : " + listeRois.get(i).getDomino_roi().getRoi_domino().getName());
							//out.println("nom du joueur du roi posé sur le domino choisi : " + listeRois.get(i).getDomino_roi().getRoi_domino().getJoueur().getName());
						} else if (listeRois.get(i).getName() == "roibis") {
							listeRois.get(i).getDomino_roi().setRoi_bis_domino(listeRois.get(i));
							//out.println("nom du roi_bis sur le domino choisi :" + listeRois.get(i).getDomino_roi().getRoi_bis_domino().getName());
							//out.println("nom du joueur du roi_bis posé sur le domino choisi : " + listeRois.get(i).getDomino_roi().getRoi_bis_domino().getJoueur().getName());
						}
					}
				}
				// Une fois le domino choisi par un joueur, on le retire du plateau
				plateau_id.remove(domino_choisi);

			}
		} else {

			// Pour chaque joueur dans l'ordre de passage, on choisit un domino
			for (int i = 0; i < nb_joueurs; i++) {

				// On ajoute en première colonne les id des joueurs (dans l'ordre de passage)
				tableau_scores[i][0] = ordre_passage_1.get(i).getId_joueur();

				// On demande au joueur quel domino il/elle choisit
				System.out.println(ordre_passage_1.get(i).getName() + ", choisissez sur quel domino vous voulez placer votre roi : " + plateau_id);
				String domino_choisi = scanner3.nextLine();

				//dominos_choisis.add(domino_choisi);

				// On vérifie que le numéro de domino choisi appartient bien à la liste
				while (!(plateau_id.contains(domino_choisi))) {
					System.out.println("Vous devez choisir un domino parmi : " + plateau_id);
					domino_choisi = scanner3.nextLine();
				}

				// Pour chaque domino choisi pour un roi, on met à jour domino_roi dans Roi
				for (Domino x : plateau_trie) {
					if (x.getId_domino() == Integer.valueOf(domino_choisi)) {
						ordre_passage_1.get(i).getRoi().setDomino_roi(x);

						// Et on met à jour le roi du domino choisi
						ordre_passage_1.get(i).getRoi().getDomino_roi().setRoi_domino(ordre_passage_1.get(i).getRoi());
					}
				}

				// Une fois le domino choisi par un joueur, on le retire du plateau
				plateau_id.remove(domino_choisi);
			}

		}
		for (Domino domino_plateau : plateau_trie) {
			if (nb_joueurs == 2) {
				if (!(domino_plateau.getRoi_domino() == null)) {
					ordre_passage_suite.add((domino_plateau.getRoi_domino().getJoueur()));
				} else if (!(domino_plateau.getRoi_bis_domino() == null)) {
					ordre_passage_suite.add((domino_plateau.getRoi_bis_domino().getJoueur()));
				}
			} else {
				ordre_passage_suite.add(domino_plateau.getRoi_domino().getJoueur());
			}
		}

		// On définit l'emplacement du chateau (au centre du royaume)
		int colum_chateau = 4;
		int row_chateau = 4;

		// Pour chaque joueur dans l'ordre de passage, on place son domino
		if (nb_joueurs == 2) {
			for (int i = 0; i < ordre_passage_1.size(); i++) {

				// On crée un royaume par joueur et 2 royaumes par joueur s'il y a 2 joueurs
				// On crée aussi un chateau au centre de chaque royaume
				Royaume royaume = new Royaume(ordre_passage_1.get(i).getId_joueur(), 0);
				Royaume royaume_bis = new Royaume(ordre_passage_1.get(i).getId_joueur(), 0);

				Position position_chateau = new Position(colum_chateau, row_chateau);
				Chateau chateau = new Chateau(royaume, position_chateau);

				Position position_chateau_bis = new Position(colum_chateau, row_chateau);
				Chateau chateau_bis = new Chateau(royaume_bis, position_chateau_bis);

				// On crée la liste des 4 positions autour du chateau
				liste_positions_autour_chateau = new Position[4];

				// On parcourt dans l'ordre haut/bas/gauche/droite les cases autour du chateau :
				liste_positions_autour_chateau[0] = new Position(colum_chateau, row_chateau - 1);
				liste_positions_autour_chateau[1] = new Position(colum_chateau, row_chateau + 1);
				liste_positions_autour_chateau[2] = new Position(colum_chateau - 1, row_chateau);
				liste_positions_autour_chateau[3] = new Position(colum_chateau + 1, row_chateau);

				// On crée la liste des positions du domino (2 domaines)
				Position[] liste_positions = new Position[2];

				Scanner scanner4 = new Scanner(System.in);
				System.out.println(ordre_passage_1.get(i).getName() + ", placez votre premier domino dans votre royaume :");

				// On initialise les positions du domino
				int position_ligne1 = 0;
				int position_colonne1 = 0;
				int position_ligne2 = 0;
				int position_colonne2 = 0;

				// On vérifie que le premier domino est collé au chateau au centre du royaume
				// On vérifie que le joueur rentre bien une valeur de ligne et de colonne plausibles, sinon on redemande
				boolean incorrect_input = true;
				boolean do_we_continue;
				while (incorrect_input) {
					do {
						try {
							System.out.println("Indiquez la position du domaine 1 du domino (ligne) :");
							position_ligne1 = Integer.parseInt(scanner4.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);

					do {
						try {
							System.out.println("Indiquez la position du domaine 1 du domino (colonne) :");
							position_colonne1 = Integer.parseInt(scanner4.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);

					liste_positions[0] = new Position(position_colonne1, position_ligne1);

					do {
						try {
							System.out.println("Indiquez la position du domaine 2 du domino (ligne) :");
							position_ligne2 = Integer.parseInt(scanner4.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);

					do {
						try {
							System.out.println("Indiquez la position du domaine 2 du domino (colonne) :");
							position_colonne2 = Integer.parseInt(scanner4.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);


					liste_positions[1] = new Position(position_colonne2, position_ligne2);

					// On vérifie que les deux domaines du domino sont bien collés
					while (!(((position_colonne1 == position_colonne2) && (Math.abs(position_ligne1 - position_ligne2) == 1)) || ((position_ligne1 == position_ligne2) && (Math.abs(position_colonne1 - position_colonne2) == 1)))) {
						System.out.println("Les deux domaines de votre domino sont séparés... :( ");

						do {
							try {
								System.out.println("Indiquez à nouveau la position du domaine 1 du domino (ligne) :");
								position_ligne1 = Integer.parseInt(scanner4.nextLine());
								do_we_continue = true;
							} catch (NumberFormatException nfe) {
								do_we_continue = false;
							}
						} while (do_we_continue == false);

						do {
							try {
								System.out.println("Indiquez à nouveau la position du domaine 1 du domino (colonne) :");
								position_colonne1 = Integer.parseInt(scanner4.nextLine());
								do_we_continue = true;
							} catch (NumberFormatException nfe) {
								do_we_continue = false;
							}
						} while (do_we_continue == false);

						do {
							try {
								System.out.println("Indiquez à nouveau la position du domaine 2 du domino (ligne) :");
								position_ligne2 = Integer.parseInt(scanner4.nextLine());
								do_we_continue = true;
							} catch (NumberFormatException nfe) {
								do_we_continue = false;
							}
						} while (do_we_continue == false);

						do {
							try {
								System.out.println("Indiquez à nouveau la position du domaine 2 du domino (colonne) :");
								position_colonne2 = Integer.parseInt(scanner4.nextLine());
								do_we_continue = true;
							} catch (NumberFormatException nfe) {
								do_we_continue = false;
							}
						} while (do_we_continue == false);
					}

					// On met à jour les positions du domino
					liste_positions[0].setPositionColumn(position_colonne1);
					liste_positions[0].setPositionRow(position_ligne1);
					liste_positions[1].setPositionColumn(position_colonne2);
					liste_positions[1].setPositionRow(position_ligne2);

					// On vérifie que le premier domino est à côté du chateau
					for (int j = 0; j < 4; j++) {
						Position position_case = liste_positions_autour_chateau[j];
						if (position_case.equals(liste_positions[0]) || position_case.equals(liste_positions[1])) {
							incorrect_input = false;
						}
						if ((position_colonne1 == colum_chateau && position_ligne1 == row_chateau) || (position_colonne2 == colum_chateau && position_ligne2 == row_chateau)) {
							incorrect_input = true;
							break;
						}
					}
					if (incorrect_input == true) {
						System.out.println("Erreur, veuillez positionner votre domino à côté du chateau.");
					}
				}


				indice_temp = ordre_passage_1.get(i).getId_joueur();

				if (listeRois.get(i).getName() == "roi") {
					// On crée la position du domaine 1 du domino placé
					Position position_domaine1 = new Position(position_colonne1, position_ligne1);
					ordre_passage_1.get(i).getRoi().getDomino_roi().setPosition_domino1(position_domaine1);

					// On crée la position du domaine 2 du domino placé
					Position position_domaine2 = new Position(position_colonne2, position_ligne2);
					ordre_passage_1.get(i).getRoi().getDomino_roi().setPosition_domino2(position_domaine2);

					table.get(indice_temp - 1)[position_ligne1][position_colonne1] = ordre_passage_1.get(i).getRoi().getDomino_roi().getDomaine1();
					table.get(indice_temp - 1)[position_ligne2][position_colonne2] = ordre_passage_1.get(i).getRoi().getDomino_roi().getDomaine2();
				} else if (listeRois.get(i).getName() == "roibis") {

					// On crée la position du domaine 1 du domino placé
					Position position_domaine1 = new Position(position_colonne1, position_ligne1);
					ordre_passage_1.get(i).getRoi_bis().getDomino_roi().setPosition_domino1(position_domaine1);

					// On crée la position du domaine 2 du domino placé
					Position position_domaine2 = new Position(position_colonne2, position_ligne2);
					ordre_passage_1.get(i).getRoi_bis().getDomino_roi().setPosition_domino2(position_domaine2);

					table.get(indice_temp - 1)[position_ligne1][position_colonne1] = ordre_passage_1.get(i).getRoi_bis().getDomino_roi().getDomaine1();
					table.get(indice_temp - 1)[position_ligne2][position_colonne2] = ordre_passage_1.get(i).getRoi_bis().getDomino_roi().getDomaine2();
				}

				// On retire du plateau le domino placé par le joueur i

				plateau_trie.remove(ordre_passage_1.get(i).getRoi().getDomino_roi());
				plateau.remove(ordre_passage_1.get(i).getRoi().getDomino_roi());

				// On retire de la liste des id des dominos du plateau le domino choisi et placé
				int indexToRemove = 0;
				for (int x = 0; x < plateau_id.size(); x++) {
					if (plateau_id.get(x).equals(ordre_passage_1.get(i).getRoi().getDomino_roi().getId_domino())) {
						indexToRemove = x;
					}
				}
				plateau_id.remove(ordre_passage_1.get(indexToRemove));

				// --------------------- CALCUL DU SCORE -----------------------//


				// On définit les domaines et nombres de couronnes
				if (listeRois.get(i).getName() == "roi") {
					nb_couronnes_domaine1 = ordre_passage_1.get(i).getRoi().getDomino_roi().getNb_couronnes1();
					nb_couronnes_domaine2 = ordre_passage_1.get(i).getRoi().getDomino_roi().getNb_couronnes2();
					domaine1 = ordre_passage_1.get(i).getRoi().getDomino_roi().getDomaine1();
					domaine2 = ordre_passage_1.get(i).getRoi().getDomino_roi().getDomaine2();

					//royaume.setTaille_royaume();
				} else if (listeRois.get(i).getName() == "roibis") {
					nb_couronnes_domaine1 = ordre_passage_1.get(i).getRoi_bis().getDomino_roi().getNb_couronnes1();
					nb_couronnes_domaine2 = ordre_passage_1.get(i).getRoi_bis().getDomino_roi().getNb_couronnes2();
					String domaine1 = ordre_passage_1.get(i).getRoi_bis().getDomino_roi().getDomaine1();
					String domaine2 = ordre_passage_1.get(i).getRoi_bis().getDomino_roi().getDomaine2();
				}
				// On additionne les couronnes et on multiplie par 2 si les 2 domaines sont identiques
				if (domaine1 == domaine2) {
					tableau_scores[i][0] = 2 * (nb_couronnes_domaine1 + nb_couronnes_domaine2);
				} else {
					tableau_scores[i][0] = nb_couronnes_domaine1 + nb_couronnes_domaine2;
				}
			}

		}
		else {
			for (int i = 0; i < nb_joueurs; i++) {

				Royaume royaume = new Royaume(ordre_passage_1.get(i).getId_joueur(), 0);
				Position position_chateau = new Position(colum_chateau, row_chateau);
				Chateau chateau = new Chateau(royaume, position_chateau);

				// On crée la liste des 4 positions autour du chateau
				Position[] liste_positions_autour_chateau = new Position[4];

				// On parcourt dans l'ordre haut/bas/gauche/droite les cases autour du chateau :
				liste_positions_autour_chateau[0] = new Position(colum_chateau, row_chateau - 1);
				liste_positions_autour_chateau[1] = new Position(colum_chateau, row_chateau + 1);
				liste_positions_autour_chateau[2] = new Position(colum_chateau - 1, row_chateau);
				liste_positions_autour_chateau[3] = new Position(colum_chateau + 1, row_chateau);

				// On crée la liste des positions du domino (2 domaines)
				Position[] liste_positions = new Position[2];

				Scanner scanner4 = new Scanner(System.in);
				System.out.println(ordre_passage_1.get(i).getName() + ", placez votre premier domino dans votre royaume :");

				// On initialise les positions du domino
				int position_ligne1 = 0;
				int position_colonne1 = 0;
				int position_ligne2 = 0;
				int position_colonne2 = 0;

				int idDomino = ordre_passage_1.get(i).getRoi().getDomino_roi().getId_domino();
				Domino dominoDomaines = ordre_passage_1.get(i).getRoi().getDomino_roi();
				String domaine1 = dominoDomaines.getDomaine1();
				String domaine2 = dominoDomaines.getDomaine2();

				// On vérifie que le premier domino est collé au chateau au centre du royaume
				// On vérifie que le joueur rentre bien une valeur de ligne et de colonne plausibles, sinon on redemande
				boolean incorrect_input = true;
				boolean do_we_continue;
				while (incorrect_input) {
					do {
						try {
							System.out.println("Indiquez la position du domaine " + domaine1 + " du domino " + idDomino + " (ligne) :");
							position_ligne1 = Integer.parseInt(scanner4.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);

					do {
						try {
							System.out.println("Indiquez la position du domaine " + domaine1 + " du domino " + idDomino + " (colonne) :");
							position_colonne1 = Integer.parseInt(scanner4.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);

					liste_positions[0] = new Position(position_colonne1, position_ligne1);

					do {
						try {
							System.out.println("Indiquez la position du domaine " + domaine2 + " du domino " + idDomino + " (ligne) :");
							position_ligne2 = Integer.parseInt(scanner4.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);

					do {
						try {
							System.out.println("Indiquez la position du domaine " + domaine2 + " du domino " + idDomino + " (colonne) :");
							position_colonne2 = Integer.parseInt(scanner4.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);


					liste_positions[1] = new Position(position_colonne2, position_ligne2);

					// On vérifie que les deux domaines du domino sont bien collés
					while (!(((position_colonne1 == position_colonne2) && (Math.abs(position_ligne1 - position_ligne2) == 1)) || ((position_ligne1 == position_ligne2) && (Math.abs(position_colonne1 - position_colonne2) == 1)))) {
						System.out.println("Les deux domaines de votre domino sont séparés... :( ");

						do {
							try {
								System.out.println("Indiquez à nouveau la position du domaine 1 du domino (ligne) :");
								position_ligne1 = Integer.parseInt(scanner4.nextLine());
								do_we_continue = true;
							} catch (NumberFormatException nfe) {
								do_we_continue = false;
							}
						} while (do_we_continue == false);

						do {
							try {
								System.out.println("Indiquez à nouveau la position du domaine 1 du domino (colonne) :");
								position_colonne1 = Integer.parseInt(scanner4.nextLine());
								do_we_continue = true;
							} catch (NumberFormatException nfe) {
								do_we_continue = false;
							}
						} while (do_we_continue == false);

						do {
							try {
								System.out.println("Indiquez à nouveau la position du domaine 2 du domino (ligne) :");
								position_ligne2 = Integer.parseInt(scanner4.nextLine());
								do_we_continue = true;
							} catch (NumberFormatException nfe) {
								do_we_continue = false;
							}
						} while (do_we_continue == false);

						do {
							try {
								System.out.println("Indiquez à nouveau la position du domaine 2 du domino (colonne) :");
								position_colonne2 = Integer.parseInt(scanner4.nextLine());
								do_we_continue = true;
							} catch (NumberFormatException nfe) {
								do_we_continue = false;
							}
						} while (do_we_continue == false);
					}

					// On met à jour les positions du domino
					liste_positions[0].setPositionColumn(position_colonne1);
					liste_positions[0].setPositionRow(position_ligne1);
					liste_positions[1].setPositionColumn(position_colonne2);
					liste_positions[1].setPositionRow(position_ligne2);

					// On vérifie que le premier domino est à côté du chateau
					for (int j = 0; j < 4; j++) {
						Position position_case = liste_positions_autour_chateau[j];
						if (position_case.equals(liste_positions[0]) || position_case.equals(liste_positions[1])) {
							incorrect_input = false;
						}
						if ((position_colonne1 == colum_chateau && position_ligne1 == row_chateau) || (position_colonne2 == colum_chateau && position_ligne2 == row_chateau)) {
							incorrect_input = true;
							break;
						}
					}
					if (incorrect_input == true) {
						System.out.println("Erreur, veuillez positionner votre domino à côté du chateau.");
					}
				}

				indice_temp = ordre_passage_1.get(i).getId_joueur();

				table.get(indice_temp - 1)[position_ligne1][position_colonne1] = domaine1;
				table.get(indice_temp - 1)[position_ligne2][position_colonne2] = domaine2;

				// On crée la position du domaine 1 du domino placé
				Position position_domaine1 = new Position(position_colonne1, position_ligne1);
				ordre_passage_1.get(i).getRoi().getDomino_roi().setPosition_domino1(position_domaine1);

				// On crée la position du domaine 2 du domino placé
				Position position_domaine2 = new Position(position_colonne2, position_ligne2);
				ordre_passage_1.get(i).getRoi().getDomino_roi().setPosition_domino2(position_domaine2);


				// On retire du plateau le domino placé par le joueur i
				plateau_trie.remove(ordre_passage_1.get(i).getRoi().getDomino_roi());
				plateau.remove(ordre_passage_1.get(i).getRoi().getDomino_roi());

				// On retire de la liste des id des dominos du plateau le domino choisi et placé
				int indexToRemove = 0;
				for (int x = 0; x < plateau_id.size(); x++) {
					if (plateau_id.get(x).equals(ordre_passage_1.get(i).getRoi().getDomino_roi().getId_domino())) {
						indexToRemove = x;
					}
				}
				plateau_id.remove(ordre_passage_1.get(indexToRemove));

				// --------------------- CALCUL DU SCORE -----------------------//

				// On définit les domaines et nombres de couronnes
				int nb_couronnes_domaine1 = ordre_passage_1.get(i).getRoi().getDomino_roi().getNb_couronnes1();
				int nb_couronnes_domaine2 = ordre_passage_1.get(i).getRoi().getDomino_roi().getNb_couronnes2();
				domaine1 = ordre_passage_1.get(i).getRoi().getDomino_roi().getDomaine1();
				domaine2 = ordre_passage_1.get(i).getRoi().getDomino_roi().getDomaine2();

				// On additionne les couronnes et on multiplie par 2 si les 2 domaines sont identiques
				if (domaine1 == domaine2) {
					tableau_scores[i][0] = 2 * (nb_couronnes_domaine1 + nb_couronnes_domaine2);
				} else {
					tableau_scores[i][0] = nb_couronnes_domaine1 + nb_couronnes_domaine2;
				}
			}
		}

		out.println("----------------------------------------------------");

		for (int i = 0; i < ordre_passage_1.size(); i++) {
			out.println("Royaume " + (i + 1));
			for (int line = 0; line < table.get(i).length; line++) {
				for (int column = 0; column < table.get(i)[line].length; column++) {
					System.out.print(table.get(i)[line][column] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

		out.println("----------------------------------------------------");


	}

	public void SuiteJeu() {
		Scanner scanner5 = new Scanner(System.in);
		int faireUnAutreTour = 0;
		while (faireUnAutreTour != 3){
			Random random = new Random();
			// On prend aléatoirement autant de dominos que de rois pour le plateau
			for (int i = 0; i < listeRois.size(); i++) {
				Domino domino = pioche.get(random.nextInt(pioche.size()));
				plateau.add(domino);
				pioche.remove(domino);
			}

			while (plateau.size() != 0) {
				int plus_petit_id = plateau.get(0).getId_domino();
				int place_plus_petit_domino = 0;
				for (int j = 0; j < (plateau.size()); j++) {
					if (plateau.get(j).getId_domino() < plus_petit_id) {
						plus_petit_id = plateau.get(j).getId_domino();
						place_plus_petit_domino = j;
					}
				}
				plateau_trie.add(plateau.get(place_plus_petit_domino));
				plateau.remove(plateau.get(place_plus_petit_domino));
			}


			for (Domino x : plateau_trie) {
				String domaine1 = x.getDomaine1();
				String domaine2 = x.getDomaine2();
				int nb_couronnes1 = x.getNb_couronnes1();
				int nb_couronnes2 = x.getNb_couronnes2();
			}

			for (Domino x : plateau_trie) {
				plateau_id.add(String.valueOf(x.getId_domino()));
			}

			if (nb_joueurs == 2) {
				// Pour chaque joueur dans l'ordre de passage, on choisit un domino
				for (int i = 0; i < listeRois.size(); i++) {

					// Pour chaque joueur, l'id devient son ordre de passage dans le jeu
					//ordre_passage_suite.get(i).setId_joueur(i + 1);

					// On demande au joueur quel domino il/elle choisit
					System.out.println(listeRois.get(i).getJoueur().getName() + ", choisissez sur quel domino vous voulez placer votre roi : " + plateau_id);
					String domino_choisi = scanner5.nextLine();

					//dominos_choisis.add(domino_choisi);

					// On vérifie que le numéro de domino choisi appartient bien à la liste
					while (!(plateau_id.contains(domino_choisi))) {
						System.out.println("Vous devez choisir un domino parmi : " + plateau_id);
						domino_choisi = scanner5.nextLine();
					}

					// Pour chaque domino choisi par un roi, on met à jour domino_roi dans Roi
					for (Domino domino_plateau : plateau_trie) {
						if (domino_plateau.getId_domino() == Integer.valueOf(domino_choisi)) {

							listeRois.get(i).setDomino_roi(domino_plateau);
							//out.println("id du domino du roi joué : " + listeRois.get(i).getDomino_roi().getId_domino());

							if (listeRois.get(i).getName() == "roi") {
								listeRois.get(i).getDomino_roi().setRoi_domino(listeRois.get(i));
								//out.println("nom du roi sur le domino choisi : " + listeRois.get(i).getDomino_roi().getRoi_domino().getName());
								//out.println("nom du joueur du roi posé sur le domino choisi : " + listeRois.get(i).getDomino_roi().getRoi_domino().getJoueur().getName());
							} else if (listeRois.get(i).getName() == "roibis") {
								listeRois.get(i).getDomino_roi().setRoi_bis_domino(listeRois.get(i));
								//out.println("nom du roi_bis sur le domino choisi :" + listeRois.get(i).getDomino_roi().getRoi_bis_domino().getName());
								//out.println("nom du joueur du roi_bis posé sur le domino choisi : " + listeRois.get(i).getDomino_roi().getRoi_bis_domino().getJoueur().getName());
							}
						}
					}
					// Une fois le domino choisi par un joueur, on le retire du plateau
					plateau_id.remove(domino_choisi);

				}
			} else {

				// Pour chaque joueur dans l'ordre de passage, on choisit un domino
				for (int i = 0; i < nb_joueurs; i++) {

					// On demande au joueur quel domino il/elle choisit
					System.out.println(ordre_passage_suite.get(i).getName() + ", choisissez sur quel domino vous voulez placer votre roi : " + plateau_id);
					String domino_choisi = scanner5.nextLine();

					//dominos_choisis.add(domino_choisi);

					// On vérifie que le numéro de domino choisi appartient bien à la liste
					while (!(plateau_id.contains(domino_choisi))) {
						System.out.println("Vous devez choisir un domino parmi : " + plateau_id);
						domino_choisi = scanner5.nextLine();
					}

					// Pour chaque domino choisi pour un roi, on met à jour domino_roi dans Roi
					for (Domino x : plateau_trie) {
						if (x.getId_domino() == Integer.valueOf(domino_choisi)) {
							ordre_passage_suite.get(i).getRoi().setDomino_roi(x);

							// Et on met à jour le roi du domino choisi
							ordre_passage_suite.get(i).getRoi().getDomino_roi().setRoi_domino(ordre_passage_suite.get(i).getRoi());
						}
					}

					// Une fois le domino choisi par un joueur, on le retire du plateau
					plateau_id.remove(domino_choisi);
				}
			}

			for (int i = 0; i < ordre_passage_suite.size(); i++) {
				//int[][] taille_max = new int[13][13];

				// On définit l'emplacement du chateau (au centre du royaume)
				int colum_chateau = 4;
				int row_chateau = 4;

				// On crée la liste des 4 positions autour du chateau
				Position[] liste_positions_autour_chateau = new Position[4];

				// On parcourt dans l'ordre haut/bas/gauche/droite les cases autour du chateau :
				liste_positions_autour_chateau[0] = new Position(colum_chateau, row_chateau - 1);
				liste_positions_autour_chateau[1] = new Position(colum_chateau, row_chateau + 1);
				liste_positions_autour_chateau[2] = new Position(colum_chateau - 1, row_chateau);
				liste_positions_autour_chateau[3] = new Position(colum_chateau + 1, row_chateau);

				// On crée la liste des positions du domino (2 domaines)
				Position[] liste_positions = new Position[2];

				System.out.println(ordre_passage_suite.get(i).getName() + ", placez votre domino dans votre royaume :");

				// On initialise les positions du domino
				int position_ligne1 = 0;
				int position_colonne1 = 0;
				int position_ligne2 = 0;
				int position_colonne2 = 0;

				boolean do_we_continue;

				int idDomino = ordre_passage_suite.get(i).getRoi().getDomino_roi().getId_domino();
				Domino dominoDomaines = ordre_passage_suite.get(i).getRoi().getDomino_roi();
				String domaine1 = dominoDomaines.getDomaine1();
				String domaine2 = dominoDomaines.getDomaine2();

				do {
					do {
						try {
							System.out.println("Indiquez la position du domaine " + domaine1 + " domino " + idDomino + " (ligne) :");
							position_ligne1 = Integer.parseInt(scanner5.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);

					do {
						try {
							System.out.println("Indiquez la position du domaine " + domaine1 + " du domino " + idDomino + " (colonne) :");
							position_colonne1 = Integer.parseInt(scanner5.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);

					liste_positions[0] = new Position(position_colonne1, position_ligne1);

					do {
						try {
							System.out.println("Indiquez la position du domaine " + domaine2 + " du domino " + idDomino + " (ligne) :");
							position_ligne2 = Integer.parseInt(scanner5.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);

					do {
						try {
							System.out.println("Indiquez la position du domaine " + domaine2 + " du domino " + idDomino + " (colonne) :");
							position_colonne2 = Integer.parseInt(scanner5.nextLine());
							do_we_continue = true;
						} catch (NumberFormatException nfe) {
							do_we_continue = false;
						}
					} while (do_we_continue == false);
					// On détermine l'indice max et l'indice min en ligne et en colonne occupé pas un domino
					int min_ligne_temp = java.lang.Math.min(position_ligne1, position_ligne2);
					int min_col_temp = java.lang.Math.min(position_colonne1, position_colonne2);
					int max_ligne_temp = java.lang.Math.max(position_ligne1, position_ligne2);
					int max_col_temp = java.lang.Math.max(position_colonne1, position_colonne2);

					for (int line = 0; line < table.get(i).length; line++) {
						for (int column = 0; column < table.get(i)[line].length; column++) {
							if (table.get(i)[line][column] != "Vide") {
								max_ligne_temp = java.lang.Math.max(line, max_ligne_temp);
								max_col_temp = java.lang.Math.max(column, max_col_temp);
							}
						}
					}

					for (int line = table.get(i).length; line > 0; line--) {
						for (int column = table.get(i)[line - 1].length; column > 0; column--) {
							if (table.get(i)[line - 1][column - 1] != "Vide") {
								min_ligne_temp = java.lang.Math.min(line - 1, min_ligne_temp);
								min_col_temp = java.lang.Math.min(column - 1, min_col_temp);
							}
						}
					}
				} while (!isPositionCorrect(position_ligne1, position_colonne1, position_ligne2, position_colonne2, i, min_ligne_temp, min_col_temp, max_ligne_temp, max_col_temp));

				liste_positions[1] = new Position(position_colonne2, position_ligne2);


				// On met à jour les positions du domino
				liste_positions[0].setPositionColumn(position_colonne1);
				liste_positions[0].setPositionRow(position_ligne1);
				liste_positions[1].setPositionColumn(position_colonne2);
				liste_positions[1].setPositionRow(position_ligne2);

				indice_temp = ordre_passage_suite.get(i).getId_joueur();

				table.get(indice_temp - 1)[position_ligne1][position_colonne1] = domaine1;
				table.get(indice_temp - 1)[position_ligne2][position_colonne2] = domaine2;

				// On crée la position du domaine 1 du domino placé
				Position position_domaine1 = new Position(position_colonne1, position_ligne1);
				ordre_passage_suite.get(i).getRoi().getDomino_roi().setPosition_domino1(position_domaine1);

				// On crée la position du domaine 2 du domino placé
				Position position_domaine2 = new Position(position_colonne2, position_ligne2);
				ordre_passage_suite.get(i).getRoi().getDomino_roi().setPosition_domino2(position_domaine2);

				// On retire de la liste des id des dominos du plateau le domino choisi et placé
				int indexToRemove = 0;
				for (int x = 0; x < plateau_id.size(); x++) {
					if (plateau_id.get(x).equals(ordre_passage_suite.get(i).getRoi().getDomino_roi().getId_domino())) {
						indexToRemove = x;
					}
				}
				plateau_id.remove(ordre_passage_suite.get(indexToRemove));


				// --------------------- CALCUL DU SCORE -----------------------//

				// On définit les domaines et nombres de couronnes
				/*int nb_couronnes_domaine1 = ordre_passage_suite.get(i).getRoi().getDomino_roi().getNb_couronnes1();
				out.println("couronnes domaine 1 : " + nb_couronnes_domaine1);
				int nb_couronnes_domaine2 = ordre_passage_suite.get(i).getRoi().getDomino_roi().getNb_couronnes2();
				out.println("couronnes domaine 2 : " + nb_couronnes_domaine2);
				domaine1 = ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1();
				out.println("nom domaine 1 " + domaine1);
				domaine2 = ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2();
				out.println("nom domaine 2 " + domaine2);

				// On additionne les couronnes et on multiplie par 2 si les 2 domaines sont identiques
				if (domaine1 == domaine2) {
					tableau_scores[i][0] = 2 * (nb_couronnes_domaine1 + nb_couronnes_domaine2);
				} else {
					tableau_scores[i][0] = nb_couronnes_domaine1 + nb_couronnes_domaine2;
				}
				out.println(tableau_scores[i][0]);*/

			}


			out.println("----------------------------------------------------");

			for (int i = 0; i < ordre_passage_suite.size(); i++) {
				out.println("Royaume " + (i + 1));
				for (int line = 0; line < table.get(i).length; line++) {
					for (int column = 0; column < table.get(i)[line].length; column++) {
						System.out.print(table.get(i)[line][column] + " ");
					}
					System.out.println();
				}
				System.out.println();

			}

			out.println("----------------------------------------------------");

			// A ajouter à la fin, pour l'ordre du tour suivant
			ordre_passage_suite.clear();
			for (Domino domino_plateau : plateau_trie) {
				ordre_passage_suite.add(domino_plateau.getRoi_domino().getJoueur());
			}

			// Permet de faire un dernier tour lorsque la pioche est vide
			if (pioche.size() == 0) {
				faireUnAutreTour += 1;
			}

			for (int i = 0; i < ordre_passage_suite.size(); i++) {
				// On retire du plateau le domino placé par le joueur i
				plateau_trie.remove(ordre_passage_suite.get(i).getRoi().getDomino_roi());
				plateau.remove(ordre_passage_suite.get(i).getRoi().getDomino_roi());
			}
		}



		// On détermine le royaume le plus grand

		/*int[][] plusGrandRoyaume = new int[4][4];

		for (int i=0; i<4; i++){
			int max_ligne_temp = 4;
			int max_col_temp = 4;
			for (int line = 0; line < table.get(i).length; line++) {
				for (int column = 0; column < table.get(i)[line].length; column++) {
					if (table.get(i)[line][column] != "Vide") {
						max_ligne_temp = java.lang.Math.max(line, max_ligne_temp);
						max_col_temp = java.lang.Math.max(column, max_col_temp);
					}
				}
			}
			plusGrandRoyaume[i][0] = max_ligne_temp;
			plusGrandRoyaume[i][1] = max_col_temp;
		}

		for (int i=0; i<4; i++){
			int min_ligne_temp = 4;
			int min_col_temp = 4;
			for (int line = table.get(i).length; line > 0; line--) {
				for (int column = table.get(i)[line - 1].length; column > 0; column--) {
					if (table.get(i)[line - 1][column - 1] != "Vide") {
						min_ligne_temp = java.lang.Math.min(line - 1, min_ligne_temp);
						min_col_temp = java.lang.Math.min(column - 1, min_col_temp);
					}
				}
			}
			plusGrandRoyaume[i][2] = min_ligne_temp;
			plusGrandRoyaume[i][3] = min_col_temp;
		}


		for (int line = 0; line < 4; line++) {
			for (int column = 0; column < 4; column++) {
				System.out.print(plusGrandRoyaume[line][column] + " ");
			}
			System.out.println();
		}

		int[][] extreme = new int[1][4];

		extreme[0][0] = Math.max(Math.abs(plusGrandRoyaume[0][0]-plusGrandRoyaume[0][2]),Math.abs(plusGrandRoyaume[0][1]-plusGrandRoyaume[0][3]));
		extreme[0][1] = Math.max(Math.abs(plusGrandRoyaume[1][0]-plusGrandRoyaume[1][2]),Math.abs(plusGrandRoyaume[1][1]-plusGrandRoyaume[1][3]));
		extreme[0][2] = Math.max(Math.abs(plusGrandRoyaume[2][0]-plusGrandRoyaume[2][2]),Math.abs(plusGrandRoyaume[2][1]-plusGrandRoyaume[2][3]));
		extreme[0][3] = Math.max(Math.abs(plusGrandRoyaume[3][0]-plusGrandRoyaume[3][2]),Math.abs(plusGrandRoyaume[3][1]-plusGrandRoyaume[3][3]));

		int indice_max_temp =0;
		int max_temp =extreme[0][0];

		for (int i=0; i<4;i++){
			if (extreme[0][i]>max_temp){
				indice_max_temp = i;
				max_temp = extreme[0][i];
			}
		}

		out.println(indice_max_temp);*/

		

	}

	public boolean isPositionCorrect(int position_ligne1, int position_colonne1, int position_ligne2, int position_colonne2, int i, int min_ligne_temp, int min_col_temp, int max_ligne_temp, int max_col_temp) {

		// On regarde si l'entrée saisie est dans le Royaume
		if (Math.abs(position_colonne1-colum_chateau)>4 || Math.abs(position_colonne2-colum_chateau)>4 || Math.abs(position_ligne1-row_chateau)>4 || Math.abs(position_ligne2-row_chateau)>4){
			out.println("Veuilez ne pas sortir du Royaume");
			return false;
		}
		// On vérifie que le premier domino est à côté du chateau
		boolean correct_input = false;
		Position[] liste_positions = new Position[2];
		liste_positions[0] = new Position(position_colonne1, position_ligne1);
		liste_positions[1] = new Position(position_colonne2, position_ligne2);
		liste_positions[0].setPositionColumn(position_colonne1);
		liste_positions[0].setPositionRow(position_ligne1);
		liste_positions[1].setPositionColumn(position_colonne2);
		liste_positions[1].setPositionRow(position_ligne2);
		liste_positions_autour_chateau[0] = new Position(colum_chateau, row_chateau - 1);
		liste_positions_autour_chateau[1] = new Position(colum_chateau, row_chateau + 1);
		liste_positions_autour_chateau[2] = new Position(colum_chateau - 1, row_chateau);
		liste_positions_autour_chateau[3] = new Position(colum_chateau + 1, row_chateau);
		for (int j = 0; j < 4; j++) {
			Position position_case = liste_positions_autour_chateau[j];
			if (position_case.equals(liste_positions[0]) || position_case.equals(liste_positions[1])) {
				correct_input = true;
			}
		}
		// On vérifie que les deux domaines du domino sont bien collés
		if (!(((position_colonne1 == position_colonne2) && (Math.abs(position_ligne1 - position_ligne2) == 1)) || ((position_ligne1 == position_ligne2) && (Math.abs(position_colonne1 - position_colonne2) == 1)))) {
			out.println("Erreur, veuillez indiquer une position pour laquelle les domaines du domino sont collés");
			return false;
		}

		// On vérifie que un des deux domaines est à côté d'un même domaine ou du chateau
		if(position_ligne1 == 0){
			if (!(table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 + 1][position_colonne1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 - 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 + 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| correct_input)) {
				out.println("Erreur, veuillez indiquer une position pour laquelle un des deux domaines est à côté d'un même domaine ou du chateau");
				return false;
			}
		}
		if (position_colonne1 == 0){
			if (!(table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 - 1][position_colonne1].equals(ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 + 1][position_colonne1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 - 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 + 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| correct_input)) {
				out.println("Erreur, veuillez indiquer une position pour laquelle un des deux domaines est à côté d'un même domaine ou du chateau");
				return false;
			}
		}
		if (position_ligne2 == 0){
			if (!(table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 - 1][position_colonne1].equals(ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 + 1][position_colonne1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 + 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| correct_input)) {
				out.println("Erreur, veuillez indiquer une position pour laquelle un des deux domaines est à côté d'un même domaine ou du chateau");
				return false;
			}
		}
		if (position_colonne2 == 0){
			if (!(table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 - 1][position_colonne1].equals(ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 + 1][position_colonne1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 - 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 + 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| correct_input)) {
				out.println("Erreur, veuillez indiquer une position pour laquelle un des deux domaines est à côté d'un même domaine ou du chateau");
				return false;
			}
		}
		if (position_ligne1 == 8){
			if (!(table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 - 1][position_colonne1].equals(ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 - 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 + 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| correct_input)) {
				out.println("Erreur, veuillez indiquer une position pour laquelle un des deux domaines est à côté d'un même domaine ou du chateau");
				return false;
			}
		}
		if (position_colonne1 == 8){
			if (!(table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 - 1][position_colonne1].equals(ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 + 1][position_colonne1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 - 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 + 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| correct_input)) {
				out.println("Erreur, veuillez indiquer une position pour laquelle un des deux domaines est à côté d'un même domaine ou du chateau");
				return false;
			}
		}
		if (position_ligne2 == 8){
			if (!(table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 - 1][position_colonne1].equals(ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 + 1][position_colonne1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 - 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| correct_input)) {
				out.println("Erreur, veuillez indiquer une position pour laquelle un des deux domaines est à côté d'un même domaine ou du chateau");
				return false;
			}
		}
		if (position_colonne2 == 8){
			if (!(table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 - 1][position_colonne1].equals(ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 + 1][position_colonne1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 - 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 + 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
					|| correct_input)) {
				out.println("Erreur, veuillez indiquer une position pour laquelle un des deux domaines est à côté d'un même domaine ou du chateau");
				return false;
			}
		}
		if (!(table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 - 1][position_colonne1].equals(ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
				|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
				|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1 + 1][position_colonne1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
				|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine1())
				|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 - 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
				|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 + 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
				|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2 + 1][position_colonne2].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
				|| table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2 - 1].equals( ordre_passage_suite.get(i).getRoi().getDomino_roi().getDomaine2())
				|| correct_input)) {
			out.println("Erreur, veuillez indiquer une position pour laquelle un des deux domaines est à côté d'un même domaine ou du chateau");
			return false;
		}
		// Tant que le domino est pas sur un emplacement vide, on redemande
		if (((table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne1][position_colonne1] != "Vide") || (table.get(ordre_passage_suite.get(i).getId_joueur() - 1)[position_ligne2][position_colonne2] != "Vide"))) {
			out.println("Erreur, veuillez indiquer un emplacement vide");
			return false;
		}
		// Tant que la taille du terrain de jeu dépasse pas 5 domaine, on redemande
		if (((max_ligne_temp - min_ligne_temp) >= 5 || (max_col_temp - min_col_temp) >= 5)) {
			out.println("Erreur, veuillez indiquer une position pour laquelle la taille du royaume est de maximum 5 domaines");

			if (!((max_ligne_temp - min_ligne_temp) >= 5 || (max_col_temp - min_col_temp) >= 5)) {
				out.println("Erreur, veuillez indiquer une position pour laquelle la taille du royaume est de maximum 5x5");
				return false;
			}
			return true;
		}
		return true;
	}
}