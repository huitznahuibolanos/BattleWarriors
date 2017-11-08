import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
//import java.awt.font.*;

public class GameStatePaused implements GameState {
	
	GameStateContext gc;

	public GameStatePaused(GameStateContext gameStateContext) {
		// TODO Auto-generated constructor stub
		gc=gameStateContext;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		System.out.println("Se ha salido del juego");
		gc.setCurrent(gc.getGameOver());

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		System.out.println("No se puede  pausar en pausa");
		

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		System.out.println("El juego continua");
		gc.setCurrent(gc.getRun());

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		// Aqui hace render la pantalla de pausa;
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(100, 75, (gc.getWidth()-200), (gc.getHeight()-100));
		g.setColor(Color.black);
		Font f=new Font("SansSerif", Font.BOLD, 24);
		g.setFont(f);
		g.drawString("Pausa",((gc.getWidth()-200)/2),100);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		//Aqui  hace update la pantalla de pausa

	}

}
