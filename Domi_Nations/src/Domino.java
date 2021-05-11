
public class Domino {
	protected String id_domino;
	protected String domaine1;
	protected String domaine2;
	protected int nb_couronnes;

	public Domino(String id_domino, String domaine1, String domaine2, int nb_couronnes) {
		this.id_domino = id_domino;
		this.domaine1 = domaine1;
		this.domaine2 = domaine2;
		this.nb_couronnes = nb_couronnes;
	}

	public String getId_domino() {
		return id_domino;
	}

	public void setId_domino(String id_domino) {
		this.id_domino = id_domino;
	}

	public String getDomaine1() {
		return domaine1;
	}

	public void setDomaine1(String couleur1) {
		this.domaine1 = domaine1;
	}

	public String getDomaine2() {
		return domaine2;
	}

	public void setDomaine2(String couleur2) {
		this.domaine2 = domaine2;
	}

	public int getNb_couronnes() {
		return nb_couronnes;
	}

	public void setNb_couronnes(int nb_couronnes) {
		this.nb_couronnes = nb_couronnes;
	}
}
