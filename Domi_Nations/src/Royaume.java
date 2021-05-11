
public class Royaume {
	protected int id_joueur;
	protected String taille;
	protected String type;

	public Royaume (int id_joueur, String taille, String type) {
		this.id_joueur = id_joueur;
		this.taille = taille;
		this.type = type;
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

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
