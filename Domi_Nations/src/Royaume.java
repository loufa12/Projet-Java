
public class Royaume {
	protected int id_joueur;
	protected int[][] taille_royaume;

	public Royaume (int id_joueur, int[][] taille) {
		this.id_joueur = id_joueur;
		this.taille_royaume = taille_royaume;
	}

	public int getId_joueur() {
		return id_joueur;
	}
	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public int[][] getTaille_royaume() {
		return taille_royaume;
	}
	public void setTaille_royaume(int[][] taille) {
		this.taille_royaume = taille_royaume;
	}

}
