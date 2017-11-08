import java.awt.Color;
import java.awt.Graphics;

public class GameStateRunning implements GameState {
	
	GameStateContext gc;

	public GameStateRunning(GameStateContext gameStateContext) {
		// TODO Auto-generated constructor stub
		gc=gameStateContext;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		System.out.println("Se ha terminado el  juego");
		gc.setCurrent(gc.getGameOver());

	}

	@Override
	public void pause() {
		gc.setCurrent(gc.getPause());
		
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		System.out.println("No se puede hacer resume en running");
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		//Aqui va el render del juego en si
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		gc.getEntities().render(g);
		

	}

	@Override
	public void update() {
		gc.getEntities().update();
		
		//Aqui  va el update del juego en si

	}

}
