public class Chateau {
    protected Royaume royaume;
    protected Position position;

    public Chateau(Royaume royaume, Position position){
        this.royaume = royaume;
        this.position = position;
    }

    public Royaume getRoyaume() {
        return royaume;
    }
    public void setRoyaume(Royaume royaume) {
        this.royaume = royaume;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
