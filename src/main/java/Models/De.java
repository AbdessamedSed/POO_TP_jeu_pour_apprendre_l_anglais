package Models;

import java.util.Random;

public class De {
    private Couleur color;

    public De(Couleur color) {
        this.color = color;
    }

    public Couleur getColor() {
        return color;
    }

    public void setColor(Couleur color) {
        this.color = color;
    }

    public int LancerDe() {
        Random rand = new Random();
        return (rand.nextInt(6) % 6 + 1);
    }

}
