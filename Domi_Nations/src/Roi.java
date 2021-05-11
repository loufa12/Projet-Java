
public class Roi {
	protected int id_roi;
	protected String color;

	public Roi(int id_roi, String color) {
		this.id_roi = id_roi;
		this.color = color;
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
}