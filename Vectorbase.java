import java.awt.Shape;

public class Vectorbase {
	protected Shape forma;
	protected boolean vivo;
	protected double x,y;
	protected double velX, velY;
	protected double moveAngle, faceAngle;
	
	
	public Shape getShape(){
		return forma;
	}
	public boolean isAlive(){
		return vivo;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getMoveAngle(){
		return moveAngle;
	}
	public double getFaceAngle(){
		return faceAngle;
	}
	
	public void setShape(Shape forma){
		this.forma=forma;
	}
	public void setAlive(boolean vivo){
		this.vivo=vivo;
	}
	public void setX(double x){
		this.x=x;
	}
	public void setY(double y){
		this.y=y;
	}
	public void setVelX(double velX){
		this.velX = velX;
	}
	
	public void setVelY(double velY){
		this.velY=velY;
	}
	public double getVelX(){
		return velX;
	}
	public double getVelY(){
		return velY;
	}
	public void setFaceAngle(double angle){
		this.faceAngle= angle;
	}
	public void incFaceAngle(double i){
		this.faceAngle += i;
	}
	public void setMoveAngle(double angle){
		this.moveAngle= angle;
	}
	public void incMoveAngle(double i){
		this.moveAngle += i;
	}
	
public Vectorbase(){
	setShape(null);
	setAlive(false);
	setX(0.0);
	setY(0.0);
	setVelX(0.0);
	setVelY(0.0);
	setMoveAngle(0.0);
	setFaceAngle(0.0);
	
}
	
}
	

