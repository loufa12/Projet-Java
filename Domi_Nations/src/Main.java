import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Partie partie = new Partie();
		test();
	}
	public static void test() {
		Scanner scanner = new Scanner(System.in);
        System.out.print( "Veuillez saisir un premier entier : " );
        String Nom = scanner.nextLine();        
        System.out.print("Bonjour : "+ Nom);

	}
}
