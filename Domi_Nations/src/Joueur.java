
public class Joueur {
	protected int id_joueur;
	protected String name;
	protected String color;
	protected Roi roi;
	protected Roi roi_bis;

	public Joueur(int id_joueur, String name, String color, Roi roi, Roi roi_bis) {
		this.id_joueur = id_joueur;
		this.name = name;
		this.color = color;
		this.roi = roi;
		this.roi_bis = roi_bis;
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

	public Roi getRoi_bis() {
		return roi_bis;
	}

	public void setRoi_bis(Roi roi_bis) {
		this.roi_bis = roi_bis;
	}
}
