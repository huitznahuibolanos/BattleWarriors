
import java.awt.Canvas;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class MiCanvas extends Canvas implements  KeyListener,Runnable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4679672030236690291L;
	//private Personaje p,p2;
	//private Layout niv;
	//private LayoutRompible nivR;
	//private Enemigos ene;
	private Thread animacion;
	private int width,height;
	//private Disparos bal;
	private boolean running;
	private Image dbImage;
	private Graphics dbg;
	private MusicaThreat rep=null;
	private BufferedImage fondo;
	
	
	private GameStateContext context;
	
	public MiCanvas(){
		super();
		//setBackground(Color.BLACK);
		
		
		
		
		//p = new Personaje();
		//jugs=1;
		width=800;
		height=600;
		//p2 = new Personaje(Color.BLACK);
		//niv= new Layout();
		//nivR= new LayoutRompible();
		//ene= new Enemigos();
		//bal=new Disparos();
		running=true;
		
		/*
		niv.agrPared(50,50,50,150);
		niv.agrPared(200, 150, 30, 200);
		niv.agrPared(0, 0, 10, 600);
		niv.agrPared(0, 0, 800, 10);
		niv.agrPared(0, 540, 800, 10);
		niv.agrPared(765, 0, 10, 600);
		ene.agrEnemig(500,500);
		ene.agrEnemig(600, 100);
		nivR.agrPared(600, 50, 150, 30);*/
		
		context=new GameStateContext(width,height);
		
		aniStart();
		
		addKeyListener(this);
	}
	
	public void aniStart(){
		animacion = new Thread(this);
		animacion.start();
		rep=new MusicaThreat("Music\\Fight, fight!.mp3");
		rep.start();
	}
	
	private void paintScreen()
	  
	  { 
	    Graphics g;
	    try {
	      g = this.getGraphics();
	      if ((g != null) && (dbImage != null))
	        g.drawImage(dbImage, 0, 0, null);
	      Toolkit.getDefaultToolkit().sync();  
	      g.dispose();
	    }
	    catch (Exception e)
	    { System.out.println("Graphics error: " + e);  }
	  } 
	
	public void gameRender(){
		if (dbImage == null){
		      dbImage = createImage(width,height);
		      if (dbImage == null) {
		        System.out.println("dbImage is null");
		        return;
		      }
		      else
		        dbg = dbImage.getGraphics();
		    }

		
			
		
		//Esto es del prototipo 2
		ImageObserver observer=null;
		dbg.drawImage(fondo, 0, 0, width, height, observer);
		context.render(dbg);
		
		
		
		
		
		
		
		    // clear the background
		/*
		    dbg.setColor(Color.orange);
		    dbg.fillRect (0, 0, width, height);

			dbg.setColor(Color.blue);
		    dbg.setFont(font);

		   
		    if(jugs!=2 && fvis){
		    	dbg.drawString("press F for Player 2 to join", 50, 500);
		    	if(i>10){
		    		fvis=false;
		    		i=0;
		    	}else{
		    		i++;
		    	}
		    }else{
		    	if(i>10){
		    		fvis=true;
		    		i=0;
		    	}else{
		    		i++;
		    	}
		    }
		    
			p.paint(dbg);
			p2.paint(dbg);
			niv.paint(dbg);
			ene.paint(dbg);
			nivR.paint(dbg);
			bal.paint(dbg);
			*/
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while (running){
			gameUpdate();
			gameRender();
			paintScreen();
			try {
		          Thread.sleep(30); 
		        }
		        catch(InterruptedException ex){}
			
		}
		
	}
	
	/*public void paint(Graphics g){
		bal.updateBalas();
		
		p.paint(g);
		p2.paint(g);
		niv.paint(g);
		ene.paint(g);
		nivR.paint(g);
		bal.paint(g);
		
		
		
		if(ene.checkColision(p.getBounds())){
			System.exit(0);
		}
		if(ene.checkColision(p2.getBounds()))
			System.exit(0);
	}*/
	
	public void gameUpdate(){
		/*bal.updateBalas();
		p.personajeUpdate(niv,nivR);
		p2.personajeUpdate(niv,nivR);
		ene.mueve(niv,nivR);
		
		if(ene.checkColision(p.getBounds())){
			System.exit(0);
		}
		if(ene.checkColision(p2.getBounds()))
			System.exit(0);
		ene.checkBala(bal);
		nivR.checkBala(bal);
		//bal.checkColisionEnes(ene);
		bal.checkColisionPad(niv);*/
		
		context.update();
		
	}

	
	
	
	public void keyPressed(KeyEvent k) { //mueve personaje
		
		
		if(k.getKeyCode()==KeyEvent.VK_LEFT){ //Izq
			/*if(!niv.checkColision(p.getX()-3,p.getY(),p.getTam()) && p.getX()>0)
				p.setVelX(-3);
			
			p.setDireccion(2);*/
			context.move(2,0);
			
		}
		
		
		if(k.getKeyCode()==KeyEvent.VK_UP){ //Arriba
			/*if(!niv.checkColision(p.getX(),p.getY()-3,p.getTam()) && p.getY()>0)
				p.setVelY(-3);
			
			p.setDireccion(1);*/
			context.move(1,0);
		}
		
		
		if(k.getKeyCode()==KeyEvent.VK_RIGHT){ //Der
			/*if(!niv.checkColision(p.getX()+3,p.getY(),p.getTam()) && p.getX()+p.getTam()<width)
				p.setVelX(3);
			
			p.setDireccion(4);*/
			context.move(4,0);
		}
		
		
		if(k.getKeyCode()==KeyEvent.VK_DOWN){ //Abajo
			/*if(!niv.checkColision(p.getX(),p.getY()+3,p.getTam()) && p.getY()+p.getTam()<height)
				p.setVelY(3);
			
			p.setDireccion(3);*/
			context.move(3,0);
		}
		
		if(k.getKeyCode()==KeyEvent.VK_CONTROL){
			context.dispara(0);
		}
		
		
		if(k.getKeyCode()==KeyEvent.VK_SPACE){
			/*if(p.getDireccion()==1){
				bal.agrBalas(0, -5.5, (double)p.getX()+(double)p.getTam()/2, (double)p.getY()+1.0);
			}else if(p.getDireccion()==2){
				bal.agrBalas(-5.5, 0, (double)p.getX()-1.0, (double)p.getY()+(double)p.getTam()/2);
			}else if(p.getDireccion()==3){
				bal.agrBalas(0, 5.5, (double)p.getX()+(double)p.getTam()/2, (double)p.getY()+(double)p.getTam()+2.0);
			}else{
				bal.agrBalas(5.5,0, (double)p.getX()+(double)p.getTam()+2.0, (double)p.getY()+(double)p.getTam()/2);
			}*/
			context.dispara(1);
		}
		
		
		if(k.getKeyCode()==KeyEvent.VK_F){//f
			//p2=new Personaje(Color.black);
			context.secondP();
			
		}
		
		if(k.getKeyCode()==KeyEvent.VK_A){
			context.move(2, 1);
		}
		if(k.getKeyCode()==KeyEvent.VK_D){
			context.move(4, 1);
		}
		if(k.getKeyCode()==KeyEvent.VK_W){
			context.move(1, 1);
		}
		if(k.getKeyCode()==KeyEvent.VK_S){
			context.move(3, 1);
		}
		//repaint();		
		
	}

	
	
	
	@SuppressWarnings("deprecation")
	public void keyReleased(KeyEvent k) {
		
		if(k.getKeyCode()==KeyEvent.VK_P){
			context.pause();
		}
		
		if(k.getKeyCode()==KeyEvent.VK_R){
			context.resume();
		}
		if(k.getKeyCode()==KeyEvent.VK_M){
			rep.stop();
		}
		
		
		if(k.getKeyCode()==KeyEvent.VK_LEFT){
			context.stop(2,0);
		}
		
		if(k.getKeyCode()==KeyEvent.VK_RIGHT){
			context.stop(2,0);
		}
		
		if(k.getKeyCode()==KeyEvent.VK_UP){
			context.stop(1,0);
		}
		
		if(k.getKeyCode()==KeyEvent.VK_DOWN){
			context.stop(1,0);
		}
		
		
		
		
		if(k.getKeyCode()==KeyEvent.VK_A){
			context.stop(2, 1);
		}
		if(k.getKeyCode()==KeyEvent.VK_D){
			context.stop(2, 1);
		}
		if(k.getKeyCode()==KeyEvent.VK_W){
			context.stop(1, 1);
		}
		if(k.getKeyCode()==KeyEvent.VK_S){
			context.stop(1, 1);
		}
	}
	public void keyTyped(KeyEvent arg0) {}





	
	
	
	

}
