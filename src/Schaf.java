/**
 * Klasse Schaf
 */
public class Schaf extends Einheit {

    public Schaf(){
        super();
    }

    void werdeAngegriffen(int schaden) throws Exception {

        try{
            System.out.println("Schaf läuft herum und sagt määäh...");
        }

        finally{
            int verbleibendeLebenspunkte = this.lebensPunkte-(schaden);
            if (verbleibendeLebenspunkte <= 0) this.lebensPunkte = 0;
            this.lebensPunkte = verbleibendeLebenspunkte;
        }
    }
}
