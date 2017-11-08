
import javax.swing.JFrame;

public class Ventana_juego extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MiCanvas canvas;
	
	
	public Ventana_juego(){
		super();
		this.setResizable(false);
		this.setBounds(200, 100, 800, 600);
		setLayout(null);
		
		
		canvas = new MiCanvas();
		canvas.setBounds(10, 10, this.getWidth(), this.getHeight());
		
		
		
		add(canvas);
		
		
		
		//add(pausa);
		//add(menuPausa);
		
		
		
	}
	
	
	
	
	

}
