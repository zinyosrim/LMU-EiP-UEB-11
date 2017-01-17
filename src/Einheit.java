import java.util.Random;

/**
 * Created by ZY on 15.01.17.
 */
abstract class Einheit implements Comparable<Einheit> {

    // Attribute

    protected final int     MAX_LEBENSPUNKTE = 20;
    protected       int     angriffsSchadensKorrektur = 0;
    protected       double  zielSchadensKorrekturFaktor = 1.;
    protected       int     initiative;
    public          int     lebensPunkte = MAX_LEBENSPUNKTE;

    // Konstruktor

    public Einheit(){
        this.lebensPunkte = lebensPunkte;
        this.angriffsSchadensKorrektur = angriffsSchadensKorrektur;
        this.zielSchadensKorrekturFaktor = zielSchadensKorrekturFaktor;
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
    public boolean kannAngreifen ( Einheit ziel ){
        return false;
    }

    /**
     * Überschreibt doe Object-Methode in der Art, dass Einheit, Lebenspunlte und Initiative ausgegeben werden
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
        if (this.lebensPunkte > 0) return true;
        return false;
    }

    /**
     * Ziel-Einheit wird angegriffen. Per default wird ein Schaden von 2 Lebenspunkten hinzugefügt.
     * Der Schaden kann durch einen klassenspezifischen Parameter angriffsSchadensKorrektur angepasst werden.
     * @param ziel  Einheit
     */
    void attackiere(Einheit ziel){
            if ( this.kannAngreifen(ziel) == true ){
                System.out.println(this+ " greift "+ziel.toString()+ " an.");
                try{
                    ziel.werdeAngegriffen(2+angriffsSchadensKorrektur);
                } catch (Exception SchafException){
                    System.out.println(SchafException);
                }
            }
    }

    /**
     * Die Einheit wird angegriffen und deren Lebenspunkte reduziert.
     * Die Reduktion der Lebenspunkte kann aufgrund der eigenen Ausstattung angepasst werden.
     * Hierbei wird das Klassenattribut zielSchadensKorrekturFaktor (double) verwendet:
     *   z.B.  1=Schadenspunkte bleiben unverändert, 0.5 reduktion auf die Hälfte usw.
     * @param schaden int
     */
    void werdeAngegriffen(int schaden) throws Exception {
        int verbleibendeLebenspunkte = this.lebensPunkte-(int)(zielSchadensKorrekturFaktor*schaden);
        if (verbleibendeLebenspunkte <= 0){
            this.lebensPunkte = 0;
        }
        this.lebensPunkte = verbleibendeLebenspunkte;
    }
}
