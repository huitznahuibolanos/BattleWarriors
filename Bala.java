import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bala extends Vectorbase {
	

	public Rectangle getBounds(){
		Rectangle r;
		r = new Rectangle((int)getX(), (int) getY(), 1, 1);
		return r;
	}

	public Bala(){
		setShape(new Rectangle(0,0,1,1));
		setAlive(false);
	}
	
	public Bala(double VelX, double VelY, double x, double y){
		setShape(new Rectangle((int)x,(int)y,3,3));
		setAlive(true);
		velX=VelX;
		velY=VelY;
		this.x=x;
		this.y=y;
	}
	
	public void updateBala(){
		x=x+velX;
		y=y+velY;
		forma=new Rectangle((int)x,(int)y,3,3);
	}
	public void paint(Graphics g){
		if(isAlive()){
			g.setColor(Color.WHITE);
			g.fillRect((int)x, (int)y, 3, 3);
			
		}
	}
}