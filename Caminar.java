import java.util.Random;

public class Caminar {
	private int vel;
	private int pref;
	private Random r;
	private int width;
	private int height;
	
	
	public int seleccionarPasearX(){
		r=new Random();
		int x=r.nextInt(width);
		
		return x;
	}
	
	public int seleccionarPasearY(){
		r=new Random();
		int y=r.nextInt(width);
		
		return y;
	}
	
	public void pasearX(int x, int eneX){
		if(x>eneX){
			
		}else{
			
		}
	}
}
