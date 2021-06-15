
public class Roi {
	protected String name;
	protected Joueur joueur;
	protected String color;
	protected Domino domino_roi;

	public Roi(String name, Joueur joueur, String color, Domino domino_roi) {
		this.name = name;
		this.joueur = joueur;
		this.color = color;
		this.domino_roi = domino_roi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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