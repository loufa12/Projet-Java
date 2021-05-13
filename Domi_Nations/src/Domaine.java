
public class Domaine {
	protected String type_domaine;
	protected String taille;

	public Domaine (String id_domaine, String taille) {
		this.type_domaine = type_domaine;
		this.taille = taille;
	}

	public String getType_domaine() {
		return type_domaine;
	}
	public void setType_domaine(String type_domaine) {
		this.type_domaine = type_domaine;
	}

	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}


}
