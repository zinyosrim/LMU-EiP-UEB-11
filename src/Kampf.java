import javafx.scene.SnapshotParametersBuilder;

import java.util.Random;
import java.util.Arrays;

public class Kampf {
	
	private int laenge = 10;
	private Einheit[] einheiten;

	public static void main(String[] args){
		Kampf kampf = new Kampf(10);
		System.out.println("Kampfaufstellung: ");
		System.out.println(kampf);
		System.out.println("\nDer Kampf beginnt!");
		if(kampf.allesSchafe())
			System.out.println("Ausnahmsweise gewinnen die Schafe mangels anderer Interessenten!\n\n");
		else {
			Einheit gewinner = kampf.kaempfen();
			System.out.println(gewinner + " beendet das Gefecht mit einem letzten beherzten Schlag!\n\n");
			System.out.println("Verbleibende Kaempfer: ");
			System.out.println(kampf);
		}
	}
	
	public Kampf(int laenge){
		this.laenge = laenge;
		einheiten = new Einheit[laenge];
		
		Random random = new Random();
		for(int i = 0; i < laenge; i++){			//Array mit Einheiten initialisieren			
			switch(random.nextInt(5)){
				case 1: einheiten[i] = new Mensch(); break;
				case 2: einheiten[i] = new Zwerg(); break;
				case 3: einheiten[i] = new Ork(); break;
				case 4: einheiten[i] = new Goblin(); break;
				default: einheiten[i] = new Schaf(); break;
			}
		}
		Arrays.sort(this.einheiten);

	}
	
	public boolean allesSchafe() {
		for(int i = 0; i < laenge; i++){
			if(!(einheiten[i] instanceof Schaf))
				return false;
		}
		return true;
	}
	
	public String toString() {
		String str = "";
		str += "-----------------\n";
		for(int i = 0; i < laenge; i++){
			if(einheiten[i].lebtNoch())
				str += einheiten[i] + "\n";
		}
		str += "-----------------";
		return str;
	}

	/**
	 * findet nächstes angreifbares Ziel
	 * @param 	angreiferPosition
	 * @return	Ziel (Einheit)
	 */
	private Einheit findeNaechstesZiel(int angreiferPosition) {

		int zielPosition = (angreiferPosition + 1) % laenge; // initialisiere Ziel mit nächster Einheit nach Round Robin
		boolean zielGefunden = false;

		while (  !zielGefunden   && angreiferPosition != zielPosition ){
			// wenn Ziel angreifbar und Ziel != Angreifer ....
			if ( (einheiten[angreiferPosition].kannAngreifen(einheiten[zielPosition]) == true) && einheiten[zielPosition].lebtNoch() ) {
				return einheiten[zielPosition]; // angreifbares Ziel gefunden
			}
			zielPosition = (zielPosition + 1) % laenge; // gehe zur nächsten Einheit nach Round Robin
		}
		return einheiten[angreiferPosition]; // kein angreifbares Ziel gefunden
	}
	
	// simuliert den gesamten Kampf und endet erst, wenn eine Fraktion gewonnen hat. 
	// Die Rückgabe ist die siegreiche Einheit, die den letzten Schlag vollführt hat.
	public Einheit kaempfen(){

		int angreiferPosition = 0;
		
		while(true) {
			Einheit angreifer = einheiten[angreiferPosition];
			if(angreifer instanceof Krieger && angreifer.lebtNoch()){
				Einheit ziel = findeNaechstesZiel(angreiferPosition);

				if(ziel == angreifer) // in diesem Fall wurde kein gueltiges Ziel gefunden => Kampfende
					return angreifer;
				if(ziel != null){
					try {
						angreifer.attackiere(ziel);
					} catch (Exception e) {
						System.out.println("Schaf läuft herum und sagt määh...");
					}
				}

			}
			angreiferPosition++;
			if(angreiferPosition >= laenge)
				angreiferPosition = 0;
			
		}
	}
		
}