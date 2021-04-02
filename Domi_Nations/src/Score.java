
public class Score {
	protected String id_score;
	protected int score;

	public Score(String id_score, int score) {
		this.id_score = id_score;
	}

	public String getId_score() {
		return id_score;
	}

	public void setId_score(String id_score) {
		this.id_score = id_score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
