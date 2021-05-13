
public class Roi {
	protected int id_roi;
	protected String color;
	protected Domino domino_roi;

	public Roi(int id_roi, String color, Domino domino_roi) {
		this.id_roi = id_roi;
		this.color = color;
		this.domino_roi = domino_roi;
	}

	public int getId_roi() {
		return id_roi;
	}
	public void setId_roi(int id_roi) {
		this.id_roi = id_roi;
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