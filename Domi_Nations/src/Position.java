public class Position {
    protected int column;
    protected int row;

    public Position(int column, int row) {
        this.column = column;
        this.row = row;
    }

    // Getters/setters :
    public int getPositionColumn() {
        return column;
    }

    public void setPositionColumn(int column) {
        this.column = column;
    }

    public int getPositionRow() {
        return row;
    }

    public void setPositionRow(int row) {
        this.row = row;
    }

    public boolean equals(Position otherPosition) {
        if (this.column == otherPosition.getPositionColumn() && this.row == otherPosition.getPositionRow()) {
            return true;
        }
        else {
            return false;
        }
    }

}