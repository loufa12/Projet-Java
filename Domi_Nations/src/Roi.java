
public class Roi {
	protected String id_roi;
	protected String couleur;
	protected String ordre;

	public Roi(String id_roi, String couleur, String ordre) {
		this.id_roi = id_roi;
		this.couleur = couleur;
		this.ordre = ordre;
	}

	public String getId_roi() {
		return id_roi;
	}

	public void setId_roi(String id_roi) {
		this.id_roi = id_roi;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getOrdre() {
		return ordre;
	}

	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}
}