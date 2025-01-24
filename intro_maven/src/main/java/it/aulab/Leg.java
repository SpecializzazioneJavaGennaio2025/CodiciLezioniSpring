package it.aulab;

public class Leg {
    private Side side;

    public Leg(Side side) {
        this.side = side;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public void walk() {
        System.out.println("Cammina con la " + side);
    }

    
}
