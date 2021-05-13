
public class Royaume {
	protected int id_joueur;
	protected String taille;

	public Royaume (int id_joueur, String taille) {
		this.id_joueur = id_joueur;
		this.taille = taille;
	}

	public int getId_joueur() {
		return id_joueur;
	}
	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}

}
