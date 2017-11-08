
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Enemigos {
	/**
	 * Clase Enemigos que es una coleccion de Malo para colocar enemigos en el nivel deseado.
	 */
	private ArrayList<Malo> enemigs;
	private int s1,s2;
	private Random r;
	
	
	
	/**
	 * Constructor de la clase.
	 */
	public Enemigos(){
		enemigs=new ArrayList<Malo>(5);
		r=new Random();
	}
	public Enemigos(int map,LoadImages limgs){
		enemigs=new ArrayList<Malo>(5);
		r=new Random();
		agrEnemigos(map,limgs);
	}

	private void agrEnemigos(int map, LoadImages limgs) {
		if(map==1){
			agrEnemig(150,175,limgs);
			agrEnemig(300,100,limgs);
		}
		
	}
	public ArrayList<Malo> getEnemigs() {
		return enemigs;
	}

	public void setEnemigs(ArrayList<Malo> enemigs) {
		this.enemigs = enemigs;
	}
	
	public void agrEnemig(int x, int y,LoadImages limgs){
		Malo f = new Malo(x,y,Color.RED,limgs);
		enemigs.add (f); 
	}
	public void rmvEnemig(Malo f){
		enemigs.remove(f);
	}
	/*public boolean checkColision(Rectangle r){
		
		ListIterator<Malo> ene= enemigs.listIterator();
		while(ene.hasNext()){
			Malo f= ene.next();
			if(f.getBounds().intersects(r)){
				return true;
			}
		}
		return false;
	}
	public void checkBala(Disparos b){
		ListIterator<Malo> ene=enemigs.listIterator();
		while(ene.hasNext()){
			Malo f=ene.next();
			if(b.checkColisionDesp(f.getBounds())){
				f.setAlive(false);
				//enemigs.remove(f);
			}
		}
		
	}*/
	
	public void mueve(Layout niv, LayoutRompible  nivR){
		ListIterator<Malo> ene = enemigs.listIterator();
		while (ene.hasNext()){
			Malo f = (Malo)ene.next();
			
			if(f.isAlive){
				if(r.nextBoolean()){
					s1=1;
				}else{
					s1=-1;
				}
				
				
				if(r.nextBoolean()){
					s2=1;
				}else{
					s2=-1;
				}
				
				if(!niv.checkColision(f.getX()+(s1*3), f.getY()+(s2*3), f.getTam())){
					if(!niv.checkColision(f.getX()+(s1*3), f.getY()+(s2*3), f.getTam())){
						f.setX(f.getX()+(s1*3));
						f.setY(f.getY()+(s2*3));
					}
					
				}
				
				
			}
		}
	}
	
	/*public boolean isEmpty(){
		if(enemigs.isEmpty()){
			return true;
		}
		return false;
	}*/
	
	public void paint(Graphics g){
		ListIterator<Malo> ene = enemigs.listIterator();
		while (ene.hasNext()){
			Malo f = ene.next();
			f.paint(g);
		}
	}
	public void update(){
		ListIterator<Malo> ene = enemigs.listIterator();
		while (ene.hasNext()){
			Malo f = (Malo)ene.next();
			
			if(f.isAlive){
				if(r.nextBoolean()){
					s1=1;
				}else{
					s1=-1;
				}
				
				
				if(r.nextBoolean()){
					s2=1;
				}else{
					s2=-1;
				}
			
				f.setX(f.getX()+(s1*3));
				f.setY(f.getY()+(s2*3));
			}
		}
			
	}
	

}
