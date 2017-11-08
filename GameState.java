import java.awt.Graphics;

public interface GameState {

	public void end();
	public void pause();
	public void resume();
	
	public void render(Graphics g);
	public void update();
}
