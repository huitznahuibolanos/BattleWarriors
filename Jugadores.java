import java.awt.Color;
import java.util.ArrayList;

public class Jugadores {
	private ArrayList<Personaje> jugs;
	
	public Jugadores(){
		jugs= new ArrayList<Personaje>(2);
	}
	
	public void agrjug(Color c){
		Personaje p= new Personaje(c);
		jugs.add(p);
	}
	
	public void rmvjug(Personaje p){
		jugs.remove(p);
	}
	
}
