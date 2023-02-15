package Models;

import java.util.Random;

public class CaseSaut extends Case {
    private int jump;
    public CaseSaut(){
        Random random = new Random();
        this.jump = random.nextInt(99) + 1;
    }
    public CaseSaut(Couleur color) {
        super(color);
    }

    public int getJump() {
        return jump;
    }
}
