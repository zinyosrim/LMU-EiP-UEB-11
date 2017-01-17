/**
 * Klasse Zwerg
 */
public class Zwerg extends Einheit implements Krieger, SchwereRuestung, Fernkampf {

    // erhöhen den Schaden auf Feinde um 2 aufgrund Fernkampf, Eigener Schaden wird um 50% reduziert wg. SchwereRuestung
    private  int    angriffsSchadensKorrektur   = 2;
    private  double zielSchadensKorrekturFaktor = 0.5;

    public Zwerg(){
        super();
        super.angriffsSchadensKorrektur = angriffsSchadensKorrektur;
        super.zielSchadensKorrekturFaktor = zielSchadensKorrekturFaktor;
    }

    /**
     * Zwerge greifen Orks, Goblins und Schafe an
     * @param   ziel
     * @return
     */
    @Override
    public boolean kannAngreifen(Einheit ziel) {
        String zielInstance=ziel.getClass().getSimpleName();
        boolean angriff=false;
        switch (zielInstance){
            case "Ork":     angriff = true; break;
            case "Goblin":  angriff = true; break;
            case "Schaf":   angriff = true; break;
            case "Mensch":  angriff = false;break;
            case "Zwerg":   angriff = false;
        }
        return angriff;
    }
}

