
public class Joueur {
	protected int id_joueur;
	protected String name;
	protected String color;
	protected Roi roi;
	protected Score score;

	public Joueur(int id_joueur, String name, String color, Roi roi, Score score) {
		this.id_joueur = id_joueur;
		this.name = name;
		this.color = color;
		this.roi = roi;
		this.score = score;
	}

	public int getId_joueur() {
		return id_joueur;
	}
	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public Roi getRoi() {
		return roi;
	}
	public void setRoi(Roi roi) {
		this.roi = roi;
	}

	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
}
