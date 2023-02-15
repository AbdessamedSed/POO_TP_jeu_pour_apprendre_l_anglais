package Models;

public class Plateau {
    private Case[] cases;
    private final int nbrCases = 100;

    public Plateau() {
        this.cases = new Case[this.nbrCases];
    }

    public Case[] getCases() {
        return cases;
    }

    public void setCases(Case[] cases) {
        this.cases = cases;
    }

    public int getNbrCases() {
        return nbrCases;
    }


    public boolean contains(int[] tab, int nbr) {
        for (int i : tab) {
            if (i == nbr) return true;
        }
        return false;
    }

    public void CreatePlateau(int tab[]) {

        /* Case de depart */
        this.cases[0] = new CaseDepart(Couleur.YELLOW);

        /* Cases Bonus */
        for (int i = 0; i < 5; i++) {
            this.cases[tab[i]] = new CaseBonus(Couleur.GREEN);
        }
        /* Cases Malus */
        for (int i = 5; i < 10; i++) {
            this.cases[tab[i]] = new CaseMalus(Couleur.RED);
        }

        /* Cases Saut */
        for (int i = 10; i < 15; i++) {
            this.cases[tab[i]] = new CaseSaut(Couleur.ORANGE);
        }

        /* Cases Question Définition */

        for (int i = 15; i < 20; i++) {
            this.cases[tab[i]] = new Definition(Couleur.BLUE) {
            };
        }

        /* Cases Image */
        for (int i = 20; i < 25; i++) {
            this.cases[tab[i]] = new ImageQue(Couleur.PINK);
        }
        this.cases[99] = new CaseFin(Couleur.BLACK);

        /* Other cases */
        for (int i = 0; i < 99; i++) {
            if (!contains(tab, i)) {
                this.cases[i] = new CaseNormal(Couleur.WHITE);
            }
        }
    }

}
