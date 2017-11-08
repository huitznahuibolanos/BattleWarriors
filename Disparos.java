import java.awt.Graphics;
//import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.ListIterator;

public class Disparos {
	/**
	 * Clase Enemigos que es una coleccion de Malo para colocar enemigos en el nivel deseado.
	 */
	private ArrayList<Bala> balas;
	private ArrayList<Bala_Rebote> balasR;
	private ArrayList<Bala_atraviesa> balasA;
	
	
	
	/**
	 * Constructor de la clase.
	 */
	public Disparos(){
		balas=new ArrayList<Bala>(5);
		balasR=new ArrayList<Bala_Rebote>(5);
		balasA=new ArrayList<Bala_atraviesa>(5);
	}

	public ArrayList<Bala> getEnemigs() {
		return balas;
	}

	public void setBalas(ArrayList<Bala> balas) {
		this.balas = balas;
	}
	
	public void agrBalas(){
		Bala f = new Bala();
		balas.add (f); 
	}
	
	public void agrBalas(double VelX, double VelY, double x, double y){
		if(balas.size()<10){
			Bala f = new Bala(VelX,  VelY,  x,  y);
			balas.add (f); 
		}else{
			ListIterator<Bala> bals= balas.listIterator(); 
			if(bals.hasNext()){
				Bala c = bals.next();
				balas.remove(c);
				
			}
			Bala f = new Bala(VelX,  VelY,  x,  y);
			balas.add (f);
		}
	}
	
	//Agregar Bala Rebote
	public void agrBalasR(double VelX, double VelY, double x, double y){
		if(balasR.size()<10){
			Bala_Rebote f = new Bala_Rebote(VelX,  VelY,  x,  y);
			balasR.add (f); 
		}else{
			ListIterator<Bala_Rebote> bals= balasR.listIterator(); 
			if(bals.hasNext()){
				Bala_Rebote c = bals.next();
				balasR.remove(c);
				
			}
			Bala_Rebote f = new Bala_Rebote(VelX,  VelY,  x,  y);
			balasR.add (f);
		}
	}
	
	//Agregar Bala Atraviesa
	public void agrBalasA(double VelX, double VelY, double x, double y){
		if(balasA.size()<10){
			Bala_atraviesa f = new Bala_atraviesa(VelX,  VelY,  x,  y);
			balasA.add (f); 
		}else{
			ListIterator<Bala_atraviesa> bals= balasA.listIterator(); 
			if(bals.hasNext()){
				Bala_atraviesa c = bals.next();
				balasA.remove(c);
				
			}
			Bala_atraviesa f = new Bala_atraviesa(VelX,  VelY,  x,  y);
			balasA.add (f);
		}
	}
	/*public boolean checkColision(Rectangle r){
		
		ListIterator<Bala> ene= balas.listIterator();
		while(ene.hasNext()){
			Bala f= ene.next();
			if(f.getBounds().intersects(r)){
				return true;
			}
		}
		return false;
	}
	public boolean checkColisionDesp(Rectangle r){
		ListIterator<Bala> ene= balas.listIterator();
		while(ene.hasNext()){
			Bala f= ene.next();
			if(f.getBounds().intersects(r)){
				f.setAlive(false);
				balas.remove(f);
				return true;
			}
		}
		return false;
	}
	
	public void checkColisionPad(Layout niv){
		ListIterator<Bala> bal= balas.listIterator();
		while(bal.hasNext()){
			Bala b=bal.next();
			if(niv.checkColision(b.getBounds())){
				b.setAlive(false);
			}
			
		}
	}*/
	public void updateBalas(){
		ListIterator<Bala> ene= balas.listIterator();
		while(ene.hasNext()){
			Bala f= ene.next();
			f.updateBala();
		}
		ListIterator<Bala_Rebote> balR= balasR.listIterator();
		while(balR.hasNext()){
			Bala_Rebote f= balR.next();
			f.updateBala();
		}ListIterator<Bala_atraviesa> balA= balasA.listIterator();
		while(balA.hasNext()){
			Bala_atraviesa f= balA.next();
			f.updateBala();
		}
	}
	
	public ArrayList<Bala_Rebote> getBalasR() {
		return balasR;
	}

	public void setBalasR(ArrayList<Bala_Rebote> balasR) {
		this.balasR = balasR;
	}

	public ArrayList<Bala_atraviesa> getBalasA() {
		return balasA;
	}

	public void setBalasA(ArrayList<Bala_atraviesa> balasA) {
		this.balasA = balasA;
	}

	public ArrayList<Bala> getBalas() {
		return balas;
	}

	public void paint(Graphics g){
		
		ListIterator<Bala> ene = balas.listIterator();
		while (ene.hasNext()){
			Bala f = ene.next();
			f.paint(g);
		}
		ListIterator<Bala_Rebote> balR= balasR.listIterator();
		while(balR.hasNext()){
			Bala_Rebote f= balR.next();
			System.out.println("BalaRebotePintada");
			f.paint(g);
		}
		ListIterator<Bala_atraviesa> balA= balasA.listIterator();
		while(balA.hasNext()){
			Bala_atraviesa f= balA.next();
			f.paint(g);
		}
	}
	

}