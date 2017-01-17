/**
 * Klasse Mensch
 */
public class Mensch extends Einheit implements SchwereRuestung, Fernkampf, Krieger {

    // erhöhen den Schaden auf Feinde um 2 aufgrund Fernkampf, Eigener Schaden wird um 50% reduziert wg. SchwereRuestung
    private int angriffsSchadensKorrektur = 2;
    private double zielSchadensKorrekturFaktor = 0.5;

    public Mensch() {
        super();
        super.angriffsSchadensKorrektur = angriffsSchadensKorrektur;
        super.zielSchadensKorrekturFaktor = zielSchadensKorrekturFaktor;
    }

    /**
     * Menschen greifen Orks, Goblins und Schafe an
     *
     * @param ziel
     * @return
     */
    @Override
    public boolean kannAngreifen(Einheit ziel) {
        String zielInstance = ziel.getClass().getSimpleName();
        boolean angriff = false;
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
        return angriff;
    }
}
