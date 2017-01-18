import java.util.Random;

/**
 * Created by ZY on 15.01.17.
 */
abstract class Einheit implements Comparable<Einheit> {

    // Attribute

    protected int initiative;
    protected int lebensPunkte = 20;
    //public          int     lebensPunkte = MAX_LEBENSPUNKTE;

    // Konstruktor

    public Einheit(){
        this.lebensPunkte = lebensPunkte;
        this.initiative = new Random().nextInt(101);
    }

    // Methoden

    /**
     * Ermöglicht die Sortierung der Einheiten nach Initiative genutzt
     * @param   andereEinheit
     * @return  int
     */
    @Override
    public int compareTo(Einheit andereEinheit){
        double delta = this.initiative - andereEinheit.initiative;
        if (delta < 0) return 1;
        if (delta > 0) return -1;
        return 0;
    }

    /**
     * Gibt an, ob das Ziel angegriffen werden kann, oder nicht
     * @param   ziel
     * @return  boolean
     */
    public boolean kannAngreifen ( Einheit ziel ) {

        boolean angriff = false;
        String zielInstance = ziel.getClass().getSimpleName();

        if (this instanceof Schaf) angriff = false;

        if (this instanceof Ork || this instanceof Goblin) {
            switch (zielInstance) {
                case "Ork":
                    angriff = false;
                    break;
                case "Goblin":
                    angriff = false;
                    break;
                case "Schaf":
                    angriff = true;
                    break;
                case "Mensch":
                    angriff = true;
                    break;
                case "Zwerg":
                    angriff = true;
            }
        }

        if (this instanceof Mensch || this instanceof Zwerg) {
            switch (zielInstance) {
                case "Ork":
                    angriff = true;
                    break;
                case "Goblin":
                    angriff = true;
                    break;
                case "Schaf":
                    angriff = true;
                    break;
                case "Mensch":
                    angriff = false;
                    break;
                case "Zwerg":
                    angriff = false;
            }
        }
        return angriff;
    }

    /**
     * Überschreibt die Object-Methode in der Art, dass Einheit, Lebenspunkte und Initiative ausgegeben werden
     * @return  String
     */
    @Override
    public String toString(){
        String className = new Exception().getStackTrace()[1].getClassName();
        return className + "(LP:"+this.lebensPunkte+"|INIT:"+ this.initiative+")";
    };

    /**
     * Gibt an ob die Lebenspunkte einer Einheit > 0 sind
     * @return  boolean
     */
    boolean lebtNoch(){
        return this.lebensPunkte > 0;
    }

    /**
     * Ziel-Einheit wird angegriffen. Per default wird ein Schaden von 2 Lebenspunkten hinzugefügt.
     * Der Schaden kann abhängig vom Ziel angepasst werden.
     * @param ziel  Einheit
     */
    void attackiere(Einheit ziel){
            int schaden = 2;
            if (this instanceof Fernkampf) schaden += 2;
            if (this instanceof Gift) schaden += 2;

            if ( this.kannAngreifen(ziel) == true ){
                System.out.println(this+ " greift "+ziel.toString()+ " an.");
                try{
                    if (ziel instanceof Schaf){throw new SchafException("Schaf versucht määäähend zu fliehen....");}
                } catch(SchafException e){System.out.println(e.getMessage());}

                ziel.werdeAngegriffen(schaden);

            }
    }

    /**
     * Die Einheit wird angegriffen und deren Lebenspunkte reduziert.
     * Die Reduktion der Lebenspunkte kann aufgrund der eigenen Ausstattung angepasst werden.
     * @param schaden int
     */
    void werdeAngegriffen(int schaden){
        if (this instanceof SchwereRuestung) schaden /= 2;
        int verbleibendeLebenspunkte = this.lebensPunkte-schaden;
        if (verbleibendeLebenspunkte <= 0) this.lebensPunkte = 0;
        this.lebensPunkte = verbleibendeLebenspunkte;
    }
}
