import java.awt.Graphics;

public class Nivel {
	private  int niv;
	private Layout nivel;
	private LayoutRompible nivelR;
	private LoadImages limgs;
	
	
	public Nivel(int n, LoadImages loimgs){
		niv=n;
		nivel= new Layout();
		nivelR= new LayoutRompible();
		
		limgs = loimgs;
		crearLayout();
		crearLayoutR();
	}
	public Layout getNivel(){
		return nivel;
	}
	public LayoutRompible getNivelR(){
		return nivelR;
	}
//--------------------------------------Significado de "niv"--------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------
	
/*
 * niv representa al nivel que se va a construir (ya sea coliseo, Domo Fututista o Barrio)
 * 
 * niv =1 Es el Coliseo
 * 
 * niv=2 Es el Domo Futurista
 * 
 * niv=3 Es el Barrio
 * 
 */

	private void crearLayoutR() {
		//limites
		nivel.agrPared(0, 0, 900, 30, limgs);
		nivel.agrPared(0, 0, 30, 540, limgs);
		nivel.agrPared(0, 540, 780, 30, limgs);
		nivel.agrPared(750, 0, 60, 570, limgs);
		
		
		if(niv==1){
			nivel.agrPared(90, 90, 120, 30,limgs);
			//nivel.agrPared(120, 120, 30, 90, limgs);
			//nivel.agrPared(200, 300, 60, 60, limgs);
		}
		
	}


	private void crearLayout() {
		if(niv==1){
			//nivelR.agrPared(200, 20, 150, 30,limgs);
			nivelR.agrPared(30, 90, 60, 30, limgs);
		}
		
	}

	public void paint(Graphics g) {
		nivel.paint(g);
		nivelR.paint(g);
		
		
	}
	
}
