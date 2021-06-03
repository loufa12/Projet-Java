
public class Domino {
	protected int id_domino;
	protected String domaine1;
	protected String domaine2;
	protected int nb_couronnes1;
	protected int nb_couronnes2;
	protected Position position_domino1;
	protected Position position_domino2;

	public Domino(int id_domino, String domaine1, String domaine2, int nb_couronnes1, int nb_couronnes2, Position position_domino, Position position_domino2) {
		this.id_domino = id_domino;
		this.domaine1 = domaine1;
		this.domaine2 = domaine2;
		this.nb_couronnes1 = nb_couronnes1;
		this.nb_couronnes2 = nb_couronnes2;
		this.position_domino1 = position_domino1;
		this.position_domino2 = position_domino2;
	}

	public int getId_domino() {
		return 	id_domino;
	}
	public void setId_domino(int id_domino) {
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

	public int getNb_couronnes1() {
		return nb_couronnes1;
	}
	public void setNb_couronnes1(int nb_couronnes1) {
		this.nb_couronnes1 = nb_couronnes1;
	}

	public int getNb_couronnes2() {
		return nb_couronnes2;
	}
	public void setNb_couronnes2(int nb_couronnes2) {
		this.nb_couronnes2 = nb_couronnes2;
	}

	public Position getPosition_domino1() {
		return position_domino1;
	}
	public void setPosition_domino1(Position position_domino1) {
		this.position_domino1 = position_domino1;
	}

	public Position getPosition_domino2() {
		return position_domino2;
	}
	public void setPosition_domino2(Position position_domino2) {
		this.position_domino2 = position_domino2;
	}
}
