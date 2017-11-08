
import javazoom.jl.player.jlp;
public class MusicaThreat extends Thread {
	public MusicaThreat(){
		super();
	}
	
	private jlp mReproductor=null;
		
		
	public MusicaThreat(String pFileName){
		
		
		//Exception de el reproductor
	try{
		String[] args = new String[1];
			args[0] = pFileName;
			mReproductor = jlp.createInstance(args);
			
	} catch (Exception e){
		e.printStackTrace();
	}
}
	public void run(){
		try{
			while(true){
				mReproductor.play();
				Thread.sleep(10);// tiempo de recarga despues de terminar la canción
			}
		} catch(Exception e){
			e.printStackTrace();
			
		}
	}
}

