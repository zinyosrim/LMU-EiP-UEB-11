/**
 * Klasse Ork
 */
public class Ork extends Einheit implements SchwereRuestung, Krieger {

    // Eigener Schaden wird um 50% reduziert wg. SchwereRuestung
    private  int     angriffsSchadensKorrektur   = 0;
    private  double  zielSchadensKorrekturFaktor = 0.5;

    public Ork(){
        super();
        super.angriffsSchadensKorrektur = angriffsSchadensKorrektur;
        super.zielSchadensKorrekturFaktor = zielSchadensKorrekturFaktor;
    }

    /**
     * Orks greifen Menschen, Zwerge und Schafe an
     * @param   ziel
     * @return
     */
    @Override
    public boolean kannAngreifen(Einheit ziel) {
        String zielInstance = ziel.getClass().getSimpleName();
        boolean angriff = false;
        switch (zielInstance) {
            case "Ork":     angriff = false;break;
            case "Goblin":  angriff = false;break;
            case "Schaf":   angriff = true;break;
            case "Mensch":  angriff = true;break;
            case "Zwerg":   angriff = true;
        }
        return angriff;
    }
}
