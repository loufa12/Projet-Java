
public class Domaine {
	protected String id_domaine;
	protected String taille;
	protected String type;

	public Domaine (String id_domaine, String taille, String type) {
		this.id_domaine = id_domaine;
		this.taille = taille;
		this.type = type;
	}

	public String getId_domaine() {
		return id_domaine;
	}

	public void setId_domaine(String id_domaine) {
		this.id_domaine = id_domaine;
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
