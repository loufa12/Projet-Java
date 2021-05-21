import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	// Lance le jeu.
	public static void main(String[] args) throws FileNotFoundException {
		Partie partie = new Partie();
		partie.creationJoueurs();
		partie.creationDominos();

	}
}


