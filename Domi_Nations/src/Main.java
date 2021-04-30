import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Joueur joueur = new Joueur();
		Partie partie = new Partie();
		partie.play();	
	}
	public static void test() {
		Scanner scanner = new Scanner(System.in);
        System.out.print( "Veuillez saisir un premier entier : " );
        String Nom = scanner.nextLine();        
        System.out.print("Bonjour : "+ Nom);

	}
}
