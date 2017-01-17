/**
 * Klasse Goblin
 */
public class Goblin extends Einheit implements Gift, Fernkampf, Krieger {

    // erhöhen den Schaden auf Feinde um 4 aufgrund Fernkampf und Gift
    private  int     angriffsSchadensKorrektur   = 4;
    private  double  zielSchadensKorrekturFaktor = 1.;

    public Goblin(){
        super();
        super.angriffsSchadensKorrektur = angriffsSchadensKorrektur;
        super.zielSchadensKorrekturFaktor = zielSchadensKorrekturFaktor;
    }

    /**
     * Goblins greifen Menschen, Zwerge und Schafe an
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
