
public class Royaume {
	protected int id_joueur;
	protected int taille_royaume_max;

	public Royaume (int id_joueur, int taille_royaume_max) {
		this.id_joueur = id_joueur;
		this.taille_royaume_max = taille_royaume_max;
	}

	public int getId_joueur() {
		return id_joueur;
	}
	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public int getTaille_royaume_max() {
		return taille_royaume_max;
	}
	public void setTaille_royaume_max(int taille) {
		this.taille_royaume_max = taille_royaume_max;
	}

	public void verifTailleRoyaume(Royaume royaume_a_verifier, int position_ligne1, int position_ligne2, int position_col1, int position_col2) {
		int max1 = Math.max(position_col2, position_col1);
		int max2 = Math.max(position_ligne1, position_ligne2);
		int max = Math.max(max1, max2);

	}
}
