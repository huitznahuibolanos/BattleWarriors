import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class ParedRompible {
	/**
	 * Clase Pared, que se encarga de darle la forma a cada una de las paredes en el laberinto.
	 */
	
	private int x,y,ancho,largo,tam;
	private Color c;
	private boolean visible;
	private BufferedImage sprite;
	private LoadImages limgs;
	
	/**
	 * Constructor de la clase
	 * @param x_posición x de la pared
	 * @param y_posición y de la pared
	 * @param ancho_ancho de la pared
	 * @param largo_largo de la pared
	 */
	public ParedRompible(int x, int y, int ancho, int largo,LoadImages loimgs) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.largo = largo;
		this.c = Color.YELLOW;
		visible =true;
		tam=30;
		limgs=loimgs;
		sprite=limgs.getImage("pared_arena_romp");
	}
	
	public ParedRompible(int x, int y, int ancho, int largo, Color c) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.largo = largo;
		this.c = c;
		visible = true;
	}
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getX() {
		return x;
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
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getLargo() {
		return largo;
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	/**
	 * Es el método que se encarga de dibujar un rectángulo en la posicioón de la pared para que se pueda ver una representación gráfica de la pared
	 * @param g_ es la variable de Graphics que se encarga de dibujar las paredes
	 */
	public void  paint(Graphics g){
		if(sprite==null){
			g.setColor(c);
			g.fillRect(x, y, ancho, largo);
			} else{
				//if(ancho>tam && largo>tam){
					int repA=ancho/tam;
					int repL =largo/tam;
					
					for(int i=0;i<repA;i++){
						for(int j=0;j<repL;j++){
							ImageObserver obs = null;
							g.drawImage(sprite, x+(tam*i), y+(tam*j), tam,tam , obs);
						}
					}
			}
	
		
	}

	public Rectangle getBounds(){
		Rectangle bounds;
		bounds = new Rectangle (x,y,ancho,largo);
		return bounds;
	}
}
