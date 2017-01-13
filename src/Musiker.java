/**
 * Created by ZY on 13.01.17.
 *
 */
public class Musiker {

    private String name;

    // Instanzvariable für die Anzahl der erstellten Musiker
    private static int instanceCounter=0;

    private Musiker(String name){
    // String className = new Exception().getStackTrace()[1].getClassName();
            this.name = name;
            instanceCounter++;
    }

    public String toString(){
        return this.name;
    }

    public static Musiker erstelleMusiker(String name) throws Exception {
        Musiker m = new Musiker(name);
        try {
            if (instanceCounter > 4)
            {
                throw new Exception();
            }
            else {
                System.out.println("counter = "+instanceCounter);
                return m;

            }
        } catch (Exception e) {
            System.out.println("Can’t have more than 4 instances");
        }
    return m;

    }
}
