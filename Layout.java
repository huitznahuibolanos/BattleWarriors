import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.ListIterator;

public class Layout {
	
	/**
	 * Clase Layout que se encarga de detectar y mostrar los comportamientos e interacci�n
	 * de las paredes y los personajes dentro de cada nivel.
	 */
	
	private ArrayList<Pared> paredes;

	public Layout(){
		paredes=new ArrayList<Pared>(5);
	}

	
	/**
	 * Es el m�todo que agrega una pared a la colecci�n de paredes 
	 * @param loimgs 
	 * @param x_  es el inicio de la  pared en x
	 * @param y_ es el inicio de la pared en y
	 * @param ancho_ es el ancho de la pared
	 * @param largo_ es el largo  de la pared
	 */
	public void agrPared(int x,int y,int ancho, int largo, LoadImages loimgs){
		Pared p=new Pared(x,y,ancho,largo,loimgs);
		paredes.add(p);
	}
	/**
	 * Es el m�todo que detecta si hay  alguna colisi�n con una pared del laberinto en la zona vertical
	 * @param x1_ es la posici�n en x del jugador
	 * @param y1_ es la posici�n en y del jugador
	 * @param diametro_ es el tama�o del jugador
	 * @return regresa el numero int que se necesita  para corregir la posici�n de pacmon o un n�mero alto que interpreta como una colisi�n incorregible
	 */
	/* int  noColicionVer(int x1,int y1, int  diametro){
		ListIterator<Pared> pad= paredes.listIterator();
		int x2= x1+diametro;
		int y2= y1+diametro;
		int i=1;
		int s=0;
		int dif=0;
		//System.out.println("checa colision");
		while (pad.hasNext()){
			//System.out.println(i);
			i=i+1;
			Pared p= pad.next();
			int px1=p.getX();
			int px2=p.getX()+p.getAncho();
			int py1=p.getY();
			int py2=p.getY()+p.getLargo();
			if(x2>px1 && x1<px2 && y2>py1 && y1<py2){
			//if ((x2>px1 && (y2>py1 || y1<py2)) || (x1<px2 && (y2>py1 || y1<py2))){
				s=s+1;
				if(x1<px1 && ((y2-5)<py1 || (y1+5)>py2)){
					dif = px1-29;
					return dif;
				}
				else if(x2>px2 && ((y2-5)<py1 || (y1+5)>py2)){
					dif = px2+1;
					return dif;
				}
			}
		}
		if(s==0){
			dif=x1;
			return dif;
		} else{
			dif = 50;
			return dif;
		}
	}
	/**
	 * Es el m�todo que detecta si hay  alguna colisi�n con una pared del laberinto en la zona horizontal
	 * @param x1_ es la posicion en x del jugador
	 * @param y1_ es la posicion en y del jugador
	 * @param diametro_ es el tama�o del jugador
	 * @return regresa el n�mero int que se necesita  para corregir la posici�n de pacmon o un n�mero alto que interpreta como una colisi�n incorregible
	 */
	/*public int  noColicionHor(int x1,int y1, int  diametro){
		ListIterator<Pared> pad= paredes.listIterator();
		int x2= x1+diametro;
		int y2= y1+diametro;
		int i=1;
		int s=0;
		int dif=0;
		//System.out.println("checa colision");
		while (pad.hasNext()){
			//System.out.println(i);
			i=i+1;
			Pared p= pad.next();
			int px1=p.getX();
			int px2=p.getX()+p.getAncho();
			int py1=p.getY();
			int py2=p.getY()+p.getLargo();
			if(x2>px1 && x1<px2 && y2>py1 && y1<py2){
			//if ((x2>px1 && (y2>py1 || y1<py2)) || (x1<px2 && (y2>py1 || y1<py2))){
				s=s+1;
				if(y1<py1 && ((x2-5)<px1 || (x1+5)>px2)){
					dif =py1-29;
					return dif;
				}
				else if(y2>py2 && ((x2-5)<px1 || (x1+5)>px2)){
					dif = py2+1;
					return dif;
				}
			}
		}
		if(s==0){
			dif=y1;
			return dif;
		} else{
			dif = 50;
			return dif;
		}
	}
	/**
	 * Es el m�todo que detecta si hay  alguna colisi�n con una pared del laberinto por parte de los fantasmas
	 * @param x1_ es la poici�n en x del fantasma
	 * @param y1_ es la posici�n en y del fantasma
	 * @param diametro_ es el tama�o del fantasma
	 * @return regresa un booleano que indica si el fantasma esta colicionando o no
	 */
	/*public boolean noColicion(int x1,int y1, int  diametro){
		ListIterator<Pared> pad= paredes.listIterator();
		int x2= x1+diametro;
		int y2= y1+diametro;
		int i=1;
		int s=0;
		//System.out.println("checa colision");
		while (pad.hasNext()){
			//System.out.println(i);
			i=i+1;
			Pared p= pad.next();
			int px1=p.getX();
			int px2=p.getX()+p.getAncho();
			int py1=p.getY();
			int py2=p.getY()+p.getLargo();
			if(x2>px1 && x1<px2 && y2>py1 && y1<py2){
				s=s+1;
			}
		}
		if(s==0){
			return true;
		} else{
			return false;
		}
	}
	
	
	
	/**
	 * M�todo que pinta las paredes en el canvas.
	 * @param g_variable que permite, desde Graphics, pintar los objetos en un canvas.
	 */
	public void paint(Graphics g){
		ListIterator<Pared> pad= paredes.listIterator();
		while(pad.hasNext()){
			Pared p= pad.next();
			p.paint(g);
		}
	}
	public boolean checkColision(int x, int  y, int tam){
	
		ListIterator<Pared> pad= paredes.listIterator();
		while(pad.hasNext()){
			Pared p= pad.next();
			if(p.getBounds().intersects(new Rectangle(x,y,tam,tam))){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkColision(Rectangle r){
		
		ListIterator<Pared> pad= paredes.listIterator();
		while(pad.hasNext()){
			Pared p= pad.next();
			if(p.getBounds().intersects(r)){
				return true;
			}
		}
		return false;
	}
	public ArrayList<Pared> getParedes() {
		return paredes;
	}

	public void setParedes(ArrayList<Pared> paredes) {
		this.paredes = paredes;
	}
}

