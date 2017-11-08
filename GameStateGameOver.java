import java.awt.Graphics;

public class GameStateGameOver implements GameState {
	GameStateContext gc;

	public GameStateGameOver(GameStateContext gameStateContext) {
		// TODO Auto-generated constructor stub
		gc=gameStateContext;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		System.out.println("Ya esta en Game Over");

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		System.out.println("No se  puede pausar en Game Over");

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		System.out.println("No  se puede hacer resume en Game over");

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		//Aqui  se hace render de la Pantalla del Game Over

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		//Aqui se hace  el update  de la pantalla  de Game Over

	}

}
