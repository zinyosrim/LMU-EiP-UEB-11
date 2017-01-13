/**
 * Created by ZY on 13.01.17.
 */
public final class Quartett {

    final int ANZAHL_MUSIKER = 4;
    private Musiker[] musikerGruppe = new Musiker[ANZAHL_MUSIKER];

    // Konstruktor
    Quartett(Musiker[] musikerArray){

        try{
            for (int i = 0; i < musikerArray.length; i++){
               this.musikerGruppe[i] = musikerArray[i];
            }
            System.out.println("Quartett ist erstellt.");
        } catch(Exception e){
            System.out.println("Quartett konnte nicht angelegt werden. Die Anzahl der Musiker darf 4 nicht überschreiten!");
        }
    }

    public static void main(String[] args){

        Musiker[] albanBergQuartett = new Musiker[5];
        albanBergQuartett[0] = new Musiker("Klavier");
        albanBergQuartett[1] = new Musiker("Cello");
        albanBergQuartett[2] = new Musiker("Violine");
        albanBergQuartett[3] = new Musiker("Kontrabass");
        albanBergQuartett[4] = new Musiker("Becken");
        Quartett q = new Quartett(albanBergQuartett);


    }
}
