import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bala_Rebote extends Bala {
	
	public Bala_Rebote(){
		setShape(new Rectangle(0,0,1,1));
		setAlive(false);
	}
	
	public Bala_Rebote(double VelX, double VelY, double x, double y){
		setShape(new Rectangle((int)x,(int)y,3,3));
		setAlive(true);
		velX=VelX;
		velY=VelY;
		this.x=x;
		this.y=y;
	}
	
	public void paint(Graphics g){
		if(isAlive()){
			g.setColor(Color.GREEN);
			g.fillRect((int)x, (int)y, 3, 3);
			
		}
	}
}
