package Models;

public abstract class Case {
    protected Couleur color;

    public Case(){};

    public Case(Couleur color) {
        this.color = color;
    }

    public Couleur getColor() {
        return color;
    }

    public void setColor(Couleur color) {
        this.color = color;
    }

}
