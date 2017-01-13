/**
 * Created by ZY on 13.01.17.
 *
 */
public class Musiker {

    // Instanzvariable für die Anzahl der erstellten Musiker^
    public static int instances;
    // Attribute
    private String instrument;
    private String name;
    // Konstruktor
    public Musiker(String instrument){
        this.instrument = instrument;
        Musiker.instances++;
        System.out.println("Musiker Nr."+Musiker.instances+" mit Instrument: " + this.instrument+" wurde erstellt.");
    }

}
