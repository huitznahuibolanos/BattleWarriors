import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ListIterator;



public class Entity_mgr {
	
	Nivel niv;
	Enemigos ene;
	Disparos balas;
	Personaje[] pers;
	int j1, j2, map;
	LoadImages imags;
	BufferedImage fondo;
	
		
	public Entity_mgr(){
		
		//los valores de map, j1 y j2 los tiene que recibir de la pantalla anterior
		map = 1; j1=3; j2=2;
		cargarImagenes();
		
		niv = new Nivel(map,imags);
		ene = new Enemigos(map,imags);
		balas = new Disparos();
		pers=new Personaje[2];
		
		pers[0]= new Personaje(j1,true,imags);
		pers[1]= new Personaje(j2,true,imags);
		fondo=imags.getImage("fondo_mapa");
		
		
	}
	
	private void cargarImagenes(){
		imags = new LoadImages();
		
		imags.loadImageFile("imgs.txt");
	}
	public void render(Graphics g){
		ImageObserver observer = null;
		g.drawImage(fondo, 0, 0, 900, 700, observer);
		niv.paint(g);
		pers[0].paint(g);
		pers[1].paint(g);
		ene.paint(g);
		balas.paint(g);
		
	}
	public void update(){
		if(!checkPersPared(0)){
		pers[0].personajeUpdate();
		}
		if(!checkPersPared(1)){
		pers[1].personajeUpdate();
		}
		balas.updateBalas();
		ene.update();
		checkParedR();
		checkBala();
		checkBalaA();
		checkBalaR();
		checkEneBala();
		checkPersEnem(0);
		checkPersEnem(1);
		
	}


	public void dispara(int i) {
		if(pers[i].isAlive){
			if(pers[i].getDireccion()==1){
				if(pers[i].getTipoB()==1){
					balas.agrBalas(0, -5.5, (double)pers[i].getX()+(double)pers[i].getTam()/2, (double)pers[i].getY()-3.0);
				}else if(pers[i].getTipoB()==2){
					balas.agrBalasR(0, -5.5, (double)pers[i].getX()+(double)pers[i].getTam()/2, (double)pers[i].getY()-3.0);
					pers[i].setMunicion(pers[i].getMunicion()-1);
				}else if(pers[i].getTipoB()==3){
					balas.agrBalasA(0, -5.5, (double)pers[i].getX()+(double)pers[i].getTam()/2, (double)pers[i].getY()-3.0);
					pers[i].setMunicion(pers[i].getMunicion()-1);
				}
			}else if(pers[i].getDireccion()==2){
				if(pers[i].getTipoB()==1){
					balas.agrBalas(-5.5, 0, (double)pers[i].getX()-3.0, (double)pers[i].getY()+(double)pers[i].getTam()/2);
				}else if(pers[i].getTipoB()==2){
					balas.agrBalasR(-5.5, 0, (double)pers[i].getX()-3.0, (double)pers[i].getY()+(double)pers[i].getTam()/2);
					pers[i].setMunicion(pers[i].getMunicion()-1);
				}else if(pers[i].getTipoB()==3){
					balas.agrBalasA(-5.5, 0, (double)pers[i].getX()-3.0, (double)pers[i].getY()+(double)pers[i].getTam()/2);
					pers[i].setMunicion(pers[i].getMunicion()-1);
				}
				
			}else if(pers[i].getDireccion()==3){
				if(pers[i].getTipoB()==1){
					balas.agrBalas(0, 5.5, (double)pers[i].getX()+(double)pers[i].getTam()/2, (double)pers[i].getY()+(double)pers[i].getTam()+3.0);
				}else if(pers[i].getTipoB()==2){
					balas.agrBalasR(0, 5.5, (double)pers[i].getX()+(double)pers[i].getTam()/2, (double)pers[i].getY()+(double)pers[i].getTam()+3.0);
					pers[i].setMunicion(pers[i].getMunicion()-1);
				}else if(pers[i].getTipoB()==3){
					balas.agrBalasA(0, 5.5, (double)pers[i].getX()+(double)pers[i].getTam()/2, (double)pers[i].getY()+(double)pers[i].getTam()+3.0);
					pers[i].setMunicion(pers[i].getMunicion()-1);
				}
			}else{
				if(pers[i].getTipoB()==1){
					balas.agrBalas(5.5,0, (double)pers[i].getX()+(double)pers[i].getTam()+3.0, (double)pers[i].getY()+(double)pers[i].getTam()/2);
				}else if(pers[i].getTipoB()==2){
					balas.agrBalasR(5.5,0, (double)pers[i].getX()+(double)pers[i].getTam()+3.0, (double)pers[i].getY()+(double)pers[i].getTam()/2);
					pers[i].setMunicion(pers[i].getMunicion()-1);
				}else if(pers[i].getTipoB()==3){
					balas.agrBalasA(5.5,0, (double)pers[i].getX()+(double)pers[i].getTam()+3.0, (double)pers[i].getY()+(double)pers[i].getTam()/2);
					pers[i].setMunicion(pers[i].getMunicion()-1);
				}
			}
		}
		
	}
	
	
	
	
	
	/**INICIO
	 * Métodos a llamarse en colisiones de objetos
	 */
	public boolean checkCollisionEne(Rectangle r){
		ListIterator<Malo> enem = ene.getEnemigs().listIterator();
		while(enem.hasNext()){
			Malo f = enem.next();
			if(f.getBounds().intersects(r)){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean checkCollisionBalas(Rectangle r){
		ListIterator<Bala> bala = balas.getEnemigs().listIterator();
		while(bala.hasNext()){
			Bala f = bala.next();
			if(f.getBounds().intersects(r)){
				f.setAlive(false);
				balas.getEnemigs().remove(f);
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean checkCollisionBalasR(Rectangle r){
		ListIterator<Bala_Rebote> br = balas.getBalasR().listIterator();
		while(br.hasNext()){
			Bala_Rebote f = br.next();
			if(f.getBounds().intersects(r)){
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean checkCollisionBalasA(Rectangle r){
		ListIterator<Bala_atraviesa> ba = balas.getBalasA().listIterator();
		while(ba.hasNext()){
			Bala_atraviesa f = ba.next();
			if(f.getBounds().intersects(r)){
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean checkCollisionParedes(Rectangle r){
		ListIterator<Pared> p = niv.getNivel().getParedes().listIterator();
		while(p.hasNext()){
			Pared f = p.next();
			if(f.getBounds().intersects(r)){
				return true;
			}
		}
		return false;
	}
	

	
	public boolean checkCollisionParedesR(Rectangle r){
		ListIterator<ParedRompible> pr = niv.getNivelR().getParedes().listIterator();
		while(pr.hasNext()){
			ParedRompible f = pr.next();
			if(f.getBounds().intersects(r)){
				return true;
			}
		}
		return false;
	}
	/**FIN
	 * Métodos a llamarse en colisiones de objetos
	 */
	
	
	
	/**INICIO
	 * Métodos de colisiones de objetos
	 */
	
	//Cualquier pared rompible se destruye con una bala
	public boolean checkParedR(){
		ListIterator<ParedRompible> p = niv.getNivelR().getParedes().listIterator();
		while(p.hasNext()){
			ParedRompible f = p.next();
			
			if(checkCollisionBalas(f.getBounds())||checkCollisionBalasA(f.getBounds())||checkCollisionBalas(f.getBounds())){
				niv.getNivelR().getParedes().remove(f);
				return true;
			}
			/**
			if(checkCollisionBalas(f.getBounds())){
				niv.getNivelR().getParedes().remove(f);
				return true;
			}else if(checkCollisionBalasA(f.getBounds())){
				niv.getNivelR().getParedes().remove(f);
				return true;
			}else if(checkCollisionBalas(f.getBounds())){
				niv.getNivelR().getParedes().remove(f);
				return true;
			}**/
		}
		return false;
	}
		//Cualquier bala se desaparece con pared
	public boolean checkBalaA(){
		ListIterator<Bala_atraviesa> b = balas.getBalasA().listIterator();
		while(b.hasNext()){
			Bala_atraviesa f = b.next();
			if(checkCollisionParedes(f.getBounds())){
				balas.getBalasA().remove(f);
				return true;
			}
		}
		return false;
	}
	
	
	public boolean checkBalaR(){
		ListIterator<Bala_Rebote> br = balas.getBalasR().listIterator();
		while(br.hasNext()){
			Bala_Rebote f = br.next();
			if(checkCollisionParedesR(f.getBounds()) || checkCollisionParedes(f.getBounds())){
				f.setVelX(f.getVelX()*-1);
				f.setVelY(f.getVelY()*-1);
				return true;
			}
			if(checkCollisionBalasR(pers[1].getBounds()) || checkCollisionBalasR(pers[2].getBounds())){
				balas.getBalasR().remove(f);
				return true;
			}
		}
		return false;
	}
	public boolean checkBala(){
		ListIterator<Bala> b=balas.getBalas().listIterator();
		while(b.hasNext()){
			Bala f=b.next();
			if(checkCollisionParedesR(f.getBounds()) || checkCollisionParedes(f.getBounds())){
				balas.getBalas().remove(f);
				return true;
			}
		}
		return false;			
	}
	
	
	//Las balas normales se eliminan con todo, implementado desde método base
	
	//un enemigo muere con todas balas
	public boolean checkEneBala(){
		ListIterator <Malo> enem = ene.getEnemigs().listIterator();
		while(enem.hasNext()){
			Malo f = enem.next();
			if(checkCollisionBalas(f.getBounds())||checkCollisionBalasR(f.getBounds())|| checkCollisionBalasA(f.getBounds()) ){
				f.setAlive(false);
				ene.getEnemigs().remove(f);
				return true;
			}
		}
		return false;
	}
	
	//Checa enem-pared, va a contextoo impide mov
	public boolean checkEnePared(){
		ListIterator <Malo> enem = ene.getEnemigs().listIterator();
		while(enem.hasNext()){
			Malo f = enem.next();
			if(checkCollisionParedes(f.getBounds())||checkCollisionParedesR(f.getBounds())){
				return true;
			}
		}
		return false;
	}
	
	//Detecta si bala toca personaje, cualqier bala lo mata
	public boolean checkPersBala(int j){
		if( checkCollisionBalas(pers[j].getBounds())){
			pers[j].setAlive(false);
			return true;
		}else if(checkCollisionBalasA(pers[j].getBounds())){
			pers[j].setAlive(false);
			return true;			
		}else if(checkCollisionBalasR(pers[j].getBounds())){
			pers[j].setAlive(false);
			return true;
		}
		return false;
	}
	
	
	
	//checa colisión con paredes normales y rompibles, va a contexto
	public boolean checkPersPared(int j){
		return (checkCollisionParedes(pers[j].getBounds()) || checkCollisionParedesR(pers[j].getBounds()));
	}
	
	//checa colisión con enemigo, va a contexto a cambiar.
	public boolean checkPersEnem(int j){
		if(checkCollisionEne(pers[j].getBounds())){
			pers[j].setAlive(false);
			return true;
		}
		return false;
	}
	
	
	
}
