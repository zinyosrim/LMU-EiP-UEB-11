/**
 * Class Musiker erstellt Musiker
 *
 */
public class Musiker {

    private String name;

    // Instanzvariable für die Anzahl der erstellten Musiker
    private static int instanceCounter=0;

    // Konstruktor
    private Musiker(String name){
            this.name = name;
    }

    public String toString(){
        return "Musiker "+this.name;
    }

    /**
     * erstellt Musiker.
     *
     * @param   name
     * @return  Musiker
     * @throws  Exception   Sofern aufrufende Klasse = Quartett ist und mehr 4 Musiker erstellt werden sollen
     */
    public static Musiker erstelleMusiker(String name) throws Exception {

            String className = new Exception().getStackTrace()[1].getClassName();
            if ( (instanceCounter >= 4) && (className == "Quartett") ) {
                throw new Exception("Quartett kann nicht mehr als 4 Personen haben!");
            }
            instanceCounter++;
            return new Musiker(name);
    }
}
