/**
 * Created by ZY on 15.01.17.
 */
abstract class Einheit implements Comparable<Einheit> {
    private int lebensPunkte = 20;

    public int compareTo(Einheit andereEinheit){
        String myClass = this.getClass().getSimpleName();
        String othersClass = andereEinheit.getClass().getSimpleName();
        if ( myClass == othersClass ) return 0;
        if (    ( myClass == "Mensch") && ( othersClass == "Zwerg" )  ||
                ( myClass == "Zwerg") && ( othersClass == "Mensch" )  ||
                ( myClass == "Ork") && ( othersClass == "Goblin" ) ||
                ( myClass == "Goblin") && ( othersClass == "Ork" ) ) return 1;
        else return -1;


    }
}
