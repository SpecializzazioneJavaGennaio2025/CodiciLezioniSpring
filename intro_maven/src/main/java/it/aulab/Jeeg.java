package it.aulab;

public class Jeeg {
    private Arm armSx;
    private Arm armDx;
    private Leg legSx;
    private Leg legDx;

    public Jeeg(Arm armSx, Arm armDx, Leg legSx, Leg legDx) {
        this.armSx = armSx;
        this.armDx = armDx;
        this.legSx = legSx;
        this.legDx = legDx;
    }

    public Arm getArmSx() {
        return armSx;
    }

    public void setArmSx(Arm armSx) {
        this.armSx = armSx;
    }

    public Arm getArmDx() {
        return armDx;
    }

    public void setArmDx(Arm armDx) {
        this.armDx = armDx;
    }

    public Leg getLegSx() {
        return legSx;
    }

    public void setLegSx(Leg legSx) {
        this.legSx = legSx;
    }

    public Leg getLegDx() {
        return legDx;
    }

    public void setLegDx(Leg legDx) {
        this.legDx = legDx;
    }

    
}
