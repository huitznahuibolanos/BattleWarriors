import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class Malo extends Personaje {
	
	
	private  Random r;
	
	
	public Malo(int x, int y,Color c,LoadImages limgs) {
		r=new Random();
		//x=r.nextInt(width-100);
		//y=r.nextInt(height-100);
		this.x=500;
		this.y=y;
		tam=30;
		this.c=c;
		sprite=limgs.getImage("luchador_front");
	}
		
	
	/*public Rectangle getBounds(){
		Rectangle bounds;
		bounds = new Rectangle (x,y,tam,tam);
		return bounds;
	}*/
}
	