import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Joueur joueur = new Joueur();
		Partie partie = new Partie();
		//partie.play();
		partie.createPlayers();
	}
	public static void test() {
		Scanner scanner = new Scanner(System.in);
		System.out.print( "Quel est le nombre de joueurs ?");
        int NbJoueurs = scanner.nextInt();
		//System.out.print("Bienvenue " + Nom + " !");
	}
}
