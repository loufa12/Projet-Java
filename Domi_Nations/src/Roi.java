
public class Roi {
	protected Joueur joueur;
	protected String color;
	protected Domino domino_roi;

	public Roi(Joueur joueur, String color, Domino domino_roi) {
		this.joueur = joueur;
		this.color = color;
		this.domino_roi = domino_roi;
	}

	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String couleur) {
		this.color = color;
	}

	public Domino getDomino_roi() {
		return domino_roi;
	}
	public void setDomino_roi(Domino domino_roi) {
		this.domino_roi = domino_roi;
	}
}