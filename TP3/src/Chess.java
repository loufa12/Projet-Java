import java.util.Scanner;

public class Chess {
	private Cell[][] board;
	private Player[] players;
	private Player currentPlayer;
	public void play() {
		while (true) {
			createPlayers();
			initialiseBoard();
			while (!isCheckMate()) {
				printBoard();
				String move;
				do {
				move = askMove();
				}
				while (!isValidMove(move));
				updateBoard(move);
				switchPlayer();
			}
		}
	}
	
	
	private void createPlayers() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bonjour premier joueur, quel est votre nom ?");
		String firstPlayer = scanner.nextLine();
		System.out.println("Bonjour deuxième joueur, quel est votre nom ?");
		String secondPlayer = scanner.nextLine();
		
	}
	
	
	private void initialiseBoard() {
		
	}
	
	
	private void initialiseBoard() {
		
	}
	
	
	private String askMove() {
		
	}
	
	
	private boolean isCheckMate() {
		
	}
	
	
	private boolean isValidMove(String move) {
		
	}
	
	
	private void updateBoard(String move) {
		
	}
	
	
	private void switchPlayer() {
		
	}

}
