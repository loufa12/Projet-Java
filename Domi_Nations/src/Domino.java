
public class Domino {
	protected String id_domino;
	protected String couleur1;
	protected String couleur2;
	protected int nb_couronnes;

	public Domino(String id_domino, String couleur1, String couleur2, int nb_couronnes) {
		this.id_domino = id_domino;
		this.couleur1 = couleur1;
		this.couleur2 = couleur2;
		this.nb_couronnes = nb_couronnes;
	}

	public String getId_domino() {
		return id_domino;
	}

	public void setId_domino(String id_domino) {
		this.id_domino = id_domino;
	}

	public String getCouleur1() {
		return couleur1;
	}

	public void setCouleur1(String couleur1) {
		this.couleur1 = couleur1;
	}

	public String getCouleur2() {
		return couleur2;
	}

	public void setCouleur2(String couleur2) {
		this.couleur2 = couleur2;
	}

	public int getNb_couronnes() {
		return nb_couronnes;
	}

	public void setNb_couronnes(int nb_couronnes) {
		this.nb_couronnes = nb_couronnes;
	}
}
