import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Personaje {

	
	protected int x,velX;
	protected int y,velY;
	protected int tam,sprt;
	protected int speed=5;
	protected Color c;
	protected boolean isAlive;
	protected int direccion;
	protected int municion, tipoB;
	protected BufferedImage sprite;
	protected LoadImages limgs;
	
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMunicion() {
		return municion;
	}

	public void setMunicion(int municion) {
		this.municion = municion;
	}

	public int getTipoB() {
		return tipoB;
	}

	public void setTipoB(int tipoB) {
		this.tipoB = tipoB;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Personaje(){
		x = 300;
		y = 300;
		tam = 15;
		c= Color.WHITE;
		isAlive=true;
		direccion=1;
		velX=0;
		velY=0;
		tipoB=1;
		municion=0;
	}
	
	public Personaje(Color c){
		x = 400;
		y = 400;
		tam = 15;
		this.c= c;
		isAlive=false;
		direccion=1;
		velX=0;
		velY=0;
		tipoB=3;
		municion=10;
	}
	
	public Personaje(int sprt, boolean mainPlayer,LoadImages loimgs){
		x = 400;
		y = 400;
		tam = 50;
		isAlive=mainPlayer;
		direccion=1;
		velX=0;
		velY=0;
		tipoB=1;
		municion=0;
		limgs=loimgs;
		this.sprt=sprt;
		
		spriteFront();
	}

	
	

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	/**
	 * setters y getters
	 **/
	
	public int getX() {
		return x;
	}
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getTam() {
		return tam;
	}
	public void setTam(int tam) {
		this.tam = tam;
	}
	public Rectangle getBounds(){
		Rectangle bounds;
		if(isAlive){
			if(direccion==1){
				bounds = new Rectangle (x,y-speed,tam,tam);
			}
			else if(direccion==2){
				bounds = new Rectangle (x-speed,y,tam,tam);
			}
			else if(direccion==3){
				bounds = new Rectangle (x,y+speed,tam,tam);
			}
			else if(direccion==4){
				bounds = new Rectangle (x+speed,y,tam,tam);
			}
			else {
				bounds = new Rectangle (x,y,tam,tam);
			}
			return bounds;
		}else{
			bounds=new Rectangle(0,0,0,0);
			return bounds;
		}
	}
	
	public void personajeUpdate(/*Layout niv, LayoutRompible n*/){
		if(isAlive){
			x=x+velX;
			y=y+velY;
		}
		checarTipoBala();
		/*if(isAlive){
			if(!niv.checkColision(tempx, tempy, tam) && !n.checkColision(tempx,tempy,tam) && (tempx>0||tempx<800)){
				x=x+velX;
				y=y+velY;
			}
		}*/
	}

	private void checarTipoBala() {
		if(municion<1){
			tipoB=1;
		}
	}

	public void vels(int dir){
		switch(dir){
		case 1:
			velY=-speed;
			spriteBack();
			break;
		case 2:
			velX=-speed;
			break;
		case 3:
			velY=speed;
			spriteFront();
			break;
		case 4:
			velX=speed;
			break;
		default:
			velX=0;
			velY=0;
		}
	}
	
	private void spriteFront() {
		// TODO Auto-generated method stub
		switch(sprt){
		case 1:
			sprite=limgs.getImage("ciclop_front");
			break;
		case 2:
			sprite=limgs.getImage("formal_front");
			break;
		case 3:
			sprite=limgs.getImage("mex_front");
			break;
		default:
			sprite=limgs.getImage("ciclop_front");
			break;
		}
	}

	private void spriteBack() {
		// TODO Auto-generated method stub
		switch(sprt){
		case 1:
			sprite=limgs.getImage("ciclop_back");
			break;
		case 2:
			sprite=limgs.getImage("formal_back");
			break;
		case 3:
			sprite=limgs.getImage("mex_back");
			break;
		default:
			sprite=limgs.getImage("ciclop_back");
			break;
		}
		
	}

	public void detenerse(int dir){
		switch(dir){
		case 1:
			velY=0;
			break;
		case 2:
			velX=0;
			break;
		default:
			velX=0;
			velY=0;
			break;
		}
	}




	public void paint(Graphics g){
		if(isAlive){
			if(sprite!=null){
				ImageObserver obs = null;
				g.drawImage(sprite, x, y, tam, tam, obs);
			}else{
				g.setColor(c);
				g.fillOval(x, y, tam, tam);
			}
		}
		
	}
	
	
}
