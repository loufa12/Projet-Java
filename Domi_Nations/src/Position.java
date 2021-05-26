public class Position {

    protected int column_domaine1;
    protected int column_domaine2;
    protected int row_domaine1;
    protected int row_domaine2;

    public Position(int column_domaine1, int row1, int column_domaine2, int row2){
        this.column_domaine1 = column_domaine1;
        this.row_domaine1 = row_domaine1;
        this.column_domaine2 = column_domaine2;
        this.row_domaine2 = row_domaine2;
    }

    // Getters/setters :
    public int getPositionColumn1() {
        return column_domaine1;
    }
    public void setPositionColumn1(int column_domaine1) {
        this.column_domaine1 = column_domaine1;
    }

    public int getPositionColumn2() {
        return column_domaine2;
    }
    public void setPositionColumn2(int column_domaine2) {
        this.column_domaine2 = column_domaine2;
    }

    public int getPositionRow1() {
        return row_domaine1;
    }
    public void setPositionRow1(int row_domaine1) {
        this.row_domaine1 = row_domaine1;
    }

    public int getPositionRow2() {
        return row_domaine2;
    }
    public void setPositionRow2(int row_domaine2) {
        this.row_domaine2 = row_domaine2;
    }
}
